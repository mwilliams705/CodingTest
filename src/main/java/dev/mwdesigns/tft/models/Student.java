package dev.mwdesigns.tft.models;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Student {

    @CsvBindByName(column = "Student Name")
    String name;
    @CsvBindByName(column = "Grade")
    Double grade;

//    Lombok used for code cleanliness.
//    Replaces code for Getter, Setter, Common constructors, ToString, and Builder Pattern
}
