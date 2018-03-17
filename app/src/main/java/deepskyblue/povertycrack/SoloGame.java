package deepskyblue.povertycrack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

import static deepskyblue.povertycrack.MainActivity.multChoiceQuestions;
import static deepskyblue.povertycrack.MainActivity.sliderQuestions;
import static deepskyblue.povertycrack.MainActivity.trueFalseQuestions;

public class SoloGame extends AppCompatActivity {
    private int count = 0;
    ConstraintLayout tf;
    ConstraintLayout mc;
    ConstraintLayout sl;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionbox_template);
        tf = findViewById(R.id.tf_view);
        mc = findViewById(R.id.mc_view);
        sl = findViewById(R.id.slider_view);
        trueFalseQuestions.add(new Question(-1, "What?", "True", " ", false));
        newQuestion();
    }

    //every new question that is called in main calls this method
    //This method calls the appropriate method to execute the question
    private ArrayList<Question> results = new ArrayList<>();
    private Question currentQuestion;
    private void newQuestion(){
        count++;
        //currentQuestion = new Question(count, passedQ, passedA, false);
        switch ((int) (Math.random() * 1)){
            case 0:
                currentQuestion = trueFalseQuestions.pop();
                currentQuestion.num = count;
                highLow(currentQuestion);
                break;
            case 1:
                currentQuestion = multChoiceQuestions.pop();
                currentQuestion.num = count;
                multipleChoice(multChoiceQuestions.pop());
                break;
            case 2:
                currentQuestion = sliderQuestions.pop();
                currentQuestion.num = count;
                slider(sliderQuestions.pop());
                break;
        }
    }
    //Check functions for each type of question
    //Parameters include the selected answer compared to the correct answer
    private void checkTF(String selectedA, Question question){
        if(selectedA.equals(question.answer)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }

    private void checkMC(String selectedA, Question question){
        if(selectedA.equals(question.answer)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }

    private void checkS(int sliderSelection, Question question){
        if(sliderSelection == Integer.parseInt(question.answer)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }
    //Function called for a true or false question
    private void highLow(final Question question){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question.question);

        tf.setVisibility(View.VISIBLE);
        mc.setVisibility(View.INVISIBLE);
        sl.setVisibility(View.INVISIBLE);
        Button True = findViewById(R.id.buttonTrue);
        //sets up onclick listeners for both buttons that call the check function above
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTF("true", question);
            }
        });
        Button False = findViewById(R.id.buttonFalse);
        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTF("false", question);
            }
        });
    }

    private void multipleChoice(final Question question){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question.question);
        tf.setVisibility(View.INVISIBLE);
        mc.setVisibility(View.VISIBLE);
        sl.setVisibility(View.INVISIBLE);

        String [] Answers = question.answer.split(";");
        String correctAnswerTemp = question.answer;
        for(int i = 0; i < 4; i++){
            if(Answers[i].charAt(0) == 'C'){
                correctAnswerTemp = Answers[i];
            }
        }
        final String correctAnswer = correctAnswerTemp;
        Button buttonOption1 = findViewById(R.id.questionOption1);
        buttonOption1.setText(Answers[0].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[0].substring(2), question);
            }
        });
        Button buttonOption2 = findViewById(R.id.questionOption2);
        buttonOption2.setText(Answers[1].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[1].substring(2), question);
            }
        });
        Button buttonOption3 = findViewById(R.id.questionOption3);
        buttonOption3.setText(Answers[2].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[2].substring(2), question);
            }
        });
        Button buttonOption4 = findViewById(R.id.questionOption4);
        buttonOption4.setText(Answers[3].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[3].substring(2), question);
            }
        });
    }

    private void slider(final Question question) {
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question.question);
        tf.setVisibility(View.INVISIBLE);
        mc.setVisibility(View.INVISIBLE);
        sl.setVisibility(View.VISIBLE);
        final SeekBar slider = findViewById(R.id.slider);
        //int newMax = (int)(Integer.parseInt(Answer) + (Integer.parseInt(Answer) * Math.random()));
        //slider.setMax(newMax);
        Button sliderButton = findViewById(R.id.sliderButton);
        sliderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkS(slider.getProgress(), question);
            }
        });
    }

}