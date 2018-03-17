package deepskyblue.povertycrack;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

public class SoloGame extends AppCompatActivity {
    private int count = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background_template);
    }

    //every new question that is called in main calls this method
    //This method calls the appropriate method to execute the question
    private ArrayList<Object> results = new ArrayList<>();

    private void newQuestion(String passedQ, String passedA){
        count++;
        question currentQuestion = new question(count, passedQ, passedA, false);
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

    private void checkAnswer(String selectedA, String correctA){
        if(selectedA.equals(correctA)){
            
        }
    }

    private void highLow(String question, final String answer){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question);
        Button True = findViewById(R.id.buttonTrue);
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("true", answer);
            }
        });
        Button False = findViewById(R.id.buttonFalse);
        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("false", answer);
            }
        });
    }

    private void checkAll(String question, String Answer){
        TextView Q = findViewById(R.id.questionText);
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

    private void correctAnswer(){

    }

    private void wrongAnswer(){

    }
}
