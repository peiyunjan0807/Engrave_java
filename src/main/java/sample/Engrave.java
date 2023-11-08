package sample;

import java.io.IOException;

public class Engrave {
    public static void main(String[] args){
        try {
            new FireBaseService();
        } catch (IOException e) {
            e.printStackTrace();
        }
        new LoginFrame();
    }
}