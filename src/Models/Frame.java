package Models;

import java.util.ArrayList;
import java.util.Arrays;


public class Frame {

    private boolean isLastFrame = false;

    private boolean[] firstRoll;
    private boolean[] secondRoll;
    private boolean[] thirdRoll;


    private Roll rollState = Roll.BEFORE_FIRST_ROLL;

    public Frame(boolean forTest) {
        firstRoll = new boolean[10];
        secondRoll = new boolean[10];
        thirdRoll = new boolean[10];
    }

    public Frame(){
        firstRoll = null;
        secondRoll = null;
        thirdRoll = null;
    }

    public Frame(boolean[] firstRoll, boolean[] secondRoll, boolean[] thirdRoll, boolean isLastFrame) {
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.thirdRoll = thirdRoll;
        this.isLastFrame = isLastFrame;
    }

    public void setFirstRoll(ArrayList<Integer> downPills) {
        if(rollState != Roll.BEFORE_FIRST_ROLL){
            throw new IllegalArgumentException();
        }
        boolean[] roll = new boolean[10];
        for (int a:downPills
             ) {
            if(a > 10 || a < 1){
                throw new IllegalArgumentException();
            }
            roll[a-1] = true;
        }
        this.firstRoll = roll;
        if(this.isStrike()){
            rollState = Roll.DONE;
        }
        else{
            rollState = Roll.BEFORE_SECOND_ROLL;
        }
    }
    public void setSecondRoll(ArrayList<Integer> downPills) {
        if(rollState != Roll.BEFORE_SECOND_ROLL){
            throw new IllegalArgumentException();
        }
        boolean[] roll = new boolean[10];
        for (int a:downPills
        ) {
            if(a > 10 || a < 1){
                throw new IllegalArgumentException();
            }
            roll[a-1] = true;
        }
        this.secondRoll = roll;
        if(this.isLastFrame){
            rollState = Roll.BEFORE_THIRD_ROLL;
        }
        else{
            rollState = Roll.DONE;
        }
    }
    public void setThirdRoll(ArrayList<Integer> downPills) {
        if(rollState != Roll.BEFORE_THIRD_ROLL){
            throw new IllegalArgumentException();
        }
        boolean[] roll = new boolean[10];
        for (int a:downPills) {
            if(a > 10 || a < 1){
                throw new IllegalArgumentException();
            }
            roll[a-1] = true;
        }
        this.thirdRoll = roll;
        rollState = Roll.DONE;
    }

    public int getFirstRollDownPills(){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if(firstRoll[i]){
                count++;
            }
        }
        return count;
    }

    public int getSecondRollDownPills(){
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if(secondRoll[i]){
                count++;
            }
        }
        return count;
    }

    public int getThirdRollDownPills(){
        if(!isLastFrame){
            throw new IllegalArgumentException();
        }else{
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if(thirdRoll[i]){
                    count++;
                }
            }
            return count;
        }
    }

    public boolean isStrike(){
        if(getFirstRollDownPills() == 10){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isSecondStrike(){
        if(isLastFrame){
            if (getSecondRollDownPills() == 10){
                return true;
            }
            else{
                return false;
            }
        }else{
            throw new IllegalArgumentException();
        }

    }

    public boolean isThirdStrike(){
        if(isLastFrame){
            if (getThirdRollDownPills() == 10){
                return true;
            }
            else{
                return false;
            }
        }else{
            throw new IllegalArgumentException();
        }
    }

    public boolean isSpare(){
            if(getFirstRollDownPills() != 10 && getSecondRollDownPills() == 10){
                return true;
            }else{
                return false;
            }
    }

    public boolean isSecondSpare(){
        if(!isLastFrame){
            throw new IllegalArgumentException();
        }else{
            if(isStrike() && getSecondRollDownPills() != 10 && getSecondRollDownPills() == 10){
                return true;
            }else{
                return false;
            }
        }

    }

    public boolean isSplit(){
        if(isLastFrame){
            throw new IllegalArgumentException();
        }else{
            if(firstRoll[0] == true && getSecondRollDownPills() == 10){
                if(isSplitCombination()){
                    return true;
                }else return false;
            }
            return false;
        }

    }

    public boolean isWashout(){
        if(isLastFrame){
            throw new IllegalArgumentException();
        }else{
            if(firstRoll[0] == false && getSecondRollDownPills() == 10){
                if(isWashoutCombination()){
                    return true;
                }else return false;
            }
            return false;
        }
    }

    public static ArrayList<Integer> getNumbersOfLeavedPills(boolean[] roll){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < roll.length; i++) {
            if(roll[i] == false){
                list.add(i+1);
            }
        }
        return list;
    }

    public static ArrayList<Integer> getNumbersOfDownPills(boolean[] roll){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < roll.length; i++) {
            if(roll[i]){
                list.add(i+1);
            }
        }
        return list;
    }

    public boolean isSplitCombination(){
        return  (
                getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(7,9)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(8,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(5,7)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(5,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(5,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(3,7)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(2,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(2,7)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(3,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(2,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(3,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(4,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(4,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(4,6,7,8,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(4,6,7,9,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(3,4,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(2,4,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(2,4,6,7,8,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(3,4,6,7,9,10))
        );
    }

    public boolean isWashoutCombination(){
        return  (
                getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,7,9)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,8,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,5,7)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,5,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,5,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,3,7)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,2,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,2,7)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,3,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,2,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,3,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,4,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,4,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,4,6,7,8,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,4,6,7,9,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,3,4,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,2,4,6,7,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,2,4,6,7,8,10)) ||
                        getNumbersOfLeavedPills(firstRoll).equals(Arrays.asList(1,3,4,6,7,9,10))
        );
    }

    public boolean[] getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(boolean[] firstRoll) {
        this.firstRoll = firstRoll;
    }

    public boolean[] getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(boolean[] secondRoll) {
        this.secondRoll = secondRoll;
    }

    public boolean[] getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(boolean[] thirdRoll) {
        this.thirdRoll = thirdRoll;
    }

    public Roll getRollState() {
        return rollState;
    }

    public void setRollState(Roll rollState) {
        this.rollState = rollState;
    }

}
