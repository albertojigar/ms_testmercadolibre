package co.com.test.mercadolibre.conf;

import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseGateway;
import co.com.test.mercadolibre.model.transport.gateway.ICouponUseCaseStatsGateway;
import co.com.test.mercadolibre.usecase.CouponUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfig {

    /**
     * Configuration Bean, inject the usecase configuration into the application context
     * @param couponGateway interface to instance
     * @return CouponUseCase Object with the instance of usecase
     */
    @Bean
    public CouponUseCase initCouponUseCase(ICouponUseCaseGateway couponGateway, ICouponUseCaseStatsGateway couponUseCaseStatsGateway){
        return new CouponUseCase(couponGateway, couponUseCaseStatsGateway);
    }
}
