package org.example.file.reader;

import org.example.model.EmploymentPeriod;
import org.example.model.Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CSVProjectEmployeesFileReader implements ProjectEmployeesFileReader {

    public static final String FILE_NAME_IS_NULL_OR_EMPTY = "File name is null or empty: %s";
    public static final String FILE_IS_NOT_CSV_TYPE = "File is not CSV type : %s";
    public static final String FILE_DONT_HAVE_ANY_DATA = "File don't have any data";
    public static final String DATE_TO_NULL_VALUE = "NULL";

    @Override
    public Map<Integer, Project> readProjects(String file) {

        if (isNullOrEmpty(file)) {
            throw new IllegalArgumentException(String.format(FILE_NAME_IS_NULL_OR_EMPTY, file));
        }

        if (isNotCSVFile(file)) {
            throw new IllegalArgumentException(String.format(FILE_IS_NOT_CSV_TYPE, file));
        }


        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Map<Integer, Project> projectMap = new HashMap<>();

        boolean skipHeader = true;
        int lineNumber = 1;

        try (BufferedReader br = new BufferedReader(new InputStreamReader( CSVProjectEmployeesFileReader.class.getClassLoader().getResourceAsStream(file)))) {
            String line;
            while ((line = br.readLine()) != null) {

                if (skipHeader) {
                    skipHeader = false;
                    continue;
                }

                String[] data = line.split(",");
                Integer employeeId = Integer.parseInt(data[0].trim());
                Integer projectID = Integer.parseInt(data[1].trim());
                Date dateFrom = dateFormat.parse(data[2].trim());
                Date dateTo = data[3].trim().equalsIgnoreCase(DATE_TO_NULL_VALUE) ? new Date() : dateFormat.parse(data[3].trim());


                Project existingProject = projectMap.get(projectID);
                if (existingProject != null) {
                    existingProject.addEmploymentPeriod(employeeId, new EmploymentPeriod(dateFrom, dateTo));
                } else {
                    Project newProject = new Project(projectID);
                    newProject.addEmploymentPeriod(employeeId, new EmploymentPeriod(dateFrom, dateTo));
                    projectMap.put(projectID, newProject);
                }

                lineNumber++;
            }
        } catch (IOException e) {
            throw new RuntimeException(String.format("IO exception occurred : %s ", e.getMessage()));
        } catch (ParseException e) {
            throw new IllegalArgumentException(String.format("Parse exception for file occurred at line number: %d  with message ", lineNumber, e.getMessage()));
        }


        if(projectMap.isEmpty()){
            throw new IllegalArgumentException(FILE_DONT_HAVE_ANY_DATA);
        }

        return projectMap;
    }

    private static boolean isNullOrEmpty(String file) {
        return file == null || file.isEmpty();
    }

    private boolean isNotCSVFile(String file) {
        return !file.endsWith(".csv");
    }

}
