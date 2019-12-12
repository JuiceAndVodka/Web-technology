package dao.DataBaseDAO;

import bean.Department;
import dao.DepartmentDAO;
import dao.ExceptionDAO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.TimeZone;

import static dao.XmlDAO.XmlDepartmentDAO.LOG;

public class DBDepartmentDAO implements DepartmentDAO {

    public List<Department> getAllDepartments()throws ExceptionDAO
    {
        return null;
    }

    public void addDepartments(List<Department> departmentsList)throws ExceptionDAO
    {
        Connection con = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?serverTimezone=" + TimeZone.getDefault().getID(),"root","root26root11root1999");
            System.out.println("Connected successfully");
            String sql = "INSERT INTO departments(id,name,floor,wards_amount,doctors_amount,current_patients_amount, max_patients_amount) VALUES(?,?,?,?,?,?,?)";
            for(Department department: departmentsList) {
                String selectSql = "Select * from departments where (id = ?)";
                PreparedStatement selectPs = con.prepareStatement(selectSql);
                selectPs.setInt(1, department.getId());
                ResultSet resSet =  selectPs.executeQuery();
                if(!resSet.next()) {
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setInt(1, department.getId());
                    ps.setString(2, department.getName());
                    ps.setInt(3, department.getFloor());
                    ps.setInt(4, department.getWardsAmount());
                    ps.setInt(5, department.getDoctorsAmount());
                    ps.setInt(6, department.getCurrentPatientsAmount());
                    ps.setInt(7, department.getMaxPatientsAmount());
                    ps.execute();
                }
                else
                {
                    //log
                }
            }

        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            LOG.log(Level.ERROR,e.getMessage());
            throw new ExceptionDAO(e);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            LOG.log(Level.ERROR,e.getMessage());
            throw new ExceptionDAO(e);
        }
        finally {
            try{
                if(con != null){
                    con.close();
                }
            }
            catch (SQLException e){
                LOG.log(Level.ERROR,e.getMessage());
                throw new ExceptionDAO(e);
            }
        }
    }
}
