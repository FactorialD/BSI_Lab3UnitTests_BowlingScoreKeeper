package Models;

import java.util.Scanner;

public class Game {
    private Player[] players;

    public Game() {
        this.players = new Player[2];
        play();
    }

    public void play(){
        for (int i = 0; i < players.length; i++) {
            inputPlayerName(i);
        }
    }

    private void inputPlayerName(int index) {
        Scanner in = new Scanner(System.in);
        String name = "";
        while(true){
            System.out.print("Input a name for player #" + (index + 1) + " (name will be trimmed by 10 symbols): ");
            name = in.nextLine();
            if(name == ""){
                System.out.println("Wrong input! Try again.");
            }else{
                if(name.length() > 10){
                    name = name.substring(0,11);
                }
                break;

            }
        }


        players[index].setName(name);
        System.out.println("Player #"+ (index+1) +": " + players[index].getName());
        in.close();
    }


}
