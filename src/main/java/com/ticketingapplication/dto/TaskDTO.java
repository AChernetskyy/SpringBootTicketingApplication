package com.ticketingapplication.dto;

import com.ticketingapplication.enums.Status;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Setter
public class TaskDTO {
   private Long id;
   private ProjectDTO project;
   private UserDTO employee;
   private String taskSubject;
   private String taskDetails;
   @Enumerated(EnumType.STRING)
   private Status taskStatus;
   @DateTimeFormat(pattern = "dd-MM-yyyy")
   private LocalDate timeCreated;

   public TaskDTO(ProjectDTO project, UserDTO employee, String taskSubject, String taskDetails, Status projectStatus, LocalDate timeCreated) {
      this.project = project;
      this.employee = employee;
      this.taskSubject = taskSubject;
      this.taskDetails = taskDetails;
      this.taskStatus = projectStatus;
      this.timeCreated = timeCreated;
      this.id=UUID.randomUUID().getMostSignificantBits();
   }

}
