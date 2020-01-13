package com.sugelamei.config;

import feign.Contract;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.context.annotation.Bean;


/*
 该类为Feign的配置类
 注意:该类可以不写@Configuration注解；如果加了@Configuration注解，
 就不能放在主应用程序上下文@ComponentScan所扫描的包中。
 */
public class FeignConfig {
    /*
     将契约改为fegin原生的默认契约，
     这样就可以使用feign自带的注解了。
     */
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    /*
   使用默认的编码器
     */
    @Bean
    public Encoder feignEncoder() {
        return new Encoder.Default();
    }

    /*
    使用默认的解码器
     */
    @Bean
    public Decoder feignDecoder() {
        return new Decoder.Default();
    }
}
