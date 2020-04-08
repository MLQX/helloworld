package com.example.demo.hutool.db.dialect.impl;

import com.example.demo.hutool.db.Page;
import com.example.demo.hutool.db.dialect.DialectName;
import com.example.demo.hutool.db.sql.SqlBuilder;
import com.example.demo.hutool.db.sql.Wrapper;

/**
 * MySQL方言
 * @author loolly
 *
 */
public class MysqlDialect extends AnsiSqlDialect{
	private static final long serialVersionUID = -3734718212043823636L;

	public MysqlDialect() {
		wrapper = new Wrapper('`');
	}

	@Override
	protected SqlBuilder wrapPageSql(SqlBuilder find, Page page) {
		return find.append(" LIMIT ").append(page.getStartPosition()).append(", ").append(page.getPageSize());
	}
	
	@Override
	public DialectName dialectName() {
		return DialectName.MYSQL;
	}
}
