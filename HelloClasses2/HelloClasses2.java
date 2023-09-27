package HelloClasses2;
import java.io.*;
import java.util.*;
public class HelloClasses2 {


    static class CSVFile { // just an object CSVFile, with headers and rows, headers are a list of string, so basicly line 1, 2 etc ?
        private final List<String> headers;
        private final List<List<String>> rows;

        public CSVFile(List<String> headers, List<List<String>> rows) {
            this.headers = headers;
            this.rows = rows;
        }

        public List<String> getHeaders() {
            return headers;
        }

        public List<List<String>> getRows() {
            return rows;
        }
    }

    class ReportGenerator {
        public static Map<String, Integer> generateDailyReport(CSVFile csvFile, int day, int month, int year) {
            List<String> headers = csvFile.getHeaders();
            List<List<String>> rows = csvFile.getRows();
            Map<String, Integer> dailyReport = new HashMap<>();

            for (List<String> row : rows) {
                String date = row.get(0);
                String[] dateParts = date.split("-");
                int rowDay = Integer.parseInt(dateParts[0]);
                int rowMonth = Integer.parseInt(dateParts[1]);
                int rowYear = Integer.parseInt(dateParts[2]);

                if (rowDay == day && rowMonth == month && rowYear == year) {
                    for (int i = 1; i < headers.size(); i++) {
                        String department = headers.get(i);
                        int count = Integer.parseInt(row.get(i));
                        dailyReport.put(department, dailyReport.getOrDefault(department, 0) + count);
                    }
                }
            }

            return dailyReport;
        }

        public static Map<String, Integer> generateMonthlyReport(CSVFile csvFile, int month, int year) {
            List<String> headers = csvFile.getHeaders();
            List<List<String>> rows = csvFile.getRows();
            Map<String, Integer> monthlyReport = new HashMap<>();

            for (List<String> row : rows) {
                String date = row.get(0);
                String[] dateParts = date.split("-");
                int rowMonth = Integer.parseInt(dateParts[1]);
                int rowYear = Integer.parseInt(dateParts[2]);

                if (rowMonth == month && rowYear == year) {
                    for (int i = 1; i < headers.size(); i++) {
                        String department = headers.get(i);
                        int count = Integer.parseInt(row.get(i));
                        monthlyReport.put(department, monthlyReport.getOrDefault(department, 0) + count);
                    }
                }
            }

            return monthlyReport;
        }
    }

    static class CustomFileWriter {
        public static void writeReportToFile(Map<String, Integer> report, String fileName) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                for (Map.Entry<String, Integer> entry : report.entrySet()) {
                    writer.println(entry.getKey() + ": " + entry.getValue());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        public static void main(String[] args) {
            // Read the CSV file and create an instance of CSVFile
            List<String> headers = Arrays.asList("Date", "Cardiology", "Radiology", "VisitingPatients");
            List<List<String>> rows = new ArrayList<>();
            rows.add(Arrays.asList("27-07-2021", "40", "98", "1120"));
            rows.add(Arrays.asList("28-07-2021", "50", "75", "1050"));
            CSVFile csvFile = new CSVFile(headers, rows);

            // Generate daily and monthly reports using the ReportGenerator
            Map<String, Integer> dailyReport = ReportGenerator.generateDailyReport(csvFile, 27, 7, 2021);
            Map<String, Integer> monthlyReport = ReportGenerator.generateMonthlyReport(csvFile, 7, 2021);

            // Write the reports to files using the FileWriter
            CustomFileWriter.writeReportToFile(dailyReport, "daily_report.txt");
            CustomFileWriter.writeReportToFile(monthlyReport, "monthly_report.txt");
        }


}
