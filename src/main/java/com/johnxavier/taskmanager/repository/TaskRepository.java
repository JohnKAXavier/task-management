package com.johnxavier.taskmanager.repository;

import com.johnxavier.taskmanager.dto.TaskDto;
import com.johnxavier.taskmanager.model.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query("SELECT new com.johnxavier.taskmanager.dto.TaskDto(t.id, t.title, t.responsible.name) from Task t")
    Page<TaskDto> findAllTaskDto(Pageable pageable);
}
