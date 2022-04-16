package com.example.demo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

public class DataService {

    public ArrayList<String> fetchData() throws IOException{

        //By giving the path to the file (Local File)
        Reader in = new FileReader("C:/Users/himas/OneDrive/Documents/Web Service/water_quality.csv");
        
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withSkipHeaderRecord().parse(in);

        ArrayList<String> list = new ArrayList<>();

        for (CSVRecord record : records) {
            String hardness = record.get("Hardness");
            list.add(hardness);
        }

        System.out.println("Out of Time :D");
        return list;
    }

    public void writeData(){
        try {
            Writer writer = new FileWriter("C:/Users/himas/OneDrive/Documents/Book.csv");

            CSVPrinter printer = CSVFormat.DEFAULT.withHeader("id", "name").print(writer);

            printer.printRecord(1, "John Mike");
            printer.printRecord(2, "Jovan Krovoski");
         
          

            // flush the stream
            printer.flush();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 

}
