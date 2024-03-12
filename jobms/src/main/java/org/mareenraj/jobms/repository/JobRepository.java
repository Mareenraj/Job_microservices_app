package org.mareenraj.jobms.repository;

import org.mareenraj.jobms.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findByCompanyId(Long id);

    List<Job> findByLocation(String location);

    List<Job> findJobByTitle(String title);

    List<Job> findByMinSalaryGreaterThanEqualAndMaxSalaryLessThanEqual(double minSalary, double maxSalary);
}
