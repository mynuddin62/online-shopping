package com.faith.oneUmmah.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.util.Objects;

public class PasswordEqualValidator implements ConstraintValidator<PasswordEqual, Object> {
    private String firstFieldName;
    private String secondFieldName;
    private String message;


    @Override
    public void initialize(PasswordEqual constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        boolean valid = true;

        try {
            final Object firstObject = getValue(value, firstFieldName);
            final Object secondObject = getValue(value, secondFieldName);
            valid = Objects.equals(firstObject, secondObject);
        } catch (final Exception ignore) {
            //ignore
        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondFieldName)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }


        return valid;
    }


    private Object getValue(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(object);
    }
}
