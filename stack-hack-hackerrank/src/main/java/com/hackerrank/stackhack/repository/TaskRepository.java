package com.hackerrank.stackhack.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.stackhack.model.Task;

public interface TaskRepository extends CrudRepository<Task, String>{

}
