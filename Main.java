package encryptdecrypt;

import encryptdecrypt.algorythms.Cipher;
import encryptdecrypt.algorythms.ShiftingAlgorythm;
import encryptdecrypt.algorythms.UnicodeAlgorythm;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        String result;
        Parser parser = new Parser(args);

        Cipher cipherMachine = new Cipher();

        if (parser.getAlg().equals("unicode")) {
            cipherMachine.setAlgorythm(new UnicodeAlgorythm());
        } else if (parser.getAlg().equals("shift")) {
            cipherMachine.setAlgorythm(new ShiftingAlgorythm());
        }

        if (parser.getMode().equals("enc")) {
            result = cipherMachine.encrypt(parser.getData(), parser.getKey());
        } else {
            result = cipherMachine.decrypt(parser.getData(), parser.getKey());
        }

        if (parser.getOutputFilePath() != null) {
            writeResultToFile(result, parser.getOutputFilePath());
        } else {
            System.out.println(result);
        }

    }

    private static void writeResultToFile(String text, String filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(text);
        }
        catch(IOException e){
            System.out.println("Error. output file not found or it can't be opened");
            System.exit(0);
        }
    }


}
