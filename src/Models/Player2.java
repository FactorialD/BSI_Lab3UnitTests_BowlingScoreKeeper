package Models;

import lombok.Data;
import java.util.ArrayList;

@Data
public class Player2 {
    //really is 11 frames here. if 10th and 11th frames is strikes, then there are 12 frames.
    ArrayList<Integer> summaryScores;
    ArrayList<Frame2> frames;
    private String name;

    public Player2(String name) {
        this.name = name;
        frames = new ArrayList<>();
        summaryScores = new ArrayList<>();
    }

    public boolean isLastFrame(){

        if(frames.size() == 11){
            if( !frames.get(10).isStrike() || !frames.get(9).isStrike() ){
                //endOfGame;
                return true;
            }else{//add 12th frame
                return false;
            }
        }else if(frames.size() == 12){
            return true;
        }else{
            return false;
        }

    }

    public boolean isFirstRollInFrame(){
        if(getFrames().get(getFrames().size()-1).awaitsForFirstRoll()){
            return true;
        }else if(getFrames().get(getFrames().size()-1).awaitsForLastRoll()){
            return false;
        }else {
            return true;
        }

    }

    public void makeRoll(ArrayList<Integer> downedPills){

        if(frames.size() == 0){
            System.out.println("                    Frame is empty.");
        }else{
            System.out.println("                    Frame waits for first roll: " + frames.get(frames.size()-1).awaitsForFirstRoll());
            System.out.println("                    Frame waits for last roll: " + frames.get(frames.size()-1).awaitsForLastRoll());
        }

        if(frames.size() == 0 || !frames.get(frames.size()-1).awaitsForRoll()){
            if(isLastFrame()){
                return;
                //endOfGame;
            }
            frames.add(new Frame2());
            frames.get(frames.size() - 1).addNewRoll(downedPills);
        }else{
            frames.get(frames.size()-1).addNewRoll(downedPills);
        }
        System.out.println("                    After adding new roll;");
        System.out.println("                    Frame waits for first roll: " + frames.get(frames.size()-1).awaitsForFirstRoll());
        System.out.println("                    Frame waits for last roll: " + frames.get(frames.size()-1).awaitsForLastRoll());
        updateSummaryScore();
    }

    public void updateSummaryScore(){
        summaryScores = new ArrayList<>();
        for (int i = 0; i < getFrames().size(); i++) {
            if(i < 9){
                if (getFrames().size()-1 >= i+2 && getFrames().get(i).isStrike()){
                    summaryScores.add(10 + getFrames().get(i+1).getAllDownedPills().size() + getFrames().get(i+2).getAllDownedPills().size());
                }else if(getFrames().size()-1 >= i+1 && getFrames().get(i).isSpare()){
                    summaryScores.add(10 + getFrames().get(i+1).getAllDownedPills().size());
                }else{
                    summaryScores.add(getFrames().get(i).getAllDownedPills().size());
                }
            }else{
                if(getFrames().size()-1 >= i+1 && getFrames().get(i).isSpare()){
                    summaryScores.add(10 + getFrames().get(i+1).getAllDownedPills().size());
                }else{
                    summaryScores.add(getFrames().get(i).getAllDownedPills().size());
                }
            }



        }

    }

    public Integer getSummaryScoreOf(int index){
        int summaryScore = 0;
        for (int i = 0; i <= index; i++) {
            summaryScore+=getSummaryScores().get(i);
        }

        return summaryScore;


    }

    public Integer get10Score(){//get last 10 frame score. if not exist then null;
        if(!isLastFrame()){
            return null;
        }else{
            return getSummaryScores().get(getSummaryScores().size()-1);
        }
    }


}
