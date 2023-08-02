package org.example.model;

public class MaxEmploymentPair {

    private Integer employeeIdFirst;
    private Integer employeeIdSecond;
    private Integer maxOverlapMonthsOnProject;


    public MaxEmploymentPair(Integer employeeIdFirst, Integer employeeIdSecond, Integer maxOverlapMonthsOnProject) {
        this.employeeIdFirst = employeeIdFirst;
        this.employeeIdSecond = employeeIdSecond;
        this.maxOverlapMonthsOnProject = maxOverlapMonthsOnProject;
    }

    public MaxEmploymentPair() {
        this.maxOverlapMonthsOnProject = 0;
    }

    public void setEmployeeIdFirst(Integer employeeIdFirst) {
        this.employeeIdFirst = employeeIdFirst;
    }

    public void setEmployeeIdSecond(Integer employeeIdSecond) {
        this.employeeIdSecond = employeeIdSecond;
    }

    public Integer getMaxOverlapMonthsOnProject() {
        return maxOverlapMonthsOnProject;
    }

    public void setMaxOverlapMonthsOnProject(Integer maxOverlapMonthsOnProject) {
        this.maxOverlapMonthsOnProject = maxOverlapMonthsOnProject;
    }

    @Override
    public String toString() {
        return String.format("%d, %d, %d", employeeIdFirst, employeeIdSecond, maxOverlapMonthsOnProject);
    }
}
