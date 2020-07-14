package com.projectsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectsapi.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {   }