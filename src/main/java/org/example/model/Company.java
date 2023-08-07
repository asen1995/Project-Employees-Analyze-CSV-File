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

        for (Integer projectId : projects.keySet()) {

            final Project project = projects.get(projectId);

            if (project.atLeastTwoPeopleWorkedOnThisProject()) {

                final Optional<MaxEmploymentPair> maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject = project.findMaximumEmploymentPeriodBetweenTwoEmployeesOnThisProject();

                if (maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject.isPresent()) {

                    if (firstEmployeePairFound(maxEmploymentPair)) {
                        maxEmploymentPair = maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject.get();
                        continue;
                    }
                    if (newLongerEmploymentPairFound(maxEmploymentPair, maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject)) {
                        maxEmploymentPair = maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject.get();
                    }
                }
            }
        }
        return Optional.of(maxEmploymentPair);
    }

    private boolean newLongerEmploymentPairFound(MaxEmploymentPair maxEmploymentPair, Optional<MaxEmploymentPair> maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject) {
        return maxEmploymentPair != null && maximumEmploymentPeriodBetweenTwoEmployeesOnThisProject.get().getMaxOverlapMonthsOnProject() > maxEmploymentPair.getMaxOverlapMonthsOnProject();
    }

    private boolean firstEmployeePairFound(MaxEmploymentPair maxEmploymentPair) {
        return maxEmploymentPair == null;
    }
}
