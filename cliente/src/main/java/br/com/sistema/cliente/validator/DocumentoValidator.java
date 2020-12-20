package br.com.sistema.cliente.validator;

import br.com.sistema.cliente.exception.ValidationException;

public class DocumentoValidator {
  private static final int[] PESO_CPF = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
  private static final int[] PESO_CNPJ = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

  public static void validar(String cpfCnpj) {
    if (!(isValidCPF(cpfCnpj) || isValidCNPJ(cpfCnpj))) {
      throw new ValidationException(
          "O documento de número ".concat(cpfCnpj).concat(" não é válido."));
    }
  }

  private static int calcularDigito(String str, int[] peso) {
    int soma = 0;
    for (int indice = str.length() - 1, digito; indice >= 0; indice--) {
      digito = Integer.parseInt(str.substring(indice, indice + 1));
      soma += digito * peso[peso.length - str.length() + indice];
    }
    soma = 11 - soma % 11;
    return soma > 9 ? 0 : soma;
  }

  private static String padLeft(String text, char character) {
    return String.format("%11s", text).replace(' ', character);
  }

  private static boolean isValidCPF(String cpf) {
    cpf = cpf.trim().replace(".", "").replace("-", "");
    if ((cpf == null) || (cpf.length() != 11)) return false;

    for (int j = 0; j < 10; j++)
      if (padLeft(Integer.toString(j), Character.forDigit(j, 10)).equals(cpf)) return false;

    Integer digito1 = calcularDigito(cpf.substring(0, 9), PESO_CPF);
    Integer digito2 = calcularDigito(cpf.substring(0, 9) + digito1, PESO_CPF);
    return cpf.equals(cpf.substring(0, 9) + digito1.toString() + digito2.toString());
  }

  private static boolean isValidCNPJ(String cnpj) {
    cnpj = cnpj.trim().replace(".", "").replace("-", "");
    if ((cnpj == null) || (cnpj.length() != 14)) return false;

    Integer digito1 = calcularDigito(cnpj.substring(0, 12), PESO_CNPJ);
    Integer digito2 = calcularDigito(cnpj.substring(0, 12) + digito1, PESO_CNPJ);
    return cnpj.equals(cnpj.substring(0, 12) + digito1.toString() + digito2.toString());
  }
}
