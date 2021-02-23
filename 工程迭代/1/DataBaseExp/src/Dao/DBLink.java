package Dao;
import java.sql.*;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DBLink {
	/**
	 * �������
	 * 
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = null;
		String jdbcURL = "jdbc:sqlserver://localhost:1433;DatabaseName=Supermarket";
		String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String user = "sa";
		String password = "123456";
		try {
			Class.forName(jdbcDriver);// establish link
			conn = DriverManager.getConnection(jdbcURL, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * select option
	 * return ResultSet data
	 * */
	public ResultSet select(String sqlLine) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			st = con.createStatement();
			rs = st.executeQuery(sqlLine);
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return rs;
	}
	/**
	 * delete something from the database
	 * when success return true
	 * */
	public boolean delete(String sqlLine) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			st = con.createStatement();
			int rs = st.executeUpdate(sqlLine);
			if(rs > 0) return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			try{
				con.close();
			}catch(SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return false;
	}
	public boolean update(String sqlLine) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			st = con.createStatement();
			int rs = st.executeUpdate(sqlLine);
			if(rs > 0) return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public boolean insert(String sqlLine) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			st = con.createStatement();
			int rs = st.executeUpdate(sqlLine);
			if(rs > 0) return true;
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	public void create(String sql) {
		Connection con = null;
		Statement st = null;
		try {
			con = getConnection();
			st = con.createStatement();
			st.execute(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//������ʹ��apache�ܹ��Ĺ���
	
	
	/**
	 * ִ�и��µ�sql���,����,�޸�,ɾ��
	 * 
	 * @param sql
	 * @return
	 */
	public boolean update(String sql, Object[] params) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			int i = qRunner.update(conn, sql, params);
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return flag;
	}

	/**
	 * ���Ҷ������
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 */
	public List query(String sql, Class clazz) {
		List beans = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			beans = (List) qRunner.query(conn, sql, new BeanListHandler(clazz));
			// BeanListHandler�����˴�ResultSet�л�ȡ���ݣ���װ���󲢴���List����
			// Դ��ͬ����Ҫ�õ�ResultSet
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return beans;
	}

	/**
	 * ���ز�ѯ������󷽷�
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 */
	public List query(String sql, Class clazz, Object[] params) {
		List beans = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			beans = (List) qRunner.query(conn, sql, new BeanListHandler(clazz), params);

			// BeanListHandler�����˴�ResultSet�л�ȡ���ݣ���װ���󲢴���List����
			// Դ��ͬ����Ҫ�õ�ResultSet
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return beans;
	}

	/**
	 * ���Ҷ���
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 */
	public Object get(String sql, Class clazz) {
		Object obj = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler(clazz));
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return obj;
	}

	/**
	 * ���ز�ѯ�����󷽷�
	 * 
	 * @param sql
	 * @param clazz
	 * @return
	 */
	public Object get(String sql, Class clazz, Object[] params) {
		Object obj = null;
		Connection conn = null;
		try {
			conn = getConnection();
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbUtils.closeQuietly(conn);
		}
		return obj;
	}
}
