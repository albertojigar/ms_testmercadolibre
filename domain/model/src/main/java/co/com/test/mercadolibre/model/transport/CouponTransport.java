package co.com.test.mercadolibre.model.transport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class CouponTransport {
    private Map<String, String> headers;
    private Object request;
    private Object response;
    private Integer statusCode;
    private boolean status;

}
