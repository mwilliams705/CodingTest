package dev.mwdesigns.tft.models;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @CsvBindByName(column = "Student Name")
    String name;
    @CsvBindByName(column = "Grade")
    Double grade;

}
