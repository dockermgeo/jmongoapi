package de.mgeo.jrest.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {

   @Id
   String id;
    String name;
    String project;
    String repo;

    public Product (String name, String project, String repo) {
        this.name=name;
        this.project=project;
        this.repo=repo;
   }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }


    public String getRepo() {
        return repo;
    }

    public void setRepo(String repo) {
        this.repo = repo;
    }

    public String toString() {
        return "{'product': '"+name+"', 'project': '"+project+"', 'repository': '"+repo+"'";
    }
}
