package com.demoo.zjsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

import com.demoo.zjsu.dao.impl.WxAPIDaoImpl;
import com.demoo.zjsu.dbutil.DbCon;
import com.demoo.zjsu.entity.AccessToken;

public class WxAPIDao implements WxAPIDaoImpl {
	private Logger logger = Logger.getLogger(WxAPIDao.class);

	@Override
	public void save(AccessToken aToken) {
		//查询数据库中是否存在用户openid信息
			Connection conn = DbCon.Con_Accesstoken();
			PreparedStatement ps = null;
			String sql = "insert into wx_accesstoken (a_accesstoken,a_time) values (?,?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, aToken.getAccess_token());
				ps.setLong(2, aToken.getLasttime());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("数据插入报错" + e.getMessage());
			}finally{
				DbCon.destroyDb(conn, ps, null);
		}
	}

	@Override
	public AccessToken accesstokenGet() {
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		AccessToken aToken = new AccessToken();
		try {
			String sqlSel = "select * from wx_accesstoken where a_id=1";
			conn = DbCon.Con_Accesstoken();
			ps = conn.prepareStatement(sqlSel); // 定义PreparedStatement对象
			rs = ps.executeQuery();
			if (rs.next()) {
				aToken.setAccess_token(rs.getString("a_accesstoken"));
				aToken.setLasttime(rs.getLong("a_time"));
			}
		} catch (Exception e) {
			logger.error("祝福信息数据获取报错：" + e.getMessage());
			System.out.println("写入日志文件" + e.getMessage());
		} finally {
			DbCon.destroyDb(conn, ps, rs);
		}
		return aToken;
	}
	
	public void accesstokenUpdate(AccessToken aToken){

		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update wx_accesstoken set a_accesstoken=?,a_time=? where a_id=1";
		try {
			conn = DbCon.Con_Accesstoken();
			ps = conn.prepareStatement(sql); // 定义PreparedStatement对象
			ps.setString(1, aToken.getAccess_token());
			ps.setLong(2, aToken.getLasttime());
			ps.executeUpdate();
		} catch (Exception e) {
			logger.error("数据更新报错：" + e.getMessage());
		} finally {
			DbCon.destroyDb(conn, ps, null);
		}

	}

}
