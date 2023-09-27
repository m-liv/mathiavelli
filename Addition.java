//Authors: Nadine, Ella
//Addition.java (Calculator subclass)
//Purpose:       This class is a subclass of Calculator, used for generating
//               addition questions and their answers. 
public class Addition extends Calculator{
    private int correctAnswer;
    
    /**
     * Default 2-argument Constructor that calls the Calculator Constructor\
     *   pre-condition: min and max are variables inputted by the user
     *   post-condition: the instance data has been updated
     * 
     * @param   min           the minimum value
     * @param   max           the maximum value
     * @author  Nadine Alexander
     */
    public Addition(int min, int max){
        super(min, max);
    }
    
    /**
     * Overrides Calculator's getQuestion() method and prints result
     *   pre-condition: none
     *   post-condition: addition question has been printed
     * 
     * @author  Nadine Alexander
     */
    public void getQuestion(){

        System.out.print(getTerm1()+ " + "+ getTerm2()+" = ");
    }
    
    /**
     * Overrides Calculator's setCorrectAnswer() method
     *   pre-condition: none
     *   post-condition: correct answer has been set based on addition
     * 
     * @author  Nadine Alexander
     */
    public void setCorrectAnswer(){
        correctAnswer = getTerm1() + getTerm2();
    }
    
    /**
     * Overrides Calculator's checkInput() method
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
     * @param   input         the user's inputed answer
     * @return  returns true if the input is equal to the question's
     * correct answer and false otherwise
     * @author  Nadine Alexander
     */
    public boolean checkInput(int input){
        if(input == correctAnswer){
            return true;
        }
        return false;
    }

}