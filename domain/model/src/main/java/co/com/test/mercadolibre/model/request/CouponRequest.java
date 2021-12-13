package co.com.test.mercadolibre.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequest {

    /**
     * @param items_ids List with the items
     */
    private ArrayList<String> items_ids;

    /**
     * @param amount Coupon value
     */
    private Integer amount;
}
