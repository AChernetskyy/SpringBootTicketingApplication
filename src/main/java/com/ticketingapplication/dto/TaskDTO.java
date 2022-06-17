package com.ticketingapplication.dto;

import com.ticketingapplication.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TaskDTO {
    private Long id;
   private ProjectDTO project;
   private UserDTO employee;
   private String taskSubject;
   private String taskDetails;
   @Enumerated(EnumType.STRING)
   private Status projectStatus;
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private LocalDate timeCreated;


   public TaskDTO(ProjectDTO project, UserDTO employee, String taskSubject, String taskDetails, Status projectStatus, LocalDate timeCreated) {
      this.project = project;
      this.employee = employee;
      this.taskSubject = taskSubject;
      this.taskDetails = taskDetails;
      this.projectStatus = projectStatus;
      this.timeCreated = timeCreated;
   }
}
