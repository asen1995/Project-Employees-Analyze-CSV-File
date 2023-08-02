package org.example.file.reader;


import org.example.model.Project;

import java.util.Map;

public interface ProjectEmployeesFileReader {
    Map<Integer, Project> readProjects(String file);
}
