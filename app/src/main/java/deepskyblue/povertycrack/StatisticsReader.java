package deepskyblue.povertycrack;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static android.content.ContentValues.TAG;

public class StatisticsReader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("test");
    }

    public void order(View v) {
        try {
            AssetManager am = getAssets();
            InputStream is = am.open("statistics.xls");
            Workbook wb = (Workbook) jxl.Workbook.getWorkbook(is);
            Sheet s = wb.getSheet(0);
            int row =s.getRow();
            int col = s.getColumns();
            String xx ="";

            for (int i = 0; i < row; i++){
                for (int c = 0; c < col; c++){
                    Cell z =s.getCell(c, i);
                    xx = xx + z.getContents();
                }
                xx = xx+ "\n";
            }


        } catch (Exception e) {

        }

    }

    public void display(String value) {
        TextView x = (TextView) findViewById(R.id.excelText);
        x.setText(value);
    }
}
