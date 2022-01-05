package dev.mwdesigns.tft.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import dev.mwdesigns.tft.models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVConverter {

    /**
     * Using the provided 'path' String, FileReader, loads the file and passes it to the CSVReader class provided by
     * the OpenCSV library.
     * CSVToBeanBuilder binds the CSV output to the Student POJO using the '@CSVBindByName' annotation
     * provided by OpenCSV.
     * Once the list of Students in created, it is passed to a list outside the try/catch and returned by the method.
     * @param path Path to CSV file.
     * @return List of Student Objects created from the parsed CSV file.
     */
    public List<Student> convertCSVToStudentList(String path){

        List<Student> output = new ArrayList<>();

//        Used the OpenCSV 'Quick Start' section to get an idea of the basic implementation which shows an example using
//        the CSVToBeanBuilder class to pass a Generic object through the builder and apply the CSV values to fields in
//        the Generic object. I replaced the 'MyBean' reference and 'Visitors.class' with my Student class.
//        Code from 'Opencsv Users Guide' on Sourceforge:
//        http://opencsv.sourceforge.net/#:~:text=List%3CMyBean%3E%20beans%20%3D%20new%20CsvToBeanBuilder(FileReader(%22yourfile.csv%22))%0A%20%20%20%20%20%20%20.withType(Visitors.class).build().parse()%3B
            try {
                CSVReader csvReader = new CSVReaderBuilder(new FileReader(path)).build();
                List<Student> students = new CsvToBeanBuilder<Student>(csvReader)
                        .withType(Student.class)
                        .build()
                        .parse();
                output.addAll(students);

            } catch (Exception e) {
                e.printStackTrace();
            }

        return output;
    }

}
