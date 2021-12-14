package co.com.test.mercadolibre.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CouponRoutesProperties {

    @Value("${routes.base-path:/api/v1}")
    private String basePath;

    @Value("${routes.coupon.path:/coupon}")
    private String routeCoupon;

    @Value("${routes.coupon.stats:/coupon/stats}")
    private String couponStats;
}
