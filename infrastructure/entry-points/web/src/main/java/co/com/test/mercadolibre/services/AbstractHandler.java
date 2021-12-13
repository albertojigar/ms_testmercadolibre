package co.com.test.mercadolibre.services;

import co.com.test.mercadolibre.model.transport.CouponTransport;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import java.util.function.Function;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RequiredArgsConstructor
public abstract class AbstractHandler {

    /**
     * Orchestrator to request & response, contains the call to item use case function and transform the ServerRequest to CouponTransport
     * @param request Object with all the request information
     * @param useCase Object with the usecase function
     * @return Mono Object with the ServerResponse information
     */
    protected Mono<ServerResponse> getResponse(ServerRequest request, Function<CouponTransport,Mono<CouponTransport>> useCase) {
        return request.bodyToMono(Object.class)
                .map(body -> buildTransaction(request, body))
                .flatMap(useCase)
                .flatMap(this::response);
    }

    /**
     * Transform the ServerRequest to CouponTransport Object
     * @param serverRequest Object with all the request information
     * @param request Object with the request body
     * @return CouponTransport Object with the request information
     */
    private CouponTransport buildTransaction(ServerRequest serverRequest, Object request){
        return CouponTransport.builder()
                .request(request)
                .build();
    }

    /**
     * Build the response from the CouponTransport
     * @param couponTransport Object with all the response information
     * @return Mono Object with the request information
     */
    public Mono<ServerResponse> response(CouponTransport couponTransport){
        return buildResponse(HttpStatus.valueOf( couponTransport.getStatusCode()  ), couponTransport.getResponse() );
    }

    /**
     * Generic Method, build the response from any response body to ServerResponse Object
     * @param status Object with status information
     * @param body Object with the response body
     * @return Mono Object with the ServerResponse information
     */
    public  <T> Mono<ServerResponse> buildResponse (HttpStatus status, T body){
        return ServerResponse
                .status(status)
                .contentType(APPLICATION_JSON)
                .bodyValue(body);
    }

}
