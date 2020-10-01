import database.Slip;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class MusicInfoExporter {
    private final String dirPath = PropertiesManager.getProperty("dirPath");

    public void exportToFile(List<Slip> allAdvice) {
        try {
            PrintWriter zapis = new PrintWriter(dirPath + "musicLibrary.txt");
            for (Slip slips : allAdvice) {
                zapis.println("| slipId = " + slips.getSlipId() + " | id = " + slips.getId() + " | album = " + slips.getAlbum());
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file was found!");
        }
    }

    //eksport naszych porad do eksela
    public void exportToSheet(List<Slip> allAlbum) {
        Workbook workbook = new XSSFWorkbook(); //utworzenie workbooka (xlsx)

        Sheet sheet = workbook.createSheet("My favourite albums"); //utworzenie arkuszu

        //naglowki tabeli
        String[] columns = {"slipId", "id", "album"};
        createHeaderRow(columns, sheet);

        //wypelnienie danymi
        createDataRows(sheet, allAlbum);

        //resize column tak żeby pasowały do zawartosci
        for (int i = 0; i < columns.length; i++) {
            sheet.autoSizeColumn(i);
        }

        //zapis do pliku
        saveWorkbookToFile(workbook);
    }

    private void createHeaderRow(String[] columns, Sheet sheet) {
        Row headerRow = sheet.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
    }

    private void createDataRows(Sheet sheet, List<Slip> slips) {
        int rowNumber = 1;

        for (Slip slip : slips) {
            Row row = sheet.createRow(rowNumber++);
            row.createCell(0).setCellValue(slip.getSlipId());
            row.createCell(1).setCellValue(slip.getId());
            row.createCell(2).setCellValue(slip.getAlbum());
        }
    }

    private void saveWorkbookToFile(Workbook workbook) {
        //zapis do pliku!
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(dirPath + "musicLibrary.xlsx");
            workbook.write(fileOutputStream);

            fileOutputStream.close();
            workbook.close();
        } catch (IOException e) {
            System.out.println("We couldn't export the albums!");
        }
    }
}
