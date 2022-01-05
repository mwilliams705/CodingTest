package dev.mwdesigns.tft.util;

import dev.mwdesigns.tft.models.ClassReport;
import dev.mwdesigns.tft.models.Student;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.List;

public class OutputWriter {

    public String individualClassReportBuilder(ClassReport classReport){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("--------------------- %s ---------------------%n", classReport.getClassName()));
        stringBuilder.append(String.format("Total Number of Students: %02d %n",classReport.getStudentList().size()));
//        Could not sort out String format for adding a 0 in the tens place on a Double value so I resorted to using DecimalFormat as shown in link below:
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

//    TODO: This does not output correctly. Solve algorithm. to retireve ClassReport with Highest Average
    public String classWithHighestAverage(List<ClassReport> allClasses){
        ClassReport highestAverageClass = null;
        for (int i = 0;i<allClasses.size();i++
             ) {
            highestAverageClass = allClasses.get(i);
            if (allClasses.get(i).getClassAverage() > highestAverageClass.getClassAverage()){
                highestAverageClass = allClasses.get(i);
            }
        }
        return String.format("The highest average was in %s with an average of %.2f",highestAverageClass.getClassName(),highestAverageClass.getClassAverage());
    }

    public void writeReportToFile(List<ClassReport> classReports) throws IOException {

        FileWriter fw = new FileWriter("src/main/resources/report.txt",false);
        PrintWriter pw = new PrintWriter(fw);
        for (ClassReport c: classReports){
            pw.println(individualClassReportBuilder(c));
        }
        pw.println(classWithHighestAverage(classReports));

//
        pw.close();

    }

}
