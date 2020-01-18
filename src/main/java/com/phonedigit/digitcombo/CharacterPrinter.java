package com.phonedigit.digitcombo;

import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class CharacterPrinter {
    public void printCharacters(HashMap<Integer, LinkedList<String>> hashMap) {
        for (Map.Entry<Integer, LinkedList<String>> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}
