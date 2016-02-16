package com.example.j2eeapp.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.TasksEntity;

/**
 * Data access object JPA impl to work with User entity database operations.
 * 
 * @author Di
 */
public class TasksJpaDao extends GenericJpaDao<TasksEntity, Long> implements TasksDao {

	public TasksJpaDao() {
		super(TasksEntity.class);
	}

	/**
	public <TasksEntity> findAll(){

		Query query = getEntityManager().createQuery("select count(*) from " + getPersistentClass().getSimpleName());

		return = (<TasksEntity>) query.getResultList();
	}

	 * Queries database for user name availability
	 * 
	 * @param taskName
	 * @return true if available
	 */
	public boolean checkAvailable(String firstName) {
		Assert.notNull(firstName);

		Query query = getEntityManager()
				.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
						+ " u where u.first_name = :firstName").setParameter("firstName", firstName);

		Long count = (Long) query.getSingleResult();

		return count < 1;
	}

	/**
	 * Queries user by taskname
	 * 
	 * @param taskName
	 * @return Tasks entity
	 */
	public TasksEntity loadTaskByFirstName(String firstName) {
		Assert.notNull(firstName);

		TasksEntity task = null;

		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.first_name = :firstName").setParameter("firstName", firstName);

		try {
			task = (TasksEntity) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}

		return task;
	}

	public List<TasksEntity> loadAll() {
		
		Query query = getEntityManager().createQuery("select count(*) from " + getPersistentClass().getSimpleName());
		return query.getResultList();
		
	}


}
