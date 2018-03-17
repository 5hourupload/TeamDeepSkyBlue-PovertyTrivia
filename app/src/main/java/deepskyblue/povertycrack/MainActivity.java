package deepskyblue.povertycrack;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent newIntent = new Intent(this, StatisticsReader.class);
        //startActivity(newIntent);

        Button buttonSolo = findViewById(R.id.buttonSolo);
        buttonSolo.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent newIntent = new Intent(MainActivity.this, SoloGame.class);
                startActivity(newIntent);
            }
        });
        TextView testtest = findViewById(R.id.testtest);
        testtest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent newIntent = new Intent(MainActivity.this, ResultScreen.class);
                startActivity(newIntent);
            }
        });
        TextView d = findViewById(R.id.dykFact);
        d.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent newIntent = new Intent(MainActivity.this, StatisticsReader.class);
                startActivity(newIntent);
            }
        });


    }
}
