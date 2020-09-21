import CC.Cryptography;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CryptographyTest {

    Cryptography cryptography = new Cryptography();

    @Test
    void generateEncryptionKey(){
        String var = "abcdefghijklmnopqrstuvwxyz";
        char[] alphabet = var.toCharArray();
        Random random = new Random();

        int randomNumber = random.nextInt(alphabet.length-1) +1;

        Map<Character,Character> keyMap = new HashMap<>();

        for (int i = 0; i <alphabet.length; i++){
            if (i + randomNumber < alphabet.length){
                keyMap.put(alphabet[i],alphabet[i+randomNumber]);
            }
            else{
                keyMap.put(alphabet[i],alphabet[i+randomNumber-alphabet.length]);
            }
        }
        assertEquals(keyMap.get('a'),var.charAt(randomNumber));
        assertEquals(keyMap.get('c'),var.charAt(randomNumber+2));
        assertEquals(keyMap.get('z'),var.charAt(randomNumber-1));
    }
}