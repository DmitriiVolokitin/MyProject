package com.example.j2eeapp.services;

import java.util.List;

import javax.faces.event.AjaxBehaviorEvent;

import com.example.j2eeapp.domain.TasksEntity;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author Di
 */
public interface TasksService {

	/**
	 * Create task - persist to database
	 * 
	 * @param TasksEntity
	 * @return true if success
	 */
	boolean createTask(TasksEntity taskEntity);
	
	/**
	 * Check user name availability. UI ajax use.
	 * 
	 * @param ajax event
	 * @return
	 */
	boolean checkAvailable(AjaxBehaviorEvent event);
	
	/**
	 * Retrieves full Task record from database by first name
	 * 
	 * @param taskName
	 * @return TasksEntity
	 */
	TasksEntity loadTaskByFirstName(String taskName);
	
	List<TasksEntity> loadAll();
	
}
