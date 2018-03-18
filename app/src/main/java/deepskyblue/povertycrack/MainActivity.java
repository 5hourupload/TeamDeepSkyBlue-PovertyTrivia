package deepskyblue.povertycrack;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;

import jxl.Sheet;
import jxl.read.biff.BiffException;

public class MainActivity extends AppCompatActivity {

    //The lists that will hold the various diverse generated questions
    static LinkedList<Question> multChoiceQuestions = new LinkedList<>();
    static LinkedList<Question> trueFalseQuestions = new LinkedList<>();
    static LinkedList<Question> sliderQuestions = new LinkedList<>();
    static LinkedList<Question> results = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent statistics = new Intent(MainActivity.this, StatisticsReader.class);
        startService(statistics);

        //Start button that initiates the game.
        Button buttonSolo = findViewById(R.id.buttonSolo);
        buttonSolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(MainActivity.this, SoloGame.class);
                startActivity(newIntent);
            }
        });

        //URL list of helpful sites related to poverty
        final LinkedList<String> urlList = new LinkedList<>();

        /*Initial buffered reader that will take in a .txt file from the assets folder and
        parse it into separate strings*/
        BufferedReader urlReader = null;
        try {
            //Looking to find assets, specifically opens up the URLS.txt
            urlReader = new BufferedReader(
                    new InputStreamReader(getAssets().open("URLs.txt")));

            /*String that will be set to the url buffered reader and will be added to the urlList
            until the buffered reader is out of lines to read from the file*/
            String mLine;
            while ((mLine = urlReader.readLine()) != null) {
                //String is added into the urlList
                urlList.add(mLine);

            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (urlReader != null) {
                try {
                    urlReader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

        /*
        The following will take in information from an excel .xls file and harvest that information
        to later be used to generate a question by taking in the data and setting it to instances.
         */
        AssetManager am = getApplicationContext().getAssets();
        InputStream is = null;
        jxl.Workbook wb = null;
        try {
            /*
            The asset manager opens up the specified folder from the app assets and feeds the Input
            Stream (is) that information. Afterwords, the app creates a Workbook who then gets its
            information from the InputStream and locks it down for later use when accessing Sheet
            data. InputStream(is) is closed as it is currently no longer needed.
             */
            is = am.open("focused_statistics.xls");
            wb = jxl.Workbook.getWorkbook(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        }
        /*
        Sheet s will house information from the Workbook from the first sheet (0) that can be provide
        information relative to rows, columns and cells.
        */
        Sheet s = wb.getSheet(0);
        int rows = s.getRows();
        /*
        The structure of the excel file is set in such a way that it provides information of
        constants from left to right. We use a random number generator to choose one of the rows to
        randomly select a fact of a different subject.
        */
        int random = (int) (Math.random() * rows);
        String arg1 = s.getCell(0, random).getContents();
        String arg2 = s.getCell(1, random).getContents();
        String arg3 = s.getCell(2, random).getContents();
        String arg4 = s.getCell(3, random).getContents();

        /*
        As the cells are arranged in a certain order, we created a template to plug those constants
        in making generic question that can be recycled repeatedly for other questions.
         */
        String randomFactText = "Did you know: In " + arg1 +
                ", the " + arg2 + " for " + arg3 + " was " + arg4 + ".";
        //Sets the generated random fact to the textview in the homescreen.
        TextView randomFact = findViewById(R.id.dykFact);
        randomFact.setText(randomFactText);

        //A random url is selected from our urlList and provides an actual link to that site.
        final double randomURL = Math.random() * urlList.size();
        //makes an instance to replace homescreen textfield with "Learn More Here" replacement.
        TextView urlTextView = findViewById(R.id.factURL);
        String textPlaceholder = "Learn More Here";
        urlTextView.setText(textPlaceholder);
        //makes the textview become clickable, allowing for the user to be taken to a random site.
        urlTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(urlList.get((int) randomURL)));
                startActivity(browserIntent);
            }
        });
    }
}