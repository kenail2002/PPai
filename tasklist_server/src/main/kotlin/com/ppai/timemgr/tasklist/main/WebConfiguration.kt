package com.ppai.timemgr.tasklist.main

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration
import org.springframework.http.codec.ServerCodecConfigurer
import org.springframework.http.codec.json.Jackson2JsonDecoder
import org.springframework.http.codec.json.Jackson2JsonEncoder
import org.springframework.web.reactive.config.WebFluxConfigurer

@Configuration

class WebConfiguration : WebFluxConfigurer {
    override fun configureHttpMessageCodecs(configurer: ServerCodecConfigurer) {
        LOG.info("configure 1 ")
        configurer.defaultCodecs().jackson2JsonEncoder(Jackson2JsonEncoder(ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)))

        configurer.defaultCodecs().jackson2JsonDecoder(Jackson2JsonDecoder(ObjectMapper()
                .enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)))
    }
}

val LOG: Logger = LoggerFactory.getLogger(WebConfiguration::class.java)
