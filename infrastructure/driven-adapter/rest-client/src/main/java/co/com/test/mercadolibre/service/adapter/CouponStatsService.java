package co.com.test.mercadolibre.service.adapter;

import co.com.test.mercadolibre.model.transport.CouponTransport;
import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseStatsGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class CouponStatsService implements ICouponUseCaseStatsGateway {

    @Override
    public Mono<CouponTransport> couponStats(CouponTransport couponTransport) {
        return null;
    }
}
