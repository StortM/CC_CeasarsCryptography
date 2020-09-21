package CC;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @Test
    void readFile(){
        try{
            Cryptography cryptography = new Cryptography();
            //Checker at objektet blev oprettet korrekt
            assertNotNull(cryptography);
            File alice = new File("src/CC/AliceInWonderland.txt");
            Scanner scanner = new Scanner(alice);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                //Checker at vi altid får input in via vores Scanner
                assertNotNull(line);
                line = line.replaceAll("[^a-zA-Z0-9_-]", "");
                String tempString = "";
                // Checker at tempString blev "nulstillet"
                assertEquals("",tempString);

                for (int i = 0; i < line.length(); i++){
                    tempString += cryptography.getKeyMap().get(line.charAt(i));
                }

                // Validere at det ikke er de samme Strings
                assertNotSame(line,tempString);
                System.out.println(tempString);
                tempString = "";
                // Checker at tempString blev "nulstillet"
                assertEquals("",tempString);
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}