package com.example.user_management.utils;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
