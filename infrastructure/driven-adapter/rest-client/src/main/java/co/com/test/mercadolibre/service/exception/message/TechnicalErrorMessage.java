package co.com.test.mercadolibre.service.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TechnicalErrorMessage {

    GET_ITEM_TIMEOUT("ITM001", "Get Item timeout", "GET_ITEM_TIMEOUT"),
    ERROR_PARSER_ITEM("ITM002", "Error Parser Item", "ERROR_PARSER_ITEM"),
    TECHNICAL_RESTCLIENT_ERROR("ITM003", "Technical Generic Error", "TECHNICAL_RESTCLIENT_ERROR");

    private final String code;
    private final String description;
    private final String message;
}
