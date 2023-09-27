//Authors: Nadine, Ella
//Subtraction.java (Calculator subclass)
//Purpose:       This class is a subclass of Calculator, used for generating
//               subtraction questions and their answers. 
public class Subtraction extends Calculator{
    private int correctAnswer;
    
    /**
     * Default 2-argument Constructor calls Calculator's Constructor
     *   pre-conditions: min and max are both valid integers provided by the user
     *   post-conditions: instance data has been updated
     * 
     * @param   min           the minimum value 
     * @param   max           the maximum value
     * @author  Nadine Alexander
     */
    public Subtraction(int min, int max){
        super(min, max);
    }
    
    /**
     * Overrides Calculator's getQuestion() method for Subtraction and prints
     * the result
     *   pre-conditions: none
     *   post-conditions: subtraction question has been printed
     * 
     * @author  Nadine Alexander
     */
    public void getQuestion(){
        System.out.print(getTerm1()+ " - "+ getTerm2()+" = ");
    }
    
    /**
     * Overrides Calculator's setCorrectAnswer() method for Subtraction
     *   pre-conditions: none
     *   post-conditions: correctAnswer has been set based on subtraction
     * 
     * @author  Nadine Alexander
     */
    public void setCorrectAnswer(){
        correctAnswer = getTerm1() - getTerm2();
    }
    
    /**
     * Overrides Calculator's checkInput() method 
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
     * @param   input         the user's inputed value
     * @return  returns true if input is equal to correctAnswer and false
     * otherwise
     * @author  Nadine Alexander
     */
    public boolean checkInput(int input){
        if(input == correctAnswer){
            return true;
        }
        return false;
    }
}