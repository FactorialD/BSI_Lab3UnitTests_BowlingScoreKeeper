package Models;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class Frame2 {


    private ArrayList<Integer> scores;
    private ArrayList<ArrayList<Integer>> downPills;


    public Frame2(ArrayList<Integer> scores, ArrayList<ArrayList<Integer>> downPills) {
        this.scores = scores;
        this.downPills = downPills;
    }

    public Frame2() {
        scores = new ArrayList<>();
        downPills = new ArrayList<>();
    }

    public void addNewRoll(ArrayList<Integer> downedPills){
        if(downPills.size() > 2){
            throw new IllegalArgumentException();
        }else{
            downPills.add(downedPills);
            scores.add(getScoreFromPills(downedPills));
        }
    }

    public boolean awaitsForRoll(){
    if(awaitsForFirstRoll() || awaitsForLastRoll()){
        return true;
    }else{
        return false;
    }
    }

    public boolean awaitsForLastRoll(){
        if( (scores.size() == 1 && !isStrike()) ) {return true;}
        else {
            return false;
        }
    }
    public boolean awaitsForFirstRoll(){
        if(scores.size() == 0) {return true;}
        else {
            return false;
        }
    }


    public boolean isStrike(){
        if(scores.get(0) == 10) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isSpare(){
        if(!isStrike() && (getAllDownedPills().size() == 10) ) {
            return true;
        }else{
            return false;
        }
    }

    public boolean isSplit(){

        if(downPills.get(0).contains(1)){
            if(isSplitCombination()){
                return true;
            }else return false;
        }
        return false;

    }

    public boolean isWashout(){
        if(! downPills.get(0).contains(1)){
            if(isWashoutCombination()){
                return true;
            }else return false;
        }
        return false;
    }

    public ArrayList<Integer> getAllDownedPills(){
        ArrayList<Integer> allList = new ArrayList<Integer>();
        allList.addAll(getDownPills().get(0));
        if(!awaitsForRoll() && !isStrike()){
            allList.addAll(getDownPills().get(1));
        }
        return allList;
    }


    public ArrayList<Integer> getLeavedPillsForFirstRoll(){
        ArrayList<Integer> leavedPills = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            if(getDownPills().get(0).contains(i)){
                continue;
            }else{
                leavedPills.add(i);
            }
        }
        return leavedPills;
    }

    public static int getScoreFromPills(ArrayList<Integer> pills){
        return pills.size();
    }

    public boolean isSplitCombination(){
        return  (
            getLeavedPillsForFirstRoll().equals(Arrays.asList(7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(7,9)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(8,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(5,7)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(5,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(5,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(3,7)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(2,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(2,7)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(3,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(2,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(3,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(4,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(6,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(4,6,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(4,6,7,8,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(4,6,7,9,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(3,4,6,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(2,4,6,7,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(2,4,6,7,8,10)) ||
            getLeavedPillsForFirstRoll().equals(Arrays.asList(3,4,6,7,9,10))
        );
    }

    public boolean isWashoutCombination(){
        return  (
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,7,9)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,8,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,5,7)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,5,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,5,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,3,7)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,2,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,2,7)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,3,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,2,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,3,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,4,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,6,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,4,6,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,4,6,7,8,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,4,6,7,9,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,3,4,6,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,2,4,6,7,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,2,4,6,7,8,10)) ||
             getLeavedPillsForFirstRoll().equals(Arrays.asList(1,3,4,6,7,9,10))
        );
    }

}
