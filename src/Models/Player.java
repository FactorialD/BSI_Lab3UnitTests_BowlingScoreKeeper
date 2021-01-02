package Models;

public class Player {

    private Frame[] frames = new Frame[10];
    private int currentFrame = 0;//1
    private int currentScore = 0;
    private int[] scores = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
    private String name;



    /**
     *
     * @param frames
     * @throws IllegalArgumentException
     */
    public void updateScore(Frame[] frames){
        for (int i = 0; i < currentFrame; i++) {
            if(frames == null ){
                throw new IllegalArgumentException();
            }
            if(frames[i].getRollState() != Roll.DONE) break;
            if(i == 9){


                return;
            }
            if(frames[i].isStrike()) {
                if (getNextRollAt(i, RollStage.SECOND_ROLL) == null &&
                        getNextRollAt(i+1, RollStage.FIRST_ROLL) == null) {

                }
            }
        }




    }

    public boolean[] getNextRollAt(int frame, RollStage stage){

        if(frame >= currentFrame){
            if(frames[frame].getRollState() == Roll.BEFORE_FIRST_ROLL){
                return null;
            }else if(frames[frame].getRollState() == Roll.BEFORE_SECOND_ROLL){
                return null;
            }else if(frames[frame].getRollState() == Roll.BEFORE_THIRD_ROLL){
                if(stage == RollStage.FIRST_ROLL){
                    return frames[frame].getSecondRoll();
                }else return null;
            }else if(frames[frame].getRollState() == Roll.DONE){
                switch(stage){
                    case FIRST_ROLL: return frames[frame].getSecondRoll();
                    case SECOND_ROLL: return frame == 9? frames[frame].getThirdRoll(): null ;
                    case THIRD_ROLL: return null;
                }
            }
        }else{
            switch (stage){
                case FIRST_ROLL: return frames[frame].getSecondRoll();
                case SECOND_ROLL: return frames[frame+1].getRollState() != Roll.BEFORE_FIRST_ROLL?
                        frames[frame+1].getFirstRoll():
                        null;
            }
        }
        return null;



//        if(frame > currentFrame){
//            return null;
//        }else if(frame == currentFrame){
//            if(frames[frame].getRollState() == Roll.BEFORE_FIRST_ROLL){
//                return null;
//            }else if(frames[frame].getRollState() == Roll.BEFORE_SECOND_ROLL){
//                return null;
//            }else if(frames[frame].getRollState() == Roll.BEFORE_THIRD_ROLL){
//                if(stage == RollStage.FIRST_ROLL){
//                    return frames[frame].getSecondRoll();
//                }else return null;
//            }else if(frames[frame].getRollState() == Roll.DONE){
//                switch(stage){
//                    case FIRST_ROLL: return frames[frame].getSecondRoll();
//                    case SECOND_ROLL: return frame == 9? frames[frame].getThirdRoll(): null ;
//                    case THIRD_ROLL: return null;
//                }
//            }
//        }else{
//            switch (stage){
//                case FIRST_ROLL: return frames[frame].getSecondRoll();
//                case SECOND_ROLL: return frames[frame+1].getRollState() != Roll.BEFORE_FIRST_ROLL?
//                        frames[frame+1].getFirstRoll():
//                        null;
//            }
//        }
//        return null;

    }


    public void printScores(){

    }




    public Frame[] getFrames() {
        return frames;
    }

    public void setFrames(Frame[] frames) {
        this.frames = frames;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int currentScore) {
        this.currentScore = currentScore;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
