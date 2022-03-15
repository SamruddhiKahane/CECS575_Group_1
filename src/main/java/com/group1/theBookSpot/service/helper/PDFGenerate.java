package com.group1.theBookSpot.service.helper;

import com.group1.theBookSpot.models.BookDetailsDTO;

import com.group1.theBookSpot.service.DocumentType;
import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PDFGenerate implements DocumentType {
    @Override
    public void produceDocument(List<BookDetailsDTO> list, HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        Paragraph paragraph = new Paragraph("List Of Books/Magazines/Journals", fontTiltle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(paragraph);
        PdfPTable table = new PdfPTable(7);
        table.setWidthPercentage(100f);
        table.setWidths(new int[] { 3, 3, 3 ,3,3,3,3});
        table.setSpacingBefore(5);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(CMYKColor.LIGHT_GRAY);
        cell.setPadding(5);
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        cell.setPhrase(new Phrase("Book ID", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("ISBN", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Title", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Author", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Publisher", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Year Published", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Category", font));
        table.addCell(cell);
        for (BookDetailsDTO bookDetailsDTO : list) {
            table.addCell(bookDetailsDTO.getBookId());
            table.addCell(bookDetailsDTO.getIsbn());
            table.addCell(bookDetailsDTO.getTitle());
            table.addCell(bookDetailsDTO.getAuthor());
            table.addCell(bookDetailsDTO.getPublisher());
            table.addCell(bookDetailsDTO.getYear().toString());
            table.addCell(bookDetailsDTO.getCategory());
        }
        document.add(table);
        document.close();
    }
}
