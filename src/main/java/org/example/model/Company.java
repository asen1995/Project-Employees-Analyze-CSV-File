package org.example.model;

import java.util.Map;
import java.util.Optional;

public class Company {
    private final Map<Integer, Project> projects;
    public Company(Map<Integer, Project> projects) {
        this.projects = projects;
    }

    public Optional<MaxEmploymentPair> findMaximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject() {
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
        return Optional.of(maxEmploymentPair);
    }
}
