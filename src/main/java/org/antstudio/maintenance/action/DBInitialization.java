package org.antstudio.maintenance.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.antstudio.db.manager.DBManager;
import org.antstudio.moon.rest.annotation.Get;
import org.antstudio.moon.rest.annotation.Post;
import org.antstudio.rbac.domain.annotation.LoginRequired;
import org.antstudio.rbac.domain.annotation.MenuMapping;
import org.antstudio.rbac.domain.annotation.PermissionMapping;
import org.antstudio.utils.MessageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 数据库维护控制器
 * @author Gavin
 * @date 2014-3-9 下午4:46:07
 */
@Controller
@LoginRequired
@RequestMapping("/dbMaintenance")
public class DBInitialization {

	@Resource
	private DBManager dbManager;
	/**
	 * 初始化数据库,此操作会删除数据库内容并重建
	 * @return
	 */
	@Post("/initDb")
	@PermissionMapping(name="初始化数据",code="platform01")
	public @ResponseBody Map<String,Object> initDb(){
		List<String> tableNames = new ArrayList<String>();
		tableNames.add("tab_log");
		tableNames.add("tab_menu");
		tableNames.add("tab_permission");
		tableNames.add("tab_role");
		tableNames.add("tab_role_menu");
		tableNames.add("tab_role_permission");
		tableNames.add("tab_user");
		dbManager.dropTables(tableNames);
		dbManager.createTableIfNecessary();
		dbManager.reLoadMenus();
		dbManager.reLoadPermissions();
		return MessageUtils.getMapMessage(true);
	}
	
	@Get("")
	@MenuMapping(code="platform_6",name="数据维护",url="/dbMaintenance",parentCode="platform")
	public ModelAndView showMaintenancePage(){
		return new ModelAndView("/pages/maintenance/DBMaintenance");
	}
}
