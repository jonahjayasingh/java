package com.example.jobapplication.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.jobapplication.Models.jobs;

@Repository
public class websiteRepository {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(jobs j){
        String sql = "insert into jobs (job_name,job_description) values (?,?)";

        int jobId  = jdbc.update(
            sql,
            j.getJobName(),
            j.getJobDescription()
        );

     

        String techSql = """
    INSERT INTO job_tech (job_id, tech)
    VALUES (?, ?)
    ON CONFLICT (job_id, tech) DO NOTHING
    """;
        for ( String tech : j.getTech()){
            jdbc.update(techSql,jobId,tech);

        }

    }

   public List<jobs> findAll() {

    String jobSql = """
        SELECT id, job_name, job_description
        FROM jobs
        ORDER BY id
        """;

    return jdbc.query(jobSql, (rs, rowNum) -> {

        jobs job = new jobs();

        job.setJobName(rs.getString("job_name"));
        job.setJobDescription(rs.getString("job_description"));

        String techSql = """
            SELECT tech
            FROM job_tech
            WHERE job_id = ?
            """;

        List<String> tech = jdbc.query(
            techSql,
            (techRs, techRowNum) -> techRs.getString("tech"),
            rs.getInt("id")
        );

        job.setTech(tech);

        return job;
    });
}
    
    
}
