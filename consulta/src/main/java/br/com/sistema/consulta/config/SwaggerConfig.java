package br.com.sistema.consulta.config;

import static springfox.documentation.builders.PathSelectors.regex;
import java.util.ArrayList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.basePackage("br.com.sistema.consulta.controller"))
        .paths(regex("/consulta.*"))
        .build()
        .groupName("consulta")
        .apiInfo(metaData());
  }

  private ApiInfo metaData() {
    return new ApiInfo(
        "API de Consulta", "", "0.0.1", "", ApiInfo.DEFAULT_CONTACT, "", "", new ArrayList<>());
  }
}
