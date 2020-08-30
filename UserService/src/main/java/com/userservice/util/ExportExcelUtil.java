package com.userservice.util;

import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;

import com.userservice.entity.User;

public class ExportExcelUtil {
	
	//public static final Logger log = Logger.getLogger("RxLogger");
    private static final String LABEL_LEFT = "LABEL_LEFT";
    private static final String BOLDHEADING = "BOLD_JUSTIFY";
    private static final String TABLE_HEADER = "TABLE_HEADER";
    private static final String TABLE_HEADER_RIGHT = "TABLE_HEADER_RIGHT";
    private static final String TABLE_HEADER_LEFT = "TABLE_HEADER_LEFT";
    private static final String ERROR_TEXT = "ERROR_TEXT";
    private static final String CENTER_ALIGN_WRAP_TEXT = "CENTER_ALIGN_WRAP_TEXT";
    private static final String RIGHT_ALIGN_WRAP_TEXT = "RIGHT_ALIGN_WRAP_TEXT";
    private static final String LEFT_ALIGN_WRAP_TEXT = "LEFT_ALIGN_WRAP_TEXT";
	
    
	 public static void buildExcelDocument(List<User> userList,HttpServletResponse response)  {

            try{

            int rowCnt = 0;
            response.reset();
            response.setHeader("Content-type", "application/xls");
            response.setHeader("Content-disposition",
                    "inline; filename=User Excel.xls");
            
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet();

            ExcelStylesText excelStylesText = new ExcelStylesText(wb);
            ExcelStylesInteger excelStylesInteger = new ExcelStylesInteger(wb);
           
            HSSFFont fontTableData = wb.createFont();
            HSSFCellStyle cellStyleTableData = wb.createCellStyle();
            cellStyleTableData = getTableDataStyle(fontTableData,cellStyleTableData);
           

            //setting print properties for excel sheet
            sheet.setAutobreaks(true);
            sheet.getPrintSetup().setLandscape(true);
            sheet.getPrintSetup().setFitWidth((short) 1);
            sheet.getPrintSetup().setFitHeight((short) 0);

            // set the sheet name in Unicode
            wb.setSheetName(0, "Detail");
            HSSFRow row = sheet.createRow(rowCnt);
            
            HSSFCell cell = row.createCell(0);
            
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
            createSheetCell(row, cell, (short) 0, "User Detail", LABEL_LEFT, wb, excelStylesText);
            
            sheet.setColumnWidth(0,3500);
            sheet.setColumnWidth(1,3500);
            sheet.setColumnWidth(2,3500);

            rowCnt++;
            row = sheet.createRow(rowCnt);
            //createSheetCell(row, cell, (short) 15, "User Search Result", BOLDHEADING, wb, excelStylesText);
            rowCnt++;
            //Table Header Data
            createSheetCell(row, cell,0, "User Id", TABLE_HEADER, wb,excelStylesText);
            createSheetCell(row, cell,1, "User Name", TABLE_HEADER, wb,excelStylesText);
            createSheetCell(row, cell,2, "Role", TABLE_HEADER, wb,excelStylesText);

            //Table Data
            User user =null;
            for(int j = 0; j<userList.size(); j++){
                user = userList.get(j);
    
                row = sheet.createRow(rowCnt++);
                System.err.println("User Id::::::"+user.getUserId());
    
                createSheetCell(row, cell,0, ("" + user.getUserId()), CENTER_ALIGN_WRAP_TEXT, wb,excelStylesText);
                createSheetCell(row, cell,1, ("" + user.getUserName()), CENTER_ALIGN_WRAP_TEXT, wb,excelStylesText);
                createSheetCell(row, cell,2, ("" + user.getRole()), CENTER_ALIGN_WRAP_TEXT, wb,excelStylesText);
            }
            
            
            ServletOutputStream out = response.getOutputStream();
            wb.write(out);
            out.close();
            } catch(Exception e){
                e.printStackTrace();

            }

     }

	 private static void createSheetCell(HSSFRow row, HSSFCell cell,
             int colNbr, String val, String styleType, HSSFWorkbook workBook,
             ExcelStylesText excelStylesText) {

         cell = row.createCell(colNbr);
         cell.setCellValue(val);
         excelStylesText.addStyle(cell, workBook, styleType);
     }
	 
	 private static HSSFCellStyle getTableDataStyle(HSSFFont font,
             HSSFCellStyle cellStyle) {

         cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
         cellStyle.setIndention((short) 0);
         cellStyle.setWrapText(true);
         font.setFontHeight((short) 175);
         cellStyle.setFont(font);
         cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
         cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
         cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
         cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
         return cellStyle;
     }
}
