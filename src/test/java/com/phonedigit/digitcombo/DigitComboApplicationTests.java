package com.phonedigit.digitcombo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class DigitComboApplicationTests{
    @Autowired
    CharCombiner charCombiner;

    @Test
    void inputNumber() {
        charCombiner.setNumber("23");
        charCombiner.printMappingChars();
        charCombiner.setNumber("");
        charCombiner.printMappingChars();
    }
}
