package co.com.test.mercadolibre.service.exception;

import co.com.test.mercadolibre.service.exception.message.TechnicalErrorMessage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class TechnicalException extends Exception {

    private final TechnicalErrorMessage technicalErrorMessage;

    /**
     * Management exception message
     * @param cause Object with the exception information
     * @param technicalErrorMessage management message
     */
    public TechnicalException(Throwable cause, TechnicalErrorMessage technicalErrorMessage) {
        super(cause);
        this.technicalErrorMessage = technicalErrorMessage;
    }
}