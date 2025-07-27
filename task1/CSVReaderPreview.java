package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVReaderPreview {

    public static void main(String[] args) {
        String filePath = "dataset/dataset.csv";
        String line;
        String separator = ",";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            String headerLine = bufferedReader.readLine();
            if (headerLine == null) {
                System.out.println("The CSV file is empty.");
                return;
            }

            System.out.println("=== CSV Data Preview ===\n");

            String[] headers = headerLine.split(separator);
            System.out.println("Column Headers:");
            for (String column : headers) {
                System.out.print(column + " ");
            }

            System.out.println("\nTotal Columns: " + headers.length);
            System.out.println("\nFirst 5 Data Rows:\n");

            int rowsDisplayed = 0;

            while ((line = bufferedReader.readLine()) != null && rowsDisplayed < 5) {
                String[] fields = line.split(separator);
                System.out.println(String.join(" ", fields));
                rowsDisplayed++;
            }

            while (bufferedReader.readLine() != null) {
                rowsDisplayed++;
            }

            System.out.println("\nTotal Data Records (excluding header): " + rowsDisplayed);

        } catch (IOException e) {
            System.err.println("Error occurred while reading the CSV file:");
            e.printStackTrace();
        }
    }
}
