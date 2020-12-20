package br.com.sistema.cliente.utils;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.sistema.cliente.exception.ParseException;

@Component
public class JsonUtils {

  public static String toJson(Object object) {
    try {
      return new ObjectMapper().writeValueAsString(object);
    } catch (Exception e) {
      throw new ParseException("Ocorreu um erro ao transformar o objeto em json");
    }
  }

  public static Object toObject(String json, Class tipo) {
    try {
      return new ObjectMapper().readValue(json, tipo);
    } catch (Exception e) {
      throw new ParseException("Ocorreu um erro ao transformar json em objeto");
    }
  }
}
