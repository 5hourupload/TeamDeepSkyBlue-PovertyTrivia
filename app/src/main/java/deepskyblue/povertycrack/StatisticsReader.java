package deepskyblue.povertycrack;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Random;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import static deepskyblue.povertycrack.MainActivity.multChoiceQuestions;
import static deepskyblue.povertycrack.MainActivity.sliderQuestions;
import static deepskyblue.povertycrack.MainActivity.trueFalseQuestions;


public class StatisticsReader extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetManager am = getApplicationContext().getAssets();
        InputStream is = null;
        Workbook wb = null;
        try
        {
            is = am.open("statistics.xls");
            wb = Workbook.getWorkbook(is);
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (BiffException e)
        {
            e.printStackTrace();
        }
        Sheet s = wb.getSheet(0);
        //System.out.println(s.getCell(0,0).getContents());
        int row = s.getRows();
        int col = s.getColumns();

        String questionString = "";
        LinkedList<String> factz = new LinkedList<>();

        for (int i = 0; i < row; i++)
        {
            questionString = "In " + s.getCell(0,i).getContents() + ", the " + s.getCell(1,i).getContents() + " for " + s.getCell(2,i).getContents() + " is " + s.getCell(3,i).getContents() + ".";
            factz.add(questionString);
        }
    }

    private void generateQuestions(){
        AssetManager am = getApplicationContext().getAssets();
        InputStream is = null;
        Workbook wb = null;
        try
        {
            is = am.open("statistics.xls");
            wb = Workbook.getWorkbook(is);
        } catch (IOException e)
        {
            e.printStackTrace();
        } catch (BiffException e)
        {
            e.printStackTrace();
        }
        Sheet s = wb.getSheet(0);
        int rows = s.getRows();
        int cols = s.getColumns();

        for(int i = 0; i < rows; i++){
            String year = s.getCell(0,i).getContents();
            String type = s.getCell(1,i).getContents();
            String group = s.getCell(2,i).getContents();
            String value = s.getCell(3,i).getContents();
            int questionType = (int)(Math.random() * 2);
            switch (questionType){
                case 0:
                    trueFalseQuestions.push(generateTrueFalse(year, type, group, value));
                    break;
                case 1:
                    multChoiceQuestions.push(generateMultipleChoice(year, type, group, value));
                    break;
                case 2:
                    sliderQuestions.push(generateSlider(year, type, group, value));
            }
        }
    }

    private Question generateTrueFalse(String year, String type, String group, String value){
        String q;
        String a;
        String cf;
        Random r = new Random();
        boolean TorF = r.nextBoolean();
        if(TorF){
            q = "True or False: In " +year+ ", the " +type+ " for " +group+ " was " +value+ "?";
            a = "True";
        }
        else{
            int shiftedIncome = (int)(Math.random() * (87_057 - 30_572)) + 30_572;
            q = "True or False: In " +year+ ", the " +type+ " for " +group+ " was " +shiftedIncome+ "?";
            a = "False";
        }
        cf = "In " +year+ ", the " +type+ " for " +group+ " was " +value;
        return new Question(-1, q, a, cf, false);
    }

    private Question generateMultipleChoice(String year, String type, String group, String value){
        String q = "In " +year+ ", what was the " +type+ " for " +group+ "?";
        String cf = "In " +year+ ", the " +type+ " for " +group+ " was " +value;
        return new Question(-1, q, value, cf, false);
    }

    private Question generateSlider(String year, String type, String group, String value){
        String q = "In the year " +year+ ", what was the level of " +type+ " for " +group+ "?";
        String cf = "Can you believe that in " +year+ ", that the " +type+ " for " +group+ "was only" +value+ "!";
        return new Question(-1, q, value, cf, false);
    }
}
