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
        AssetManager am = getApplicationContext().getAssets();
        InputStream is = null;
        Workbook wb = null;
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
        Sheet s = wb.getSheet(0);
        int rows = s.getRows();

        for (int i = 0; i < rows; i++)
        {
            String year = s.getCell(0, i).getContents();
            String type = s.getCell(1, i).getContents();
            String group = s.getCell(2, i).getContents();
            String value = s.getCell(3, i).getContents();
            int questionType = (int) (Math.random() * 2);
            switch (questionType)
            {
                case 0:
                    trueFalseQuestions.push(generateTrueFalse(year, type, group, value));
                    break;
                case 1:
                    multChoiceQuestions.push(generateMultipleChoice(year, type, group, value));
                    break;
                case 2:
                    sliderQuestions.push(generateSlider(year, type, group, value));
                    break;
            }
        }
        Collections.shuffle(trueFalseQuestions);
        Collections.shuffle(multChoiceQuestions);
        Collections.shuffle(sliderQuestions);
    }

    private Question generateTrueFalse(String year, String type, String group, String value)
    {
        String q;
        String a;
        String cf;
        Random r = new Random();
        boolean TorF = r.nextBoolean();
        if (TorF)
        {
            q = "True or False: In " + year + ", the " + type + " for " + group + " was " + value + "?";
            a = "True";
        } else
        {
            String shift = "";
            if (type.contains("Income"))
            {
                shift = "$" + (int) (Math.random() * (87_057 - 30_572)) + 30_572;
            } else if (type.contains("percentage"))
            {
                DecimalFormat formatter = new DecimalFormat("#.##");
                shift = formatter.format(Math.random() * 1);
            } else
            {
                DecimalFormat formatter = new DecimalFormat("###,###,###");
                shift = formatter.format(((int)(Math.random() * 100) * (1000)) + 10_000);
            }
            q = "True or False: In " + year + ", the " + type + " for " + group + " was " + shift + "?";
            a = "False";
        }
        cf = "In " + year + ", the " + type + " for " + group + " was " + value;
        return new Question(-1, q, type, a, cf, false);
    }

    private Question generateMultipleChoice(String year, String type, String group, String value)
    {
        String q = "In " + year + ", what was the " + type + " for " + group + "?";
        String cf = "In " + year + ", the " + type + " for " + group + " was " + value;
        return new Question(-1, q, type, value, cf, false);
    }

    private Question generateSlider(String year, String type, String group, String value)
    {
        String q = "In the year " + year + ", what was the level of " + type + " for " + group + "?";
        String cf = "Can you believe that in " + year + ", that the " + type + " for " + group + "was only" + value + "!";
        return new Question(-1, q, type, value, cf, false);
    }
}
