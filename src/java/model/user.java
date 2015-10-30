package model;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Jon Janet
 */
@ManagedBean
@RequestScoped
public class user implements Serializable
{

    private String user_name;
    private String granted_by;
    private String users_role;
    private String request_date;
    private String password;
    private String work_area;


    public user(String user_name, String granted_by, String users_role, String request_date, String password, String work_area)
    {
        this.user_name = user_name;
        this.granted_by = granted_by;
        this.users_role = users_role;
        this.request_date = request_date;
        this.password = password;
        this.work_area = work_area;
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
}
