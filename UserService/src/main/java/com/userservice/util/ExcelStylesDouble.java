package com.userservice.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/*******************************************************************************
 * @author : agongad
 * 
 * File    : ExcelStylesDouble.java
 * 
 * Description : This class will process the actions that are related to 
 *               generating excel styles.
 ******************************************************************************/
public class ExcelStylesDouble {

	
	private static final String FREIGHT_CHARGE_BOLD = "FREIGHT_CHARGE_BOLD";
	
	private static final String RIGHT_ALIGN_WRAP_TEXT = "RIGHT_ALIGN_WRAP_TEXT";
	
	///------------------------------------------

	HSSFFont fontRightAlign = null;
	HSSFCellStyle cellStyleRightAlign = null;
	
	HSSFCellStyle cellStyleFreightChargeBold = null;
	HSSFFont fontFreightChargeBold = null;
	HSSFDataFormat dataFormatFreightChargeBold = null;
	///------------------------------------------
	
	public ExcelStylesDouble(HSSFWorkbook wb){
			
		fontRightAlign = wb.createFont();
		cellStyleRightAlign = wb.createCellStyle();
		
		cellStyleFreightChargeBold = wb.createCellStyle();
        fontFreightChargeBold = wb.createFont();
        dataFormatFreightChargeBold = wb.createDataFormat();   
        
    }
	
	/***************************************************************************
	 * Method : addStyle
	 * 
	 * Description : To add styles to the column, It is similar to styles in
	 * HTML.
	 * 
	 * @param :
	 *            cell - Cell to which the style has to be applied.
	 * @param :
	 *            workbook - WorkBook to which the style has to be applied.
	 * @param :
	 *            styleType - Is the style type that has to be applied to the
	 *            cell in the work book.
	 **************************************************************************/	
	public void addStyle(HSSFCell cell, HSSFWorkbook workbook,
			String styleType) {
		
		if(styleType.equals(FREIGHT_CHARGE_BOLD)) {
            setDataFormat(cellStyleFreightChargeBold);
            fontFreightChargeBold.setFontHeight((short) 150);
           // fontFreightChargeBold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            cellStyleFreightChargeBold.setLocked(false);
            cellStyleFreightChargeBold
                    .setDataFormat(dataFormatFreightChargeBold
                            .getFormat("#,##0.00_);(#,##0.00)"));
            cellStyleFreightChargeBold.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
            //cellStyleFreightChargeBold.setFont(fontFreightChargeBold);
            cellStyleFreightChargeBold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyleFreightChargeBold.setBorderRight(HSSFCellStyle.BORDER_THIN);
            
            cellStyleFreightChargeBold.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyleFreightChargeBold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            
            cellStyleFreightChargeBold.setWrapText(true);
            cell.setCellStyle(cellStyleFreightChargeBold);
        } else if(styleType.equals(RIGHT_ALIGN_WRAP_TEXT)) {
			setDataFormat(cellStyleRightAlign);
			cellStyleRightAlign.setLocked(false);
			cellStyleRightAlign.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			fontRightAlign.setFontHeight((short) 175);
			cellStyleRightAlign.setFont(fontRightAlign);
			cellStyleRightAlign.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyleRightAlign.setWrapText(true);
			cell.setCellStyle(cellStyleRightAlign);
		}
	}
	
    /***************************************************************************
     * Method Name : setDataFormat
     * 
     * Description : Sets the format for the given cell. 
     * 
     * @param      : HSSFCellStyle
     * 
     * @return     : None
     **************************************************************************/
	private void setDataFormat(HSSFCellStyle cellStyle) {
		cellStyle.setDataFormat((short) 0x27);
	}
}
