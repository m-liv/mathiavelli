//Authors: Miya, Ella
//MathGame.java (Game subclass)
//Purpose:      This class is a subclass of the Game class, providing a point system based 
//              on conditions for a timer and a bonus. 
import java.util.*;
public class MathGame extends Game
{
    private int score;
    private boolean gotBonus;
    
    /**
     * Default no argument constructor 
     *   pre-condition: none
     *   post-condition: the instance data has been updated
     * 
     * @author  Miya Livingston
     */
    public MathGame() {
        score = 0;
        gotBonus = true;
    }
    
    /**
     * increments game score with given point value
     *   pre-condition: point is a valid integer provided by the user
     *   post-condition: score has been updated
     * 
     * @param   point    point value to add to the score
     * @author  Miya Livingston
     */
    public void incrementScore(int point) {
        score += point;
    }
    
    /**
     * resets game score 
     *   pre-condition: none
     *   post-condition: score has been reset
     * 
     * @author  Miya Livingston
     */
    public void resetScore() {
        score = 0;
    }
    
    /**
     * accessor method for game score
     *   pre-condition: none
     *   post-condition: score is provided
     * 
     * @return   score    player's running game score
     * @author  Miya Livingston
     */
    public int getScore() {
        return score;
    }
    
    /**
     * setter method for gotBonus boolean 
     *   pre-condition: boo is a valid boolean provided by the user
     *   post-condition: gotBonus has been updated
     * 
     * @param   boo   whether or not player earned a bonus
     * @author  Miya Livingston
     */
    public void setBonus(boolean boo) {
        gotBonus = boo;
    }
    
    /**
     * accessor method for bonus
     *   pre-condition: none
     *   post-condition: gotBonus is provided
     * 
     * @return   gotBonus    whether or not player earned a bonus
     * @author  Miya Livingston
     */
    public boolean getBonus() {
        return gotBonus;
    }
    
    /**
     * calculates final score with bonuses
     *   pre-condition:  timeMet is a valid boolean and time is a valid long variable
     *                   provided by the user
     *   post-condition: local data has been updated
     * 
     * @param   timeMet     whether user met their time goal
     * @return  final score
     * @author  Nadine Alexander, Miya Livingston
     */
    public int getFinalScore(boolean timeMet, long time){
        int sum = 0;
        int multFactor = 1;
        sum += score * 100;
        if (gotBonus)
        {
            multFactor++;
        }
        if (timeMet)
        {
            multFactor++;
        }
        return sum * multFactor / (int) time;
    }
    
    /**
     * determines the highest score among a list of game scores
     *   pre-condition: scoreList is an ArrayList of the user's game scores
     *   post-condition: highest score in scoreList has been determined
     * 
     * @param   scoreList    ArrayList of user's game scores
     * @return  highScore    highest score in the list
     * @author  Miya Livingston
     */
    public int getHighScore(ArrayList<Integer> scoreList){
        int highScore = 0;
        for (Integer score : scoreList)
        {
            if (score > highScore)
            {
                highScore = score;
            }
        }
        return highScore;
    }
}