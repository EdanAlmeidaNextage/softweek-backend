package com.softweek.softweek.domain.utils;

import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Utils {

    // Atualiza campos de um objeto com valores de um mapa
    public static Object atualizarObjetos(Class<?> classe, Map<String, Object> objModificado, Object objBanco) {
        objModificado.forEach((property, value) -> {
            Field field = ReflectionUtils.findField(classe, property);
            if (field != null) {
                field.setAccessible(true);

                // Verifica se o campo é primitivo ou uma instância de java.lang
                if (!field.getType().isPrimitive() && !field.getType().getName().startsWith("java.lang")) {
                    return;
                }

                // Atualiza o campo se o valor não for nulo
                if (value != null) {
                    ReflectionUtils.setField(field, objBanco, value);
                }
            }
        });

        return objBanco;
    }

    // Formata uma data para string no formato dd/MM/yyyy
    public static String formataDataString(Date date) {
        if (date != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(date);
        }
        return null; // Retorna null se a data for nula
    }

    // Sobrecarga para formatar data com padrão customizado
    public static String formataDataString(Date date, String formato) {
        if (date != null && formato != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(formato);
            return sdf.format(date);
        }
        return null; // Retorna null se a data ou formato forem nulos
    }
}
