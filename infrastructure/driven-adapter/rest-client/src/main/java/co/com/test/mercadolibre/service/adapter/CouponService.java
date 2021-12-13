package co.com.test.mercadolibre.service.adapter;

import co.com.test.mercadolibre.model.error.Error;
import co.com.test.mercadolibre.model.response.CouponResponse;
import co.com.test.mercadolibre.model.response.Item;
import co.com.test.mercadolibre.model.transport.CouponTransport;
import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseGateway;
import co.com.test.mercadolibre.service.exception.TechnicalException;
import io.netty.handler.codec.http.HttpResponseStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import static co.com.test.mercadolibre.service.exception.message.TechnicalErrorMessage.TECHNICAL_RESTCLIENT_ERROR;


@Repository
@RequiredArgsConstructor
@Primary
@Slf4j
public class CouponService implements ICouponUseCaseGateway {

    private final CouponProperties couponProperties;

    /**
     * Adapter method, contains the logic to sort the items, consume the mercadolibre api and return the max items depending of coupon
     * @param couponTransport Object with all the request information
     * @return Mono Object with the response information
     */
    public Mono<CouponTransport> maxItemsCoupon(CouponTransport couponTransport){
        LinkedHashMap<String,Object> request = (LinkedHashMap)couponTransport.getRequest();
        ArrayList<String> items = (ArrayList<String>) request.get("item_ids");
        Integer amount = (Integer) request.get("amount");
        AtomicInteger i = new AtomicInteger();

        Map<Integer, Item> data = items.stream().collect(Collectors.toMap(s -> (Integer) i.getAndIncrement(), s ->
                {
                    Item item = new Item();
                    try {
                        item = getItem(couponProperties.getCouponItemRoute()+s);
                    } catch (ParseException e) {
                        log.error(Error.Data.builder().message(e.getMessage()).domain("CouponService").reason(e.getCause().toString()).code(String.valueOf(e.getErrorType())).build().toString());
                        new TechnicalException(e.getCause(), TECHNICAL_RESTCLIENT_ERROR);
                    }
                    return item;
                }));

        Map<Integer, Item> result = new LinkedHashMap<>();
        AtomicReference<Integer> acum = new AtomicReference<>(0);
        AtomicReference<Integer> total = new AtomicReference<>(0);

        data.entrySet().stream()
                .sorted((e1,e2)-> e1.getValue().getPrice().compareTo(e2.getValue().getPrice()))
                .forEachOrdered(x -> {
                    acum.updateAndGet(v -> v + (Integer) x.getValue().getPrice());
                    if(acum.get()<=amount){
                        total.updateAndGet(v -> v + (Integer) x.getValue().getPrice());
                        result.put(x.getKey(), x.getValue());
                    }
                });

        ArrayList<String> listItems = new ArrayList<String>();
        result.forEach((k,v) -> listItems.add(v.getId()));
        couponTransport.setStatusCode(HttpResponseStatus.OK.code());
        couponTransport.setStatus(true);
        couponTransport.setResponse(CouponResponse.builder().items_ids(listItems).total(total.get()).build());
        log.info("Items returned: "+ listItems.toString() + " Total price: "+total.get());
        return Mono.just(couponTransport);
    }

    /**
     * Rest client generic to get method
     * @param route endpoint to consume
     * @return Item Object with the response information
     */
    public Item getItem(String route) throws ParseException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(route, String.class);
        return setResponseItems(response);
    }
    /**
     * Rest client generic to get method
     * @param response information of response
     * @return Item Object with the response information
     */
    private Item setResponseItems(ResponseEntity<String> response) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject result = (JSONObject) parser.parse(response.getBody());
        return Item.builder().id((String)result.get("id")).price((Integer)result.get("price")).build();
    }
}
