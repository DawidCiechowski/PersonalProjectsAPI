package com.projectsapi.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.projectsapi.exception.ApiKeyMissingException;
import com.projectsapi.exception.ProjectNotFoundException;
import com.projectsapi.model.Project;
import com.projectsapi.repository.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ProjectController {

    @Autowired
    private final ProjectRepository repository;

    ProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/projects")
    CollectionModel<EntityModel<Project>> all() {
        
        List<EntityModel<Project>> projects = repository.findAll().stream()
                .map(project -> EntityModel.of(project,
                        linkTo(methodOn(ProjectController.class).getProjectById(project.getId())).withSelfRel(),
                        linkTo(methodOn(ProjectController.class).all()).withRel("projects")))
                .collect(Collectors.toList());

        return CollectionModel.of(projects, linkTo(methodOn(ProjectController.class).all()).withSelfRel());
    }

    @PostMapping("/projects")
    Project postNewProject(@RequestBody Project newProject) {
        return repository.save(newProject);
    }

    @GetMapping("/projects/{id}")
    EntityModel<Project> getProjectById(@PathVariable Long id) {
        Project project = repository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));

        return EntityModel.of(project, linkTo(methodOn(ProjectController.class).getProjectById(id)).withSelfRel(),
                linkTo(methodOn(ProjectController.class).all()).withRel("projects"));
    }

    @PutMapping("/projects/{id}")
    Project updateProjectById(@RequestBody Project newProject, @PathVariable Long id) {
        return repository.findById(id) //
				.map(project -> {
					project.setName(newProject.getName());
                    project.setDescription(newProject.getDescription());
                    project.setLink(newProject.getLink());
					return repository.save(project);
				}) //
				.orElseGet(() -> {
					newProject.setId(id);
					return repository.save(newProject);
				});
    }

    @DeleteMapping("/projects/{id}")
    public Map<String, Boolean> deleteProjectById(@PathVariable(name = "id") Long id) throws ProjectNotFoundException {
        Project project = repository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));

        this.repository.delete(project);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);

        return response;
    }
}