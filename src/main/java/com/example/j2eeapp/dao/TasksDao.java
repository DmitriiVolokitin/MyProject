package com.example.j2eeapp.dao;

import java.util.List;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.TasksEntity;

/**
 * Data access object interface to work with User entity database operations.
 * 
 * @author Di
 */
public interface TasksDao extends GenericDao<TasksEntity, Long> {

	/**
	 * Queries database for user name availability
	 * 
	 * @param userName
	 * @return true if available
	 */
	boolean checkAvailable(String taskName);
	
	/**
	 * Queries task by first name
	 * 
	 * @param userName
	 * @return User entity
	 */
	TasksEntity loadTaskByFirstName(String taskName);
	
	List<TasksEntity> loadAll();
	
}
