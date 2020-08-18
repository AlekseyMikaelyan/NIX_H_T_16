package org.example.csvproject;

import org.example.csvproject.util.CsvMapper;
import org.example.csvproject.util.CsvTable;
import org.example.csvproject.util.ObjectData;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CsvMapperTest {

    private static List<ObjectData> objectsList;

    @BeforeClass
    public static void methodShouldMakeListOfObjects() throws Exception {
        CsvMapper mapper = new CsvMapper();
        Path path = Paths.get(CsvMapperTest.class.getClassLoader().getResource("table.csv").toURI());
        CsvTable table = CsvTable.fromFile(path).orElseThrow();
        objectsList = mapper.makeObjectsList(table, ObjectData.class);

    }
    @Test
    public void methodShouldReturnCorrectSizeOfList() {
        Assert.assertEquals(2, objectsList.size());
    }

    @Test
    public void methodShouldReturnCorrectName() {
        Assert.assertEquals("Beth", objectsList.get(1).getName());
    }

    @Test
    public void methodShouldReturnCorrectAge() {
        Assert.assertEquals(27, objectsList.get(0).getAge());
    }

    @Test
    public void methodShouldReturnTrueGender() {
        Assert.assertEquals(ObjectData.Gender.FEMALE, objectsList.get(1).getGender());
    }

    @Test
    public void methodShouldReturnCorrectOccupation() {
        Assert.assertEquals("janitor", objectsList.get(0).getOccupation());
    }

}
