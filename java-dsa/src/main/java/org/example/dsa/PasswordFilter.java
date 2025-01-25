package org.example.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PasswordFilter {

    public static void main(String[] args) {
        List<String> passwords = Arrays.asList("pass123", "123456", "password", "pa$sw0rd", "pass@123", "1234", "abcd@1", "abc?123");
        String validPasswords = filterValidPasswords(passwords);
        System.out.println("Valid Passwords: " + validPasswords);
    }

    public static String filterValidPasswords(List<String> passwords) {
        Pattern specialCharPattern = Pattern.compile("[@#$]");

        return passwords.stream()
                .filter(pwd -> pwd.length() >= 5) // Condition 1: length >= 5
                .filter(pwd -> !pwd.matches("[a-zA-Z]+")) // Condition 2: Should not be all characters
                .filter(pwd -> !pwd.matches("\\d+")) // Condition 3: Should not be all numbers
                .filter(pwd -> specialCharPattern.matcher(pwd).find()) // Condition 4: Must have special characters [@#$]
                .collect(Collectors.joining(", ")); // Collect valid passwords into a single string
    }
}
