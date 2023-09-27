//Authors: Nadine, Ella
//Division.java (Calculator subclass)
//Purpose:       This class is a subclass of Calculator, used for generating
//               integer division questions (decimals rounded down) and their 
//               answers. 
public class Division extends Calculator {
    private int correctAnswer;
    
    /**
     * Default 2-argument Constructor calls Calculator's Constructor
     *   pre-condition: min and max are valid integers provided by the user
     *   post-condition: the instance data has been updated
     * 
     * @param   min           minimum value
     * @author  Nadine Alexander
     */
    public Division(int min, int max){
        super(min, max);
    }
    
    /**
     * Overrides Calculator's getQuestion method for integer division
     *   pre-condition: none
     *   post-condition: division question has been printed
     * 
     * @author  Nadine Alexander
     */
    public void getQuestion(){
        System.out.print(getTerm1()+ " / "+ getTerm2()+" = ");
    }
    
    /**
     * Overrides Calculator's getQuestion method for integer division
     *   pre-condition: none
     *   post-condition: correctAnswer is set based on division
     * 
     * @author  Nadine Alexander
     */
    public void setCorrectAnswer(){
        correctAnswer = getTerm1() / getTerm2();
    }
    
    /**
     * Overrides Calculator's getQuestion method for integer division
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
     * @param   input         user's inputed value
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