package co.com.test.mercadolibre.usecase;

import co.com.test.mercadolibre.model.transport.CouponTransport;
import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseGateway;
import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseStatsGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CouponUseCase {

    private final ICouponUseCaseGateway couponGateway;
    private final ICouponUseCaseStatsGateway couponUseCaseStatsGateway;

    /**
     * maxItemsCoupon, use the couponGateway to resolve the request with the adapter
     * @param couponTransport Object with the request data
     * @return Mono<CouponTransport> Object with the response included
     */
    public Mono<CouponTransport> maxItemsCoupon(CouponTransport couponTransport){
        return couponGateway.maxItemsCoupon(couponTransport);
    }

    /**
     * couponStats, use the couponGateway to resolve the request with the adapter
     * @param couponTransport Object with the request data
     * @return Mono<CouponTransport> Object with the response included
     */
    public Mono<CouponTransport> couponStats(CouponTransport couponTransport){
        return couponUseCaseStatsGateway.couponStats(couponTransport);
    }
}
