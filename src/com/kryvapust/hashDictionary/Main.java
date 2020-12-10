package com.kryvapust.hashDictionary;

import java.util.Scanner;

public class Main {

    public static final int HASH_SIZE = 255;

    public static void main(String[] args) {
        System.out.println("Welcome to the Simple Dictionary!");
        Section[] dictionary = new Section[HASH_SIZE];
        boolean exit = false;

        while (!exit) {
            System.out.println("1 - add translation\n2 - translate word \n3 - delete translation");
            Scanner scanner = new Scanner(System.in);
            if (scanner.hasNextInt()) {
                int command = scanner.nextInt();
                switch (command) {
                    case 1:
                        System.out.println("--ADD NEW TRANSLATION--");
                        addTranslation(dictionary);
                        break;
                    case 2:
                        System.out.println("--FIND TRANSLATION--");
                        getTranslation(dictionary);

                        break;
                    case 3:
                        System.out.println("--DELETE TRANSLATION");
                        deleteTranslation(dictionary);
                        break;
                    default:
                        continue;
                }
            } else {
                System.out.println("Something goes wrong :(( ... Your answer isn't correct.");
            }
            System.out.print("Continue? (y/n): ");
            exit = scanExit();
        }
    }

    private static void addTranslation(Section[] dictionary) {
        String key = "";
        String value = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("word: ");
        if (scanner.hasNextLine()) {
            key = scanner.nextLine();
        }
        System.out.print("translation: ");
        if (scanner.hasNextLine()) {
            value = scanner.nextLine();
        }
        if (dictionary[getModFromHash(key)] == null) {
            dictionary[getModFromHash(key)] = new Section();
        }
        dictionary[getModFromHash(key)].addTranslation(new Combination(key, value));
    }

    private static void getTranslation(Section[] dictionaries) {
        String key = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert word, which translation you want to find: ");
        if (scanner.hasNextLine()) {
            key = scanner.nextLine();
        }
        if (dictionaries[getModFromHash(key)] == null) {
            return;
        }
        System.out.println(dictionaries[getModFromHash(key)].getTranslation(key));
    }

    private static void deleteTranslation(Section[] dictionaries) {
        String key = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("Insert word, which you want to delete: ");
        if (sc.hasNextLine()) {
            key = sc.nextLine();
        }
        if (dictionaries[getModFromHash(key)] == null) {
            return;
        }
        dictionaries[getModFromHash(key)].deleteTranslation(key);
    }

    public static int getModFromHash(String key) {
        return key.hashCode() % HASH_SIZE;
    }

    private static boolean scanExit() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().equalsIgnoreCase("n");
    }
}
