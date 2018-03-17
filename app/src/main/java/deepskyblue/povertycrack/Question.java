package deepskyblue.povertycrack;

/**
 * Created by Charley Bickel on 3/17/2018.
 * This class is used to instantiate questions called by the solo game method
 * It creates objects with member variables that correspond to the question attributes
 */

class Question {
<<<<<<< HEAD
    private int num;
    private String question;
    private String answer;
    private String completeFact;
    protected boolean correct;
=======
    public int num;
    public String question;
    public String answer;
    public boolean correct;
>>>>>>> e1d0e33d7c92028f786392b98d05354529e2b1b2

    public Question(int num, String question, String answer, String completeFact, boolean correct){
        this.num = num;
        this.question = question;
        this.answer = answer;
        this.completeFact = completeFact;
        this.correct = correct;
    }
}
