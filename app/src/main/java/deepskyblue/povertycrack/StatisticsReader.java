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

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


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

    public void order()
    {


    }

}
