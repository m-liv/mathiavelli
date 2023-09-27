//Authors: Nadine, Miya, Ella
//Driver.java (Driver class) 
//Purpose:      This class drives the program, allowing users to play the Mathiavelli 
//              game an unlimited number of times, keeping track of scores and printing 
//              a score report at the end.
import java.util.*;
import java.time.Duration;
import java.time.Instant;
public class Driver
{
    public static void main(String[] args)
    {
        Scanner myScan = new Scanner(System.in);
        Calculator obj;
        String mode;
        String answer;
        int numQuestions; 
        int input;
        int pointValue;
        MathGame game;
        Instant start = null;
        Instant finish;
        int timeGoal;
        int numPlays = 0;
        String playAgain = null;
        ArrayList<Integer> scores = new ArrayList<Integer>();
        String[] mathTypes = {"Addition", "Subtraction", "Multiplication", "Division"};
        String[] multiplicationTypes = {"Multiplication", "Factorial"};
        String[] divisionTypes = {"Regular Division", "Integer Division", "Modulo Division"};
        
        System.out.println("Welcome to Mathiavelli, a game where you can put your math skills to the test!");
        do {
            System.out.println();
            numPlays++;
            System.out.println("********************* Round " + numPlays + " *********************");
            System.out.println("What kind of math would you like to practice?");
            System.out.println("1. " + mathTypes[0]);
            System.out.println("2. "+ mathTypes[1]);
            System.out.println("3. " + mathTypes[2]); 
            System.out.println("4. "+ mathTypes[3]);
            System.out.print("Enter a number here: ");
            answer = myScan.next();
            while (!(answer.equals("1") || answer.equals("2") || answer.equals("3") || answer.equals("4"))) {
                //while loop ensures that the code will not continue until one of the options is chosen
                printCatch();
                answer = myScan.next();
            } 
    
            if(answer.equals("1")){
                obj = new Addition(0,100);
                mode = "add";
            }
            else if(answer.equals("2")){
                obj = new Subtraction(0,100);
                mode = "sub";
            }
            else if(answer.equals("3")){
                System.out.println("\nWhat kind of multiplication would you like to practice?");
                System.out.println("1. " + multiplicationTypes[0]);
                System.out.println("2. " + multiplicationTypes[1]);
                System.out.print("Enter a number here: ");
                answer = myScan.next();
                while (!(answer.equals("1") || answer.equals("2") || answer.equals("3"))) {
                    printCatch();
                    answer = myScan.next();
                } 
                if(answer.equals("1")){
                    obj = new Multiplication(0,12);
                }
                //else if
                else { //}if (answer.equals("2")){
                    obj = new Factorial(1,12);
                }
                mode = "mult";
            }
            else { //answer is 4
                mode = "div";
                System.out.println("\nWhat kind of division would you like to practice?");
                System.out.println("1. " + divisionTypes[0]);
                System.out.println("2. " + divisionTypes[1]);
                System.out.println("3. " + divisionTypes[2]);
                System.out.print("Enter a number here: ");
                answer = myScan.next();
                while (!(answer.equals("1") || answer.equals("2") || answer.equals("3"))) {
                    printCatch();
                    answer = myScan.next();
                } 
                
                if(answer.equals("1")){
                    obj = new NonIntDivision(1,12);
                }
                else if (answer.equals("2")){
                    obj = new Division(1,12);
                }
                else {
                    obj = new ModuloDivision(1,12);
                }
                
            }
            
            game = new MathGame();
            pointValue = 1; 
            System.out.println("\nHow many questions would you like to practice?");
            System.out.print("Enter a number here: ");
            answer = myScan.next();
            while (!isInteger(answer)) {
                printCatch();
                answer = myScan.next();
            } 
            numQuestions = Integer.parseInt(answer);
            System.out.println("\nWhat is your time goal? ");
            System.out.print("Enter a number of seconds here: ");
            answer = myScan.next();
            while (!isInteger(answer)) {
                printCatch();
                answer = myScan.next();
            } 
            timeGoal = Integer.parseInt(answer);
            
            //Introductory statement
            System.out.println();
            String answer2 = "";
            while(!answer2.equals("yes")){
                System.out.println("Are you ready? Enter yes to begin!");
                answer2 = myScan.next();
            }
            if(answer2.equalsIgnoreCase("yes")){
                start = Instant.now();
                System.out.println();
                for(int i = 0; i<numQuestions; i++) {
                    obj.generateQuestions();
                    obj.getQuestion();
                    obj.setCorrectAnswer();
                    answer = myScan.next();
                    while (!isInteger(answer)) {
                        System.out.print("Please enter a numeric answer: ");
                        answer = myScan.next();
                    } 
                    input = Integer.parseInt(answer);
                    if (obj.checkInput(input)) {
                        game.incrementScore(pointValue);
                    } 
                    else {
                        game.setBonus(false);
                    }
                }
                finish = Instant.now();
                long timeElapsed = Duration.between(start, finish).toMillis();
                timeElapsed /= 1000;
        
                //Print points
                boolean timeGoalMet = timeElapsed <= timeGoal;
                System.out.println();
                System.out.println("You got " + game.getScore() + " out of " + numQuestions + " correct!"); 
                System.out.println("Total time: "+ timeElapsed + " seconds");
                System.out.println("Accuracy bonus earned: " + game.getBonus());
                System.out.println("Time goal achieved: " + timeGoalMet);
                System.out.println("Total score: "+ game.getFinalScore(timeGoalMet, timeElapsed));
                scores.add(game.getFinalScore(timeGoalMet, timeElapsed));
                
                //Asks user if they want to play again
                System.out.println();
                System.out.println("Thanks for playing! Play again?");
                System.out.println("Enter yes or no: ");
                playAgain = myScan.next();
                while (!(playAgain.equalsIgnoreCase("yes") || playAgain.equalsIgnoreCase("no"))) {
                        System.out.print("Sorry, invalid response. Please enter yes or no: ");
                        playAgain = myScan.next();
                } 
            }
        } while (playAgain.equalsIgnoreCase("yes"));
        
        //Once user is done playing, prints totals 
        int round = 1;
        int total = 0;
        System.out.println();
        System.out.println("******************* Score Report ******************");
        for (Integer score : scores)
        {
            System.out.println("Round " + round + ": " + score);
            round++;
            total += score;
        }
        System.out.println("High score: " + game.getHighScore(scores));
        System.out.println("Total score: " + total);
    }
    
    /**
     * isInteger method to check whether user input is an int
     *  pre-condition: s is a String input by the user
     *  post-condition: s is unchanged, but its parsability is now known
     * 
     * @param   s   String storing user input
     * @return  whether s holds an int
     * @author  Miya Livingston
     */
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        } catch(NullPointerException e) {
            return false;
        }
        return true;
    }
    
    /**
     * printCatch method to ask for a new input, for when user inputs invalid value
     *  pre-condition: user has entered an invalid input for the question asked
     *  post-condition: user has been asked to enter a new input
     * 
     * @author  Miya Livingston
     */
    public static void printCatch() {
        System.out.println("\nSorry, that is not an option. Please try again. ");
        System.out.print("Enter a number here: ");
    }
}