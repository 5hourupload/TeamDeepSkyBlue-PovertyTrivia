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
            int questionType = (int)(Math.random() * 3) + 1;
            switch (questionType){
                case 1:
                    generateTrueFalse(year, type, group, value);
                    break;
                case 2:

            }
        }
    }

    private void generateTrueFalse(String year, String type, String group, String value){
        int currentYear = 2018;
        Random r = new Random();
        boolean TorF = r.nextBoolean();
        if(TorF){
            String q = "True or False: In " +year+ ", the " +type+ " for " +group+ " was " +value+ "?";
        }
        else{
            int changeValue = (int)(Math.random());
            if(changeValue == 0){
            }
        }
    }
}
