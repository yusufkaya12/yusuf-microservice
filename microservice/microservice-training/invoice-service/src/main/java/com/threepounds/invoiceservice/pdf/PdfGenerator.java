package com.threepounds.invoiceservice.pdf;

import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.threepounds.baseservice.shared.sharedorder.OrderResource;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class PdfGenerator {


    public static void generate(HttpServletResponse response, OrderResource orderResource) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);

        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();

        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);

        Paragraph paragraph = new Paragraph("Invoice Of Orders", fontTitle);


        paragraph.setAlignment(Paragraph.ALIGN_CENTER);


        document.add(paragraph);

        // Creating a table of 3 columns
        PdfPTable table = new PdfPTable(7);

        // Setting width of table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[]{5, 3, 5, 3, 3, 3, 3});
        table.setSpacingBefore(5);


        // Create Table Cells for table header
        PdfPCell cell = new PdfPCell();

        // Setting the background color and padding
        cell.setBackgroundColor(CMYKColor.MAGENTA);
        cell.setPadding(5);

        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.BLACK);

        // Adding headings in the created table cell/ header
        // Adding Cell to table
        cell.setPhrase(new Phrase("Name", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Restaurant", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Order Date", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Foods", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Restaurant Note", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Payment Type", font));
        table.addCell(cell);
        String joiningFood = orderResource.getFoodName().stream().collect(Collectors.joining(", "));
        table.addCell(orderResource.getName());
        table.addCell(orderResource.getRestaurantName());
        table.addCell(orderResource.getDate());
        table.addCell(joiningFood);
        table.addCell(orderResource.getNote());
        table.addCell(orderResource.getPrice());
        table.addCell(orderResource.getPaymentType());

        // Adding the created table to document
        document.add(table);

        // Closing the document
        document.close();

    }
}

