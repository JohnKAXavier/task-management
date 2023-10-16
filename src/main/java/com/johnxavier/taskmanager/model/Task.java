package com.johnxavier.taskmanager.model;

import com.johnxavier.taskmanager.enums.PriorityEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Title is mandatory")
    private String title;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    private Responsible responsible;
    private PriorityEnum priorityEnum;

    @NotNull(message = "Deadline is mandatory")
    private LocalDateTime deadLine;
}
