import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


public class RockPaperScissorTest {

    RockPaperScissor rock = new RockPaperScissor();
    TestOutput testOutput = new TestOutput();
    TestInput testInput = new TestInput();
    TestInput computerInput = new TestInput();
    Config configFromStubb = new ConfigFromStubb();


    final String[] weaponList = {"Rock","Scissors","Paper"};


    private ArrayList<String>  setUpTest(ArrayList<String> userInputs, ArrayList<String> computerInputs){
        testOutput.clear();
        testInput.setTestInputs(userInputs);
        computerInput.setTestInputs(computerInputs);
        rock.setUserOutput(testOutput);
        rock.setUserInput(testInput);
        rock.setComputerInput(computerInput);
        rock.setConfig(configFromStubb);
        return testOutput.getTestOutputs();
    }


    @Test
    public void testDetermineWinner() {
        String result = rock.determineWinner(weaponList,0,0);
        assertEquals("Draw both selected Rock", result);
    }

    @Test
    public void testGenerateGamesRequest() {
        String result = rock.generateGamesListRequest();
        assertEquals("Please select 0 - Rock Paper Scissors 1 - Star Wars", result);
    }

    @Test
    public void testRockVsRock() {
        ArrayList<String> userInputs = new ArrayList<String>(2);
        userInputs.add("0");
        userInputs.add("4");
        ArrayList<String> computerInputs = new ArrayList<>(1);
        computerInputs.add("0");
        ArrayList<String> userOutput = setUpTest(userInputs,computerInputs);

        rock.playGame(weaponList);
        String result = userOutput.remove(1);
        assertEquals("Draw both selected Rock", result);
    }
}