package sample;

import java.io.File;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadGrammar {
    private Scanner input;
    private String fileName; // target file name
    private int num;

    public ReadGrammar(String fileName) {
        this.fileName = fileName;
    }

    public String[] read() {
        String[] temp = new String[100];
        try {
            File file = new File(fileName);
            input = new Scanner(file);
        } catch (IOException ioException) {
            System.err.println("Error opening file. Terminating.");
            System.exit(1);
        }

        try {
            for(num=0; input.hasNextLine(); num++) {
                temp[num]= input.nextLine();
                //grammar.append(temp);
                //System.out.println(temp);
            }

        } catch (NoSuchElementException elementException) {
            System.err.println("File improperly formed. Terminating.");
        } catch (IllegalStateException stateException) {
            System.err.println("Error reading from file. Terminating.");
        }

        if (input != null)
            input.close();

        return temp;
    }

    public int returnNum() {
        return num;
    }
}