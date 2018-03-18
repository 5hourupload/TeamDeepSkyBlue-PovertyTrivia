package deepskyblue.povertycrack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static deepskyblue.povertycrack.MainActivity.results;

public class ResultScreen extends AppCompatActivity
{

    //initializes local variables to keep count on questions
    private int wrongCount = 0;
    private int rightCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);
        //Resets count
        wrongCount = 0;
        rightCount = 0;

        //converts linkedlist results to array of questions
        Question[] questions = results.toArray(new Question[results.size()]);

        //loops through answered questions to check for right and wrongs
        for (int i = 0; i < results.size(); i++)
        {
            if (results.get(i).correct)//question was answered correctly
            {
                rightCount++;
            } else//question was answered incorrectly
            {
                wrongCount++;
            }
        }

        //sets text for tally on right and wrong
        TextView tallyCounter = findViewById(R.id.tallyCounterTV);
        tallyCounter.setText("Correct: " + rightCount + " " + "Wrong: " + wrongCount);

        //sets text for score
        TextView scoreTally = findViewById(R.id.scoreTally);
        scoreTally.setText("Score: " + SoloGame.score);

        //uses custom adapter to create an image with two rows of text in a single row through custom_row.xml
        ListAdapter queAdapter = new CustomAdapter(this, questions);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(queAdapter);

        //resets game
        Button startAgain = findViewById(R.id.startAgain);
        startAgain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
    }
}