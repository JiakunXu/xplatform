package com.hsh24.xplatform.monitor.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;

import com.hsh24.xplatform.api.monitor.bo.LogMonitor;
import com.hsh24.xplatform.framework.dao.impl.BaseDaoImpl;
import com.hsh24.xplatform.monitor.dao.ILogMonitorDao;
import com.ibatis.sqlmap.client.SqlMapExecutor;

/**
 * 
 * @author xujiakun
 * 
 */
public class LogMonitorDaoImpl extends BaseDaoImpl implements ILogMonitorDao {

	@Override
	public int getLogMonitorCount(LogMonitor logMonitor) {
		return (Integer) getSqlMapClientTemplate().queryForObject("monitor.log.getLogMonitorCount", logMonitor);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogMonitor> getLogMonitorList(LogMonitor logMonitor) {
		return (List<LogMonitor>) getSqlMapClientTemplate().queryForList("monitor.log.getLogMonitorList", logMonitor);
	}

	@Override
	public int createLogMonitor(final List<LogMonitor> logMonitorList) {
		return getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>() {
			public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
				int count = 0;
				executor.startBatch();
				for (LogMonitor s : logMonitorList) {
					executor.insert("monitor.log.createLogMonitor", s);
					count++;
				}
				executor.executeBatch();

				return count;
			}
		});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LogMonitor> getLogMonitorList4SendEmail() {
		return (List<LogMonitor>) getSqlMapClientTemplate().queryForList("monitor.log.getLogMonitorList4SendEmail");
	}

}
