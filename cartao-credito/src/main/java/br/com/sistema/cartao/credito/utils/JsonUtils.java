package br.com.sistema.cartao.credito.utils;

import java.io.IOException;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.sistema.cartao.credito.exception.ParseException;

@Component
public class JsonUtils {

  public static String toJson(Object object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (IOException e) {
      throw new ParseException("Ocorreu um erro ao transformar o objeto em json");
    }
  }

  public static Object toObject(String json, Class tipo) {
    try {
      return new ObjectMapper().readValue(json, tipo);
    } catch (JsonProcessingException e) {
      throw new ParseException("Ocorreu um erro ao transformar json em objeto");
    }
  }
}
