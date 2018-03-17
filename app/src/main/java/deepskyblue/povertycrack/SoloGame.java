package deepskyblue.povertycrack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class SoloGame extends AppCompatActivity {
    private int count = 0;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questionbox_template);
        newQuestion();
    }

    //every new question that is called in main calls this method
    //This method calls the appropriate method to execute the question
    private ArrayList<Object> results = new ArrayList<>();
    private Question currentQuestion;
    private void newQuestion(){
        count++;
//        currentQuestion = new Question(count, passedQ, passedA, false);
//        switch ((int) (Math.random() * 4)){
//            case 0:
//
//                highLow(passedQ, passedA);
//                break;
//            case 1:
//                multipleChoice(passedQ, passedA);
//                break;
//            case 2:
//                slider(passedQ, passedA);
//                break;
//            case 3:
//                checkAll(passedQ, passedA);
//                break;
//        }
    }
    //Check functions for each type of question
    //Parameters include the selected answer compared to the correct answer
    private void checkTF(String selectedA, String correctA){
        if(selectedA.equals(correctA)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }

    private void checkSA(String selectedA, String correctA){
        if(selectedA.equals(correctA)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }

    private void checkMC(String selectedA, String correctA){
        if(selectedA.equals(correctA)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }

    private void checkS(int sliderSelection, String correctA){
        if(sliderSelection == Integer.parseInt(correctA)){
            currentQuestion.correct = true;
        }
        results.add(currentQuestion);
    }
    //Function called for a true or false question
    private void highLow(String question, final String answer){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question);
        Button True = findViewById(R.id.buttonTrue);
        //sets up onclick listeners for both buttons that call the check function above
        True.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTF("true", answer);
            }
        });
        Button False = findViewById(R.id.buttonFalse);
        False.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkTF("false", answer);
            }
        });
    }

    private void checkAll(String question, String Answer){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question);
        String Answers [] = Answer.split(";");
        String correctAnswersTemp = "";
        final CheckBox Option [] = new CheckBox[5];
        int checkBox [] = {
                R.id.checkboxOption1,
                R.id.checkboxOption2,
                R.id.checkboxOption3,
                R.id.checkboxOption4,
                R.id.checkboxOption5
        };
        for(int i = 0; i < 5; i++){
            Option[i] = findViewById(checkBox[i]);
            Option[i].setText(Answers[i].substring(2));
            if(Answers[i].charAt(0) == 'c'){
                correctAnswersTemp += i;
            }
        }
        final String correctAnswers = correctAnswersTemp;
        Button submit = findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedAnswers = "";
                for(int i = 0; i < 5; i++){
                    if(Option[i].isChecked()){
                        selectedAnswers += i;
                    }
                    checkSA(selectedAnswers, correctAnswers);
                }
            }
        });
    }

    private void multipleChoice(String question, String answer){
        TextView Q = findViewById(R.id.questionText);
        Q.setText(question);
        final String [] Answers = answer.split(";");
        String correctAnswerTemp = "";
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
                checkMC(Answers[0].substring(2), correctAnswer);
            }
        });
        Button buttonOption2 = findViewById(R.id.questionOption2);
        buttonOption2.setText(Answers[1].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[1].substring(2), correctAnswer);
            }
        });
        Button buttonOption3 = findViewById(R.id.questionOption3);
        buttonOption3.setText(Answers[2].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[2].substring(2), correctAnswer);
            }
        });
        Button buttonOption4 = findViewById(R.id.questionOption4);
        buttonOption4.setText(Answers[3].substring(2));
        buttonOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkMC(Answers[3].substring(2), correctAnswer);
            }
        });
    }

    private void slider(String Question, final String Answer) {
        TextView Q = findViewById(R.id.questionText);
        Q.setText(Question);
        final SeekBar slider = findViewById(R.id.slider);
        int newMax = (int)(Integer.parseInt(Answer) + (Integer.parseInt(Answer) * Math.random()));
        slider.setMax(newMax);
        Button sliderButton = findViewById(R.id.sliderButton);
        sliderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkS(slider.getProgress(), Answer);
            }
        });
    }
}