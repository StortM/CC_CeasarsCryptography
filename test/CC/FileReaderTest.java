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

            File alice = new File("src/CC/AliceInWonderland.txt");
            Scanner scanner = new Scanner(alice);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                line = line.replaceAll("[^a-zA-Z0-9_-]", "");

                String tempString = "";


                for (int i = 0; i < line.length(); i++){
                    tempString += cryptography.getKeyMap().get(line.charAt(i));
                }
                System.out.println(tempString);
                tempString = "";
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}