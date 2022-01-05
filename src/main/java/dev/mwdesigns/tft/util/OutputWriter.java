package dev.mwdesigns.tft.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class OutputWriter {

    public void writeReportToFile(String className) throws IOException {

        FileWriter fw = new FileWriter("src/main/resources/report.txt",false);
        PrintWriter pw = new PrintWriter(fw);
        pw.println(String.format("--------------------- %s ---------------------",className));
        pw.println(String.format("Total Number of Students: %s",className));
        pw.println(String.format("Number of Students for Calculating Class Average: %s",className));
        pw.println(String.format("Class Average: %s",className));
        pw.println("Students Missing Grades:");

//        TODO: add iteration to include names of students missing grades (0)
        pw.println(String.format("                   %s",className));

        pw.println("=================================================");
        pw.println(String.format("The highest average was in %s with an average of %s",className,className));
        System.out.printf("--------------------- %s ---------------------%n",className);
        pw.close();

    }

}
