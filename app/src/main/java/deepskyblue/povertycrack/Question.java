package deepskyblue.povertycrack;

/**
 * Created by Charley Bickel on 3/17/2018.
 * This class is used to instantiate questions called by the solo game method
 * It creates objects with member variables that correspond to the question attributes
 */

public class Question {
<<<<<<< HEAD
    protected int num;
    protected String question;
    protected String answer;
    protected String completeFact;
    protected boolean correct;

    public Question(int num, String question, String answer, String completeFact, boolean correct){
        /*All the instantiations are set from the class to later formulate the questions for the
        app, taking in specific words and data that will be passed on to make a comprehensible
        question.*/
=======
    public int num;
    public String question;
    public String answer;
    public String type;
    public String completeFact;
    public boolean correct;

    public Question(int num, String question, String type, String answer, String completeFact, boolean correct){
>>>>>>> 1995ba6489f62c23a24f5caadbdab306f3c09a2f
        this.num = num;
        this.question = question;
        this.type = type;
        this.answer = answer;
        this.completeFact = completeFact;
        this.correct = correct;
    }
}
