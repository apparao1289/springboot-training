package com.userservice.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;


/*******************************************************************************
 * @author : agongad
 * 
 * File    : ExcelStylesInteger.java
 * 
 * Description : This class will process the actions that are related to 
 *               generating excel styles.
 ******************************************************************************/
public class ExcelStylesInteger {

	
	private static final String RIGHT_ALIGN_WRAP_TEXT ="RIGHT_ALIGN_WRAP_TEXT";
	private static final String CENTER_ALIGN_WRAP_TEXT ="CENTER_ALIGN_WRAP_TEXT";	
	private static final String LEFT_ALIGN_WRAP_TEXT = "LEFT_ALIGN_WRAP_TEXT";
    private static final String BILLED_UNITS_TOTAL = "BILLED_UNITS_TOTAL";
    private static final String FISCAL_YEAR = "FISCAL_YEAR"; 
    private static final String TABLE_HEADER_RIGHT = "TABLE_HEADER_RIGHT";
	
	///------------------------------------------
    HSSFFont fontLabel = null;
	
	HSSFFont fontCenterAlign = null;
	HSSFCellStyle cellStyleCenterAlign = null;
	
	HSSFFont fontRightAlign = null;
	HSSFCellStyle cellStyleRightAlign = null;
	
	/*HSSFFont fontLeftAlign = null;
	HSSFCellStyle cellStyleLeftAlign = null;*/
  
    HSSFFont fontBilledUnitsTotal = null;
    HSSFCellStyle cellStyleBilledUnitsTotal = null;
    HSSFDataFormat dataFormatBilledUnitsTotal = null;
    
    HSSFFont fontFiscalYear = null;
    HSSFCellStyle cellStyleFiscalYear = null;
    HSSFDataFormat dataFormatFiscalYear = null;
    
    HSSFCellStyle cellStyleTableHeaderRight = null;
	HSSFFont fontTableHeaderRight = null;
	HSSFPalette paletteTableHeaderRight = null;
    
	///------------------------------------------
	
	public ExcelStylesInteger(HSSFWorkbook wb){
			
		fontLabel = wb.createFont();;
		
		fontCenterAlign = wb.createFont();
		cellStyleCenterAlign = wb.createCellStyle();
		
		fontRightAlign = wb.createFont();
		cellStyleRightAlign = wb.createCellStyle();
		
		/*fontLeftAlign = wb.createFont();
		cellStyleLeftAlign = wb.createCellStyle();*/
	
		fontBilledUnitsTotal = wb.createFont();
        cellStyleBilledUnitsTotal = wb.createCellStyle();
        dataFormatBilledUnitsTotal =wb.createDataFormat();
        
        fontFiscalYear = wb.createFont();
        cellStyleFiscalYear = wb.createCellStyle();
        dataFormatFiscalYear =wb.createDataFormat();
        
        cellStyleTableHeaderRight = wb.createCellStyle();
		fontTableHeaderRight = wb.createFont();
		paletteTableHeaderRight = wb.getCustomPalette();
	}
	
	/***************************************************************************
	 * Method 		: 	addStyle
	 * 
	 * Description 	: 	To add styles to the column, It is similar to styles in
	 * 				 	HTML.
	 * 
	 * @param 		:	cell - Cell to which the style has to be applied.
	 * @param 		:	workbook - WorkBook to which the style has to be 
	 * 					applied.
	 * @param 		:	styleType - Is the style type that has to be applied 
	 * 					to the cell in the work book.
	 **************************************************************************/	
	public void addStyle(HSSFCell cell, HSSFWorkbook workbook,
			String styleType) {
		
		if(styleType.equals(CENTER_ALIGN_WRAP_TEXT)) {
			setDataFormat(cellStyleCenterAlign);
			cellStyleCenterAlign.setDataFormat(dataFormatBilledUnitsTotal
                    .getFormat("#,##0"));
			fontCenterAlign.setFontHeight((short) 175);
			cellStyleCenterAlign.setLocked(false);
			cellStyleCenterAlign.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleCenterAlign.setFont(fontCenterAlign);
			cellStyleCenterAlign.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setWrapText(true);
			cell.setCellStyle(cellStyleCenterAlign);
		} else if(styleType.equals(RIGHT_ALIGN_WRAP_TEXT)) {
			setDataFormat(cellStyleRightAlign);
			cellStyleRightAlign.setLocked(false);
			cellStyleRightAlign.setDataFormat(dataFormatBilledUnitsTotal
                    .getFormat("#,##0"));
			cellStyleRightAlign.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			fontRightAlign.setFontHeight((short) 175);
			cellStyleRightAlign.setFont(fontRightAlign);
			cellStyleRightAlign.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setWrapText(true);
			cell.setCellStyle(cellStyleRightAlign);
		}else if(styleType.equals(BILLED_UNITS_TOTAL)) {
            setDataFormat(cellStyleBilledUnitsTotal);
            cellStyleBilledUnitsTotal
            .setDataFormat(dataFormatBilledUnitsTotal
                    .getFormat("#,##0"));
            fontBilledUnitsTotal.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyleBilledUnitsTotal
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_TOP);
			fontBilledUnitsTotal.setFontHeight((short) 175);
			cellStyleBilledUnitsTotal.setLocked(false);
			cellStyleBilledUnitsTotal.setFont(fontLabel);
			cellStyleBilledUnitsTotal.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			
			cellStyleBilledUnitsTotal.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleBilledUnitsTotal
					.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleBilledUnitsTotal.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleBilledUnitsTotal.setBorderRight(HSSFCellStyle.BORDER_THIN);

			cellStyleBilledUnitsTotal.setFont(fontBilledUnitsTotal);
			cell.setCellStyle(cellStyleBilledUnitsTotal);
        } else if(styleType.equals(FISCAL_YEAR)) {
			setDataFormat(cellStyleCenterAlign);
			fontCenterAlign.setFontHeight((short) 175);
			cellStyleCenterAlign.setLocked(false);
			cellStyleCenterAlign.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleCenterAlign.setFont(fontCenterAlign);
			cellStyleCenterAlign.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlign.setWrapText(true);
			cell.setCellStyle(cellStyleCenterAlign);
        } else if (styleType.equals(TABLE_HEADER_RIGHT)) {
			setDataFormat(cellStyleTableHeaderRight);
			paletteTableHeaderRight.setColorAtIndex(HSSFColor.RED.index,
					(byte) 221, (byte) 213, (byte) 143);
			cellStyleTableHeaderRight.setLocked(false);
			cellStyleTableHeaderRight
					.setFillForegroundColor(HSSFColor.RED.index);
			cellStyleTableHeaderRight
					.setFillBackgroundColor(HSSFColor.RED.index);
			cellStyleTableHeaderRight.setFillPattern(HSSFColor.RED.index);
			fontTableHeaderRight.setFontHeight((short) 175);
			fontTableHeaderRight.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyleTableHeaderRight.setFont(fontTableHeaderRight);
			
			cellStyleTableHeaderRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyleTableHeaderRight.setWrapText(true);
			cellStyleTableHeaderRight
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleTableHeaderRight
					.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleTableHeaderRight);
		} 
		
		/*else if(styleType.equals(LEFT_ALIGN_WRAP_TEXT)) {
    			setDataFormat(cellStyleLeftAlign);
    			cellStyleLeftAlign.setLocked(false); 
    			cellStyleLeftAlign.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
    			fontLeftAlign.setFontHeight((short) 175);
    			cellStyleLeftAlign.setFont(fontLeftAlign);
    			cellStyleLeftAlign.setBorderTop(HSSFCellStyle.BORDER_THIN);
    			cellStyleLeftAlign.setBorderBottom(HSSFCellStyle.BORDER_THIN);
    			cellStyleLeftAlign.setBorderLeft(HSSFCellStyle.BORDER_THIN);
    			cellStyleLeftAlign.setBorderRight(HSSFCellStyle.BORDER_THIN);
    			cellStyleLeftAlign.setWrapText(true);
    			cell.setCellStyle(cellStyleLeftAlign);
        }*/
	}
	  
    /***************************************************************************
	 * Method Name : setDataFormat
	 * 
	 * Description : Sets the format for the given cell.
	 * 
	 * @param :
	 *            HSSFCellStyle
	 * 
	 * @return : None
	 **************************************************************************/
	private void setDataFormat(HSSFCellStyle cellStyle) {
		cellStyle.setDataFormat((short) 1);
	}
}
