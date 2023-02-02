package dsalgo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.format.CellDateFormatter;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;

import io.netty.handler.codec.DateFormatter;

public class xlutility {
	public FileInputStream fi;
	public FileOutputStream fo;
	public HSSFWorkbook workbook;
	public HSSFSheet sheet;
	public HSSFRow row;
	public HSSFCell cell;
	//public CellStyle style;
	 String path=null;
	
	public xlutility(String path)
	{
		this.path=path;
	}
public int getRowCount(String sheetName)throws IOException
{
	fi=new FileInputStream(path);
	workbook=new HSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	int rowcount=sheet.getLastRowNum();
	workbook.close();
	fi.close();
	return rowcount;
}
public int getCellCount(String sheetName,int rownum)throws IOException
{
	fi=new FileInputStream(path);
	workbook=new HSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	int cellcount=row.getLastCellNum();
	workbook.close();
	return cellcount;
}
public String getCelldata(String sheetName,int rownum,int colnum)throws IOException
{
	fi=new FileInputStream(path);
	workbook=new HSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	//int cellcount=row.getLastCellNum();
	
	cell=row.getCell(colnum);
	DataFormatter formatter=new DataFormatter();
	String data;
	try {
		data=formatter.formatCellValue(cell);
	}
	catch(Exception e)
	{
		data="";
	}
	
	workbook.close();
	fi.close();
	return data;
}
public void setCelldata(String sheetName,int rownum,int colnum,String data)throws IOException
{
	fi=new FileInputStream(path);
	workbook=new HSSFWorkbook(fi);
	sheet=workbook.getSheet(sheetName);
	row=sheet.getRow(rownum);
	cell.setCellValue(data);
	fo=new FileOutputStream(path);
	workbook.write(fo);
	workbook.close();
	fi.close();
	fo.close();
	
}
}

