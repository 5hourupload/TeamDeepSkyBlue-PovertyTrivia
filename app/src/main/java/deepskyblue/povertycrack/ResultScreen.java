package deepskyblue.povertycrack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ResultScreen extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultscreen);

        Question[] questions = new Question[5];
        questions[0].question = "I";
        questions[0].correct = true;
        questions[1].question = "Suck";
        questions[1].correct = false;
        questions[2].question = "at";
        questions[2].correct = true;
        questions[3].question = "coding";
        questions[3].correct = false;
        questions[4].question = "!";
        questions[4].correct = true;
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
                        Toast.makeText(ResultScreen.this, question, Toast.LENGTH_LONG).show();
                        //when clicked displays answer to the question
//                        sendMessage();
                    }
                }
        );
    }

    public void sendMessage(View view)
    {
//        Intent intent = new Intent(this)
    }


}
