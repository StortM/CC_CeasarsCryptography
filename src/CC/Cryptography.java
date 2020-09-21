package CC;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cryptography {
    private String alphabet;
    private Map<Character,Character> keyMap;

    public Cryptography() {
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789,.!?";
        this.keyMap = generateEncryptionKey();
    }

    public Map<Character, Character> getKeyMap() {
        return keyMap;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public Map<Character,Character> generateEncryptionKey() {
        char[] charAlphabet = alphabet.toCharArray();

        Random random = new Random();
        int randomNumber = random.nextInt(charAlphabet.length-1) +1;

        keyMap = new HashMap<>();

        for (int i = 0; i <charAlphabet.length; i++){
            if (i + randomNumber < charAlphabet.length){
                keyMap.put(charAlphabet[i],charAlphabet[i+randomNumber]);
            }
            else{
                keyMap.put(charAlphabet[i],charAlphabet[i+randomNumber-charAlphabet.length]);
            }
        }
        return keyMap;
    }
}
