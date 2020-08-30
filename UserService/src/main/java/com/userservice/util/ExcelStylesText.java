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
 * File    : ExcelStylesText.java
 * 
 * Description : This class will process the actions that are related to 
 *               generating excel styles.
 ******************************************************************************/
public class ExcelStylesText {

	private static final String TABLE_HEADER = "TABLE_HEADER";
	private static final String CENTER_ALIGN_WITH_BOLD = "CENTER_ALIGN_WITH_BOLD";
	private static final String BOLDHEADING = "BOLD_JUSTIFY";
    private static final String LEFT_ALIGN_WRAP_TEXT ="LEFT_ALIGN_WRAP_TEXT";
	private static final String RIGHT_ALIGN_WRAP_TEXT ="RIGHT_ALIGN_WRAP_TEXT";
	private static final String CENTER_ALIGN_WRAP_TEXT ="CENTER_ALIGN_WRAP_TEXT";	
	private static final String ERROR_TEXT = "ERROR_TEXT";
    private static final String ERROR_TEXT_LEFT = "ERROR_TEXT_LEFT";
	private static final String LEFT_ALIGN_WRAP_BOLD_TEXT  = "LEFT_ALIGN_WRAP_BOLD_TEXT";
	private static final String TABLE_HEADER_LEFT = "TABLE_HEADER_LEFT";
	private static final String TABLE_HEADER_RIGHT = "TABLE_HEADER_RIGHT";
	private static final String LABEL = "LABEL";
    private static final String LABEL_LEFT = "LABEL_LEFT";
	private static final String LABEL_VALUE = "LABEL_VALUE";
	private static final String LEFT_BORDER = "LEFT_BORDER";
	private static final String BOTTOM_BORDER = "BOTTOM_BORDER";
    private static final String VERTICAL_CENTER_ALIGN_WITH_BOLD = "VERTICAL_CENTER_ALIGN_WITH_BOLD";
	
	
	HSSFCellStyle cellStyleLeftBorder = null;
	HSSFCellStyle cellStyleBottomBorder = null;
	
	HSSFFont fontTableHeader = null;    
	HSSFCellStyle cellStyleTableHeader = null;
	HSSFPalette paletteTableHeader = null;
    
    HSSFFont fontTableErrorMsg = null;
    HSSFCellStyle cellFontTableErrorMsg = null;
    HSSFPalette paletteFontTableErrorMsg = null;
		
	HSSFCellStyle cellStyleLeftAlign = null;
	HSSFFont fontLeftAlign = null;
	
	HSSFFont fontCenterAlign = null;
	HSSFCellStyle cellStyleCenterAlign = null;
	
	HSSFFont fontRightAlign = null;
	HSSFCellStyle cellStyleRightAlign = null;
    
    HSSFFont fontLeftAlignWrap = null;
    HSSFCellStyle cellStyleLeftAlignWrap = null;
	
	HSSFFont fontRightAlignMain = null;
	HSSFCellStyle cellStyleRightAlignMain = null;
	
	HSSFFont fontCenterAlignBold = null;
	HSSFCellStyle cellStyleCenterAlignBold = null;

	HSSFFont fontBoldHeading = null;
	HSSFCellStyle cellStyleBoldHeading = null;
	
	HSSFCellStyle cellStyleTableHeaderLeft = null;
	HSSFFont fontTableHeaderLeft = null;
	HSSFPalette paletteTableHeaderLeft = null;
	
	HSSFCellStyle cellStyleTableHeaderRight = null;
	HSSFFont fontTableHeaderRight = null;
	HSSFPalette paletteTableHeaderRight = null;
	
	HSSFCellStyle cellStyleLabel = null;
	HSSFFont fontLabel = null;
	
	HSSFCellStyle cellStyleLabelValue = null;
	HSSFFont fontLabelValue = null;
    
    HSSFCellStyle cellStyleLabelLeft = null;
    HSSFFont fontLabelLeft = null;
    
    HSSFDataFormat textData = null;
	
	public ExcelStylesText(HSSFWorkbook wb){
		fontTableHeader = wb.createFont();        
		cellStyleTableHeader = wb.createCellStyle();
		paletteTableHeader = wb.getCustomPalette();
		
		cellStyleLeftBorder = wb.createCellStyle();
		
		cellStyleBottomBorder = wb.createCellStyle();
		
        fontTableErrorMsg = wb.createFont();
        cellFontTableErrorMsg = wb.createCellStyle();
        paletteFontTableErrorMsg = wb.getCustomPalette();
		
		fontLeftAlign = wb.createFont();
		cellStyleLeftAlign = wb.createCellStyle();
        
        fontLeftAlignWrap = wb.createFont();
        cellStyleLeftAlignWrap = wb.createCellStyle();
        
		fontCenterAlign = wb.createFont();
		cellStyleCenterAlign = wb.createCellStyle();
		
		fontRightAlign = wb.createFont();
		cellStyleRightAlign = wb.createCellStyle();
		
		fontRightAlignMain = wb.createFont();
		cellStyleRightAlignMain = wb.createCellStyle();
		
		fontCenterAlignBold = wb.createFont();
		cellStyleCenterAlignBold = wb.createCellStyle();

		fontBoldHeading = wb.createFont();
		cellStyleBoldHeading = wb.createCellStyle();
		
		cellStyleTableHeaderLeft = wb.createCellStyle();
		fontTableHeaderLeft = wb.createFont();
		paletteTableHeaderLeft = wb.getCustomPalette();
		
		cellStyleTableHeaderRight = wb.createCellStyle();
		fontTableHeaderRight = wb.createFont();
		paletteTableHeaderRight = wb.getCustomPalette();
		
		cellStyleLabel = wb.createCellStyle();
		fontLabel = wb.createFont();
		
		cellStyleLabelValue = wb.createCellStyle();
		fontLabelValue = wb.createFont();
        
        cellStyleLabelLeft = wb.createCellStyle();
        fontLabelLeft = wb.createFont();
        
        textData =wb.createDataFormat();
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
		
		if(styleType.equals(TABLE_HEADER)) {
			setDataFormat(cellStyleTableHeader);
			fontTableHeader.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            paletteTableHeader.setColorAtIndex(HSSFColor.RED.index, (byte) 206,
                    (byte) 203, (byte) 206);
            cellStyleTableHeader.setLocked(false);
            cellStyleTableHeader.setFillForegroundColor(HSSFColor.RED.index);
			cellStyleTableHeader.setFillBackgroundColor(HSSFColor.RED.index);
			cellStyleTableHeader.setFillPattern(HSSFColor.RED.index);
			fontTableHeader.setFontHeight((short) 175);
			cellStyleTableHeader.setFont(fontTableHeader);
			cellStyleTableHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleTableHeader.setWrapText(true);
			cellStyleTableHeader
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleTableHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleTableHeader);
		} else if(styleType.equals(CENTER_ALIGN_WITH_BOLD)) {
			setDataFormat(cellStyleCenterAlignBold);
			cellStyleCenterAlignBold.setLocked(false);
			cellStyleCenterAlignBold.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			fontCenterAlignBold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			fontCenterAlignBold.setFontHeight((short) 175);
			cellStyleCenterAlignBold.setFont(fontCenterAlignBold);
			cellStyleCenterAlignBold.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlignBold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlignBold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleCenterAlignBold.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleCenterAlignBold);
		}else if(styleType.equals(VERTICAL_CENTER_ALIGN_WITH_BOLD)) {
            setDataFormat(cellStyleCenterAlignBold);
            cellStyleCenterAlignBold.setLocked(false);
            cellStyleCenterAlignBold.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
            cellStyleCenterAlignBold.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            fontCenterAlignBold.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            fontCenterAlignBold.setFontHeight((short) 175);
            cellStyleCenterAlignBold.setFont(fontCenterAlignBold);
            cellStyleCenterAlignBold.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyleCenterAlignBold.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyleCenterAlignBold.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyleCenterAlignBold.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cell.setCellStyle(cellStyleCenterAlignBold);
        } else if(styleType.equals(BOLDHEADING)) {
			setDataFormat(cellStyleBoldHeading);
			fontBoldHeading.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyleBoldHeading.setLocked(false);
			cellStyleBoldHeading.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleBoldHeading.setVerticalAlignment(
				HSSFCellStyle.VERTICAL_CENTER);
			cellStyleBoldHeading.setWrapText(false);
			cellStyleBoldHeading.setFont(fontBoldHeading);
			cell.setCellStyle(cellStyleBoldHeading);
		} else if(styleType.equals(CENTER_ALIGN_WRAP_TEXT)) {
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
		}else if(styleType.equals(ERROR_TEXT)) {			
			setDataFormat(cellStyleTableHeader);
			paletteTableHeader.setColorAtIndex(HSSFColor.RED.index, (byte) 221,
                    (byte) 213, (byte) 143);	
			cellStyleTableHeader.setLocked(false);
			cellStyleTableHeader.setFillForegroundColor(HSSFColor.RED.index);
			cellStyleTableHeader.setFillBackgroundColor(HSSFColor.RED.index);
			cellStyleTableHeader.setFillPattern(HSSFColor.RED.index);
			fontTableHeader.setFontHeight((short) 175);
			cellStyleTableHeader.setFont(fontTableHeader);
			cellStyleTableHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);
			cellStyleTableHeader.setWrapText(true);
			cellStyleTableHeader
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleTableHeader.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeader.setWrapText(true);
			cell.setCellStyle(cellStyleTableHeader);
		} else if (styleType.equals(ERROR_TEXT_LEFT)) {
			setDataFormat(cellFontTableErrorMsg);
			paletteFontTableErrorMsg.setColorAtIndex(HSSFColor.RED.index,
					(byte) 188, (byte) 212, (byte) 246);
			cellFontTableErrorMsg.setLocked(false);
			cellFontTableErrorMsg.setFillForegroundColor(HSSFColor.RED.index);
			cellFontTableErrorMsg.setFillBackgroundColor(HSSFColor.RED.index);
			cellFontTableErrorMsg.setFillPattern(HSSFColor.RED.index);
			fontTableErrorMsg.setFontHeight((short) 160);
			cellFontTableErrorMsg.setFont(fontTableErrorMsg);
			cellFontTableErrorMsg.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellFontTableErrorMsg.setWrapText(true);
			cellFontTableErrorMsg
					.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellFontTableErrorMsg.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellFontTableErrorMsg.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellFontTableErrorMsg.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellFontTableErrorMsg.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellFontTableErrorMsg.setWrapText(true);
			cell.setCellStyle(cellFontTableErrorMsg);
		} else if(styleType.equals(LEFT_ALIGN_WRAP_BOLD_TEXT)) {
			setDataFormat(cellStyleLeftAlign);
			fontLeftAlign.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			fontLeftAlign.setFontHeight((short) 175);
			cellStyleLeftAlign.setLocked(false);
			cellStyleLeftAlign.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyleLeftAlign.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleLeftAlign.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleLeftAlign.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleLeftAlign.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cellStyleLeftAlign.setWrapText(true);
			cellStyleLeftAlign.setFont(fontLeftAlign);
			cell.setCellStyle(cellStyleLeftAlign);
		} else if(styleType.equals(LEFT_ALIGN_WRAP_TEXT)) {
            setDataFormat(cellStyleLeftAlignWrap);
            
            fontLeftAlignWrap.setFontHeight((short) 175);
            cellStyleLeftAlignWrap.setLocked(false);
            cellStyleLeftAlignWrap.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            cellStyleLeftAlignWrap.setBorderTop(HSSFCellStyle.BORDER_THIN);
            cellStyleLeftAlignWrap.setBorderBottom(HSSFCellStyle.BORDER_THIN);
            cellStyleLeftAlignWrap.setBorderLeft(HSSFCellStyle.BORDER_THIN);
            cellStyleLeftAlignWrap.setBorderRight(HSSFCellStyle.BORDER_THIN);
            cellStyleLeftAlignWrap.setWrapText(true);
            cellStyleLeftAlignWrap.setDataFormat(textData.getFormat("General"));
            cellStyleLeftAlignWrap.setFont(fontLeftAlignWrap);
            cell.setCellStyle(cellStyleLeftAlignWrap);
        } else if(styleType.equals(TABLE_HEADER_LEFT)) {
			setDataFormat(cellStyleTableHeaderLeft);
			paletteTableHeaderLeft.setColorAtIndex(HSSFColor.RED.index, (byte) 221,
                    (byte) 213, (byte) 143);
			cellStyleTableHeaderLeft.setLocked(false);
			cellStyleTableHeaderLeft.setFillForegroundColor(HSSFColor.RED.index);
			cellStyleTableHeaderLeft.setFillBackgroundColor(HSSFColor.RED.index);
			cellStyleTableHeaderLeft.setFillPattern(HSSFColor.RED.index);
			fontTableHeaderLeft.setFontHeight((short) 175);
			fontTableHeaderLeft.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyleTableHeaderLeft.setFont(fontTableHeaderLeft);
			cellStyleTableHeaderLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			cellStyleTableHeaderLeft.setWrapText(true);
			cellStyleTableHeaderLeft.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleTableHeaderLeft.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderLeft.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderLeft.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderLeft.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleTableHeaderLeft);
		} else if(styleType.equals(TABLE_HEADER_RIGHT)) {
			setDataFormat(cellStyleTableHeaderRight);
			paletteTableHeaderRight.setColorAtIndex(HSSFColor.RED.index, (byte) 221,
                    (byte) 213, (byte) 143);
			cellStyleTableHeaderRight.setLocked(false);
			cellStyleTableHeaderRight.setFillForegroundColor(HSSFColor.RED.index);
			cellStyleTableHeaderRight.setFillBackgroundColor(HSSFColor.RED.index);
			cellStyleTableHeaderRight.setFillPattern(HSSFColor.RED.index);
			fontTableHeaderRight.setFontHeight((short) 175);
			fontTableHeaderRight.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			cellStyleTableHeaderRight.setFont(fontTableHeaderRight);
			cellStyleTableHeaderRight.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cellStyleTableHeaderRight.setWrapText(true);
			cellStyleTableHeaderRight.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
			cellStyleTableHeaderRight.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderRight.setBorderTop(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderRight.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cellStyleTableHeaderRight.setBorderRight(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleTableHeaderRight);
		} else if(styleType.equals(LABEL)) {
			setDataFormat(cellStyleLabel);
			fontLabel.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			fontLabel.setFontHeight((short) 175);
			cellStyleLabel.setLocked(false);
			cellStyleLabel.setFont(fontLabel);
			cellStyleLabel.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
			cell.setCellStyle(cellStyleLabel);
		} else if(styleType.equals(LABEL_LEFT)) {
            setDataFormat(cellStyleLabelLeft);
            fontLabelLeft.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            fontLabelLeft.setFontHeight((short) 175);
            cellStyleLabelLeft.setLocked(false);
            cellStyleLabelLeft.setFont(fontLabelLeft);
            cellStyleLabelLeft.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            cell.setCellStyle(cellStyleLabelLeft);
        } else if(styleType.equals(LABEL_VALUE)) {
			setDataFormat(cellStyleLabelValue);
			cellStyleLabelValue.setLocked(false);
			cellStyleLabelValue.setAlignment(HSSFCellStyle.ALIGN_LEFT);
            cellStyleLabelValue.setLocked(false);
			fontLabelValue.setFontHeight((short) 170);
			cellStyleLabelValue.setFont(fontLabelValue);
			cellStyleLabelValue.setWrapText(true);
			cell.setCellStyle(cellStyleLabelValue);
		}  else if(styleType.equals(LEFT_BORDER)) {
			setDataFormat(cellStyleLeftBorder);
			cellStyleLeftBorder.setLocked(false);
			cellStyleLeftBorder.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleLeftBorder);
		} else if(styleType.equals(BOTTOM_BORDER)) {
			setDataFormat(cellStyleBottomBorder);
			cellStyleBottomBorder.setLocked(false);
			cellStyleBottomBorder.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			cell.setCellStyle(cellStyleBottomBorder);
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
		cellStyle.setDataFormat((short) 0x31);
	}
}
