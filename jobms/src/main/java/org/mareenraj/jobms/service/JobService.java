package org.mareenraj.jobms.service;

import org.mareenraj.jobms.dto.JobDto;

import java.util.List;
import java.util.Optional;

public interface JobService {
    List<JobDto> findAllJobs();

    String createJob(JobDto jobDto);

    JobDto getJobById(Long id);

    Boolean deleteJobById(Long id);

    Boolean updateJobById(Long id, JobDto updatedJobDto);

    List<JobDto> findJobsByCompanyId(Long companyId);

    List<JobDto> findJobsByLocation(String location);

    List<JobDto> findJobsByTitleContaining(String title);

    List<JobDto> findJobsBySalaryRange(Double minSalary, Double maxSalary);
}
