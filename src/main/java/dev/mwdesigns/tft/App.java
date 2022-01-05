package dev.mwdesigns.tft;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import dev.mwdesigns.tft.util.OutputWriter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, CsvException {
        OutputWriter outputWriter = new OutputWriter();

        String classA = "src/main/resources/ClassA.csv";
        String classB = "src/main/resources/ClassB.csv";
        String classC = "src/main/resources/ClassC.csv";

        outputWriter.writeReportToFile("Michael");

        CSVReader reader = new CSVReader(new FileReader(classA));
        reader.skip(1);
        List<String[]> strings = reader.readAll();
        for(String[] s : strings){
            System.out.println(Arrays.toString(s));
        }
        reader.close();



    }


}
