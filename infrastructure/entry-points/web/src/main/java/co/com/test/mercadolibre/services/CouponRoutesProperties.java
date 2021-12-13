package co.com.test.mercadolibre.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class CouponRoutesProperties {

    @Value("${routes.base-path:/api/v1/coupon}")
    private String basePath;

    @Value("${routes.coupon.path:/coupon}")
    private String routeCoupon;
}
