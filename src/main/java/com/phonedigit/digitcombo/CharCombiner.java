package com.phonedigit.digitcombo;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;

@Component
public class CharCombiner {
    @Getter
    @Setter
    private String number;

    @Autowired
    private CharacterPrinter characterPrinter;

    private LinkedList<String> convertNumber(String number){
        String tempNumber = number.replace("0", "")
                .replace("1", "");

        LinkedList<String> characters = new LinkedList<>();
        characters.add("");

        if(!tempNumber.isEmpty()) {
            while (characters.peek().length() != tempNumber.length()) {
                String firstElement = characters.pop();
                String lastElement = "";
                // get mapping characters
                String mappingChars = DigitConstants.
                        DIGIT_CHAR[tempNumber.charAt(firstElement.length()) - '0']; //convert ASC II
                for (char character : mappingChars.toCharArray()) {
                    lastElement = firstElement + character;
                    characters.add(lastElement);
                }
            }
        }
        return characters;
    }

    public void printMappingChars(){
        HashMap<Integer, LinkedList<String>> numCharsMapping = new HashMap<>();

        if(!number.isEmpty()){
            numCharsMapping.put(Integer.parseInt(number), convertNumber(number));
        }else{
            for (int counter = 0; counter < 100; counter++){
               numCharsMapping.put(counter,
                       convertNumber(String.valueOf(counter)));
            }
        }
        characterPrinter.printCharacters(numCharsMapping);
    }
}
