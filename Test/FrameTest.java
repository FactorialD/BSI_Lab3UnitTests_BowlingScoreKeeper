import Models.Frame;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class FrameTest {


    @Test
    @Parameters(method = "parameters_to_testgetFirstRollDownPills")
    public void testgetFirstRollDownPills(boolean[] roll, int expectedScore, boolean isLastFrame){
        Frame f = new Frame(roll, roll, roll, false);
        assertEquals(expectedScore, f.getFirstRollDownPills());
    }
    @Test
    @Parameters(method = "parameters_to_testgetFirstRollDownPills")
    public void testgetSecondRollDownPills(boolean[] roll, int expectedScore, boolean isLastFrame){
        Frame f = new Frame(roll, roll, roll, false);
        assertEquals(expectedScore, f.getSecondRollDownPills());
    }
    @Test
    @Parameters(method = "parameters_to_testgetFirstRollDownPills")
    public void testgetThirdRollDownPills(boolean[] roll, int expectedScore, boolean isLastFrame){
        Frame f = new Frame(roll, roll, roll, isLastFrame);
        assertEquals(expectedScore, f.getThirdRollDownPills());
    }
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testgetThirdRollDownPills_WhenNotLastFrame")
    public void testgetThirdRollDownPills_WhenNotLastFrame(boolean[] roll, int expectedScore, boolean isLastFrame){
        Frame f = new Frame(roll, roll, roll, isLastFrame);
        assertEquals(expectedScore, f.getThirdRollDownPills());
    }
    private Object[] parameters_to_testgetFirstRollDownPills() {
        return new Object[]{
                new Object[]{new boolean[]{false,false,false,false,true,false,false,true,false,false}, 2, true},
                new Object[]{new boolean[]{true,true,true,true,true,true,true,true,true,true}, 10, true},
                new Object[]{new boolean[]{false,false,false,false,false,false,false,false,false,false}, 0, true},
        };
    }
    private Object[] parameters_to_testgetThirdRollDownPills_WhenNotLastFrame() {
        return new Object[]{
                new Object[]{new boolean[]{false,false,false,false,false,false,false,false,false,false}, 0, false},
                new Object[]{new boolean[]{false,false,false,false,true,false,false,true,false,false}, 2, false},
                new Object[]{new boolean[]{true,true,true,true,true,true,true,true,true,true}, 10, false},
        };
    }


    @Test
    @Parameters(method = "parameters_to_testisStrike")
    public void testisStrike(Frame frame, boolean expectedStrike){
        assertEquals(expectedStrike, frame.isStrike());
    }
    private Object[] parameters_to_testisStrike() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, false), false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,true,false,false,false,false,false},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false}, true), true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},false), false}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testisSpare")
    public void testisSpare(Frame frame, boolean expectedStrike){
        assertEquals(expectedStrike, frame.isSpare());
    }
    private Object[] parameters_to_testisSpare() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, false), false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},false), false},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false}, false), true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false}, true), false}
        };
    }

    @Test
    @Parameters(method = "parameters_to_isSecondStrike")
    public void isSecondStrike(Frame frame, boolean expectedStrike){
        assertEquals(expectedStrike, frame.isSecondStrike());
    }
    private Object[] parameters_to_isSecondStrike() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, true),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false}, true),
                        true},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_isSecondStrike_WhenNotLastFrame")
    public void isSecondStrike_WhenNotLastFrame(Frame frame, boolean expectedStrike){
        assertEquals(expectedStrike, frame.isSecondStrike());
    }
    private Object[] parameters_to_isSecondStrike_WhenNotLastFrame() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, false),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false}, false),
                        true},
        };
    }

    @Test
    @Parameters(method = "parameters_to_isThirdStrike")
    public void isThirdStrike(Frame frame, boolean expectedStrike){
        assertEquals(expectedStrike, frame.isThirdStrike());
    }
    private Object[] parameters_to_isThirdStrike() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, true),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},true),
                        false},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
        };
    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_isThirdStrike_WhenNotLastFrame")
    public void isThirdStrike_WhenNotLastFrame(Frame frame, boolean expectedStrike){
        assertEquals(expectedStrike, frame.isThirdStrike());
    }
    private Object[] parameters_to_isThirdStrike_WhenNotLastFrame() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, false),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false}, false),
                        true},
        };
    }

    @Test
    @Parameters(method = "parameters_to_testisSplit")
    public void testisSplit(Frame frame, boolean expectedSplit){
        assertEquals(expectedSplit, frame.isSplit());
    }
    private Object[] parameters_to_testisSplit() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, false),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},false),
                        false},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,false,true,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,true,false,true,false,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,true,false,true,true,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,true,false,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,false,true,true,true,false,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,false,true,true,true,true,true,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,false,true,true,true,true,false,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,false,true,true,true,true,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,false,true,true,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,false,true,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,false,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,false,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,false,true,false,false,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,true,false,true,false,false,true,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,false,false,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,false,true,false,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,false,true,false,true,false,false,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{true,true,false,false,true,false,false,true,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true}
        };

    }

    @Test(expected =  IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testisSplit_WhenLastFrame")
    public void testisSplit_WhenLastFrame(Frame frame, boolean expectedSplit){
        assertEquals(expectedSplit, frame.isSplit());
    }
    private Object[] parameters_to_testisSplit_WhenLastFrame() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, true),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},true),
                        false},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        false},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,true,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,false,false,true,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,true,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,false,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,true,false,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,false,false,false,true,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,false,false,false,false,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,false,false,false,true,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,false,false,false,false,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,false,false,false,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,false,false,false,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,true,false,false,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,false,false,true,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,true,false,true,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,true,false,true,true,true,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,false,true,false,true,true,false,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,true,false,true,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,true,false,true,true,false,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,true,false,true,true,true,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,true,false,true,true,false,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, true),
                        true},
        };

    }

    @Test
    @Parameters(method = "parameters_to_testgetNumbersOfDownPills")
    public void testgetNumbersOfDownPills(boolean[] roll, ArrayList<Integer>expectedResult){
        assertEquals(expectedResult, Frame.getNumbersOfDownPills(roll));

    }
    private Object[] parameters_to_testgetNumbersOfDownPills() {
        return new Object[]{
                new Object[]{ new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new ArrayList<Integer>(Arrays.asList(5,8))
                },
                new Object[]{ new boolean[]{true,false,true,false,true,false,false,true,false,false},
                        new ArrayList<Integer>(Arrays.asList(1,3,5,8))
                },
                new Object[]{ new boolean[]{false,false,true,false,true,false,false,true,true,false},
                        new ArrayList<Integer>(Arrays.asList(3,5,8,9))
                },
                new Object[]{ new boolean[]{false,true,false,false,true,false,false,true,false,false},
                        new ArrayList<Integer>(Arrays.asList(2,5,8))
                },
                new Object[]{ new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))
                },
                new Object[]{new boolean[]{false, false, false, false, false, false, false, false, false, false},
                        new ArrayList<Integer>()
                }

        };

    }

    @Test
    @Parameters(method = "parameters_to_testgetNumbersOfLeavedPills")
    public void testgetNumbersOfLeavedPills(boolean[] roll, ArrayList<Integer>expectedResult){
        assertEquals(expectedResult, Frame.getNumbersOfLeavedPills(roll));

    }
    private Object[] parameters_to_testgetNumbersOfLeavedPills() {
        return new Object[]{
                new Object[]{ new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7,9,10))
                },
                new Object[]{ new boolean[]{true,false,true,false,true,false,false,true,false,false},
                        new ArrayList<Integer>(Arrays.asList(2,4,6,7,9,10))
                },
                new Object[]{ new boolean[]{false,false,true,false,true,false,false,true,true,false},
                        new ArrayList<Integer>(Arrays.asList(1,2,4,6,7,10))
                },
                new Object[]{ new boolean[]{false,true,false,false,true,false,false,true,false,false},
                        new ArrayList<Integer>(Arrays.asList(1,3,4,6,7,9,10))
                },
                new Object[]{ new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new ArrayList<Integer>()
                },
                new Object[]{new boolean[]{false, false, false, false, false, false, false, false, false, false},
                        new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))
                }





        };

    }


    @Test
    @Parameters(method = "parameters_to_testisWashout")
    public void testisWashout(Frame frame, boolean expectedSplit){
        assertEquals(expectedSplit, frame.isWashout());
    }
    private Object[] parameters_to_testisWashout() {
        return new Object[]{
                new Object[]{new Frame(new boolean[]{true,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false},
                        new boolean[]{false,false,false,false,true,false,false,true,false,false}, false),
                        false},
                new Object[]{new Frame(new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{false,false,false,false,false,false,false,false,false,false},false),
                        false},
                new Object[]{new Frame(new boolean[]{true,false,false,false,false,false,false,false,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        false},
                new Object[]{new Frame(new boolean[]{false,true,true,true,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,true,true,true,false,true,false,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,true,true,true,true,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,true,false,true,false,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,true,false,true,true,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,true,false,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,true,true,true,false,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,true,true,true,true,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,true,true,true,false,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,true,true,true,true,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,true,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,true,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,false,true,true,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,true,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,false,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,false,true,false,false,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,true,false,true,false,false,true,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,false,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,false,true,false,false,true,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,false,true,false,true,false,false,false,true,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true},
                new Object[]{new Frame(new boolean[]{false,true,false,false,true,false,false,true,false,false},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true},
                        new boolean[]{true,true,true,true,true,true,true,true,true,true}, false),
                        true}
        };

    }

    @Test
    @Parameters(method = "parameters_to_testsetFirstSecondThirdRoll")
    public void testsetFirstSecondThirdRoll(ArrayList<Integer> downedPills, boolean []expectedRoll){
        Frame f = new Frame();
        f.setFirstRoll(downedPills);
        f.setSecondRoll(downedPills);
        f.setThirdRoll(downedPills);
        assertArrayEquals(expectedRoll, f.getFirstRoll());
        assertArrayEquals(expectedRoll, f.getSecondRoll());
        assertArrayEquals(expectedRoll, f.getThirdRoll());
    }
    private Object[] parameters_to_testsetFirstSecondThirdRoll() {
        return new Object[]{
                new Object[]{
                        new ArrayList<Integer>(Arrays.asList(1, 3, 5, 6, 7, 9)),
                        new boolean[]{true, false, true, false, true, true, true, false, true, false}
                },
                new Object[]{
                        new ArrayList<Integer>(Arrays.asList(1, 4, 5, 7, 8, 10)),
                        new boolean[]{true, false, false, true, true, false, true , true, false, true}
                }

        };

    }
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testsetFirstSecondThirdRoll_WhenWrongNumberPill")
    public void testsetFirstSecondThirdRoll_WhenWrongNumberPill(ArrayList<Integer> downedPills, boolean []expectedRoll){
        Frame f = new Frame();
        f.setFirstRoll(downedPills);
        f.setSecondRoll(downedPills);
        f.setThirdRoll(downedPills);
        assertEquals(expectedRoll,(f.getFirstRoll()));
        assertEquals(expectedRoll,(f.getSecondRoll()));
        assertEquals(expectedRoll,(f.getThirdRoll()));
    }
    private Object[] parameters_to_testsetFirstSecondThirdRoll_WhenWrongNumberPill() {
        return new Object[]{
                new Object[]{
                        new ArrayList<Integer>(Arrays.asList(0, 3, 5, 6, 7, 10)),
                        new boolean[]{true, false, true, false, true, true, true, false, true, false},

                },
                new Object[]{
                        new ArrayList<Integer>(Arrays.asList(1, 4, 5, 7, 8, 11)),
                        new boolean[]{true, false, false, true, true, false, true , true, false, true},

                },
                new Object[]{
                        new ArrayList<Integer>(Arrays.asList(-40, 22, 5, 7, 8, 11)),
                        new boolean[]{true, false, false, true, true, false, true , true, false, true},

                }

        };

    }
}
