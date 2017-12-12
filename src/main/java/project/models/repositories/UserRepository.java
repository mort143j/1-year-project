package project.models.repositories;

import project.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbc;

    //@Override
    public void create(User user) {
        String query = "INSERT INTO user(name, email, password) VALUES('" + user.getName() + "','" + user.getPassword() + "') ";

        jdbc.update(query);
    }
    //@Override
    public User login(User user) {
        SqlRowSet sqlRowSet = jdbc.queryForRowSet("SELECT * FROM user WHERE name ='" + user.getName() + "' AND password =  '"+ user.getPassword() + "'");
        User currentUser = new User();
        if(sqlRowSet.next()) {
            String name = sqlRowSet.getString("name");
            String password = sqlRowSet.getString("password");
            int userId = sqlRowSet.getInt("user_id");


            currentUser.setName(name);
            currentUser.setPassword(password);
            currentUser.setUserId(userId);

        }
        return currentUser;
    }
    //@Override
    public void update(User user) {

        jdbc.update("Update user SET password = '" + user.getPassword() + "' WHERE user_id = '" + user.getUserId() + "'");
    }

    //@Override
    public void delete(int id) {
        jdbc.update("DELETE FROM user WHERE user_id = " + id);
    }
}