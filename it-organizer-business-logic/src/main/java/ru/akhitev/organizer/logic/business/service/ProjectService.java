package ru.akhitev.organizer.logic.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.akhitev.organizer.entity.Project;
import ru.akhitev.organizer.logic.business.converter.ProjectConverter;
import ru.akhitev.organizer.logic.business.dto.project.ProjectForEditor;
import ru.akhitev.organizer.logic.business.dto.project.ProjectForList;
import ru.akhitev.organizer.repository.ProjectRepository;

import javax.xml.ws.ServiceMode;
import java.util.Set;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository repository;

    @Autowired
    private ProjectConverter converter;

    private Project activeProject;

    public Set<ProjectForList> giveProjectsForList(Integer nameSize) {
        return converter.convertFromProjectsToProjectsForList(repository.findAll(), nameSize);
    }

    public ProjectForEditor giveProjectForEdit(Integer projectId, Integer nameSize) {
        return converter.convertFromProjectToProjectForEditor(repository.getOne(projectId), nameSize);
    }

    public Integer saveProject(ProjectForEditor projectForEditor) {
        Integer id = projectForEditor.getId();
        Project project = null;
        if (id != null) {
            project = repository.getOne(id);
        }
        project = converter.mergeProjectForListToProject(project, projectForEditor);
        return repository.save(project).getId();
    }

    public void removeProject(Integer projectId) {
        repository.delete(projectId);
    }

    public void activateProject(Integer projectId) {
        activeProject = repository.getOne(projectId);
    }

    public Project getActiveProject() {
        return activeProject;
    }
}