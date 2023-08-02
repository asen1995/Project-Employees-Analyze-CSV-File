package org.example;

import org.example.file.reader.CSVProjectEmployeesFileReader;
import org.example.file.reader.ProjectEmployeesFileReader;
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

        MaxEmploymentPair maxEmploymentPair = null;
        
        for(Integer projectId : projects.keySet()){
            final Project project = projects.get(projectId);

            if(project.atLeastTwoPeopleWorkedOnThisProject()) {
                final Optional<MaxEmploymentPair> maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject = project.findMaximumEmploymentPeriodBetweenTwoEmployeesOnThisProject();
                if(maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject.isPresent()){
                    maxEmploymentPair = maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject.get();
                }
            }
        }


        System.out.println(maxEmploymentPair);
    }


}
