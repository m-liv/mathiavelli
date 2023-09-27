//Authors: Miya, Ella
//NonIntDivision.java (Division subclass)
//Purpose:      This class is a subset of the Division class that generates
//              regular division questions (with cleanly divisible factors, 
//              no rounding) and their answers.
public class NonIntDivision extends Division //classic whole number division
{
    private int correctAnswer;
    private int minim;
    private int maxim;
    
    /**
     * Default 2-argument Constructor that calls Calculator's Constructor
     * and checks for if the question will result in the correctAnswer
     * equalling zero
     *   pre-condition: min and max are valid integers provided by the user
     *   post-condition: the instance data has been updated
     * 
     * @param   min           minimum value
     * @param   max           maximum value
     * @author  Miya Livingston
     */
    public NonIntDivision(int min, int max){
        super(min, max);
        minim = min;
        maxim = max;
        swapTerms();
        if (getTerm1() % getTerm2() != 0)
        {
            setTerm1(((int) (Math.random() * 10 + 1) * getTerm2()));
        }
    }
    
    /**
     * Swaps term1 with term2 and term 2 with term1 if term2 is less than term2
     *   pre-condition: none
     *   post-condition: term1 and term2 have swapped values
     * 
     * @author  Miya Livingston
     */
    public void swapTerms()
    {
        if (getTerm1() < getTerm2())
        {
            int temp = getTerm1();
            setTerm1(getTerm2());
            setTerm2(temp);
        }
    }
    
    /**
     * Overrides the generateQuestions() method for NonIntegerDivision
     *   pre-condition: none
     *   post-condition: term1 and term2 have been updated
     * 
     * @author  Miya Livingston
     */
    public void generateQuestions(){ //overrides parent method
        setTerm2((int)(Math.random() * (maxim - minim) + minim));
        setTerm1((int)(Math.random() * (maxim - minim) + minim) * getTerm2());
    }
    
    /**
     * Overrides the getQuestion() method for NonIntegerDivision and prints
     * the result
     *   pre-condition: none
     *   post-condition: nonIntegerDivision question has been printed
     * 
     * @author  Miya Livingston
     */
    public void getQuestion(){
        System.out.print(getTerm1()+ " / "+ getTerm2()+" = ");
    }
    
    /**
     * Overrides the setCorrectAnswer() method for NonIntegerDivision
     *   pre-condition: none
     *   post-condition: correctAnswer is set based on nonIntDivision
     * 
     * @author  Miya Livingston
     */
    public void setCorrectAnswer(){
        correctAnswer = getTerm1() / getTerm2();
    }
    
    /**
     * Overrides the checkInput() method
     *   pre-condition: input is a valid integer provided by the user
     *   post-condition: the correctness of the user's input has been determined
     * 
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