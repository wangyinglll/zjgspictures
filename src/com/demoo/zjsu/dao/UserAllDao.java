package com.demoo.zjsu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.demoo.zjsu.dao.impl.UserAllDaoImpl;
import com.demoo.zjsu.dbutil.DbCon;
import com.demoo.zjsu.entity.UserInfo;

public class UserAllDao implements UserAllDaoImpl {
	private Logger logger = Logger.getLogger(UserAllDaoImpl.class);

	private Connection conn = null;

	@Override
	public UserInfo userinfoExistJudgeByOpenid(String openid) {
		String sql = "SELECT * FROM user_zjsu where u_openid=?"; // 定义查询语句
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo userInfo = null;
		try {
			conn = DbCon.Con();
			ps = conn.prepareStatement(sql); // 定义PreparedStatement对象
			ps.setString(1, openid);
			rs = ps.executeQuery(); // 执行查询
			if (rs.next()) {
				userInfo = new UserInfo();
				userInfo.setNickname(rs.getString("u_nickname"));
				userInfo.setU_id(rs.getInt("u_id"));
				userInfo.setOpenid(rs.getString("u_openid"));
			}
		} catch (SQLException e) {
			logger.error("查询报错" + e.getMessage());
			System.out.println("写入日志文件" + e.getMessage());
		} finally {
			DbCon.destroyDb(conn, ps, rs);
		}
		return userInfo;
	}

	@Override
	public void userinfoSave(UserInfo userinfo) {

		String sql = "insert into user_zjsu (u_openid,u_nickname,u_headimgurl,u_sex,u_province,u_city) values (?,?,?,?,?,?)";
		PreparedStatement ps = null;
		try {
			conn = DbCon.Con();
			ps = conn.prepareStatement(sql); // 定义PreparedStatement对象
			ps.setString(1, userinfo.getOpenid());
			ps.setString(2, userinfo.getNickname());
			ps.setString(3, userinfo.getHeadimgurl());
			ps.setInt(4, userinfo.getSex());
			ps.setString(5, userinfo.getProvince());
			ps.setString(6, userinfo.getCity());
			ps.executeUpdate();
		} catch (SQLException e) {
			logger.error("数据插入报错" + e.getMessage() + ",nickname:"
					+ userinfo.getNickname());
			System.out.println("写入日志文件" + e.getMessage());
		} finally {
			DbCon.destroyDb(conn, ps, null);
		}
	}

	@Override
	public UserInfo userinfoGetByOpenid(String openid) {
		String sql = "SELECT * FROM user_zjsu where u_openid=?"; // 定义查询语句
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfo userInfo = null;
		try {
			conn = DbCon.Con();
			ps = conn.prepareStatement(sql); // 定义PreparedStatement对象
			ps.setString(1, openid);
			rs = ps.executeQuery(); // 执行查询
			if (rs.next()) {
				userInfo = new UserInfo();
				userInfo.setNickname(rs.getString("u_nickname"));
				userInfo.setU_id(rs.getInt("u_id"));
				userInfo.setOpenid(rs.getString("u_openid"));
			}
		} catch (SQLException e) {
			logger.error("查询报错" + e.getMessage());
			System.out.println("写入日志文件" + e.getMessage());
		} finally {
			DbCon.destroyDb(conn, ps, rs);
		}
		return userInfo;
	}

}
