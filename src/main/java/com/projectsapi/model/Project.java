package com.projectsapi.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "introduction")
    private String introduction;

    @ElementCollection
    @CollectionTable(name = "tech", joinColumns = @JoinColumn(name="technologies_account_id"))
    @Column(name = "technologies")
    private List<String> technologies;

    @Column(name = "description")
    private String description;

    @Column(name = "link")
    private String link;


    public Project() {
    }

    public Project(String name, String introduction, List<String> technologies, String description, String link) {
        this.name = name;
        this.introduction = introduction;
        this.technologies = technologies;
        this.description = description;
        this.link = link;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getTechnologies() {
        return this.technologies;
    }

    public void setTechnologies(List<String> technologies) {
        this.technologies = technologies;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Project id(Long id) {
        this.id = id;
        return this;
    }

    public Project name(String name) {
        this.name = name;
        return this;
    }

    public Project introduction(String introduction) {
        this.introduction = introduction;
        return this;
    }

    public Project technologies(List<String> technologies) {
        this.technologies = technologies;
        return this;
    }

    public Project description(String description) {
        this.description = description;
        return this;
    }

    public Project link(String link) {
        this.link = link;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Project)) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(introduction, project.introduction) && Objects.equals(technologies, project.technologies) && Objects.equals(description, project.description) && Objects.equals(link, project.link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, introduction, technologies, description, link);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", introduction='" + getIntroduction() + "'" +
            ", technologies='" + getTechnologies() + "'" +
            ", description='" + getDescription() + "'" +
            ", link='" + getLink() + "'" +
            "}";
    }
    
    

}