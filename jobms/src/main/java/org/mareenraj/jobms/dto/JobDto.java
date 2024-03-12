package org.mareenraj.jobms.dto;

import lombok.Data;

@Data
public class JobDto {
    private Long id;
    private String title;
    private String description;
    private double minSalary;
    private double maxSalary;
    private String location;
    private Long companyId;
}
