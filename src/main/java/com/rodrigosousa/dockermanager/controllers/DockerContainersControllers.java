package com.rodrigosousa.dockermanager.controllers;

import com.github.dockerjava.api.model.Container;
import com.rodrigosousa.dockermanager.service.DockerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/containers")
public class DockerContainersControllers {

    private DockerService dockerService;

    public DockerContainersControllers(DockerService dockerService){
        this.dockerService = dockerService;
    }

    @GetMapping
    public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showAll){
        return dockerService.listContainers(showAll);
    }

    @PostMapping("/{id}/start")
    public void startContainer(@PathVariable String id){
        dockerService.startContainer(id);
    }

    @PostMapping("/{id}/stop")
    public void stopContainer(@PathVariable String id){
        dockerService.stopContainer(id);
    }

    @DeleteMapping("/{id}")
    public void deleteContainer(@PathVariable String id){
        dockerService.deleteContainer(id);
    }

    @PostMapping("")
    public void createContainer(@RequestParam String imageName){
        dockerService.createContainer(imageName);
    }
}
