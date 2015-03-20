package team.unibro.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import team.unibro.dao.IUserDao;
import team.unibro.model.User;

public class UserJdbcDaoImpl implements IUserDao {
	
	private final Logger logger = LoggerFactory.getLogger(UserJdbcDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO user (name, phone, email)"
				+ " VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, user.getUserName(), user.getUserPhone(),
				user.getUserEmail());
		logger.info("add user : {0}", user.toString());
	}

	public List<User> findAllUser() {
		List<User> list = null;
		try {

			String sql = "select * from user";
			list = jdbcTemplate.query(sql,
					new RowMapperResultSetExtractor<User>(new UserRowMapper()));
		} catch (Exception e) {

		}
		return list;
	}

	class UserRowMapper implements RowMapper<User> {
		public User mapRow(ResultSet rs, int index) throws SQLException {
			User u = new User(rs.getLong("id"), rs.getString("user_name"),
					rs.getString("user_phone"), rs.getString("user_email"));
			return u;
		}
	}
}
