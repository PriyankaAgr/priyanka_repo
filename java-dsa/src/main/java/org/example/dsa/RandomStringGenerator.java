package org.example.dsa;

import java.security.SecureRandom;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomStringGenerator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%";
    private static final int STRING_LENGTH = 12;
    private static final Random RANDOM = new SecureRandom();

    public static void main(String[] args) {
        String randomString = generateRandomString(STRING_LENGTH);
        System.out.println("Random String: " + randomString);
    }

    public static String generateRandomString(int length) {
        Supplier<String> randomCharSupplier = () -> {
            int index = RANDOM.nextInt(CHARACTERS.length());
            return String.valueOf(CHARACTERS.charAt(index));
        };

        return Stream.generate(randomCharSupplier)
                .limit(length)
                .collect(Collectors.joining());
    }
}
