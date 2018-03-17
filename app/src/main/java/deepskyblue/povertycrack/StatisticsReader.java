package deepskyblue.povertycrack;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
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

public class StatisticsReader extends MainActivity
{
    public StatisticsReader()
    {


        //workbook = WorkbookFactory.create(f);
    }

//    //@Override
//    protected void onHandleIntent(Intent workIntent)
//    {
//        // Creating a Workbook from an Excel file (.xls or .xlsx)
//        Workbook workbook = null;
//        try
//        {
////            AssetManager am = getApplicationContext().getAssets();
////            InputStream is = am.open("statistics.xlsx");
//
//            File f = new File(getCacheDir()+"/statistics.xlsx");
//            if (!f.exists())
//                try {
//
//                    InputStream is = getApplicationContext().getAssets().open("statistics.xlsx");
//                    byte[] buffer = new byte[1024];
//                    is.read(buffer);
//                    is.close();
//
//
//                    FileOutputStream fos = new FileOutputStream(f);
//                    fos.write(buffer);
//                    fos.close();
//                } catch (Exception e) { throw new RuntimeException(e); }
//
//
//
////
////            try{
////// Creating Input Stream
////                File file = new File(getApplicationContext().getExternalFilesDir(null), "statistics.xlsx");
////                FileInputStream myInput = new FileInputStream(f);
////
////// Create a POIFSFileSystem object
////                POIFSFileSystem myFileSystem = new POIFSFileSystem(myInput);
////
////// Create a workbook using the File System
////                HSSFWorkbook myWorkBook = new HSSFWorkbook(myFileSystem);
////
////// Get the first sheet from workbook
////                HSSFSheet mySheet = myWorkBook.getSheetAt(0);
////
/////** We now need something to iterate through the cells.**/
////                Iterator rowIter = mySheet.rowIterator();
////
////                while(rowIter.hasNext()){
////                    HSSFRow myRow = (HSSFRow) rowIter.next();
////                    Iterator cellIter = myRow.cellIterator();
////                    while(cellIter.hasNext()){
////                        HSSFCell myCell = (HSSFCell) cellIter.next();
////                        Log.d(TAG, "Cell Value: " + myCell.toString());
////                        Toast.makeText(getApplicationContext(), "cell Value: " + myCell.toString(), Toast.LENGTH_SHORT).show();
////                    }
////                }
////            }catch (Exception e){e.printStackTrace(); }
//
//
//            InputStream is = getApplicationContext().getAssets().open("statidstics.xlsx");
//            workbook = WorkbookFactory.create(is);
//
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        } catch (InvalidFormatException e)
//        {
//            e.printStackTrace();
//        }
//
//        System.out.println(workbook.getNumCellStyles());
//        // Retrieving the number of sheets in the Workbook
//        System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
//
//        /*
//           =============================================================
//           Iterating over all the sheets in the workbook (Multiple ways)
//           =============================================================
//        */
//
//        // 1. You can obtain a sheetIterator and iterate over it
//        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
//        System.out.println("Retrieving Sheets using Iterator");
//        while (sheetIterator.hasNext()) {
//            Sheet sheet = sheetIterator.next();
//            System.out.println("=> " + sheet.getSheetName());
//        }
//
//        // 2. Or you can use a for-each loop
//        System.out.println("Retrieving Sheets using for-each loop");
//        for(Sheet sheet: workbook) {
//            System.out.println("=> " + sheet.getSheetName());
//        }
//
////        // 3. Or you can use a Java 8 forEach with lambda
////        System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
////        workbook.forEach(sheet -> {
////            System.out.println("=> " + sheet.getSheetName());
////        });
////
////        /*
////           ==================================================================
////           Iterating over all the rows and columns in a Sheet (Multiple ways)
////           ==================================================================
////        */
////
////        // Getting the Sheet at index zero
////        Sheet sheet = workbook.getSheetAt(0);
////
////        // Create a DataFormatter to format and get each cell's value as String
////        DataFormatter dataFormatter = new DataFormatter();
////
////        // 1. You can obtain a rowIterator and columnIterator and iterate over them
////        System.out.println("\n\nIterating over Rows and Columns using Iterator\n");
////        Iterator<Row> rowIterator = sheet.rowIterator();
////        while (rowIterator.hasNext()) {
////            Row row = rowIterator.next();
////
////            // Now let's iterate over the columns of the current row
////            Iterator<Cell> cellIterator = row.cellIterator();
////
////            while (cellIterator.hasNext()) {
////                Cell cell = cellIterator.next();
////                String cellValue = dataFormatter.formatCellValue(cell);
////                System.out.print(cellValue + "\t");
////            }
////            System.out.println();
////        }
////
////        // 2. Or you can use a for-each loop to iterate over the rows and columns
////        System.out.println("\n\nIterating over Rows and Columns using for-each loop\n");
////        for (Row row: sheet) {
////            for(Cell cell: row) {
////                String cellValue = dataFormatter.formatCellValue(cell);
////                System.out.print(cellValue + "\t");
////            }
////            System.out.println();
////        }
////
////        // 3. Or you can use Java 8 forEach loop with lambda
////        System.out.println("\n\nIterating over Rows and Columns using Java 8 forEach with lambda\n");
////        sheet.forEach(row -> {
////            row.forEach(cell -> {
////                String cellValue = dataFormatter.formatCellValue(cell);
////                System.out.print(cellValue + "\t");
////            });
////            System.out.println();
////        });
////
////        // Closing the workbook
////        workbook.close();
//    }
}
