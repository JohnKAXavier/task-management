package com.johnxavier.taskmanager.controller;

import com.johnxavier.taskmanager.dto.PageableTaskDto;
import com.johnxavier.taskmanager.model.Task;
import com.johnxavier.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable("id") Long id){
        Task task = service.findById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping
    public ResponseEntity<PageableTaskDto> findAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "3") Integer size){

        PageableTaskDto dto = service.findAllPageable(page, size);
        return ResponseEntity.ok(dto);
    }

    @PostMapping(produces = "text/plain")
    public ResponseEntity<String> create(@RequestBody @Validated Task task){
        service.create(task);
        return ResponseEntity.ok("Saved");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") Long id, @RequestBody @Validated Task task){
        service.update(id, task);
        return ResponseEntity.ok("Updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }


}
