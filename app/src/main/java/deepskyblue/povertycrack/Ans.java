package deepskyblue.povertycrack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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
        Intent intent = getIntent();
        String id = intent.getStringExtra("test");
        System.out.println(id);

        Question[] answers = results.toArray(new Question[results.size()]);

    }
}
