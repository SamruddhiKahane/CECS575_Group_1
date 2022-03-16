package com.group1.theBookSpot.service.helper;

import com.group1.theBookSpot.models.BookDetailsDTO;
import com.group1.theBookSpot.service.DocumentType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;


public class ExcelGenerate implements DocumentType {

    private XSSFWorkbook workbook = new XSSFWorkbook();
    private XSSFSheet sheet;
    @Override
    public void produceDocument(List<BookDetailsDTO> list, HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines(list);
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Book List");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Book ID", style);
        createCell(row, 1, "ISBN", style);
        createCell(row, 2, "Title", style);
        createCell(row, 3, "Author", style);
        createCell(row, 4, "Publisher", style);
        createCell(row, 5, "Year Published", style);
        createCell(row, 6, "Category", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }
        else if(value instanceof Date){
            cell.setCellValue((Date)value);
        }
        else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines(List<BookDetailsDTO> list) {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (BookDetailsDTO bookDetailsDTO : list) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, bookDetailsDTO.getBookId(), style);
            createCell(row, columnCount++, bookDetailsDTO.getIsbn(), style);
            createCell(row, columnCount++, bookDetailsDTO.getTitle(), style);
            createCell(row, columnCount++, bookDetailsDTO.getAuthor(), style);
            createCell(row, columnCount++, bookDetailsDTO.getPublisher(), style);
            createCell(row, columnCount++, bookDetailsDTO.getYear(), style);
            createCell(row, columnCount++, bookDetailsDTO.getCategory(), style);

        }
    }
}
