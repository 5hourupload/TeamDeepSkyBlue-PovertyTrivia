package deepskyblue.povertycrack;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;


public class StatisticsReader extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("test");
        order();
    }

    public void order()
    {
        try
        {
            AssetManager am = getApplicationContext().getAssets();
            InputStream is = am.open("statistics.xls");
            Workbook wb = jxl.Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            //System.out.println(s.getCell(0,0).getContents());
            int row = s.getRows();
            int col = s.getColumns();
            String xx = "";

            for (int i = 0; i < row; i++)
            {
                for (int c = 0; c < col; c++)
                {
                    Cell z = s.getCell(c, i);
                    xx = xx + z.getContents();
                }
                xx = xx + "\n";
            }


        } catch (Exception e)
        {

        }

    }

}
