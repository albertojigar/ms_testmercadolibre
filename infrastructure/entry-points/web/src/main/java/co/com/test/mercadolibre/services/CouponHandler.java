package co.com.test.mercadolibre.services;

import co.com.test.mercadolibre.usecase.CouponUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class CouponHandler extends AbstractHandler{

    private final CouponUseCase couponUseCase;

    public CouponHandler(final CouponUseCase couponUseCase){
        super();
        this.couponUseCase=couponUseCase;
    }

    /**
     * Handler method, contains the call to item use case
     * @param request Object with all the request information
     * @return Mono Object with the response information
     */
    public Mono<ServerResponse> maxItemsCoupon(ServerRequest request) {
        return getResponse(request,couponUseCase::maxItemsCoupon);
    }
}
