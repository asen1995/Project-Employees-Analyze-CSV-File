package org.example.file.reader;

import org.example.model.Project;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CSVProjectEmployeesFileReaderTest {

    @Test
    public void readAllProjectsSuccessfully() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        Map<Integer, Project> projectMap = csvProjectEmployeesFileReader.readProjects("employees-projects.csv");

        assertEquals(2, projectMap.size());

    }

    @Test(expected = IllegalArgumentException.class)
    public void readAllProjectsWhenFileDoesNotExist() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        csvProjectEmployeesFileReader.readProjects("notExistingFile.csv");

    }

    @Test(expected = IllegalArgumentException.class)
    public void readAllProjectsWhenFileIsEmpty() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        csvProjectEmployeesFileReader.readProjects("");

    }

    @Test(expected = IllegalArgumentException.class)
    public void readAllProjectsWhenFileIsNull() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        csvProjectEmployeesFileReader.readProjects(null);

    }

    @Test(expected = IllegalArgumentException.class)
    public void readAllProjectsWhenFileIsNotCSV() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        csvProjectEmployeesFileReader.readProjects("notCSVFile.txt");

    }

    @Test(expected = IllegalArgumentException.class)
    public void readCSVFileWithNoDataInIt() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        csvProjectEmployeesFileReader.readProjects("no-data-file.csv");

    }
}
