package dev.mwdesigns.tft.util;

import dev.mwdesigns.tft.models.ClassReport;
import dev.mwdesigns.tft.models.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OutputWriter {

    /**
     *For the supplied ClassReport object, this method will extract data from methods on the ClassReport object
     * to be applied to each part of the String builder.
     * The String.format() method is used to insert data into each part of the string and to create line breaks by
     * appending '%n' to each section of the StringBuilder.
     * StringBuilder was chosen for this method so that I could easily append any amount of Students returned by
     * classReport.studentsWithoutGrade()
     * @param classReport Single ClassReport object to be processed by the method
     * @return String built by StringBuilder class
     */
    public String individualClassReportBuilder(ClassReport classReport){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("--------------------- %s ---------------------%n", classReport.getClassName()));
        stringBuilder.append(String.format("Total Number of Students: %02d %n",classReport.getStudentList().size()));
//        Could not sort out String format for adding a 0 in the tens place on a Double value, so I resorted to using DecimalFormat as shown in link below.
//        Code from 'The DecimalFormat Class' found on docs.oracle.com:
//        https://docs.oracle.com/javase/tutorial/java/data/numberformat.html#:~:text=public%20class%20DecimalFormatDemo,123.78)%3B%0A%20%20%20%20%20%20customFormat(%22%24%23%23%23%2C%23%23%23.%23%23%23%22%2C%2012345.67)%3B%20%20%0A%20%20%20%7D%0A%7D
        stringBuilder.append(String.format("Number of Students for Calculating Class Average: %s %n", new DecimalFormat("00.00").format(classReport.studentCountWithValidGrade())));
        stringBuilder.append(String.format("Class Average: %.2f %n",classReport.getClassAverage()));
        stringBuilder.append(String.format("Students Missing Grades: %n"));
            for (Student s: classReport.studentsWithoutGrade()){
                stringBuilder.append(String.format("                   %s %n",s.getName()));
            }
        stringBuilder.append(String.format("================================================= %n"));
        return String.valueOf(stringBuilder);
    }

    /**
     *Given a supplied collection of ClassReport Objects, this method will sort the array using the
     * Java Collections API's Comparator functional interface, comparing and sorting based on the output
     * of getClassAverage() method on ChildReport.
     *
     * Once the collection is sorted, an enhanced for loop is used to apply the last object in the
     * collection (the ClassReport object with the highest average) to an individual object.
     *
     * The individual object is then used to plug in data to the formatted String which is returned.
     * @param allClasses Collection of ClassReport objects to be processed by the method.
     * @return String with data from ClassReport object with the highest grade average.
     */
    public String classWithHighestAverage(List<ClassReport> allClasses){
        ClassReport highestAverageClass = null;

        allClasses.sort(Comparator.comparing(ClassReport::getClassAverage));
        for(ClassReport c: allClasses){
            highestAverageClass = c;
        }


        return String.format("The highest average was in %s with an average of %.2f",highestAverageClass.getClassName(),highestAverageClass.getClassAverage());
    }

    /**
     *This method Takes the list of class reports and runs them through the methods above to build the final output
     * required by this project.
     * It starts by iterating through the supplied List of ClassReport objects to build
     * each individualClassReportBuilder() String and write the output to the 'report.txt' file.
     * After writing each report to the file, it takes the same List and does the classWithHighestAverage() method
     * to output the 'highest average' String at the end of the report as required
     * @param classReports Collection of ClassReport objects to be processed by the method.
     * @throws IOException In the event of an error using FileWriter, throws generic IOException
     */
    public void writeReportToFile(List<ClassReport> classReports) throws IOException {

        FileWriter fw = new FileWriter("src/main/resources/report.txt",false);
        PrintWriter pw = new PrintWriter(fw);
        for (ClassReport c: classReports){
            pw.println(individualClassReportBuilder(c));
        }
        pw.println(classWithHighestAverage(classReports));

//        Close the PrintWriter
        pw.close();

    }

}
