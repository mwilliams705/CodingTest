package dev.mwdesigns.tft.models;

import dev.mwdesigns.tft.util.CSVConverter;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ClassReport {

    
    private String className;
    private List<Student> studentList;

    public ClassReport(String path) {
        CSVConverter converter = new CSVConverter();
        this.className  = path.substring(19,25);;
        this.studentList = converter.convertCSVToStudentList(path);
    }

    public Double getClassAverage(){
        double sumOfGrades=0.0;
        List<Student> studentsWithGrade = new ArrayList<>();

        for (Student student: studentList){
            if (student.getGrade() != 0.0){
                studentsWithGrade.add(student);
            }
        }
        for (Student student:studentsWithGrade) {
            sumOfGrades = sumOfGrades + student.getGrade();
        }

        return sumOfGrades / studentsWithGrade.size();

    }

    public double studentCountWithValidGrade(){
        List<Student> studentsWithGrade = new ArrayList<>();
        for (Student student: studentList){
            if (student.getGrade() != 0.0){
                studentsWithGrade.add(student);
            }
        }
        return studentsWithGrade.size();
    }

    public List<Student> studentsWithoutGrade(){
        List<Student> studentsWithoutGrade = new ArrayList<>();
        for (Student student: studentList) {
            if (student.getGrade() == 0.0){
                studentsWithoutGrade.add(student);
            }
        }
        return studentsWithoutGrade;
    }


}
