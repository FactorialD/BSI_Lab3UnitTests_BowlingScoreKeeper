import Models.Frame;
import Models.Player;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnitParamsRunner.class)
public class PlayerTest {

    @Test
    @Parameters(method = "parameters_to_testisLastFrame")
    public void testisLastFrame(ArrayList<Frame> frames, boolean expectedResult){
        assertEquals(Player.isLastFrame(frames), expectedResult);
    }
    private Object[] parameters_to_testisLastFrame() {

        ArrayList<Frame> f1 = new ArrayList<>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) )
        )   );
        ArrayList<Frame> f2 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) )
        )   );
        ArrayList<Frame> f3 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      )))),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))    ))) )
        )   );
        ArrayList<Frame> f4 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))    ))) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList())),                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      ))))

        )   );
        ArrayList<Frame> f5 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))    ))) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      ))))

        )   );
        ArrayList<Frame> f6 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))    ))) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))      )))),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) )

        )   );

        return new Object[]{
                new Object[]{   f1,    false},
                new Object[]{   f2,    true},
                new Object[]{   f3,    true},
                new Object[]{   f4,    true},
                new Object[]{   f5,    false},
                new Object[]{   f6,    true}
        };


    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testisLastFrame_whenFrameIsNull")
    public void testisLastFrame_whenFrameIsNull(ArrayList<Frame> frames, boolean expectedResult){
        assertEquals(Player.isLastFrame(frames), expectedResult);
    }
    private Object[] parameters_to_testisLastFrame_whenFrameIsNull() {

        return new Object[]{
                new Object[]{   null,    false},
                new Object[]{   null,    true}
        };

    }

    @Test
    @Parameters(method = "parameters_to_testisFirstRollInFrame")
    public void testisFirstRollInFrame(ArrayList<Frame> frames, boolean expectedResult){
        assertEquals(Player.isFirstRollInFrame(frames), expectedResult);
    }
    private Object[] parameters_to_testisFirstRollInFrame() {

        ArrayList<Frame> f1 = new ArrayList<>(Arrays.asList(
                new Frame( new ArrayList<>(Arrays.asList()) ),
                new Frame( new ArrayList<>(Arrays.asList()) )

        )   );
        ArrayList<Frame> f2 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList()))) )))

        )   );
        ArrayList<Frame> f3 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))    ))) )
        )   );
        ArrayList<Frame> f4 = new ArrayList<Frame>(Arrays.asList(
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList())) ),
                new Frame( new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(7,8,9,10)))      ))))

        )   );

        return new Object[]{
                new Object[]{   f1,    true},
                new Object[]{   f2,    false},
                new Object[]{   f3,    true},
                new Object[]{   f4,    false},
        };


    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testisFirstRollInFrame_whenFrameIsNull")
    public void testisFirstRollInFrame_whenFrameIsNull(ArrayList<Frame> frames, boolean expectedResult){
        assertEquals(Player.isFirstRollInFrame(frames), expectedResult);
    }
    private Object[] parameters_to_testisFirstRollInFrame_whenFrameIsNull() {

        return new Object[]{
                new Object[]{   null,    false},
                new Object[]{   null,    true}
        };

    }

    @Test(expected = IllegalArgumentException.class)
    @Parameters(method = "parameters_to_testisFirstRollInFrame_whenFrameIsEmpty")
    public void testisFirstRollInFrame_whenFrameIsEmpty(ArrayList<Frame> frames, boolean expectedResult){
        assertEquals(Player.isFirstRollInFrame(frames), expectedResult);
    }
    private Object[] parameters_to_testisFirstRollInFrame_whenFrameIsEmpty() {

        return new Object[]{
                new Object[]{  new ArrayList<Frame>(Arrays.asList()   ),    false},
        };

    }

    @Test
    @Parameters(method = "parameters_to_testget10Score")
    public void testget10Score(Player player, Integer expected10Score){
        assertEquals(player.get10Score(), expected10Score);
    }
    private Object[] parameters_to_testget10Score() {
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))

        )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,10)))

        )));

        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList())),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList())),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(5)))

        )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList())),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),
                new ArrayList<>((Arrays.asList()))

        )));

        return new Object[]{
                new Object[]{   new Player( a4 ),   new Integer(10)},
                new Object[]{   new Player( a5 ),   new Integer(4)},
                new Object[]{   new Player( a6 ),   new Integer(1)},
                new Object[]{   new Player( a7 ),   new Integer(0)}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testgetSummaryScoreOf")
    public void testgetSummaryScoreOf(Player player,Integer index, Integer expectedSummaryScore){
        assertEquals(player.getSummaryScoreOf(index), expectedSummaryScore);
    }
    private Object[] parameters_to_testgetSummaryScoreOf() {
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//2
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//3
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//4
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//5
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//6
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//7
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//8
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//9
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//10
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//11

        )));

        return new Object[]{
                new Object[]{   new Player( a4 ),0  ,  new Integer(30)},
                new Object[]{   new Player( a4 ),1  ,  new Integer(60)},
                new Object[]{   new Player( a4 ),2  ,  new Integer(90)},
                new Object[]{   new Player( a4 ),3  ,  new Integer(120)},
                new Object[]{   new Player( a4 ),4  ,  new Integer(150)},
                new Object[]{   new Player( a4 ),5  ,  new Integer(180)},
                new Object[]{   new Player( a4 ),6  ,  new Integer(210)},
                new Object[]{   new Player( a4 ),7  ,  new Integer(240)},
                new Object[]{   new Player( a4 ),8  ,  new Integer(270)},
                new Object[]{   new Player( a4 ),9  ,  new Integer(280)},
                new Object[]{   new Player( a4 ),10 ,  new Integer(290)},
                new Object[]{   new Player( a4 ),11 ,  new Integer(300)}
        };
    }

    @Test
    @Parameters(method = "parameters_to_testget10Score_WherReturnNull")
    public void testget10Score_WherReturnNull(Player player){
        assertNull(player.get10Score());
    }
    private Object[] parameters_to_testget10Score_WherReturnNull() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))       )));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))     )));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),       new ArrayList<>((Arrays.asList(6,7,8,9,10)))                )));

        return new Object[]{
                new Object[]{   new Player( a1 ) },
                new Object[]{   new Player( a2 ) },
                new Object[]{   new Player( a3 ) }
        };
    }

    @Test
    @Parameters(method = "parameters_to_testupdateSummaryScore")
    public void testupdateSummaryScore(Player player, ArrayList<Integer> downedPills, ArrayList<Integer> expectedSummaryScores){
        if(player.getFrames().size() == 0 || !player.getFrames().get(player.getFrames().size()-1).awaitsForRoll()){
            if(Player.isLastFrame(player.getFrames())){
                return;
                //endOfGame;
            }
            player.getFrames().add(new Frame());
            player.getFrames().get(player.getFrames().size() - 1).addNewRoll(downedPills);
        }else{
            player.getFrames().get(player.getFrames().size()-1).addNewRoll(downedPills);
        }
        player.updateSummaryScore();
        assertEquals(expectedSummaryScores, player.getSummaryScores());
    }
    private Object[] parameters_to_testupdateSummaryScore() {
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//2
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//3
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//4
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//5
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//6
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//7
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//8
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//9
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//10

        )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,5,6,8,9,10)))//0

        )));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList())),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//2

        )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//2
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//3
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//4
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//5
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//6
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//7
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//8
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//9


        )));

        return new Object[]{
                new Object[]{   new Player( a4 ), new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))) , new ArrayList<Integer>(Arrays.asList(30,30,30,30,30,30,30,30,30,10,10,10     )) },
                new Object[]{   new Player( a5 , true), new ArrayList<>((Arrays.asList(1,2,3,5,6,8,9,10))) , new ArrayList<Integer>(Arrays.asList( 8,8    )) },
                new Object[]{   new Player( a6 , true), new ArrayList<Integer>(Arrays.asList( 1,2,3,4,5,6,7,8,9,10    )) , new ArrayList<Integer>(Arrays.asList(0,20,20,10     )) },
                new Object[]{   new Player( a7 , true), new ArrayList<Integer>(Arrays.asList( 1,2,3,4,5,6,7,8,9,10    )) , new ArrayList<Integer>(Arrays.asList(20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 10     )) }

        };
    }

    @Test
    @Parameters(method = "parameters_to_testmakeRoll")
    public void testmakeRoll(Player player, ArrayList<Integer> downedPills, Integer size, Frame lastFrame){
        player.makeRoll(downedPills);
        assertEquals(lastFrame, player.getFrames().get(player.getFrames().size()-1));
        assertEquals(size, new Integer(player.getFrames().size()));
    }
    private Object[] parameters_to_testmakeRoll() {
        ArrayList<ArrayList<Integer>> a4 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//2
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//3
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//4
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//5
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//6
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//7
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//8
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//9
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//10

        )));
        ArrayList<ArrayList<Integer>> a5 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,5,6,8,9,10)))//0

        )));
        ArrayList<ArrayList<Integer>> a6 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList())),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//2

        )));
        ArrayList<ArrayList<Integer>> a7 = new ArrayList<>(new ArrayList<>(Arrays.asList(
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//0
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//1
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//2
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//3
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//4
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//5
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//6
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//7
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//8
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//9
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))),//10
                new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))//11

        )));

        return new Object[]{
                new Object[]{   new Player( a4 ), new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10))) , 12,   new Frame(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))))   ) },
                new Object[]{   new Player( a5 ), new ArrayList<>((Arrays.asList(7))) , 1,   new Frame(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,5,6,8,9,10))), new ArrayList<>((Arrays.asList(7)))))   ) },
                new Object[]{   new Player( a6 ), new ArrayList<>((Arrays.asList())) , 3,   new Frame(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList()))))   ) },
                new Object[]{   new Player( a7 ), new ArrayList<>((Arrays.asList())) , 12,   new Frame(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))))   ) }//,
        };
    }

    @Test
    @Parameters(method = "parameters_to_testPlayer")
    public void testPlayer(String expectedName){
        Player player = new Player(expectedName);
        assertEquals(player.getName(), expectedName);
        assertEquals(player.getFrames(), new ArrayList<>());
        assertEquals(player.getSummaryScores(), new ArrayList<>());
    }
    private Object[] parameters_to_testPlayer() {
        return new Object[]{
                new Object[]{  "" },
                new Object[]{  "daefsrbt" },
                new Object[]{   "AWFEC"},
                new Object[]{   "йцукенгорпаві"}//,
        };
    }

}
