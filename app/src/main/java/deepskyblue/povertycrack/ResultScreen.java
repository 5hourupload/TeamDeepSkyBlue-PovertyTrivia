package deepskyblue.povertycrack;

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

        String[] questions = {"Why x", "How y", "When z", "What q", "Who w"};
        ListAdapter queAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, questions);
//        ListView myListView = (ListView) findViewById(R.id.myListView);
//        myListView.setAdapter(queAdapter);

//        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        String question = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(ResultScreen.this, question, Toast.LENGTH_LONG).show();

                    }
                }
        );
    }


}
