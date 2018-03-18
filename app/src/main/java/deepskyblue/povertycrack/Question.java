package deepskyblue.povertycrack;

/**
 * This class is used to instantiate questions called by the solo game method
 * It creates objects with member variables that correspond to the question attributes
 */

public class Question {
    public int num;
    public String question;
    public String answer;
    public String type;
    public String completeFact;
    public boolean correct;
    
    public Question( int num, String question, String type, String answer, String completeFact,
        boolean correct){
        /*All the instantiations are set from the class to later formulate the questions for the
        app, taking in specific words and data that will be passed on to make a comprehensible
        question.*/
            this.num = num;
            this.question = question;
            this.type = type;
            this.answer = answer;
            this.completeFact = completeFact;
            this.correct = correct;
        }
    }
