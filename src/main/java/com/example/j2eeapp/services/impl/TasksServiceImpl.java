package com.example.j2eeapp.services.impl;

import java.io.Serializable;
import java.util.List;

/**
import java.util.ArrayList;
import java.util.Collection;
*/

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

import org.primefaces.component.inputtext.InputText;

import com.example.j2eeapp.dao.TasksDao;
import com.example.j2eeapp.domain.TasksEntity;
import com.example.j2eeapp.services.TasksService;

/**
 * Service providing service methods to work with user data and entity.
 * 
 * @author Di
 */

public class TasksServiceImpl implements TasksService, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TasksDao taskDao;
	
	/**
	public <TasksEntity> findAll() {
		return taskDao.findAll();
		
	}
		
	
	 * Create user - persist to database
	 * 
	 * @param userEntity
	 * @return true if success
	 */
	public boolean createTask(TasksEntity taskEntity) {
		
		/**
		if (!tasksDao.checkAvailable(userEntity.getUserName())) {
			FacesMessage message = constructErrorMessage(String.format(getMessageBundle().getString("userExistsMsg"), userEntity.getUserName()), null);
			getFacesContext().addMessage(null, message);
			
			return false;
		}
		*/
		
		try {
			taskDao.save(taskEntity);
		} catch(Exception e) {
			FacesMessage message = constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			
			return false;
		}
		
		return true;
	}
	
	public List<TasksEntity> loadAll() {
		return taskDao.findAll();
	}
	
	/**
	 * Check user name availability. UI ajax use.
	 * 
	 * @param ajax event
	 * @return
	*/
	
	public boolean checkAvailable(AjaxBehaviorEvent event) {
		
		InputText inputText = (InputText) event.getSource();
		String value = (String) inputText.getValue();
		
		boolean available = taskDao.checkAvailable(value);
		
		if (!available) {
			FacesMessage message = constructErrorMessage(null, String.format(getMessageBundle().getString("userExistsMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		} else {
			FacesMessage message = constructInfoMessage(null, String.format(getMessageBundle().getString("userAvailableMsg"), value));
			getFacesContext().addMessage(event.getComponent().getClientId(), message);
		}
		
		return available;
	}
	
	public TasksEntity loadTaskByFirstName(String taskName) {
		return taskDao.loadTaskByFirstName(taskName);
	}

	protected FacesMessage constructErrorMessage(String message, String detail){
		return new FacesMessage(FacesMessage.SEVERITY_ERROR, message, detail);
	}
	
	protected FacesMessage constructInfoMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_INFO, message, detail);
	}
	
	protected FacesMessage constructFatalMessage(String message, String detail) {
		return new FacesMessage(FacesMessage.SEVERITY_FATAL, message, detail);
	}
	
	protected FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}
	
	protected ResourceBundle getMessageBundle() {
		return ResourceBundle.getBundle("message-labels");
	}

	public TasksDao getTaskDao() {
		return taskDao;
	}

	public void setTaskDao(TasksDao taskDao) {
		this.taskDao = taskDao;
	}

}
