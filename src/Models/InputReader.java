package Models;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputReader{
    Scanner in = new Scanner(System.in);
    public String nextLine(){
        String buf = "";
        try {
            buf = in.nextLine();
        } catch (InputMismatchException ex) {
            in.nextLine();
            System.out.println(ex.getMessage());
        }
        return buf;
    }
    public void close(){
        in.close();
    }
}
