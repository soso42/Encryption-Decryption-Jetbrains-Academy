package encryptdecrypt;

import java.io.*;
import java.util.HashMap;

public class Parser {

    private HashMap<String, String> arguments;
    private String mode;
    private String dataSource;
    private int key;
    private String alg;
    private String outputFilePath;

    public Parser(String[] args) {

        checkForErrors(args);

        this.arguments = new HashMap<>();

        for (int i = 0; i < args.length; i += 2) {
            arguments.put(args[i], args[i + 1]);
        }

        this.mode = arguments.getOrDefault("-mode", "enc");
        this.key = Integer.parseInt(arguments.getOrDefault("-key", "0"));
        this.dataSource = getDataSource();
        this.alg = arguments.getOrDefault("-alg", "shift");
        this.outputFilePath = arguments.getOrDefault("-out", null);

    }

    // Getters

    public String getMode() {
        return this.mode;
    }

    public String getData() {
        return this.dataSource;
    }

    public int getKey() {
        return this.key;
    }

    public String getAlg() {
        return this.alg;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }

    // Util functions

    private void checkForErrors(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if (args[i].charAt(0) == '-' && args[i + 1].charAt(0) == '-') {
                System.out.println("Error. One of the paraments doesn't have a value. Exiting..");
                System.exit(0);
            }
        }
    }

    private String getDataSource() {
        if (this.arguments.get("-data") == null && this.arguments.get("-in") == null) {
            return "";
        }
        if (this.arguments.get("-data") != null) {
            return this.arguments.getOrDefault("-data", "");
        }
        if (this.arguments.get("-in") != null) {
            String filepath = this.arguments.get("-in");
            StringBuilder sb = new StringBuilder();
            String line;

            try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }return sb.toString();

            } catch (IOException e) {
                System.out.println("File not found or can not be opened!");
                System.exit(0);
            }
        }
        return "";
    }

}
