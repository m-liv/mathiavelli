//Authors: Miya, Ella
//ModuloDivision.java (Division subclass)
//Purpose:      This class is a subclass of the Division class that generates  
//              modulus questions and their answers.
public class ModuloDivision extends Division 
{
    private int correctAnswer;
    
    /**
     * Default 2-argument Constructor and calls Calulator's Constructor
     *   pre-condition: min and max are valid integers provided by the user
     *   post-condition: the instance data has been updated
     * 
     * @param   min           minimum value
     * @param   max           maximum value
     * @author  Miya Livingston
     */
    public ModuloDivision(int min, int max){
        super(min, max);
    }
    
    /**
     * Overrides Calculator's getQuestion() method and prints the result
     *   pre-condition: none
     *   post-condition: modulo division question has been printed
     * 
     * @author  Miya Livingston
     */
    public void getQuestion(){
        System.out.print(getTerm1()+ " % "+ getTerm2()+" = ");
    }
    
    /**
     * Overrides Calculator's setCorrectAnswer() method for Modulo Division
     *   pre-condition: none
     *   post-condition: correctAnswer is set based on Modulo Division
     * 
     * @author  Miya Livingston
     */
    public void setCorrectAnswer(){
        correctAnswer = getTerm1() % getTerm2();
    }
    
    /**
     * Overrides Calculator's checkInput() method
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
     * @param   input         user's input
     * @return  returns true if input is equal to correctAnswer and false
     * otherwise
     * @author  Miya Livingston
     */
    public boolean checkInput(int input){
        if(input == correctAnswer){
            return true;
        }
        return false;
    }
    
}