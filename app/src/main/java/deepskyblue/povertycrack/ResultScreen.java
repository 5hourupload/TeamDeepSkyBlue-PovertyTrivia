package deepskyblue.povertycrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import static deepskyblue.povertycrack.MainActivity.results;

public class ResultScreen extends AppCompatActivity
{

    private int wrongCount = 0;
    private int rightCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);
        //Resets count for play again option
        wrongCount = 0;
        rightCount = 0;

        Question[] questions = results.toArray(new Question[results.size()]);

        for (int i = 0; i < results.size(); i++)
        {
            if (results.get(i).correct)
            {
                rightCount++;
            } else
            {
                wrongCount++;
            }
        }

        TextView tallyCounter = findViewById(R.id.tallyCounterTV);
        tallyCounter.setText("Correct: " + rightCount + " " + "Wrong: " + wrongCount);
        ListAdapter queAdapter = new CustomAdapter(this, questions);
        ListView myListView = (ListView) findViewById(R.id.myListView);
        myListView.setAdapter(queAdapter);

        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        String question = String.valueOf(parent.getItemAtPosition(position));
                    }
                }
        );
    }
}