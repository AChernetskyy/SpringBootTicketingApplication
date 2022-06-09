package com.ticketingapplication.dto;

import com.ticketingapplication.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDTO {
    private String projectName;
    private String projectCode;
    private UserDTO assignedManager;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate startDate;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private LocalDate endDate;

    private String projectDetails;
    private Status projectStatus;


}
