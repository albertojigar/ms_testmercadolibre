package co.com.test.mercadolibre.usecase;

import co.com.test.mercadolibre.model.transport.CouponTransport;
import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CouponUseCase {

    private final ICouponUseCaseGateway couponGateway;

    /**
     * Configuration Bean, inject the usecase configuration into the application context
     * @param couponTransport Object with the request data
     * @return Mono<CouponTransport> Object with the response included
     */
    public Mono<CouponTransport> maxItemsCoupon(CouponTransport couponTransport){
        return couponGateway.maxItemsCoupon(couponTransport);
    }
}
