package deepskyblue.povertycrack;

/**
 * Created by Charley Bickel on 3/17/2018.
 * This class is used to instantiate questions called by the solo game method
 * It creates objects with member variables that correspond to the question attributes
 */

public class Question {
    protected int num;
    protected String question;
    protected String answer;
    protected String completeFact;
    protected boolean correct;

    public Question(int num, String question, String answer, String completeFact, boolean correct){
        /*All the instantiations are set from the class to later formulate the questions for the
        app, taking in specific words and data that will be passed on to make a comprehensible
        question.*/
        this.num = num;
        this.question = question;
        this.answer = answer;
        this.completeFact = completeFact;
        this.correct = correct;
    }
}
