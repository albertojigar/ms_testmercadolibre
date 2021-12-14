package co.com.test.mercadolibre.model.transport.gateway;

import co.com.test.mercadolibre.model.transport.CouponTransport;
import reactor.core.publisher.Mono;

public interface ICouponUseCaseStatsGateway {

    Mono<CouponTransport> couponStats(CouponTransport couponTransport);

}
