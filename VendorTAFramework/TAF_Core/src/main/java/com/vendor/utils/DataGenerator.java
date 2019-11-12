package com.vendor.utils;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class DataGenerator {

    private static final String NUMBERS = "0123456789";
    private static final String LETTERS = "ABCDEFJHIJKLMNOPQRSTUVWXYZ";
    private static final int MIN_VALUE_OF_CARD_NUMBERS = 12;
    private static final int MAX_VALUE_OF_CARD_NUMBERS = 12;
    private static final int MAX_VALUE_OF_CVC_CODE = 3;
    private static Random rnd = new Random();

    public static Integer randInt(int minNumber, int maxNumber) {
        return new Random().nextInt((maxNumber - minNumber) + 1) + minNumber;
    }

    public static Integer randIndexFromList(List list) {
        return new Random().nextInt(list.size() - 1);
    }

    public static String getRandomStringFromList(List list) {
        int index = DataGenerator.randIndexFromList(list);
        return list.get(index).toString();
    }

    public static Integer getCurrentDateDay() {
        Calendar cal = Calendar.getInstance();
        int dayOfMonthIndex = cal.get(Calendar.DAY_OF_MONTH);
        return dayOfMonthIndex-1;
    }

    private static int getCardNumberLength(int... startCardNumber) {
        int randomNumber = DataGenerator.randInt(MIN_VALUE_OF_CARD_NUMBERS, MAX_VALUE_OF_CARD_NUMBERS);
        return randomNumber - startCardNumber.length;
    }

    public static String getRandomNumber(int startNumber) {
        int resultLength = getCardNumberLength(startNumber);
        StringBuilder randomNumber = new StringBuilder(resultLength);
        for (int i = 0; i < resultLength; i++) {
            randomNumber.append(NUMBERS.charAt(rnd.nextInt(NUMBERS.length())));
        }
        return startNumber + randomNumber.toString();
    }

    public static String getRandomLetters(int length) {
        StringBuilder randomLetters = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            randomLetters.append(LETTERS.charAt(rnd.nextInt(LETTERS.length())));
        }
        return randomLetters.toString();
    }

    public static String getRandomCvcCode() {
        StringBuilder randomNumber = new StringBuilder(MAX_VALUE_OF_CVC_CODE);
        for (int i = 0; i < MAX_VALUE_OF_CVC_CODE; i++) {
            randomNumber.append(NUMBERS.charAt(rnd.nextInt(NUMBERS.length())));
        }
        return randomNumber.toString();
    }
}
