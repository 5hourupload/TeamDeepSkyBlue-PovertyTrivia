package deepskyblue.povertycrack;

/**
 * Created by Charley Bickel on 3/17/2018.
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

    public Question(int num, String question, String type, String answer, String completeFact, boolean correct){
        this.num = num;
        this.question = question;
        this.type = type;
        this.answer = answer;
        this.completeFact = completeFact;
        this.correct = correct;
    }
}
