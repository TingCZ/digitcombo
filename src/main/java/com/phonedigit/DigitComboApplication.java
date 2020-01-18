package com.phonedigit;

import com.phonedigit.digitcombo.CharCombiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DigitComboApplication implements CommandLineRunner {
    @Autowired
    private CharCombiner charCombiner;

    public static void main(String[] args) {
        SpringApplication.run(DigitComboApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=================== Welcome ===================");
        System.out.println("a. Convert number into corresponding characters.");
        System.out.println("b. Convert 0 ~ 99 into corresponding characters.");
        System.out.println("c. Exit.");
        System.out.println("Please enter an option (a/b/c):");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        while(!"c".equals(option.toLowerCase())){
            switch (option.toLowerCase()){
                case "a":
                    System.out.println("Please enter a positive integer: ");
                    String number = scanner.nextLine();
                    while (!(number.matches("-?(0|[1-9]\\d*)"))) {
                        System.out.println("Invalid input, please enter a positive integer: ");
                        number = scanner.nextLine();
                    }
                    // convert input number into corresponding characters
                    charCombiner.setNumber(number);
                    charCombiner.printMappingChars();
                    break;
                case "b":
                    charCombiner.setNumber("");
                    charCombiner.printMappingChars();
                    break;
                case "c":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
            System.out.println("Please enter an option (a/b/c): ");
            option = scanner.nextLine();
        }
    }
}
