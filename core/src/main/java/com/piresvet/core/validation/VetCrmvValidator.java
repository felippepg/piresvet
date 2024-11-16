package com.piresvet.core.validation;


import com.piresvet.core.exception.InvalidCrmvException;

import java.util.regex.Pattern;

public class VetCrmvValidator implements Validator {
    @Override
    public void validate(String crmv) {
        String crmvPattern = "^[0-9]{5,}/[A-Z]{2}$";

        if (crmv == null || crmv.isEmpty()) {
            throw new InvalidCrmvException("CRMV não pode ser vazio");
        }

        if (!Pattern.matches(crmvPattern, crmv)) {
            throw new InvalidCrmvException("Formato de CRMV inválido. Exemplo de formato correto: 12345/SP");
        }

        String[] parts = crmv.split("/");
        int numero = Integer.parseInt(parts[0]);
        String estado = parts[1];

        if (numero <= 0) {
            throw new InvalidCrmvException("Número do CRMV deve ser maior que zero");
        }

        if (!isValidState(estado)) {
            throw new InvalidCrmvException("Sigla de estado inválida");
        }
    }

    private static boolean isValidState(String estado) {
        String[] estadosValidos = {
                "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT",
                "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO",
                "RR", "SC", "SP", "SE", "TO"
        };

        for (String uf : estadosValidos) {
            if (uf.equals(estado)) {
                return true;
            }
        }
        return false;
    }
}
