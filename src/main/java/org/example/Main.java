package org.example;

import org.example.file.reader.CSVProjectEmployeesFileReader;
import org.example.file.reader.ProjectEmployeesFileReader;
import org.example.model.Company;
import org.example.model.MaxEmploymentPair;
import org.example.model.Project;

import java.util.Map;
import java.util.Optional;

public class Main {
    private static ProjectEmployeesFileReader projectEmployeesFileReader;

    public static void main(String[] args) {
        String csvFile = "employees-projects.csv";

        projectEmployeesFileReader = new CSVProjectEmployeesFileReader();

        Map<Integer, Project> projects = projectEmployeesFileReader.readProjects(csvFile);

        Company company = new Company(projects);

        Optional<MaxEmploymentPair> maxEmploymentPair = company.findMaximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject();

        if (maxEmploymentPair.isPresent()) {
            System.out.println(maxEmploymentPair.get());
        }else {
            System.out.println("No pair of employees worked together on a project");
        }

    }
}
