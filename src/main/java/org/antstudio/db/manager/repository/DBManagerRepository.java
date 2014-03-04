package org.antstudio.db.manager.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface DBManagerRepository {

	public void excuteUpdate(String sql);
	
	public void query(String sql);
	
	public void insert(String sql);
	
}
