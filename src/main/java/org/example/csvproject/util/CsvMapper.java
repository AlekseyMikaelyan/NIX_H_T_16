package org.example.csvproject.util;

import org.example.csvproject.util.annotations.CsvAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

public class CsvMapper {

    public <T> List <T> makeObjectsList(CsvTable table, Class <T> objectClass) throws IllegalAccessException {

        List<T> objectsList = new ArrayList<>();

        Constructor<T> constructor = null;

        try {
            constructor = objectClass.getConstructor();
        } catch (NoSuchMethodException e) {
                e.printStackTrace();
        }

        for (int i = 0; i < table.height(); i++) {

            T object = null;
            try {
                assert constructor != null;
                object = constructor.newInstance();
            } catch (InvocationTargetException | InstantiationException e) {
                e.printStackTrace();
            }

            for(Field field : objectClass.getDeclaredFields()) {
                field.setAccessible(true);

                String header = field.getAnnotation(CsvAnnotation.class).value();
                String value = table.get(i, header);

                if (field.getType() == int.class) {
                    field.set(object, Integer.parseInt(value));
                }
                if (field.getType() == double.class) {
                    field.set(object, Double.parseDouble(value));
                }
                if (field.getType() == boolean.class) {
                    field.set(object, Boolean.parseBoolean(value));
                }
                if (field.getType() == long.class) {
                    field.set(object, Long.parseLong(value));
                }
                if (field.getType() == String.class) {
                    field.set(object, value);
                }
                if(field.getType().isEnum()) {
                    field.set(object, Enum.valueOf((Class<Enum>) field.getType(), value.toUpperCase()));
                }
            }
            objectsList.add(object);
        }
        return objectsList;
    }
}
