package org.mareenraj.jobms.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.mareenraj.jobms.dto.JobDto;
import org.mareenraj.jobms.exception.InvalidJobException;
import org.mareenraj.jobms.exception.JobNotFoundException;
import org.mareenraj.jobms.mapper.JobMapper;
import org.mareenraj.jobms.model.Job;
import org.mareenraj.jobms.repository.JobRepository;
import org.mareenraj.jobms.service.JobService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {
    private final JobRepository jobRepository;

    @Override
    public List<JobDto> findAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream().map(JobMapper::toJobDto).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String createJob(JobDto jobDto) {
        if(jobDto == null){
            throw new InvalidJobException("Job can't be null");
        }
        Job job = jobRepository.save(JobMapper.toJob(jobDto));
        return "Job is created successfully with id: " + job.getId();
    }

    @Override
    public JobDto getJobById(Long id) {
        return jobRepository.findById(id).map(JobMapper::toJobDto).orElseThrow(() -> new JobNotFoundException("Job with id " + id+ " not found!"));
    }

    @Override
    @Transactional
    public Boolean deleteJobById(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    @Transactional
    public Boolean updateJobById(Long id, JobDto updatedJobDto) {
        if(updatedJobDto == null){
            throw new InvalidJobException("Job can't be null");
        }
        if(!jobRepository.existsById(id)) {
            throw new JobNotFoundException("Job with id " + id+ " not found!");
        }
        if (jobRepository.existsById(id)) {
            Job updatedJob = JobMapper.toJob(updatedJobDto);
            updatedJob.setId(id);
            jobRepository.save(updatedJob);
            return true;
        }
        return false;
    }

    @Override
    public List<JobDto> findJobsByCompanyId(Long companyId) {
        List<Job> jobs = jobRepository.findByCompanyId(companyId);
        return jobs.stream().map(JobMapper::toJobDto).collect(Collectors.toList());
    }

    @Override
    public List<JobDto> findJobsByLocation(String location) {
        List<Job> jobs = jobRepository.findByLocation(location);
        return jobs.stream().map(JobMapper::toJobDto).collect(Collectors.toList());
    }

    @Override
    public List<JobDto> findJobsByTitleContaining(String title) {
        List<Job> jobs = jobRepository.findJobByTitle(title);
        return jobs.stream().map(JobMapper::toJobDto).collect(Collectors.toList());
    }

    @Override
    public List<JobDto> findJobsBySalaryRange(Double minSalary, Double maxSalary) {
        List<Job> jobs = jobRepository.findByMinSalaryGreaterThanEqualAndMaxSalaryLessThanEqual(minSalary, maxSalary);
        return jobs.stream().map(JobMapper::toJobDto).collect(Collectors.toList());
    }
}

