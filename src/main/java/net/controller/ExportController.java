package net.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

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
	public String exportListWork(Model model) {
		List<Work> list = workService.findAll();

		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("ListWork");

		int rowNum = 0;
		Row firstRow = sheet.createRow(rowNum++);
		Cell firstCell = firstRow.createCell(0);
		firstCell.setCellValue("List of Work");
		for (Work work : list) {
			CellStyle style = workbook.createCellStyle();
//	        style.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
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
			cell6.setCellValue(work.getWork_percent());
			
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
			FileOutputStream outputStream = new FileOutputStream(
					"D:/eclipse_workspace/Net_Manager/src/main/webapp/resources/static/files/ListWork.xlsx");
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		
		model.addAttribute("listWork", list);

		return "workList";
	}
}
