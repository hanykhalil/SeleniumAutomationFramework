package com.tmb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.tmb.Constants.FrameworkConstants;
import com.tmb.exceptions.FrameworkExceptions;
import com.tmb.exceptions.InvalidPathForExcel;

public final class ExcelUtil {

	private ExcelUtil() {

	}

	public static List<Map<String, String>> getDataFromExcel(String sheetName) {
		List<Map<String, String>> list = null;

		try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath())) {

			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet(sheetName);
			Map<String, String> map = null;
			int rowNumb = sheet.getLastRowNum();
			int colNumb = sheet.getRow(0).getLastCellNum();
			list = new ArrayList<>();
			for (int i = 1; i <= rowNumb; i++) {
				map = new HashMap<>();
				for (int j = 0; j < colNumb; j++) {

					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}

		} catch (FileNotFoundException e) {

			throw new InvalidPathForExcel("Excel File you are trying to read is not found");
		} catch (IOException e) {

			throw new FrameworkExceptions("Some IO exception happened while reading excel");
		}

		return list;

	}

}
