//Authors: Miya, Ella
//Game.java (abstract game class)
//Purpose:      This abstract class informs clients of the instance data and
//              methods that all Game subclasses should have. 
import java.util.*;
public abstract class Game 
{
    private int score;
    abstract void incrementScore(int point);
    abstract void resetScore();
    abstract int getScore();
    abstract int getHighScore(ArrayList<Integer> scoreList);
}