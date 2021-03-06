//package com.htb.api.util;
//
//import com.alibaba.fastjson.serializer.SerializerFeature;
//import com.alibaba.fastjson.support.config.FastJsonConfig;
//import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
//import com.fasterxml.jackson.core.JsonGenerator;
//import com.fasterxml.jackson.databind.JsonSerializer;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializerProvider;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.io.IOException;
//import java.nio.charset.Charset;
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class JacksonConfig extends WebMvcConfigurationSupport {
//    @Bean
//    @Primary
//    @ConditionalOnMissingBean(ObjectMapper.class)
//    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {
//            @Override
//            public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
//                jsonGenerator.writeString("");
//            }
//        });
//        return objectMapper;
//    }
//
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig config = new FastJsonConfig();
//        config.setSerializerFeatures(
//                // ?????? Map ????????????
//                SerializerFeature.WriteMapNullValue,
//                // ??? String ????????? null ??????""
//                SerializerFeature.WriteNullStringAsEmpty,
//                // ??? Number ????????? null ?????? 0
//                SerializerFeature.WriteNullNumberAsZero,
//                // ??? List ????????? null ?????? []
//                SerializerFeature.WriteNullListAsEmpty,
//                // ??? Boolean ????????? null ?????? false
//                SerializerFeature.WriteNullBooleanAsFalse,
//                // ??????????????????
//                SerializerFeature.DisableCircularReferenceDetect);
//
//        converter.setFastJsonConfig(config);
//        converter.setDefaultCharset(Charset.forName("UTF-8"));
//        List<MediaType> mediaTypeList = new ArrayList<>();
//        // ??????????????????????????????????????? Controller ?????? @RequestMapping ?????????????????? produces = "application/json"
//        mediaTypeList.add(MediaType.APPLICATION_JSON);
//        converter.setSupportedMediaTypes(mediaTypeList);
//        converters.add(converter);
//    }
//
//
//
//}
