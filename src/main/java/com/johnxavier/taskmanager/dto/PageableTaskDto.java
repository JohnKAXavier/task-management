package com.johnxavier.taskmanager.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PageableTaskDto {

    private List<TaskDto> tasks;
    private Integer currentPage;
    private Long totalItems;
    private Integer totalPages;
}
