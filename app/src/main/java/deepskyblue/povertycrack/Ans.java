package deepskyblue.povertycrack;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import static deepskyblue.povertycrack.MainActivity.results;

/**
 * Created by Johnny on 3/17/2018.
 */

public class Ans extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ans);

        Question[] answers = results.toArray(new Question[results.size()]);

        ListView ansList = (ListView) findViewById(R.id.answerList);
        ArrayAdapter<Question> adapter = new ArrayAdapter<Question>(this, android.R.layout.simple_list_item_1, android.R.id.text1, answers);
        ansList.setAdapter(adapter);
    }
}
