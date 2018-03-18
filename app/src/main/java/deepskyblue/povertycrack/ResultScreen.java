package deepskyblue.povertycrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import static deepskyblue.povertycrack.MainActivity.results;

public class ResultScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);

        Question[] questions = results.toArray(new Question[results.size()]);
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