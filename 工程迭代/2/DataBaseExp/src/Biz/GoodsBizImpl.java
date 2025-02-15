package Biz;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import Dao.DBLink;
import OperateTarget.Goods;

public class GoodsBizImpl implements GoodsBiz {
	private DBLink lk  = new DBLink();
	
	public boolean add(Connection conn, Goods p) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "insert into Goods values (?,?,?,?,?,?)";
		Object[] params = {p.getGid(),p.getGname(),p.getGpprice(),p.getGsprice(),p.getPid(),p.getDatetime()};
		boolean flag = false;
		try{
			flag = lk.update(conn, sql, params);
		} catch (SQLException e) {
			throw e;
		}
		return flag;
	}

	
	public boolean delete(Connection conn,int gid) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "delete from Goods where Gid = ?";
		Object[] params = {gid};
		boolean flag = false;
		try{
			flag = lk.update(conn, sql, params);
		} catch (SQLException e) {
			throw e;
		}
		return flag;
	}

	
	public boolean update(Connection conn, Goods p) throws SQLException{
		// TODO Auto-generated method stub
		String sql = "update Goods set Gname = ?,Gpprice = ?, Gsprice = ?,Pid =?,Pdate = ? where Gid = ?";
		Object[] params = {p.getGname(),p.getGpprice(),p.getGsprice(),p.getPid(),p.getDatetime(),p.getGid()};
		boolean flag = false;
		try{
			flag = lk.update(conn, sql, params);
		} catch (SQLException e) {
			throw e;
		}
		return flag;
	}

	
	public Goods findByID(int gid) {
		// TODO Auto-generated method stub
		String sql = "select * from Goods where Gid = ?";
		Object[] params = {gid};
		return (Goods)(lk.get(sql,Goods.class, params));
	}


	public List<Goods> findAll() {
		// TODO Auto-generated method stub
		String sql = "select * from Goods";
		return lk.query(sql, Goods.class);
	}

	public List<Goods> findByCondition(String condition) {
		// TODO Auto-generated method stub
		String sql = "select * from Goods where Gname + Gpprice + Gsprice + Pid + Pdate like ?";
		Object[] params = {"%"+condition+"%"};
		return lk.query(sql, Goods.class, params);
	}
}
