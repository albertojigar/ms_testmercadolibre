package co.com.test.mercadolibre.services;

import co.com.test.mercadolibre.model.request.CouponRequest;
import co.com.test.mercadolibre.model.response.CouponResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import org.springframework.web.reactive.function.server.RouterFunction;

@Component
@RequiredArgsConstructor
public class CouponRouter {

    private final CouponRoutesProperties routes;

    @Bean(name = "CouponRoutes")
    @RouterOperations({
            @RouterOperation(method = RequestMethod.POST, path = "/api/v1/coupon",
                    operation = @Operation(operationId = "coupon", tags = {"Coupon"},
                            requestBody = @RequestBody(required = true, description = "Get the max items from an item list and coupon value",
                                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                            schema = @Schema(implementation = CouponRequest.class))),
                            parameters = {

                                    /*Headers*/
                                    @Parameter(name = "client-ip", required = false, in = ParameterIn.HEADER,
                                            description = "Ip of the consuming application."),
                                    @Parameter(name = "device-id", required = false, in = ParameterIn.HEADER,
                                            description = "Consuming application device-id."),
                                    @Parameter(name = "request-id", required = false, in = ParameterIn.HEADER,
                                            description = "ID for traceability of the request."),
                                    @Parameter(name = "request-timestamp", required = false, in = ParameterIn.HEADER,
                                            description = "Timestamp of consumer."),
                                    @Parameter(name = "app-version", required = false, in = ParameterIn.HEADER,
                                            description = "Version of the application from which the request was received"),
                                    @Parameter(name = "platform-type", required = false, in = ParameterIn.HEADER,
                                            description = "type of platform from where the request comes")},

                            responses = {
                                    @ApiResponse(responseCode = "200", content = @Content(
                                            schema = @Schema(implementation = CouponResponse.class))),
                                    @ApiResponse(responseCode = "400",
                                            content = @Content(
                                                    schema = @Schema(implementation = Error.class)))}))
    })

    public RouterFunction<ServerResponse> routes(CouponHandler handler) {
        return route()
                .POST(getPath(), accept(APPLICATION_JSON), handler::maxItemsCoupon)
                .build();
    }

    private String getPath(String variable) {
        String transactionPath = routes.getBasePath()
                .concat(routes.getRouteCoupon());
        return transactionPath.concat(variable);
    }

    private String getPath() {
        return routes.getBasePath()
                .concat(routes.getRouteCoupon());
    }
}
