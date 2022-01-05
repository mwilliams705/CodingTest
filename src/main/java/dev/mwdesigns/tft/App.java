package dev.mwdesigns.tft;


import com.opencsv.exceptions.CsvException;
import dev.mwdesigns.tft.models.ClassReport;
import dev.mwdesigns.tft.models.Student;
import dev.mwdesigns.tft.util.CSVConverter;
import dev.mwdesigns.tft.util.OutputWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, CsvException {

        OutputWriter outputWriter = new OutputWriter();

        String classA ="src/main/resources/ClassA.csv";
        String classB ="src/main/resources/ClassB.csv";
        String classC ="src/main/resources/ClassC.csv";

        ClassReport classReportA = new ClassReport(classA);
        ClassReport classReportB = new ClassReport(classB);
        ClassReport classReportC = new ClassReport(classC);
        List<ClassReport> allClassReports = new ArrayList<>();
        allClassReports.add(classReportA);
        allClassReports.add(classReportB);
        allClassReports.add(classReportC);

        outputWriter.writeReportToFile(allClassReports);

//        for (ClassReport c: classReportList) {
//
//        }
    }


}
