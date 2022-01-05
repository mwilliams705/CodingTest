package dev.mwdesigns.tft;


import dev.mwdesigns.tft.models.ClassReport;
import dev.mwdesigns.tft.util.OutputWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {

        OutputWriter outputWriter = new OutputWriter();

//        Create a List of ClassReport objects and supply the CSV file path so the Student object lists can be populated.
        List<ClassReport> allClassReports = new ArrayList<>();
        allClassReports.add(new ClassReport("src/main/resources/ClassA.csv"));
        allClassReports.add(new ClassReport("src/main/resources/ClassB.csv"));
        allClassReports.add(new ClassReport("src/main/resources/ClassC.csv"));

        outputWriter.writeReportToFile(allClassReports);

    }


}
