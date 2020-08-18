package org.example.csvproject.main;

import org.example.csvproject.util.CsvMapper;
import org.example.csvproject.util.CsvTable;
import org.example.csvproject.util.ObjectData;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, IllegalAccessException {

        CsvMapper mapper = new CsvMapper();
        Path path = Paths.get(Main.class.getClassLoader().getResource("table.csv").toURI());
        CsvTable table = CsvTable.fromFile(path).orElseThrow();

        List<ObjectData> listOfObjects = mapper.makeObjectsList(table, ObjectData.class);
        System.out.println(listOfObjects);
    }
}
