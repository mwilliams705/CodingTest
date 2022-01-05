package dev.mwdesigns.tft.models;

import dev.mwdesigns.tft.util.CSVConverter;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ClassReport {

    
    private String className;
    private List<Student> studentList;

    /**
     * Custom constructor method which takes a String to the path of a file for CSV conversion.
     * 'className' is generated from a substring of the provided 'path' String.
     * 'studentList' is generated from the convertCSVToStudentList() method on the CSVConverter class.
     * @param path Path to file for use with CSVConverter class and setting className.
     */
    public ClassReport(String path) {
        CSVConverter converter = new CSVConverter();
        this.className  = path.substring(19,25);
        this.studentList = converter.convertCSVToStudentList(path);
    }

    /**
     * Using the Student List in the POJO, this method iterates through the list and adds
     * Students where Student.getGrade() does not equal zero to a new List.
     * Once the list is populated, all the grades in the new list are summed together.
     * The sum of grades is then divided by the count of Students in the populated List.
     *
     * @return Sum of Student Grades divided by Student count for list of Students where grade != 0.
     */
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

    /**
     *Using the Student List in the POJO, this method iterates through the list and adds
     * Students where Student.getGrade() does not equal zero to a new list to be returned by the method.
     * @return List of Students where grade != 0
     */
    public double studentCountWithValidGrade(){
        List<Student> studentsWithGrade = new ArrayList<>();
        for (Student student: studentList){
            if (student.getGrade() != 0.0){
                studentsWithGrade.add(student);
            }
        }
        return studentsWithGrade.size();
    }

    /**
     *Using the Student List in the POJO, this method iterates through the list and adds
     * Students where Student.getGrade() equals zero to a new list to be returned by the method.
     * @return List of Students where grade == 0
     */
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
