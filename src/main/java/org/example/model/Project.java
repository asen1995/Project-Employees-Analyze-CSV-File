package org.example.model;

import org.example.date.DateCalculator;

import java.util.*;

public class Project {
    private Integer projectID;
    private Map<Integer, List<EmploymentPeriod>> employmentPeriods;

    public Project(Integer projectID) {
        this.projectID = projectID;
        this.employmentPeriods = new HashMap<>();
    }

    public void addEmploymentPeriod(Integer employeeId, EmploymentPeriod employmentPeriod) {
        List<EmploymentPeriod> employmentPeriodOfEmployeeList = employmentPeriods.get(employeeId);

        if (employeeAlreadyWorkedOnThisProjectBefore(employeeId)) {

            employmentPeriodOfEmployeeList.add(employmentPeriod);

        } else {
            employmentPeriodOfEmployeeList = new ArrayList<>();
            employmentPeriodOfEmployeeList.add(employmentPeriod);
            employmentPeriods.put(employeeId, employmentPeriodOfEmployeeList);

        }
    }

    private boolean employeeAlreadyWorkedOnThisProjectBefore(Integer employeeId) {
        return employmentPeriods.get(employeeId) != null;
    }

    public Optional<MaxEmploymentPair> findMaximumEmploymentPeriodBetweenTwoEmployeesOnThisProject() {

        MaxEmploymentPair maxEmploymentPair = new MaxEmploymentPair();

        final List<Integer> employeeIdsList = new ArrayList<>(employmentPeriods.keySet());

        DateCalculator dateCalculator = new DateCalculator();

        for (int firstEmployeeIndex = 0; firstEmployeeIndex < employeeIdsList.size() - 1; firstEmployeeIndex++) {

            for (int secondEmployeeIndex = firstEmployeeIndex + 1; secondEmployeeIndex < employeeIdsList.size(); secondEmployeeIndex++) {

                final List<EmploymentPeriod> employmentPeriodsFirstEmployee = employmentPeriods.get(employeeIdsList.get(firstEmployeeIndex));
                final List<EmploymentPeriod> employmentPeriodsSecondEmployee = employmentPeriods.get(employeeIdsList.get(secondEmployeeIndex));

                for (int i = 0; i < employmentPeriodsFirstEmployee.size(); i++) {
                    for (int j = 0; j < employmentPeriodsSecondEmployee.size(); j++){

                        final Date dateFromFirstEmployee = employmentPeriodsFirstEmployee.get(i).getDateFrom();
                        final Date dateToFirstEmployee = employmentPeriodsFirstEmployee.get(i).getDateTo();

                        final Date dateFromSecondEmployee = employmentPeriodsSecondEmployee.get(j).getDateFrom();
                        final Date dateToSecondEmployee = employmentPeriodsSecondEmployee.get(j).getDateTo();

                        int overlapMonths = dateCalculator.calculateOverlapMonths(dateFromFirstEmployee, dateToFirstEmployee, dateFromSecondEmployee, dateToSecondEmployee);

                        if(overlapMonths > maxEmploymentPair.getMaxOverlapMonthsOnProject()){
                            maxEmploymentPair.setEmployeeIdFirst(employeeIdsList.get(firstEmployeeIndex));
                            maxEmploymentPair.setEmployeeIdSecond(employeeIdsList.get(secondEmployeeIndex));
                            maxEmploymentPair.setMaxOverlapMonthsOnProject(overlapMonths);

                        }
                    }
                }

            }
        }

        return maxEmploymentPair.getMaxOverlapMonthsOnProject() == 0 ? Optional.empty() : Optional.of(maxEmploymentPair);
    }



    public boolean atLeastTwoPeopleWorkedOnThisProject() {
        return employmentPeriods.size() >= 2;
    }
}
