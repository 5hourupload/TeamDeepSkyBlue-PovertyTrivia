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
        questions[0] = new Question((int)Math.random(), "I", "You got it wrong", "This is the question", false);
        questions[1] = new Question((int)Math.random(), "Suck", "You got it right", "asdf", true);
        questions[2] = new Question((int)Math.random(), "at", "You got it wrong", "asdf", false);
        questions[3] = new Question((int)Math.random(), "Coding", "You got it right", "asdf", true);
        questions[4] = new Question((int)Math.random(), "!", "You got it wrong", "asdf", false);
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
