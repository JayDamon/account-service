package com.factotum.accountservice.exception;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
@Configuration
@Order(-2)
public class GlobalErrorHandler implements ErrorWebExceptionHandler {

    @NonNull
    @Override
    public Mono<Void> handle(ServerWebExchange serverWebExchange, @NonNull Throwable throwable) {

        log.error(throwable.getMessage(), throwable);

        DataBufferFactory bufferFactory = serverWebExchange.getResponse().bufferFactory();

        if (throwable instanceof ConstraintViolationException
                || throwable instanceof IllegalArgumentException
                || throwable instanceof WebExchangeBindException) {

            serverWebExchange.getResponse().setStatusCode(HttpStatus.BAD_REQUEST);
            DataBuffer dataBuffer = bufferFactory.wrap(throwable.getMessage().getBytes());
            serverWebExchange.getResponse().getHeaders().setContentType(MediaType.APPLICATION_JSON);

            return serverWebExchange.getResponse().writeWith(Mono.just(dataBuffer));
        }

        serverWebExchange.getResponse().setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        serverWebExchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        DataBuffer dataBuffer = bufferFactory.wrap("Unknown error".getBytes());

        return serverWebExchange.getResponse().writeWith(Mono.just(dataBuffer));
    }

}
