package Models;

import lombok.Data;
import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Player {
    //really is 11 frames here. if 10th and 11th frames is strikes, then there are 12 frames.
    ArrayList<Integer> summaryScores;
    ArrayList<Frame> frames;
    private String name;

    public Player(String name) {
        this.name = name;
        frames = new ArrayList<>();
        summaryScores = new ArrayList<>();
    }

    public Player(ArrayList<ArrayList<Integer>> downedPills) {
        this.name = "testImpl";
        this.frames = new ArrayList<>();
        summaryScores = new ArrayList<>();

        for (ArrayList<Integer> pills: downedPills) {
            makeRoll(pills);
        }
    }

    public Player(ArrayList<ArrayList<Integer>> downedPills, boolean spare) {
        this.name = "testImplForSpare";
        this.frames = new ArrayList<>();
        summaryScores = new ArrayList<>();

        for (ArrayList<Integer> pills: downedPills) {
            makeRoll(new ArrayList<Integer>(Arrays.asList()));
            makeRoll(pills);
        }
    }

    public static boolean isLastFrame(ArrayList<Frame> frames){
        if(frames == null){
            throw new IllegalArgumentException();
        }
        if(frames.size() == 11){
            if( !frames.get(10).isStrike() || !frames.get(9).isStrike() ){
                return true;
            }else{
                return false;
            }
        }else if(frames.size() == 12){
            return true;
        }else{
            return false;
        }

    }

    public static boolean isFirstRollInFrame(ArrayList<Frame> frames){
        if(frames == null){
            throw new IllegalArgumentException();
        }
        if(frames.size() < 1){
            throw new IllegalArgumentException();
        }

        if(frames.get(frames.size()-1).awaitsForFirstRoll()){
            return true;
        }else if(frames.get(frames.size()-1).awaitsForLastRoll()){
            return false;
        }else {
            return true;
        }
    }

    public void makeRoll(ArrayList<Integer> downedPills){

        if(frames.size() == 0 || !frames.get(frames.size()-1).awaitsForRoll()){
            if(isLastFrame(frames)){
                return;
                //endOfGame;
            }
            frames.add(new Frame());
            frames.get(frames.size() - 1).addNewRoll(downedPills);
        }else{
            frames.get(frames.size()-1).addNewRoll(downedPills);
        }
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
        if(!isLastFrame(getFrames())){
            return null;
        }else{
            return getSummaryScores().get(getSummaryScores().size()-1);
        }
    }

}
