package sample;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;

public class InitialDataReadFromExcel {
    Workbook workbook;
    Sheet sheet;
    String data[][][] = new String[26][21][5];
    String letter[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    int sheetWordNum[] = new int[26];
    public InitialDataReadFromExcel() throws BiffException, IOException {
        workbook = Workbook.getWorkbook(new File("files/Vocabulary.xls"));
        for(int i=0;i<26;i++){
            sheet = workbook.getSheet(letter[i]);
            this.sheetWordNum[i] = sheet.getRows() - 1;
        }
    }

    public String[][][] getData(){
        for(int i=0;i<26;i++){
            sheet = workbook.getSheet(letter[i]);
            sheetWordNum[i] = sheet.getRows() - 1;
            for(int j=1;j<sheet.getRows();j++){
                for(int k=0;k<sheet.getColumns();k++){
                    data[i][j][k]=sheet.getCell(k,j).getContents();
                }
            }
        }
        return data;
    }

    public int[] getSheetWordNum() {
        return sheetWordNum;
    }

    public String[] getLetter(){
        return letter;
    }

}

