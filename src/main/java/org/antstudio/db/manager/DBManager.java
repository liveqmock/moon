package org.antstudio.db.manager;

import java.util.List;

import org.antstudio.db.manager.repository.DBManagerRepository;
import org.springframework.stereotype.Component;

/**
 * 数据库管理类
 * @author Gavin
 * @date 2014-3-5
 */
@Component
public class DBManager {

	//可以注入数据库方言..待实现
	
	
	//想法:做一个可配置的通知,如某种配置文件,在项目启动后，自动读取通知,这样可以使用户及时得到信息更新.
	
	private DBManagerRepository dbManagerRepository;
	
	public void dropTables(List<String> tables){
		StringBuilder sql = new StringBuilder();
		sql.append("Drop table ");
		for(String table:tables){
			sql.append(table).append(",");
		}
		sql.deleteCharAt(sql.length()-1);
		sql.append(";");
		dbManagerRepository.excuteUpdate(sql.toString());
	}
	
}
