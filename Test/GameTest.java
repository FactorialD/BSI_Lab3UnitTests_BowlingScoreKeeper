
import Models.Game;
import Models.InputReader;
import Models.Player;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(JUnitParamsRunner.class)
public class GameTest {

    @Test
    public void testGame(){
        Game g = new Game();
        assertEquals(new ArrayList<>(), g.getPlayers() );
    }

    @Test(expected = IllegalArgumentException.class)
    public void testprintGameResult_WhenWrongFieldLength(){
        Game g = new Game();
        g.setPlayers(new ArrayList<>(Arrays.asList(new Player("123456789101112"), new Player("123456789011121314"))));
        g.printGameResult();
    }
    @Test(expected = IllegalArgumentException.class)
    public void testprintGameResult_WhenWrongPlayerCount(){
        Game g = new Game();
        g.setPlayers(new ArrayList<>(Arrays.asList(
                new Player("a"),
                new Player("b"),
                new Player("c"),
                new Player("d"),
                new Player("e"),
                new Player("f"),
                new Player("g"),
                new Player("h"),
                new Player("i"),
                new Player("j"),
                new Player("k")
        )));
        g.printGameResult();
    }

    class StubPlayer extends Player{
        public StubPlayer(String name, int score) {
            super(name);
            this.score = score;
        }
        int score;
        @Override
        public Integer getSummaryScoreOf(int index){
            return score;
        }

    }
    @Test
    public void testprintGameResult_WhenDraw(){
        Game g = new Game();
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1), new StubPlayer("b",1))));
        g.printGameResult();
    }
    @Test
    public void testprintGameResult(){
        Game g = new Game();
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1), new StubPlayer("b",2))));
        g.printGameResult();
    }

    class TestInputReader extends InputReader {
        String string = null;
        public TestInputReader(String str){
            super();
            this.string = str;
        }
        public TestInputReader(){
            super();
        }
        @Override
        public String nextLine(){
            if(string == null){
                return "1111111111111111111";
            }
            else {
                return string;
            }
        }
    }
    @Test
    public void testinputPlayerNames(){
        Game g = new Game(new TestInputReader());
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1), new StubPlayer("1234568901112131415",2))));
        g.inputPlayerNames(2, g.getIn());
    }
    @Test
    public void testinputPlayerNames_WhenEmptyInput(){
        Game g = new Game(new TestInputReader(""));
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1), new StubPlayer("1234568901112131415",2))));
        g.inputPlayerNames(2, g.getIn());
    }
    @Test
    public void testprintScoreTable(){
        Game g = new Game(new TestInputReader("1 2 3 4 5 6 7 8 9 10"));
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1),new StubPlayer("b",1))));
        g.printScoreTable();
    }

    @Test
    @Parameters(method = "parameters_to_testallPlayersEndedGame")
    public void testallPlayersEndedGame(ArrayList<Player> players, boolean expectedResult){
        assertEquals(expectedResult, Game.allPlayersEndedGame(players));
    }
    private Object[] parameters_to_testallPlayersEndedGame() {
        ArrayList<ArrayList<Integer>> a1 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,9,10)))       )));
        ArrayList<ArrayList<Integer>> a2 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5,6,7,8,9,10)))     )));
        ArrayList<ArrayList<Integer>> a3 = new ArrayList<>(new ArrayList<>(Arrays.asList(new ArrayList<>((Arrays.asList(1,2,3,4,5))),       new ArrayList<>((Arrays.asList(6,7,8,9,10)))                )));

       ArrayList<ArrayList<Integer>> b1 = new ArrayList<>(new ArrayList<>(Arrays.asList(
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
                new Object[]{  new ArrayList<>(Arrays.asList(new Player( a1 ), new Player( a2 ), new Player( a3 ))), false },
                new Object[]{   new ArrayList<>(Arrays.asList(new Player( b1 ))) , true},
                new Object[]{  new ArrayList<>(Arrays.asList(new Player( a3 ))) , false}
        };


    }

    @Test
    public void testprintScoreTableForPlayer(){
        //Game g = new Game(new TestInputReader("1 2 3 4 5 6 7 8 9 10"));
        //g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1),new StubPlayer("b",1))));
        Game.printScoreTableForPlayer(new StubPlayer("a",1));
    }

    @Test
    public void testplay(){
        Game g = new Game(new TestInputReader("1 2 3 4 5 6 7 8 9 10"));
        //g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1),new StubPlayer("b",1))));
        g.play();
    }

    @Test
    public void testinputDownPills(){
        Game g = new Game(new TestInputReader("1 2 3 4 5 6 7 8 9 10"));
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1),new StubPlayer("b",1))));
        g.inputDownPills(g.getPlayers().get(0), g.getIn(),1);
    }

    @Test
    public void testinputDownPills_WhenEmptyInput(){
        Game g = new Game(new TestInputReader(""));
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1),new StubPlayer("b",1))));
        g.inputDownPills(g.getPlayers().get(0), g.getIn(),1);
    }

    @Test
    public void testinputDownPills_WhenWrongInput(){
        Game g = new Game(new TestInputReader("abc ab"));
        g.setPlayers(new ArrayList<>(Arrays.asList(new StubPlayer("a",1),new StubPlayer("b",1))));
        g.inputDownPills(g.getPlayers().get(0), g.getIn(),1);
    }

}