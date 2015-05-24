/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.user;

/**
 *
 * @author Jon Janet 6701505
 */
@ManagedBean
@RequestScoped
public class IndexBean
{

    private String user_name;
    private String granted_by;
    private String users_role;
    private String request_date;
    private String password;
    private String work_area;
    private String message;
    private List users;

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public List getUsers()
    {
        return users;
    }

    public void setUsers(List users)
    {
        this.users = users;
    }

    public String getUser_name()
    {
        return user_name;
    }

    public void setUser_name(String user_name)
    {
        this.user_name = user_name;
    }

    public String getGranted_by()
    {
        return granted_by;
    }

    public void setGranted_by(String granted_by)
    {
        this.granted_by = granted_by;
    }

    public String getUsers_role()
    {
        return users_role;
    }

    public void setUsers_role(String users_role)
    {
        this.users_role = users_role;
    }

    public String getRequest_date()
    {
        return request_date;
    }

    public void setRequest_date(String request_date)
    {
        this.request_date = request_date;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
   
    }
        public String getWork_area()
    {
        return work_area;
    }

    public void setWork_area(String work_area)
    {
        this.work_area = work_area;
   
 }
    /**
     * Creates a new instance of IndexBean
     */
    public IndexBean()
    {
    }

    public String retrieveuser() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/new_users", "root", "JJanetIT315");
        Statement statement = (Statement) connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");



        users = new ArrayList();

        while (resultSet.next())
        {
            user_name = resultSet.getString("user_name");
            granted_by = resultSet.getString("granted_by");
            users_role = resultSet.getString("users_role");
            request_date = resultSet.getString("request_date");
            password = resultSet.getString("password");
            work_area = resultSet.getString("work_area");

            user user1 = new user(user_name, granted_by, users_role, request_date, password, work_area);

            users.add(user1);
        }
        user_name = null;
        granted_by = null;
        users_role = null;
        request_date = null;
        password = null;
        work_area = null;

        return "index";
    }

    public String insertuser() throws ClassNotFoundException, SQLException
    {
        //System.out.println("Add user button pressed");
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/new_users", "root", "JJanetIT315");
        Statement statement = (Statement) connection.createStatement();
        String insertuser = "insert into users values ('" + getUser_name() + "', '" + getGranted_by() + "', '" + getUsers_role() + "', '" + getRequest_date() + "', '" + getPassword() + "', '" + getWork_area() + "')";
        System.out.println("insertuser: " + insertuser);
        int i = statement.executeUpdate(insertuser);
        if (i != 0)
        {
            this.message = "The record was entered Successfully!";
        } else
        {
            this.message = "Sorry! Record was not entered";
        }

        return "index";
    }
}
