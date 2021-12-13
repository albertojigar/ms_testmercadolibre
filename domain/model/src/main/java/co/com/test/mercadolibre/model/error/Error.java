package co.com.test.mercadolibre.model.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Error {

    @AllArgsConstructor
    @NoArgsConstructor
    @lombok.Data
    @Builder(toBuilder = true)
    public static class Data {
        private String reason;
        private String domain;
        private String code;
        private String message;
    }

}
