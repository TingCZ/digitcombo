package com.phonedigit.digitcombo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DigitComboApplicationTests implements CommandLineRunner {

    @Autowired
    CharCombiner charCombiner;

    @Test
    void inputNumber() {
        charCombiner.setNumber("23");
        charCombiner.printMappingChars();
    }

    @Test
    void printNumbers(){
        charCombiner.setNumber("");
        charCombiner.printMappingChars();
    }

    @Override
    public void run(String... args) throws Exception {
        inputNumber();
        printNumbers();
    }
}
