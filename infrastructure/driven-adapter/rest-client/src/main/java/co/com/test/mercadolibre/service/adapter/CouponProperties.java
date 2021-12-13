package co.com.test.mercadolibre.service.adapter;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class CouponProperties {

    @Value("${adapters.rest-client.resources.items}")
    private String couponItemRoute;

    @Value("${adapters.rest-client.timeout}")
    private Integer couponItemTimeOut;
}
