package deepskyblue.povertycrack;

import android.widget.Button;
import android.widget.TextView;

public class SoloGame extends MainActivity {
    //every new question that is called in main calls this method
    //This method calls the appropriate method to execute the question
    private void newQuestion(String passedQ, String passedA){
        switch (passedQ.charAt(0)){
            case 'T':
                highLow(passedQ, passedA);
                break;
            case 'M':
                multipleChoice(passedQ, passedA);
                break;
            case 'S':
                slider(passedQ, passedA);
                break;
            case 'C':
                checkAll(passedQ, passedA);
                break;
        }
    }

    private void highLow(String question, String answer){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question);
        Button True = findViewById(R.id.buttonTrue);
        Button False = findViewById(R.id.buttonFalse);
    }

    private void checkAll(String question, String Answer){
        TextView Q = findViewById(R.id.questionBox);
        String Answers [] = Answer.split(";");

    }

    private void multipleChoice(String question, String answer){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question);


    }

    private void slider(String Question, String Answer) {
        TextView Q = findViewById(R.id.questionText);
        Q.setText(Question);
    }
}
