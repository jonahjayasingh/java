package com.example.springbootrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.repo.JobRepo;


@Service
public class JobService {
	@Autowired
	public JobRepo repo;
	
	
	
	//method to return all JobPosts
	public List<JobPost> getAllJobs() {
		return repo.getAllJobs();

		
	}
	
	
	
	

	// ***************************************************************************


	
	
	
	// method to add a jobPost
	public void addJobPost(JobPost jobPost) {
		 repo.addJobPost(jobPost);
	
	}

    public JobPost getJopbPost(int id){
        return repo.getJopPost(id);
    }





    public void updateJobPost(JobPost jobPost) {
        repo.updateJobPost(jobPost);
    }

    public void deleteJobPost(int id){
        repo.deleteJobPost(id);
    }
	
}