package org.example.model;

import org.example.file.reader.CSVProjectEmployeesFileReader;
import org.example.file.reader.ProjectEmployeesFileReader;
import org.junit.Test;

import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class CompanyTest {

    @Test
    public void findMaximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject() {

        ProjectEmployeesFileReader csvProjectEmployeesFileReader = new CSVProjectEmployeesFileReader();
        Map<Integer, Project> projectMap = csvProjectEmployeesFileReader.readProjects("employees-projects.csv");

        Company company = new Company(projectMap);

        final Optional<MaxEmploymentPair> maximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject = company.findMaximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject();

        assertTrue(maximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject.isPresent());
        assertTrue(maximumEmploymentPeriodPairBetweenTwoEmployeesOnAProject.get().getMaxOverlapMonthsOnProject() == 11);
    }
}
