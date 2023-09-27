//Authors: Nadine, Miya, Ella
//Calculator.java (Calculator parent class)
//Purpose:      This class is used to create Calculator objects, with methods
//              to randomly generate math questions and their answers.
public class Calculator
{
    private String question;
    private int term1;
    private int term2;
    private int correctAnswer;
    private int min;
    private int max;
    
    /**
     * 2 argument constructor for Calculator objects
     *   pre-condition: min and max are integer values inputed by the user
     *   post-condition: instance data has been updated
     * 
     * @param   min     minimum value that can be generated
     * @param   max     maximum value that can be generated
     * @author  Nadime Alexander, Miya Livingston
     */
    public Calculator(int min, int max)
    {
        this.min = min;
        this.max = max;
        term1 = 1;
        term2 = 1;
    }
    
    /**
     * Generates random math questions
     *   pre-condition: none
     *   post-condition: term1 and term2 have been updated 
     * 
     * @author  Nadine Alexander, Miya Livingston
     */
    public void generateQuestions(){
        term1 = (int)(Math.random() * (max - min) + min);
        term2 = (int)(Math.random() * (max - min) + min);
        
    }
    
    /**
     * Returns term1
     *   pre-condition: term1 is a valid int variable
     *   post-condition: term1 is returned
     * 
     * @return  returns the variable term1
     * @author  Nadine Alexander, Miya Livingston
     */
    public int getTerm1(){
        return term1;
    }
    
    /**
     * Returns term2
     *   pre-condition: term2 is a valid int variable
     *   post-condition: term2 is returned
     * 
     * @return  returns the variable term 1
     * @author  Nadine Alexander, Miya Livingston
     */
    public int getTerm2(){
        return term2;
    }
    
    /**
     * Changes term1 to the inputed variable
     *   pre-condition: int x is a valid integer provided by the user
     *   post-condition: term1 is set to the user's input
     * 
     * @param   variable x    inputted user value to change term1
     * @author  Nadine Alexander, Miya Livingston
     */
    public void setTerm1(int x) {
        term1 = x;
    }
    
    /**
     * Changes term2 to the inputed variable
     *   pre-condition: int x is a valid integer provided by the user
     *   post-condition: term2 is set to the user's input
     * 
     * @param   variable x    inputted user value to change term2
     * @author  Nadine Alexander, Miya Livingston
     */
    public void setTerm2(int x) {
        term2 = x;
    }
    
    /**
     * Adds term1 and term 2 together and prints the result
     *   pre-condition: none
     *   post-condition: question has been printed
     * 
     * @author  Nadine Alexander, Miya Livingston
     */
    public void getQuestion(){ 
        question = term1+ " "+ term2;
        System.out.print(question);
    }
    
    /**
     * sets the variable correct answer to the correct answer for the question
     *   pre-condition: none
     *   post-condition: correctAnswer is set to 1
     * 
     * @author  Nadine Alexander, Miya Livingston
     */
    public void setCorrectAnswer(){
        correctAnswer =  1;
    }
    
    /**
     * Checks if the user input is equal to the question's correct answer
     *   pre-condition: the user's input is a valid integer
     *   post-condition: the correctness of the input has been determined
     * 
     * @param   input       integer input by user  
     * @return  true if the input is correct and false otherwise
     * @author  Nadine Alexander, Miya Livingston
     */
    public boolean checkInput(int input){
        if(input == correctAnswer){
            return true;
        }
        return false;
    }

}