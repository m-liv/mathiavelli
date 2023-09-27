//Authors: Ella
//Factorial.java (Multiplication subclass)
//Purpose:      This class is a subset of the Multiplication class to generate
//              factorial questions and their answers.
public class Factorial extends Multiplication 
{
    private int correctAnswer;

    /**
     * Default 2-argument Constructor calls Calculator's Constructor
     *   pre-condition: min and max are valid integers provided by the user
     *   post-condition: the instance data has been updated
     * 
     * @param   min           minimum value
     * @param   max           maximum value
     * @author  Ella Greer
     */
    public Factorial(int min, int max){
        super(min, max);
    }
    
    /**
     * Overrides Calculator's getQuestion() method and prints the result 
     *   pre-condition: none
     *   post-condition: factorial question has been printed
     * 
     * @author  Ella Greer
     */
    public void getQuestion()
    {
        System.out.print(getTerm1() + "! = ");
    }
    
    /**
     * Overrides Calculator's setCorrectAnswer() method for Factorials
     *   pre-condition: none
     *   post-condition: correctAnswer is set based on Factorials
     * 
     * @author  Ella Greer
     */
    public void setCorrectAnswer()
    {
      int factorial = getTerm1();
      int i = 1;
      do
      {
         factorial = factorial * i;
         i++;
      }
      while(i < getTerm1());
      correctAnswer = factorial;
    }
    
    /**
     * Overrides Calculator's checkInput() method
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
     * @param   input         user's input
     * @return  returns true if input is equal to correctAnswer and false
     * otherwise
     * @author  Ella Greer
     */
    public boolean checkInput(int input){
        if(input == correctAnswer){
            return true;
        }
        return false;
    }
}