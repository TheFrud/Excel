package reader;

import java.io.File;
import java.io.IOException;
import com.eniro.demo.EniroAPIExample;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

  private String inputFile;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read() throws IOException  {
    File inputWorkbook = new File(inputFile);
    Workbook w;
    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      // Loop over first 10 column and lines

      
     Cell cell1 = sheet.getCell(0,1);
     Cell cell2 = sheet.getCell(1,1);
     Cell cell3 = sheet.getCell(2,1);
     Cell cell4 = sheet.getCell(3,1);
     Cell cell5 = sheet.getCell(4,1);
     CellType type1 = cell1.getType();
     CellType type2 = cell2.getType();
     CellType type3 = cell3.getType();
     CellType type4 = cell4.getType();
     CellType type5 = cell5.getType();
     if (type1 == CellType.LABEL){
    	 System.out.print(cell1.getContents());
     }
     if (type2 == CellType.LABEL){
    	 System.out.print(cell2.getContents());
     }
     if (type3 == CellType.LABEL){
    	 System.out.print(cell3.getContents());
     }
     if (type4 == CellType.LABEL){
    	 System.out.print(cell4.getContents());
     }
     if (type5 == CellType.LABEL){
    	 System.out.print(cell5.getContents());
     }
     
     EniroAPIExample eniroQuery = new EniroAPIExample();
     
     eniroQuery.makeQuery(cell1.getContents(), cell2.getContents());
     
     //Skicka API
     //Slut iteration. 
     //Öka radnr med 1
     
      
      /*
      for (int j = 1; j < sheet.getColumns(); j++) {
    	  for (int i = 1; i < sheet.getRows(); i=0) {
          Cell cell = sheet.getCell(j, i);
          CellType type = cell.getType();
          if (type == CellType.LABEL) {
            System.out.println("I got a label "
                + cell.getContents());
          }

          if (type == CellType.NUMBER) {
            System.out.println("I got a number "
                + cell.getContents());
          }

        }
     }
     */
    } catch (BiffException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) throws IOException {
    ReadExcel test = new ReadExcel();
    test.setInputFile("H:/--- Projektfiler ---/Utveckling/BE/Excel Jars/excelfilen.xls");
    test.read();
  }

} 