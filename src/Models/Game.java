package Models;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.Integer.parseInt;

@Data
public class Game {

    private ArrayList<Player> players;
    private int playerCount = 2;

    InputReader in = new InputReader();

    public Game() {
        this.players = new ArrayList<>();
    }

    public Game(InputReader in){
        this.in = in;
        this.players = new ArrayList<>();
    }

    public void play() {
        //Scanner in = new Scanner(System.in);
        inputPlayerNames(playerCount, in);
        for (int frameCounter = 0; !Game.allPlayersEndedGame(players); frameCounter++){

            for (int i = 0; i < players.size(); i++) {

                do{
                    if(players.get(i).getFrames().size() == 11 && !players.get(i).getFrames().get(9).isStrike()){
                        break;
                    }
                    System.out.println("Player's " + players.get(i).getName() + " turn:");
                    System.out.println("Frame #" + frameCounter);
                    inputDownPills(players.get(i), in, frameCounter);
                    printScoreTable();
                    System.out.println("--------------------------------------------------");
                }while(players.get(i).getFrames().get(players.get(i).getFrames().size()-1).awaitsForLastRoll());
                System.out.println("==================================================");
            }
        }

        printGameResult();

        in.close();
    }

    public void printGameResult() {

        Collections.sort(players, (ideaVal1, ideaVal2) -> {
            Integer idea1 = ideaVal1.getSummaryScoreOf(ideaVal1.frames.size()-1);
            Integer idea2 = ideaVal2.getSummaryScoreOf(ideaVal2.frames.size()-1);
            return idea2.compareTo(idea1);
        });
        String s0 = "╔═══╦══════════╦════╗";
        System.out.println(s0);
        int fieldLength = s0.length();
        for (int i = 0; i < players.size(); i++) {
            String s1 = "║ " + (i + 1) + " ║";
            if(s1.length() != 5){
                throw new IllegalArgumentException();
            }
            System.out.print(s1);

            StringBuilder spaces2 = new StringBuilder();
            for (int j = 0; j < 10 - players.get(i).getName().length(); j++) {
                spaces2.append(" ");
            }
            String s3 = spaces2.toString() + players.get(i).getName() + "║ ";
            if (s3.length() != 12){
                throw new IllegalArgumentException();
            }
            System.out.print(s3);

            StringBuilder spaces = new StringBuilder();
            for (int j = 0; j < 3 - players.get(i).getSummaryScoreOf(players.get(i).getFrames().size()-1).toString().length(); j++) {
                spaces.append(" ");
            }
            System.out.print(spaces.toString() + players.get(i).getSummaryScoreOf(players.get(i).getFrames().size()-1));
            System.out.println("║");

            System.out.println("╠═══╬══════════╬════╣");
        }

        if(players.get(0).getSummaryScoreOf(players.get(0).getFrames().size()-1).equals(players.get(1).getSummaryScoreOf(players.get(0).getFrames().size()-1))){
            System.out.println("║ Draw!             ║");
        }else{
            StringBuilder spaces2 = new StringBuilder();
            for (int j = 0; j < 10 - players.get(0).getName().length(); j++) {
                spaces2.append(" ");
            }
            String s2 = "║ "  + players.get(0).getName() + spaces2 + " wins!  ║";
            System.out.println(s2 );
        }

        System.out.println("╚═══╩══════════╩════╝");

    }

    public static boolean allPlayersEndedGame(ArrayList<Player> players){
        for (Player p: players
             ) {
            if(!p.isLastFrame(p.getFrames())) {
                return false;
            }
        }
        return true;
    }

    public void printScoreTable() {

        System.out.println("╔════════════╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╦╦══╤══╤══╗");

        for (Player p: players) {

            StringBuilder s = new StringBuilder();
            for (int i = 0; i < 10 - p.getName().length(); i++) {
                s.append(" ");
            }
            System.out.print("║ " + p.getName() + s + " ║");

            for (int i = 0; i < 9; i++) {//first 9 rounds
                System.out.print("║");

                //adding attribute: split or washout
                String attr;
                if(p.getFrames() == null || p.getFrames().size()-1 < i || p.getFrames().size() == 0 || p.getFrames().get(i) == null  ){
                    attr = " ";
                }else if(p.getFrames().get(i).isSplit()){
                    attr = "S";
                }else if(p.getFrames().get(i).isWashout()){
                    attr = "W";
                }else{
                    attr = " ";
                }
                System.out.print(attr);

                String firstScore;
                if(p.getFrames() == null || p.getFrames().size()-1 < i || p.getFrames().size() == 0 || p.getFrames().get(i) == null || p.getFrames().get(i).getScores() == null){
                    firstScore = " ";
                }else if(p.getFrames().get(i).getScores().get(0) == 0){
                    firstScore = "-";
                }else if(p.getFrames().get(i).isStrike()){
                    firstScore = " ";
                }else{
                    firstScore = p.getFrames().get(i).getScores().get(0).toString();
                }
                System.out.print(firstScore);

                System.out.print("│ ");

                String secondScore;
                if(p.getFrames() == null || p.getFrames().size()-1 < i || p.getFrames().size() == 0 || p.getFrames().get(i) == null || p.getFrames().get(i).getScores() == null ||
                        p.getFrames().get(i).getScores().get(0) == null ||
                        ( p.getFrames().get(i).getScores().size() < 2 && !p.getFrames().get(i).isStrike())
                        ){
                    secondScore = " ";
                }else if(p.getFrames().get(i).isStrike()){
                    secondScore = "X";
                }else if(p.getFrames().get(i).isSpare()){
                    secondScore = "/";
                }else if(p.getFrames().get(i).getScores().get(1) == 0){
                    secondScore = "-";
                } else{
                    secondScore = ""+(p.getFrames().get(i).getAllDownedPills().size());
                }
                System.out.print(secondScore);

                System.out.print("║");
            }

            System.out.print("║");//last 10 frame

            int cellCount = 0;
            //first roll of 10 frame
            String last11attr;
            if(p.getFrames() == null || p.getFrames().size()-1 < 9 || p.getFrames().get(9) == null || p.getFrames().get(9).getScores() == null ||
                    p.getFrames().get(9).getScores().get(0) == null || p.getFrames().get(9).getScores().size() == 0){
                last11attr = " ";
            }else if(p.getFrames().get(9).isSplit()){
                last11attr = "S";
            }else if(p.getFrames().get(9).isWashout()){
                last11attr = "W";
            }else{
                last11attr = " ";
            }
            System.out.print(last11attr);

            String last12score;
            if(p.getFrames() == null || p.getFrames().size()-1 < 9 || p.getFrames().get(9) == null || p.getFrames().get(9).getScores() == null){
                last12score = " ";
            }else if(p.getFrames().get(9).getScores().get(0) == 0){
                last12score = "-";
            }else if(p.getFrames().get(9).isStrike()){
                last12score = "X";
            }else{
                last12score = p.getFrames().get(9).getScores().get(0).toString();
            }
            System.out.print(last12score);

            cellCount++;

            //second roll of 10 frame
            if((p.getFrames() == null || p.getFrames().size()-1 < 9) ||
                    (p.getFrames() != null && p.getFrames().size()-1 >= 9 && p.getFrames().get(9) != null && p.getFrames().get(9).getScores() != null && p.getFrames().get(9).isStrike())){

            }else{
                System.out.print("│");

                String last21attr;
                if(p.getFrames() == null || p.getFrames().size()-1 < 9 || p.getFrames().get(9) == null || p.getFrames().get(9).getScores() == null ||
                        p.getFrames().get(9).getScores().size() == 0){
                    last21attr = " ";
                }else if(p.getFrames().get(9).isSplit()){
                    last21attr = "S";
                }else if(p.getFrames().get(9).isWashout()){
                    last21attr = "W";
                }else{
                    last21attr = " ";
                }
                System.out.print(last21attr);

                String last22score;
                if(p.getFrames() == null || p.getFrames().size()-1 < 9 || p.getFrames().get(9) == null ||
                        p.getFrames().get(9).getScores() == null || p.getFrames().get(9).getScores().size() < 2){
                    last22score = " ";
                }else if(p.getFrames().get(9).getScores().get(1) == 0){
                    last22score = "-";
                }else if(p.getFrames().get(9).isSpare()){
                    last22score = "/";
                } else if(p.getFrames().get(9).isStrike()){
                    last22score = "X";
                }else{
                    last22score = ""+(p.getFrames().get(9).getAllDownedPills().size());
                }
                System.out.print(last22score);

                cellCount++;
            }

            System.out.print("│");
            //first roll of 11 frame
            String last31attr;
            if(p.getFrames() == null || p.getFrames().size()-1 < 10 || p.getFrames().get(10) == null || p.getFrames().get(10).getScores() == null ||
                    p.getFrames().get(10).getScores().get(0) == null || p.getFrames().get(10).getScores().size() == 0){
                last31attr = " ";
            }else if(p.getFrames().get(10).isSplit()){
                last31attr = "S";
            }else if(p.getFrames().get(10).isWashout()){
                last31attr = "W";
            }else{
                last31attr = " ";
            }
            System.out.print(last31attr);

            String last32score;
            if(p.getFrames() == null || p.getFrames().size()-1 < 10 || p.getFrames().get(10) == null || p.getFrames().get(10).getScores() == null){
                last32score = " ";
            }else if(p.getFrames().get(10).getScores().get(0) == 0){
                last32score = "-";
            }else if(p.getFrames().get(9).isSplit()){
                last32score = "/";
            }else if(p.getFrames().get(10).isStrike()){
                last32score = "X";
            }else{
                last32score = p.getFrames().get(10).getScores().get(0).toString();
            }
            System.out.print(last32score);

            cellCount++;

            //second roll of 11 frame
            if (cellCount > 2){

            } else if((p.getFrames() == null || p.getFrames().size()-1 < 9) ||
                    (p.getFrames() != null && !(p.getFrames().size()-1 < 10) && p.getFrames().get(10) != null && p.getFrames().get(10).getScores() != null && p.getFrames().get(10).isStrike())){

            }else{
                System.out.print("│");
                String last41attr;
                if(p.getFrames() == null || p.getFrames().size()-1 < 10 || p.getFrames().get(10) == null || p.getFrames().get(10).getScores() == null ||
                        p.getFrames().get(10).getScores().size() == 0 ){
                    last41attr = " ";
                }else if(p.getFrames().get(10).isSplit()){
                    last41attr = "S";
                }else if(p.getFrames().get(10).isWashout()){
                    last41attr = "W";
                }else{
                    last41attr = " ";
                }
                System.out.print(last41attr);

                String last42score;
                if(p.getFrames() == null || p.getFrames().size()-1 < 10 || p.getFrames().get(10) == null ||
                        p.getFrames().get(10).getScores() == null || p.getFrames().get(10).getScores().size() < 2){
                    last42score = " ";
                }else if(p.getFrames().get(10).getScores().get(1) == 0){
                    last42score = "-";
                }else if(p.getFrames().get(10).isStrike()){
                    last42score = "X";
                }else{
                    last42score = ""+(p.getFrames().get(10).getAllDownedPills().size());
                }
                System.out.print(last42score);

                cellCount++;
            }

            //last cell of 10 frame
            if (cellCount > 2){

            }else{
                System.out.print("│");
                String last51attr;
                if(p.getFrames() == null || p.getFrames().size()-1 < 11 || p.getFrames().get(11) == null || p.getFrames().get(11).getScores() == null ||
                        p.getFrames().get(11).getScores().get(0) == null || p.getFrames().get(11).getScores().size() == 0){
                    last51attr = " ";
                }else if(p.getFrames().get(11).isSplit()){
                    last51attr = "S";
                }else if(p.getFrames().get(11).isWashout()){
                    last51attr = "W";
                }else{
                    last51attr = " ";
                }
                System.out.print(last51attr);

                String last52score;
                if(p.getFrames() == null || p.getFrames().size()-1 < 11 || p.getFrames().get(11) == null || p.getFrames().get(11).getScores() == null){
                    last52score = " ";
                }else if(p.getFrames().get(11).getScores().get(0) == 0){
                    last52score = "-";
                }else if(p.getFrames().get(9).isSplit()){
                    last52score = "/";
                }else if(p.getFrames().get(11).isStrike()){
                    last52score = "X";
                }else{
                    last52score = p.getFrames().get(11).getScores().get(0).toString();
                }
                System.out.print(last52score);
            }
            System.out.println("║");

            System.out.println("║            ║║  ╘══╣║  ╘══╣║  ╘══╣║  ╘══╣║  ╘══╣║  ╘══╣║  ╘══╣║  ╘══╣║  ╘══╣╠══╧══╧══╣");

            Game.printScoreTableForPlayer(p);

            System.out.println("╠════════════╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╬╬══╤══╤══╣");
        }
        System.out.println("╚════════════╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╩╩══╧══╧══╝");

    }

    public static void printScoreTableForPlayer(Player player) {
        System.out.print("║            ║");
        for (int i = 0; i < 10; i++) {
            if(i < 9){//if not last frame
                System.out.print("║  ");
                if(player.getFrames() == null || player.getSummaryScores().size()-1 < i || player.getSummaryScores().get(i) == null ||
                        ( player.getFrames().get(i) != null &&
                                player.getFrames().get(i).getScores() != null &&
                                (player.getFrames().get(i).getScores().size() < 2 && !player.getFrames().get(i).isStrike())
                        ) //if not last roll in frame
                ){
                    System.out.print("   ");
                }else{
                    StringBuilder spaces = new StringBuilder();
                    for (int j = 0; j < 3 - player.getSummaryScoreOf(i).toString().length(); j++) {
                        spaces.append(" ");
                    }
                    System.out.print(spaces.toString() + player.getSummaryScoreOf(i));
                }
            }else{//last long frame
                System.out.print("║     ");
                if(player.getFrames() == null || player.getSummaryScores().size()-1 < i || player.getSummaryScores().get(i) == null || player.get10Score() == null){
                    System.out.print("   ");
                }else{
                    StringBuilder spaces = new StringBuilder();
                    for (int j = 0; j < 3 - player.getSummaryScoreOf(player.getFrames().size()-1).toString().length(); j++) {
                        spaces.append(" ");
                    }
                    System.out.print(spaces.toString() + player.getSummaryScoreOf(player.getFrames().size()-1));
                }
            }

            System.out.print("║");
        }
        System.out.println();
    }

    public void inputDownPills(Player player, InputReader in, int frameCounter) {

        ArrayList<Integer> res;

        if(player.getFrames().size() == 0 || player.isFirstRollInFrame(player.getFrames())){
            System.out.println("First roll in frame.");
            System.out.println("Numbers of pills:");
            System.out.println("(7) (8) (9) (10)");
            System.out.println("  (4) (5) (6)");
            System.out.println("    (2) (3)");
            System.out.println("      (1)");
            System.out.println("Player " + player.getName() + ", input numbers of down pills (example: '1 2 4 5 10'): ");
        }
        else{
            ArrayList<Integer> leavedPills = player.getFrames().get(frameCounter).getLeavedPillsForFirstRoll(player.getFrames().get(frameCounter).getDownPills().get(0));
            System.out.println("Second roll in frame.");
            System.out.println("Numbers of pills:");
            System.out.printf("(%s) (%s) (%s) (%s) \n",
                    leavedPills.contains(7)?"7":"X",
                    leavedPills.contains(8)?"8":"X",
                    leavedPills.contains(9)?"9":"X",
                    leavedPills.contains(10)?"10":"X"
                    );
            System.out.printf("  (%s) (%s) (%s) \n",
                    leavedPills.contains(4)?"4":"X",
                    leavedPills.contains(5)?"5":"X",
                    leavedPills.contains(6)?"6":"X"
                    );
            System.out.printf("    (%s) (%s) \n",
                    leavedPills.contains(2)?"2":"X",
                    leavedPills.contains(3)?"3":"X"
                    );
            System.out.printf("      (%s) \n",
                    leavedPills.contains(1)?"1":"X"
                    );
            System.out.println("Downed pills: " +
                    player.getFrames().get(frameCounter).getDownPills().get(0)
                            .stream().map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
            System.out.println("Player " + player.getName() +
                    ", input numbers of down pills (allowed numbers: '" +
                    leavedPills.stream().map(Object::toString)
                            .collect(Collectors.joining(", "))
                    + "'): ");
            }
        res = new ArrayList<>();
        for(int t = 0; t < 100; t++){
            res = new ArrayList<>();
            String buf = "";

            try {
                buf = in.nextLine();
            } catch (InputMismatchException ex) {
                in.nextLine();
                System.out.println(ex.getMessage());
            }

            if(buf.equals("")){
                break;
            }

            String[] bufs = buf.split(" ");

            try{
                for (String s: bufs
                     ) {
                    int pill = parseInt(s);
                    res.add(pill);
                }
            }catch (NumberFormatException e){
                System.out.println("Wrong input! Please try again.");
                continue;
            }

            boolean hasErrors = false;
            boolean hasNoRepeats = true;
            for (int pill:res
                 ) {
                //System.out.println("Checking pill: " + pill);
                if(res.size() > 10){
                    hasErrors = true;

                }
                if(pill < 1 || pill > 10) {
                    hasErrors = true;

                }else{
                    if(player.getFrames().size() == 0 || player.isFirstRollInFrame(player.getFrames())){
                        //break;
                    }else{
                        if(player.getFrames().get(player.getFrames().size()-1).getDownPills().get(0).contains(pill)){
                            System.out.println("Pill you input (" + pill + ") already down! Try again.");
                            System.out.println("List: " + player.getFrames().get(frameCounter).getDownPills().get(0)
                                    .stream().map(Object::toString)
                                    .collect(Collectors.joining(", "))
                            );
                            hasNoRepeats = false;
                            break;
                        }
                    }
                }

            }
            if(hasErrors){
                System.out.println("Wrong input! Try again.");
                continue;
            }
            if(hasNoRepeats){
                break;
            }
        }//end of input cycle

        if(player.getFrames().size() == 0 || player.isFirstRollInFrame(player.getFrames())){

            System.out.println("Player " + player.getName() + " down pills:" + res.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")));
        }else {
            System.out.println("Player " + player.getName() + " wadditionally down pills:" + res.stream().map(Object::toString)
                    .collect(Collectors.joining(", ")) + ". All downed pills are: " +
                            Stream.of(player.getFrames().get(frameCounter).getAllDownedPills(), res)
                                    .flatMap(x -> x.stream())
                                    .collect(Collectors.toList())
                            .stream().map(Object::toString)
                            .collect(Collectors.joining(", "))
            );
        }

        player.makeRoll(res);

    }

    public void inputPlayerNames(int index, InputReader in) {
        String name = "";
        for (int i = 0; i < index; i++) {
            for(int j = 0; j < 100; j++){
                System.out.print("Input a name for player #" + (i + 1) + " (name will be trimmed by 10 symbols): ");
                name = in.nextLine();
                if(name.equals("")){
                    System.out.println("Wrong input! Try again.");
                }else{
                    if(name.length() > 10){
                        name = name.substring(0,10);
                    }
                    break;
                }
            }
            players.add(new Player(name));
            System.out.println("Player #"+ (i+1) +": " + players.get(players.size()-1).getName());
            name = "";
        }

    }

}
