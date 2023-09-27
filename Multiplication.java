//Authors: Nadine, Ella
//Multiplication.java (Calculator subclass)
//Purpose:       This class is a subclass of Calculator, used for generating
//               multiplication questions and their answers. 
public class Multiplication extends Calculator {
    private int correctAnswer;
    
    /**
     * Default 2-argument Constructor calls Calculator's Constructor
     *   pre-condition: min and max are valid integers provided by the user
     *   post-condition: the instance data has been updated
     * 
     * @param   min           minimum value
     * @param   max           maximum value
     * @author  Nadine Alexander
     */
    public Multiplication(int min, int max){
        super(min, max);
    }
    
    /**
     * Overrides Calculator's getQuestion() method for Multiplication and
     * prints the result
     *   pre-condition: none
     *   post-condition: multiplication question has been printed
     * 
     * @author  Nadine Alexander
     */
    public void getQuestion(){
        System.out.print(getTerm1()+ " x "+ getTerm2()+" = ");
    }
    
    /**
     * Overrides Calculator's setCorrectAnswer() method for Multiplication
     *   pre-condition: none
     *   post-condition: correctAnswer is set based on multiplication
     * 
     * @author  Nadine Alexander
     */
    public void setCorrectAnswer(){
        correctAnswer = getTerm1() * getTerm2();
    }
    
    /**
     * Overrides Calculator's checkInput method to check for the Multiplication
     * question's answer
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
     * @param   input         the user's input
     * @return  returns true if input is equal to the correctAnswer and
     * false otherwise
     * @author  Nadine Alexander
     */
    public boolean checkInput(int input){
        if(input == correctAnswer){
            return true;
        }
        return false;
    }
}