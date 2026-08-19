CREATE TABLE jobs (
    id INT AUTO_INCREMENT PRIMARY KEY,
    job_name VARCHAR(255) NOT NULL,
    job_description TEXT NOT NULL
);

CREATE TABLE job_tech (
    job_id INT NOT NULL,
    tech VARCHAR(100) NOT NULL,

    FOREIGN KEY (job_id) REFERENCES jobs(id)
);