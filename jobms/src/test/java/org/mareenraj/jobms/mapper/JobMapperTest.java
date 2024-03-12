package org.mareenraj.jobms.mapper;

import org.junit.jupiter.api.Test;
import org.mareenraj.jobms.dto.JobDto;
import org.mareenraj.jobms.model.Job;

import static org.junit.jupiter.api.Assertions.*;

class JobMapperTest {

    @Test
    void toJobDto() {
        Job job = new Job();
        job.setId(1L);
        job.setTitle("AI engineering");
        job.setDescription("Building powerful AI applications.");
        job.setMinSalary(1000000.0);
        job.setMaxSalary(2000000.0);
        job.setLocation("Singapore");
        job.setCompanyId(1L);

        JobDto jobDto = JobMapper.toJobDto(job);

        assertEquals(job.getId(), jobDto.getId());
        assertEquals(job.getTitle(), jobDto.getTitle());
        assertEquals(job.getDescription(), jobDto.getDescription());
        assertEquals(job.getMinSalary(), jobDto.getMinSalary());
        assertEquals(job.getMaxSalary(), jobDto.getMaxSalary());
        assertEquals(job.getLocation(), jobDto.getLocation());
        assertEquals(job.getCompanyId(), jobDto.getCompanyId());
    }

    @Test
    void toJob() {
        JobDto jobDto = new JobDto();
        jobDto.setId(1L);
        jobDto.setTitle("AI engineering");
        jobDto.setDescription("Building powerful AI applications.");
        jobDto.setMinSalary(1000000.0);
        jobDto.setMaxSalary(2000000.0);
        jobDto.setLocation("Singapore");
        jobDto.setCompanyId(1L);

        Job job = JobMapper.toJob(jobDto);

        assertEquals(job.getId(), jobDto.getId());
        assertEquals(job.getTitle(), jobDto.getTitle());
        assertEquals(job.getDescription(), jobDto.getDescription());
        assertEquals(job.getMinSalary(), jobDto.getMinSalary());
        assertEquals(job.getMaxSalary(), jobDto.getMaxSalary());
        assertEquals(job.getLocation(), jobDto.getLocation());
        assertEquals(job.getCompanyId(), jobDto.getCompanyId());
    }
}