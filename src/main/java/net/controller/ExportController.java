package net.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import net.entities.Work;
import net.service.WorkService;

@Controller
public class ExportController {
	@Autowired
	private WorkService workService;

	@RequestMapping(value = { "/export" })
	public String exportListWork(HttpServletResponse response, Model model) {
		
		List<Work> list = workService.findAll();
		
		//Create file
		XSSFWorkbook workbook = new XSSFWorkbook();

		
		//Set header
		response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=WorkList_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
		
        XSSFSheet sheet = workbook.createSheet("ListWork");
		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		Cell firstCell = firstRow.createCell(0);
		firstCell.setCellValue("List of Work");
		
		Row secondRow = sheet.createRow(rowNum++);
		//Set header
		Cell secondCell1 = secondRow.createCell(0);
		secondCell1.setCellValue("Work ID");
		
		Cell secondCell2 = secondRow.createCell(1);
		secondCell2.setCellValue("Work Name");
		
		Cell secondCell3 = secondRow.createCell(2);
		secondCell3.setCellValue("Work Start");
		
		Cell secondCell4 = secondRow.createCell(3);
		secondCell4.setCellValue("Work End");
		
		Cell secondCel5 = secondRow.createCell(4);
		secondCel5.setCellValue("Work Percent");
		
		Cell secondCel6 = secondRow.createCell(5);
		secondCel6.setCellValue("Work Status");
		
		for (Work work : list) {
			
			CellStyle style = workbook.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
			Row row = sheet.createRow(rowNum++);
			
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(work.getWork_id());
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(work.getWork_name());
			Cell cell3 = row.createCell(2);
			cell3.setCellValue(work.getWork_start());
			Cell cell4 = row.createCell(3);
			cell4.setCellValue(work.getWork_end());
			Cell cell5 = row.createCell(4);
			cell5.setCellValue(work.getWork_percent());
			Cell cell6 = row.createCell(5);
			cell6.setCellValue(work.getWork_status());
			
			if (work.getWork_status().compareToIgnoreCase("Done") == 0) {
				cell1.setCellStyle(style);
				cell2.setCellStyle(style);
				cell3.setCellStyle(style);
				cell4.setCellStyle(style);
				cell5.setCellStyle(style);
				cell6.setCellStyle(style);
			}
		}
		try {
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		System.out.println("Done");
		
		model.addAttribute("listWork", list);

		return "workList";
	}
	
	
}
