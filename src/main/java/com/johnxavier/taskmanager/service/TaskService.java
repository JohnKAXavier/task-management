package com.johnxavier.taskmanager.service;

import com.johnxavier.taskmanager.dto.PageableTaskDto;
import com.johnxavier.taskmanager.dto.TaskDto;
import com.johnxavier.taskmanager.exception.TaskNotFoundException;
import com.johnxavier.taskmanager.model.Task;
import com.johnxavier.taskmanager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository repository;

    public void create(Task task){
        repository.save(task);
    }

    public List<Task> findAll(){
        return repository.findAll();
    }

    public Task findById(Long id){
        return repository.findById(id).orElseThrow(()-> new TaskNotFoundException(id));
    }

    public PageableTaskDto findAllPageable(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<TaskDto> taskPage = repository.findAllTaskDto(pageable);

        PageableTaskDto pageableTaskDto = new PageableTaskDto();
        pageableTaskDto.setTasks(taskPage.getContent());
        pageableTaskDto.setCurrentPage(taskPage.getNumber());
        pageableTaskDto.setTotalItems(taskPage.getTotalElements());
        pageableTaskDto.setTotalPages(taskPage.getTotalPages());

        return pageableTaskDto;
    }

    public void update(Long id, Task updateTask){
        Task task = repository.findById(id).orElseThrow(()-> new TaskNotFoundException(id));

        task.setTitle(updateTask.getTitle());
        task.setDescription(updateTask.getDescription());
        task.setResponsible(updateTask.getResponsible());
        task.setDeadLine(updateTask.getDeadLine());
        task.setPriorityEnum(updateTask.getPriorityEnum());

        repository.save(task);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
