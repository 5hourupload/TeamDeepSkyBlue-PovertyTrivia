package deepskyblue.povertycrack;

import android.widget.TextView;

public class SoloGame extends MainActivity {
    private void highLow(String Question, String Answer){
        TextView Q = findViewById(R.id.questionBox);
        String test = "how many people were on food stamps in 2015?";
        Q.setText(test);

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
