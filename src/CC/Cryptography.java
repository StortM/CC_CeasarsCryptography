package CC;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cryptography {
    private String alphabet;

    public Cryptography(String alphabet) {
        this.alphabet = "abcdefghijklmnopqrstuvwxyz";
    }

    public Cryptography(){

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

        Map<Character,Character> keyMap = new HashMap<>();

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
