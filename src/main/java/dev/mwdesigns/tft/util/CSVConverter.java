package dev.mwdesigns.tft.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import dev.mwdesigns.tft.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {

    public List<Student> convertCSVToStudentList(String path){

        List<Student> output = new ArrayList<>();

            try {
                FileReader fileReader = new FileReader(path);
                CSVReader csvReader = new CSVReaderBuilder(fileReader).build();
                List<Student> students = new CsvToBeanBuilder<Student>(csvReader)
                        .withType(Student.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .withSkipLines(1)// Skip the header line
                        .build()
                        .parse();

                output.addAll(students);

            } catch (Exception e) {
                e.printStackTrace();
            }

        return output;
    }

}
