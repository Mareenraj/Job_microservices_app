package org.mareenraj.jobms.controller;

import lombok.RequiredArgsConstructor;
import org.mareenraj.jobms.dto.JobDto;
import org.mareenraj.jobms.model.Job;
import org.mareenraj.jobms.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public ResponseEntity<List<JobDto>> getAllJobs() {
        List<JobDto> jobs = jobService.findAllJobs();
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody JobDto jobDto) {
        String message = jobService.createJob(jobDto);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobDto> getJobById(@PathVariable("id") Long id) {
        JobDto jobDto = jobService.getJobById(id);
        return ResponseEntity.ok(jobDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable("id") Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job successfully deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't find this job", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody JobDto updatedJobDto) {
        Boolean updated = jobService.updateJobById(id, updatedJobDto);
        if (updated) {
            return new ResponseEntity<>("Job updated", HttpStatus.OK);
        }
        return new ResponseEntity<>("Can't update this job.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/company/{companyId}")
    public ResponseEntity<List<JobDto>> getJobByCompanyId(@PathVariable("companyId") Long companyId){
        return ResponseEntity.ok(jobService.findJobsByCompanyId(companyId));
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<JobDto>> getJobByLocation(@PathVariable("location") String location){
        return ResponseEntity.ok(jobService.findJobsByLocation(location));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<JobDto>> getJobByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(jobService.findJobsByTitleContaining(title));
    }

    @GetMapping("/salary")
    public ResponseEntity<List<JobDto>> getJobBySalaryRange(@RequestParam double minSalary, @RequestParam double maxSalary){
        return ResponseEntity.ok(jobService.findJobsBySalaryRange(minSalary,maxSalary));
    }
}
