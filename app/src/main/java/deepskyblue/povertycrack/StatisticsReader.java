package deepskyblue.povertycrack;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Random;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import static deepskyblue.povertycrack.MainActivity.multChoiceQuestions;
import static deepskyblue.povertycrack.MainActivity.sliderQuestions;
import static deepskyblue.povertycrack.MainActivity.trueFalseQuestions;

//analyzes database into questions and answers
public class StatisticsReader extends IntentService
{

    public StatisticsReader()
    {
        super("man");
    }

    public StatisticsReader(String name)
    {
        super("man");
    }

    @Override
    protected void onHandleIntent(Intent service)
    {
        //runs generateQuestions
        generateQuestions();
    }


    private void generateQuestions()
    {
        //initializes objects
        AssetManager am = getApplicationContext().getAssets();
        InputStream is = null;
        Workbook wb = null;
        //tries to grab from database
        try
        {
            is = am.open("focused_statistics.xls");
            wb = Workbook.getWorkbook(is);
            is.close();
        }
        //catches File Not Found Exception
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //catches excel related exceptions
        catch (BiffException e)
        {
            e.printStackTrace();
        }
        //sets the first sheet
        Sheet s = wb.getSheet(0);

        //sets the row variable to first sheet
        int rows = s.getRows();

        //loops through all the rows
        for (int i = 0; i < rows; i++)
        {
            String year = s.getCell(0, i).getContents();
            String type = s.getCell(1, i).getContents();
            String group = s.getCell(2, i).getContents();
            String value = s.getCell(3, i).getContents();
            int questionType = (int) (Math.random() * 2);
            //randomly selects a question for the user from True/False or Multiple Choice
            switch (questionType)
            {
                case 0:
                    trueFalseQuestions.push(generateTrueFalse(year, type, group, value));
                    break;
                case 1:
                    multChoiceQuestions.push(generateMultipleChoice(year, type, group, value));
                    break;
            }
        }
        //shuffles the database
        Collections.shuffle(trueFalseQuestions);
        Collections.shuffle(multChoiceQuestions);
    }

    //creates a True/False question from the database
    private Question generateTrueFalse(String year, String type, String group, String value)
    {
        //initializes questions, answer, correct fact
        String q;
        String a;
        String cf;
        //initializes random object r
        Random r = new Random();
        boolean TorF = r.nextBoolean();
        //formats the question from the given database
        if (TorF)
        {
            q = "True or False: In " + year + ", the " + type + " for " + group + " was " + value + "?";
            a = "True";
        } else
        {
            //creates a spacing variable
            String shift = "";
            //formats income questions to have grammatical corrections
            if (type.contains("Income"))
            {
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                shift = "$" + formatter.format((int) (Math.random() * (87_057 - 30_572)) + 30_572);
            } else if (type.contains("percentage"))//format contains percentage
            {
                DecimalFormat formatter = new DecimalFormat("#.##");
                shift = formatter.format(Math.random() * 1);
            } else//adds commas to large digits
            {
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                shift = formatter.format(((int)(Math.random() * 100) * (1000)) + 10_000);
            }
            q = "True or False: In " + year + ", the " + type + " for " + group + " was " + shift + "?";
            a = "False";
        }
        cf = "In " + year + ", the " + type + " for " + group + " was " + value;
        return new Question(-1, q, type, a, cf, false);//returns formatted question
    }

    //creates multiple choice question and answers from database
    private Question generateMultipleChoice(String year, String type, String group, String value)
    {
        //checks if the value does not contain . or $
        if (!value.contains(".") && !value.contains("$"))
        {
            //initializes objects to format
            DecimalFormat formatter = new DecimalFormat("###,###,###");
            int population = Integer.parseInt(value);
            value = formatter.format(population);
        }
        //grammatical formats the question and answer
        String q = "In " + year + ", what was the " + type + " for " + group + "?";
        String cf = "In " + year + ", the " + type + " for " + group + " was " + value;
        return new Question(-1, q, type, value, cf, false);//returns the formatted question
    }
}
