package deepskyblue.povertycrack;

/**
 * Created by Charley Bickel on 3/17/2018.
 */

public class question {
    private int num;
    private String question;
    private String answer;
    protected boolean correct;
    public question(int a, String b, String c, boolean d){
        num = a;
        question = b;
        answer = c;
        correct = d;
    }
}
