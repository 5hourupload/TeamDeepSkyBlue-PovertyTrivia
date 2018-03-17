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
        Intent newIntent = new Intent(this, StatisticsReader.class);
        startService(newIntent);
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
