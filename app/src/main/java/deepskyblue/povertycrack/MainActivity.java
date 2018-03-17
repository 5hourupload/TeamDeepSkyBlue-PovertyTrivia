package deepskyblue.povertycrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView Q = findViewById(R.id.questionBox);
        String test = "how many people were on food stamps in 2015?";
        Q.setText(test);
        String answer1 = "100,000";
        String answer2 = "200,000";
        String answer3 = "300,000";
        String answer4 = "400,000";
        Button choice1 = findViewById(R.id.option1);
        choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = "you couldn't be more wrong";
                Q.setText(response);
            }
        });
        choice1.setText(answer1);
        Button choice2 = findViewById(R.id.option2);
        choice2.setText(answer2);
        choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = "Just roll over please";
                Q.setText(response);
            }
        });
        Button choice3 = findViewById(R.id.option3);
        choice3.setText(answer3);
        choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = "Wrong";
                Q.setText(response);
            }
        });
        Button choice4 = findViewById(R.id.option4);
        choice4.setText(answer4);
        choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String response = "It's even more than that";
                Q.setText(response);
            }
        });
    }

    private void startSolo(){

    }

    private void highLow(String Question, String Answer){
        TextView Q = findViewById(R.id.questionBox);
        String test = "how many people were on food stamps in 2015?";
        Q.setText(test);

    }

    private void checkAll(String question, String Answer){
        TextView Q = findViewById(R.id.questionBox);
        String Answers [] = Answer.split(";");
        Button choice1 = findViewById(R.id.option1);
        Button choice2 = findViewById(R.id.option2);
        Button choice3 = findViewById(R.id.option3);
        Button choice4 = findViewById(R.id.option4);

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
