package org.mareenraj.jobms.mapper;

import org.mareenraj.jobms.dto.JobDto;
import org.mareenraj.jobms.model.Job;

public class JobMapper {
    public static JobDto toJobDto(Job job) {
        JobDto jobDto = new JobDto();
        jobDto.setId(job.getId());
        jobDto.setTitle(job.getTitle());
        jobDto.setDescription(job.getDescription());
        jobDto.setMinSalary(job.getMinSalary());
        jobDto.setMaxSalary(job.getMaxSalary());
        jobDto.setLocation(job.getLocation());
        jobDto.setCompanyId(job.getCompanyId());
        return jobDto;
    }

    public static Job toJob(JobDto jobDto) {
        Job job = new Job();
        job.setId(jobDto.getId());
        job.setTitle(jobDto.getTitle());
        job.setDescription(jobDto.getDescription());
        job.setMinSalary(jobDto.getMinSalary());
        job.setMaxSalary(jobDto.getMaxSalary());
        job.setLocation(jobDto.getLocation());
        job.setCompanyId(jobDto.getCompanyId());
        return job;
    }
}
