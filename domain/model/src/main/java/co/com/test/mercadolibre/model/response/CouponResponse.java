package co.com.test.mercadolibre.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponResponse {
    /**
     * @param items_ids List with the max items to return
     */
    private ArrayList<String> items_ids;

    /**
     * @param total Total sum value from the items
     */
    private Integer total;
}
