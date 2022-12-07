package com.mata62.projetofinal;

import java.util.List;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {

        Console console = new Console();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                List<String> input = Arrays.asList(scanner.nextLine().split(" "));
                
                String instru = input.get(0);
                
                console.service(input, instru);
            }
        }
    }
}