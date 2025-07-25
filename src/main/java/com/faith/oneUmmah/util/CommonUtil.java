package com.faith.oneUmmah.util;

public class CommonUtil {

    public static boolean isNotEmpty(String value) {
        return !isNullOrEmpty(value);
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isNullOrBlank(String str) {
        return str == null || str.isBlank();
    }

    public static boolean isValidEmail(String email) {
        if (isNullOrBlank(email)) {
            return false;
        }

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(regex);
    }


}

