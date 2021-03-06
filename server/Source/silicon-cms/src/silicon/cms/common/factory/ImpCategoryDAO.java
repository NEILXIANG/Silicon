package silicon.cms.common.factory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import silicon.ark.dao.DataBaseConn;
import silicon.cms.common.dao.CategoryDAO;
import silicon.cms.common.entity.CategoryEntity;
import silicon.common.SCLog;

public class ImpCategoryDAO implements CategoryDAO
{
	
	//private static String _prefix = null;
	
	public ImpCategoryDAO() {
		// TODO Auto-generated constructor stub
		//_prefix = "select * from st_category";
	}

	@Override
	public void save(CategoryEntity m_category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(CategoryEntity m_category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(CategoryEntity m_category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoryEntity> query(String m_sql) {
		// TODO Auto-generated method stub
		List<CategoryEntity> _list = new ArrayList<CategoryEntity>();
		try {
			Connection _conn = DataBaseConn.getConnection();
			if(_conn == null)
			{
				SCLog.info("CategoryEntity 获取数据库连接失败： 连接为空   ：（");
				return null;
			}
			Statement _statement = _conn.createStatement();
			ResultSet _rs = _statement.executeQuery(m_sql);
			while(_rs.next())
			{
				CategoryEntity m_category = new CategoryEntity();
				m_category.setId(_rs.getString("CATEGORY_ID"));
				m_category.setCategoryName(_rs.getString("CATEGORY_NAME"));
				_list.add(m_category);
			}
			_rs.close();
			DataBaseConn.closeConn();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return _list;
	}

	@Override
	public CategoryEntity queryEntityById(String m_categoryId) {
		// TODO Auto-generated method stub
		String _sql = "select * from st_category where category_id = " + "'" + m_categoryId + "'";
		CategoryEntity _category = new CategoryEntity();
		try {
			Connection _conn = DataBaseConn.getConnection();
			if(_conn == null)
			{
				SCLog.info("获取数据库连接失败： 连接为空   T_T");
				return null;
			}
			Statement _statement = _conn.createStatement();
			ResultSet _rs = _statement.executeQuery(_sql);
			if(_rs == null)
				return null;
			
			_rs.next();
			_category.setId(_rs.getString("CATEGORY_ID"));
			_category.setCategoryName(_rs.getString("CATEGORY_NAME"));
			_rs.close();
			DataBaseConn.closeConn();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _category;
	}
	
}
