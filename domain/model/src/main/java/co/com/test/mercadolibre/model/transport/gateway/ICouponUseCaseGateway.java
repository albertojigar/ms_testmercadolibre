package co.com.test.mercadolibre.model.transport.gateway;

import co.com.test.mercadolibre.model.transport.CouponTransport;
import reactor.core.publisher.Mono;

public interface ICouponUseCaseGateway {
    Mono<CouponTransport> maxItemsCoupon(CouponTransport couponTransport);
}
