import Models.Frame;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class FrameTest {

    @Test
    @Parameters(method = "parameters_to_testaddNewRoll")
    public void testaddNewRoll(ArrayList<Integer> downedPills,  ArrayList<Integer> expectedScores, ArrayList<ArrayList<Integer>> expectedDownPills){
        Frame f = new Frame();
        f.addNewRoll(downedPills);
        assertEquals(f.getScores(), expectedScores );
        assertEquals(f.getDownPills(), expectedDownPills);
    }
    private Object[] parameters_to_testaddNewRoll() {
        return new Object[]{
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)),                 new ArrayList<Integer>(Arrays.asList(5)),     new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(1,2,3,4,5)                 ))))     },
                new Object[]{new ArrayList<Integer>(Arrays.asList()),                          new ArrayList<Integer>(Arrays.asList(0)),     new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList()                          ))))     },
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10)),      new ArrayList<Integer>(Arrays.asList(10)),    new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)      ))))     },
                new Object[]{new ArrayList<Integer>(Arrays.asList(8,9,10)),                    new ArrayList<Integer>(Arrays.asList(3)),     new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(8,9,10)                    ))))     }

        };
    }
    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testaddNewRoll_whenWrongArgumentsNumber")
    public void testaddNewRoll_whenWrongArgumentsNumber(ArrayList<Integer> downedPills,  ArrayList<Integer> expectedScores, ArrayList<ArrayList<Integer>> expectedDownPills){
        Frame f = new Frame();
        f.addNewRoll(downedPills);
        assertEquals(expectedScores, f.getScores());
        assertEquals(expectedDownPills, f.getDownPills());
    }
    private Object[] parameters_to_testaddNewRoll_whenWrongArgumentsNumber() {
        return new Object[]{
                new Object[]{new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2)),                 new ArrayList<>(Arrays.asList(10)),      new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),  new ArrayList<>((Arrays.asList(6,7,8,9,10)))  )))     },
                new Object[]{new ArrayList<>(Arrays.asList(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)),                          new ArrayList<>(Arrays.asList(0)),      new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList()                          )))))     },
                new Object[]{new ArrayList<>(Arrays.asList(11,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12,12)),      new ArrayList<>(Arrays.asList(10)),     new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)      )))))     }
        };
    }

    @Test
    @Parameters(method = "parameters_to_testawaitsForFirstRoll")
    public void testawaitsForFirstRoll(Frame frame, boolean expectedResult){
        assertEquals( frame.awaitsForFirstRoll(), expectedResult);

    }
    private Object[] parameters_to_testawaitsForFirstRoll() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList()));

        ArrayList<ArrayList<Integer>> b1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1, 2, 3, 4, 6, 7, 10)   )))));
        ArrayList<ArrayList<Integer>> b2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(1, 2, 4, 6, 7, 10)))  , new ArrayList<Integer>((Arrays.asList(8, 9)))      )));

        return new Object[]{
                new Object[]{   new Frame( a1 ),    true},

                new Object[]{   new Frame( b1 ),   false},
                new Object[]{   new Frame( b2 ),   false}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testawaitsForLastRoll")
    public void testawaitsForLastRoll(Frame frame, boolean expectedResult){
        assertEquals( frame.awaitsForLastRoll(), expectedResult);
    }
    private Object[] parameters_to_testawaitsForLastRoll() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10))))      ));

        ArrayList<ArrayList<Integer>> b1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1, 2, 3, 4,5, 6, 7, 8, 9, 10)   )))));
        ArrayList<ArrayList<Integer>> b2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(1, 2, 4, 6, 7, 10)))  , new ArrayList<Integer>((Arrays.asList(8, 9)))      )));

        return new Object[]{
                new Object[]{   new Frame( a1 ),    true},

                new Object[]{   new Frame( b1 ),   false},
                new Object[]{   new Frame( b2 ),   false}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testawaitsForRoll")
    public void testawaitsForRoll(Frame frame, boolean expectedResult){
        assertEquals( frame.awaitsForRoll(), expectedResult);
    }
    private Object[] parameters_to_testawaitsForRoll() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10))))      ));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList()));

        ArrayList<ArrayList<Integer>> b1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1, 2, 3, 4, 5,6, 7, 8, 9, 10)   )))));
        ArrayList<ArrayList<Integer>> b2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(1, 2, 4, 6, 7, 10)))  , new ArrayList<Integer>((Arrays.asList(8, 9)))      )));
        ArrayList<ArrayList<Integer>> b4 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<Integer>((Arrays.asList(1, 2, 4, 6, 7, 10)))  , new ArrayList<Integer>((Arrays.asList(8, 9)))      )));

        return new Object[]{
                new Object[]{   new Frame( a1 ),    true},
                new Object[]{   new Frame( a2 ),    true},

                new Object[]{   new Frame( b1 ),   false},
                new Object[]{   new Frame( b2 ),   false},
                new Object[]{   new Frame( b4 ),   false}
        };
    }


    @Test
    @Parameters(method = "parameters_to_testgetAllDownedPills")
    public void testgetAllDownedPills(Frame frame, ArrayList<Integer> expectedDownedPills){
        assertEquals( frame.getAllDownedPills().containsAll( expectedDownedPills), true );
    }
    private Object[] parameters_to_testgetAllDownedPills() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))       )));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))     )));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),       new ArrayList<>((Arrays.asList(6,7,8,9,10)))                )));
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(2,4,6,8))),                new ArrayList<>((Arrays.asList(1,3,5,9,10)))         )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      )));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))            )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList()))                          )));

        return new Object[]{
                new Object[]{   new Frame( a1 ),   new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,9,10))},
                new Object[]{   new Frame( a2 ),   new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))},
                new Object[]{   new Frame( a3 ),   new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))},
                new Object[]{   new Frame( a4 ),   new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,8,9,10))},
                new Object[]{   new Frame( a5 ),   new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10))},
                new Object[]{   new Frame( a6 ),   new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,9,10))},
                new Object[]{   new Frame( a7 ),   new ArrayList<Integer>(Arrays.asList())},
        };
    }

    @Test
    @Parameters(method = "parameters_to_testisStrike")
    public void testisStrike(Frame frame, boolean expectedResult){
        assertEquals( frame.isStrike(), expectedResult);
    }
    private Object[] parameters_to_testisStrike() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))       )));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))     )));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),       new ArrayList<>((Arrays.asList(6,7,8,9,10)))                )));
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(2,4,6,8))),                new ArrayList<>((Arrays.asList(1,3,5,9,10)))         )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      )));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))            )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList()))                          )));
        ArrayList<ArrayList<Integer>> a8 = new ArrayList<>(new ArrayList<>(Arrays.asList()));
        return new Object[]{
                new Object[]{   new Frame( a1 ),   false},
                new Object[]{   new Frame( a2 ),   true},
                new Object[]{   new Frame( a3 ),   false},
                new Object[]{   new Frame( a4 ),   false},
                new Object[]{   new Frame( a5 ),   false},
                new Object[]{   new Frame( a6 ),   false},
                new Object[]{   new Frame( a7 ),   false},
                new Object[]{   new Frame( a8 ),   false}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testisSpare")
    public void testisSpare(Frame frame, boolean expectedResult){
        assertEquals( frame.isSpare(), expectedResult);
    }
    private Object[] parameters_to_testisSpare() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))       )));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))     )));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),       new ArrayList<>((Arrays.asList(6,7,8,9,10)))                )));
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(2,4,6,8))),                new ArrayList<>((Arrays.asList(1,3,5,9,10)))         )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      )));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))            )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList()))                          )));

        return new Object[]{
                new Object[]{   new Frame( a1 ),   false},
                new Object[]{   new Frame( a2 ),   false},
                new Object[]{   new Frame( a3 ),   true},
                new Object[]{   new Frame( a4 ),   false},
                new Object[]{   new Frame( a5 ),   true},
                new Object[]{   new Frame( a6 ),   false},
                new Object[]{   new Frame( a7 ),   false}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testisSplit")
    public void testisSplit(Frame frame, boolean expectedSplit){
        assertEquals(expectedSplit, frame.isSplit());
    }
    private Object[] parameters_to_testisSplit() {

        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(7, 10)                  ) )))));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(7, 9)                   ) )))));
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(8, 10)                  ) )))));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(5, 7)                   ) )))));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(5, 10)                  ) )))));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(5, 7, 10)               ) )))));
        ArrayList<ArrayList<Integer>> a8 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(3, 7)                   ) )))));
        ArrayList<ArrayList<Integer>> a9 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2, 10)                  ) )))));
        ArrayList<ArrayList<Integer>> a0 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2, 7)                   ) )))));
        ArrayList<ArrayList<Integer>> aa = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(3, 10)                  ) )))));
        ArrayList<ArrayList<Integer>> ab = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2, 7, 10)               ) )))));
        ArrayList<ArrayList<Integer>> ac = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(3, 7, 10)               ) )))));
        ArrayList<ArrayList<Integer>> ad = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(4, 7, 10)               ) )))));
        ArrayList<ArrayList<Integer>> ae = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(6, 7, 10)               ) )))));
        ArrayList<ArrayList<Integer>> af = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(4, 6, 7, 10)            ) )))));
        ArrayList<ArrayList<Integer>> ag = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(4, 6, 7, 8, 10)         ) )))));
        ArrayList<ArrayList<Integer>> ah = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(4, 6, 7, 9, 10)         ) )))));
        ArrayList<ArrayList<Integer>> ai = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(3, 4, 6, 7, 10)         ) )))));
        ArrayList<ArrayList<Integer>> aj = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2, 4, 6, 7, 10)         ) )))));
        ArrayList<ArrayList<Integer>> ak = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2, 4, 6, 7, 8, 10)      ) )))));
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(3, 4, 6, 7, 9, 10)      ) )))));

        ArrayList<ArrayList<Integer>> b1 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1, 2, 3, 4, 6, 7, 10)   ) )))));
        ArrayList<ArrayList<Integer>> b2 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1, 2, 4, 6, 7, 10)      ) )))));
        ArrayList<ArrayList<Integer>> b3 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1, 2, 4, 6, 7, 8, 10)   ) )))));
        ArrayList<ArrayList<Integer>> b4 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1, 3, 4, 6, 7, 9, 10)   ) )))));
        ArrayList<ArrayList<Integer>> b5 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2, 3, 4,5, 6, 7,8, 9, 10)   ) )))));

        return new Object[]{
                new Object[]{   new Frame( a2 ),    true},
                new Object[]{   new Frame( a3 ),    true},
                new Object[]{   new Frame( a4 ),    true},
                new Object[]{   new Frame( a5 ),    true},
                new Object[]{   new Frame( a6 ),    true},
                new Object[]{   new Frame( a7 ),    true},
                new Object[]{   new Frame( a8 ),    true},
                new Object[]{   new Frame( a9 ),    true},
                new Object[]{   new Frame( a0 ),    true},
                new Object[]{   new Frame( aa ),    true},
                new Object[]{   new Frame( ab ),    true},
                new Object[]{   new Frame( ac ),    true},
                new Object[]{   new Frame( ad ),    true},
                new Object[]{   new Frame( ae ),    true},
                new Object[]{   new Frame( af ),    true},
                new Object[]{   new Frame( ag ),    true},
                new Object[]{   new Frame( ah ),    true},
                new Object[]{   new Frame( ai ),    true},
                new Object[]{   new Frame( aj ),    true},
                new Object[]{   new Frame( ak ),    true},
                new Object[]{   new Frame( al ),    true},

                new Object[]{   new Frame( b1 ),   false},
                new Object[]{   new Frame( b2 ),   false},
                new Object[]{   new Frame( b3 ),   false},
                new Object[]{   new Frame( b4 ),   false},
                new Object[]{   new Frame( b5 ),   false}

        };

    }

    @Test
    @Parameters(method = "parameters_to_testisWashout")
    public void testisWashout(Frame frame, boolean expectedSplit){
        assertEquals(frame.isWashout(), expectedSplit);
    }
    private Object[] parameters_to_testisWashout() {

        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,7,10)         )  )))));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,7,9)          )  )))));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,8,10)         )  )))));
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,5,7)          )  )))));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,5,10)         )  )))));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,5,7,10)       )  )))));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,3,7)          )  )))));
        ArrayList<ArrayList<Integer>> a8 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,2,10)         )  )))));
        ArrayList<ArrayList<Integer>> a9 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,2,7)          )  )))));
        ArrayList<ArrayList<Integer>> a0 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,3,10)         )  )))));
        ArrayList<ArrayList<Integer>> aa = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,2,7,10)       )  )))));
        ArrayList<ArrayList<Integer>> ab = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,3,7,10)       )  )))));
        ArrayList<ArrayList<Integer>> ac = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,4,7,10)       )  )))));
        ArrayList<ArrayList<Integer>> ad = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,6,7,10)       )  )))));
        ArrayList<ArrayList<Integer>> ae = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,4,6,7,10)     )  )))));
        ArrayList<ArrayList<Integer>> af = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,4,6,7,8,10)   )  )))));
        ArrayList<ArrayList<Integer>> ag = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,4,6,7,9,10)   )  )))));
        ArrayList<ArrayList<Integer>> ah = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,3,4,6,7,10)   )  )))));
        ArrayList<ArrayList<Integer>> ai = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,2,4,6,7,10)   )  )))));
        ArrayList<ArrayList<Integer>> aj = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,2,4,6,7,8,10) )  )))));
        ArrayList<ArrayList<Integer>> ak = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,3,4,6,7,9,10) )  )))));

        ArrayList<ArrayList<Integer>> b1 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2,4,6,7,10)     )  )))));
        ArrayList<ArrayList<Integer>> b2 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(2,4,6,7,8,10)   )  )))));
        ArrayList<ArrayList<Integer>> b3 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(3,4,6,7,9,10)   )  )))));
        ArrayList<ArrayList<Integer>> b4 = new ArrayList<>(new ArrayList<>(Arrays.asList(Frame.getLeavedPillsForFirstRoll(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,9,10)   )  )))));

        return new Object[]{
                new Object[]{   new Frame( a1 ),    true},
                new Object[]{   new Frame( a2 ),    true},
                new Object[]{   new Frame( a3 ),    true},
                new Object[]{   new Frame( a4 ),    true},
                new Object[]{   new Frame( a5 ),    true},
                new Object[]{   new Frame( a6 ),    true},
                new Object[]{   new Frame( a7 ),    true},
                new Object[]{   new Frame( a8 ),    true},
                new Object[]{   new Frame( a9 ),    true},
                new Object[]{   new Frame( a0 ),    true},
                new Object[]{   new Frame( aa ),    true},
                new Object[]{   new Frame( ab ),    true},
                new Object[]{   new Frame( ac ),    true},
                new Object[]{   new Frame( ad ),    true},
                new Object[]{   new Frame( ae ),    true},
                new Object[]{   new Frame( af ),    true},
                new Object[]{   new Frame( ag ),    true},
                new Object[]{   new Frame( ah ),    true},
                new Object[]{   new Frame( ai ),    true},
                new Object[]{   new Frame( aj ),    true},
                new Object[]{   new Frame( ak ),    true},

                new Object[]{   new Frame( b1 ),   false},
                new Object[]{   new Frame( b2 ),   false},
                new Object[]{   new Frame( b3 ),   false},
                new Object[]{   new Frame( b4 ),   false}

        };
    }


    @Test
    @Parameters(method = "parameters_to_testgetLeavedPillsForFirstRoll")
    public void testgetLeavedPillsForFirstRoll(Frame frame, ArrayList<Integer> expectedLeavedPills){
        assertEquals(expectedLeavedPills, Frame.getLeavedPillsForFirstRoll(frame.getDownPills().get(0)));
    }
    private Object[] parameters_to_testgetLeavedPillsForFirstRoll() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))       )));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))     )));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),       new ArrayList<>((Arrays.asList(6,7,8,9,10)))                )));
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(2,4,6,8))),                new ArrayList<>((Arrays.asList(1,3,5,9,10)))         )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      )));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))            )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList()))                          )));

        return new Object[]{
                new Object[]{   new Frame( a1 ),   new ArrayList<>((Arrays.asList(6,7,8)))},
                new Object[]{   new Frame( a2 ),   new ArrayList<>((Arrays.asList()))},
                new Object[]{   new Frame( a3 ),   new ArrayList<>((Arrays.asList(6,7,8,9,10)))},
                new Object[]{   new Frame( a4 ),   new ArrayList<>((Arrays.asList(1,3,5,7,9,10)))},
                new Object[]{   new Frame( a5 ),   new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))},
                new Object[]{   new Frame( a6 ),   new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))},
                new Object[]{   new Frame( a7 ),   new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))}
        };

    }


    @Test
    @Parameters(method = "parameters_to_testisSplitCombination")
    public void testisSplitCombination(ArrayList<Integer> leavedPillsForFirstRoll, boolean expectedSplit){
        assertEquals(expectedSplit, Frame.isSplitCombination(leavedPillsForFirstRoll));
    }
    private Object[] parameters_to_testisSplitCombination() {
        return new Object[]{
                new Object[]{(new ArrayList<Integer>(Arrays.asList(7,10))),                 true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(7,9))),                  true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(8,10))),                 true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(5,7))),                  true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(5,10))),                 true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(5,7,10))),               true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(3,7))),                  true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(2,10))),                 true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(2,7))),                  true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(3,10))),                 true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(2,7,10))),               true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(3,7,10))),               true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(4,7,10))),               true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(6,7,10))),               true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(4,6,7,10))),             true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(4,6,7,8,10))),           true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(4,6,7,9,10))),           true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(3,4,6,7,10))),           true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(2,4,6,7,10))),           true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(2,4,6,7,8,10))),         true},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(3,4,6,7,9,10))),         true},

                new Object[]{(new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7,10))),      false},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(1,2,4,6,7,10))),        false},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(1,2,4,6,7,8,10))),      false},
                new Object[]{(new ArrayList<Integer>(Arrays.asList(1,3,4,6,7,9,10))),      false}
        };

    }

    @Test
    @Parameters(method = "parameters_to_testisWashoutCombination")
    public void testisWashoutCombination(ArrayList<Integer> leavedPillsForFirstRoll, boolean expectedSplit){
        assertEquals(expectedSplit, Frame.isWashoutCombination(leavedPillsForFirstRoll));
    }
    private Object[] parameters_to_testisWashoutCombination() {
        return new Object[]{
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,7,10))        ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,7,9))         ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,8,10))        ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,5,7))         ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,5,10))        ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,5,7,10))      ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,3,7))         ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,10))        ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,7))         ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,3,10))        ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,7,10))      ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,3,7,10))      ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,4,7,10))      ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,6,7,10))      ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,4,6,7,10))    ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,4,6,7,8,10))  ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,4,6,7,9,10))  ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,3,4,6,7,10))  ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,4,6,7,10))  ,      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,2,4,6,7,8,10)),      true},
                new Object[]{new ArrayList<Integer>(Arrays.asList(1,3,4,6,7,9,10)),      true},

                new Object[]{new ArrayList<Integer>(Arrays.asList(2,3,4,6,7,10)),     false},
                new Object[]{new ArrayList<Integer>(Arrays.asList(2,4,6,7,10)),       false},
                new Object[]{new ArrayList<Integer>(Arrays.asList(2,4,6,7,8,10)),     false},
                new Object[]{new ArrayList<Integer>(Arrays.asList(3,4,6,7,9,10)),     false}
        };

    }

}
