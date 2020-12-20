package br.com.sistema.consulta.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class IndexController {

  @GetMapping("/")
  public String redirectToSwagger() {
    return "redirect:/swagger-ui.html";
  }
}
