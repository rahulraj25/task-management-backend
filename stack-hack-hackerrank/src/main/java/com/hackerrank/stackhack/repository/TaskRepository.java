package com.hackerrank.stackhack.repository;

import org.springframework.data.repository.CrudRepository;

import com.hackerrank.stackhack.model.TaskModel;

public interface TaskRepository extends CrudRepository<TaskModel, String>{

}
