package dao.DataBaseDAO;

import bean.*;
import dao.ExceptionDAO;
import dao.HumanDAO;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.List;
import java.util.TimeZone;

import static dao.XmlDAO.XmlHumanDAO.LOG;

public class DBHumanDAO implements HumanDAO {

    public List<Human> getAllHumans() throws ExceptionDAO
    {
        return null;
    }

    public void addHumans(List<Human> humansList) throws  ExceptionDAO
    {
        Connection con = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?serverTimezone=" + TimeZone.getDefault().getID(),"root","root26root11root1999");
            System.out.println("Connected successfully");
            String sql;

            for (Human human: humansList) {
                if (human instanceof Doctor) {
                    String selectSql = "Select * from doctors where (id = ?)";
                    PreparedStatement selectPs = con.prepareStatement(selectSql);
                    selectPs.setInt(1, human.getId());
                    ResultSet resSet =  selectPs.executeQuery();

                    if(!resSet.next()) {
                        sql = "INSERT INTO doctors(id,name,surname,patronymic,gender,home_adress,birthday," +
                                     "phone_number,department_name,diploma_profession,work_phone_number," +
                                     "university_name, university_ended,current_post,started_working,patients_healed) " +
                                     "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, human.getId());
                        ps.setString(2, human.getName());
                        ps.setString(3, human.getSurname());
                        ps.setString(4, human.getPatronymic());
                        ps.setString(5, human.getGender());
                        ps.setString(6, human.getHomeAdress());
                        ps.setString(7, human.getBirthDay());
                        ps.setString(8, human.getPhoneNumber());
                        ps.setString(9, human.getDepartmentName());
                        ps.setString(10, ((Doctor) human).getDiplomaProfession());
                        ps.setString(11, ((Doctor) human).getWorkPhoneNumber());
                        ps.setString(12, ((Doctor) human).getUniversityName());
                        ps.setString(13, ((Doctor) human).getUniversityEnded());
                        ps.setString(14, ((Doctor) human).getCurrentPost());
                        ps.setString(15, ((Doctor) human).getStartedWorking());
                        ps.setInt(16, ((Doctor) human).getPatientsHealed());
                        ps.execute();
                    }
                }
                else if (human instanceof HeadPhysician) {
                    String selectSql = "Select * from headphysicians where (id = ?)";
                    PreparedStatement selectPs = con.prepareStatement(selectSql);
                    selectPs.setInt(1, human.getId());
                    ResultSet resSet =  selectPs.executeQuery();

                    if(!resSet.next()) {
                        sql = "INSERT INTO headphysicians(id,name,surname,patronymic,gender,home_adress,birthday," +
                                "phone_number,department_name,diploma_profession,work_phone_number," +
                                "university_name, university_ended,started_working,ended_working,future_plans_for_hospital) " +
                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, human.getId());
                        ps.setString(2, human.getName());
                        ps.setString(3, human.getSurname());
                        ps.setString(4, human.getPatronymic());
                        ps.setString(5, human.getGender());
                        ps.setString(6, human.getHomeAdress());
                        ps.setString(7, human.getBirthDay());
                        ps.setString(8, human.getPhoneNumber());
                        ps.setString(9, human.getDepartmentName());
                        ps.setString(10, ((HeadPhysician) human).getDiplomaProfession());
                        ps.setString(11, ((HeadPhysician) human).getWorkPhoneNumber());
                        ps.setString(12, ((HeadPhysician) human).getUniversityName());
                        ps.setString(13, ((HeadPhysician) human).getUniversityEnded());
                        ps.setString(14, ((HeadPhysician) human).getStartedWorking());
                        ps.setString(15, ((HeadPhysician) human).getEndedWorking());
                        ps.setString(16, ((HeadPhysician) human).getFuturePlansForHospital());
                        ps.execute();
                    }
                }
                else if (human instanceof Nurse) {
                    String selectSql = "Select * from nurses where (id = ?)";
                    PreparedStatement selectPs = con.prepareStatement(selectSql);
                    selectPs.setInt(1, human.getId());
                    ResultSet resSet =  selectPs.executeQuery();

                    if(!resSet.next()) {
                        sql = "INSERT INTO nurses(id,name,surname,patronymic,gender,home_adress,birthday," +
                                "phone_number,department_name,diploma_profession,work_phone_number," +
                                "university_name, university_ended,current_post,started_working,injections_did, " +
                                "patients_saved) " +
                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, human.getId());
                        ps.setString(2, human.getName());
                        ps.setString(3, human.getSurname());
                        ps.setString(4, human.getPatronymic());
                        ps.setString(5, human.getGender());
                        ps.setString(6, human.getHomeAdress());
                        ps.setString(7, human.getBirthDay());
                        ps.setString(8, human.getPhoneNumber());
                        ps.setString(9, human.getDepartmentName());
                        ps.setString(10, ((Nurse) human).getDiplomaProfession());
                        ps.setString(11, ((Nurse) human).getWorkPhoneNumber());
                        ps.setString(12, ((Nurse) human).getUniversityName());
                        ps.setString(13, ((Nurse) human).getUniversityEnded());
                        ps.setString(14, ((Nurse) human).getCurrentPost());
                        ps.setString(15, ((Nurse) human).getStartedWorking());
                        ps.setInt(16, ((Nurse) human).getInjectionsDid());
                        ps.setInt(17, ((Nurse) human).getPatientsSaved());
                        ps.execute();
                    }
                }
                else if (human instanceof Intern) {
                    String selectSql = "Select * from interns where (id = ?)";
                    PreparedStatement selectPs = con.prepareStatement(selectSql);
                    selectPs.setInt(1, human.getId());
                    ResultSet resSet =  selectPs.executeQuery();
                    if(!resSet.next()) {
                        sql = "INSERT INTO interns(id,name,surname,patronymic,gender,home_adress,birthday," +
                                "phone_number,department_name,diploma_profession,work_phone_number," +
                                "university_name, university_ended,internship_started,internship_days,mistakes_made) " +
                                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, human.getId());
                        ps.setString(2, human.getName());
                        ps.setString(3, human.getSurname());
                        ps.setString(4, human.getPatronymic());
                        ps.setString(5, human.getGender());
                        ps.setString(6, human.getHomeAdress());
                        ps.setString(7, human.getBirthDay());
                        ps.setString(8, human.getPhoneNumber());
                        ps.setString(9, human.getDepartmentName());
                        ps.setString(10, ((Intern) human).getDiplomaProfession());
                        ps.setString(11, ((Intern) human).getWorkPhoneNumber());
                        ps.setString(12, ((Intern) human).getUniversityName());
                        ps.setString(13, ((Intern) human).getUniversityEnded());
                        ps.setString(14, ((Intern) human).getInternshipStarted());
                        ps.setInt(15, ((Intern) human).getInternshipDays());
                        ps.setInt(16, ((Intern) human).getMistakesMade());
                        ps.execute();
                    }
                }
                else if (human instanceof Patient) {
                    String selectSql = "Select * from patients where (id = ?)";
                    PreparedStatement selectPs = con.prepareStatement(selectSql);
                    selectPs.setInt(1, human.getId());
                    ResultSet resSet =  selectPs.executeQuery();

                    if(!resSet.next()) {
                        sql = "INSERT INTO patients(id,name,surname,patronymic,gender,home_adress,birthday," +
                                "phone_number,department_name,ward_number) " +
                                "VALUES(?,?,?,?,?,?,?,?,?,?)";
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, human.getId());
                        ps.setString(2, human.getName());
                        ps.setString(3, human.getSurname());
                        ps.setString(4, human.getPatronymic());
                        ps.setString(5, human.getGender());
                        ps.setString(6, human.getHomeAdress());
                        ps.setString(7, human.getBirthDay());
                        ps.setString(8, human.getPhoneNumber());
                        ps.setString(9, human.getDepartmentName());
                        ps.setInt(10, ((Patient) human).getWardNumber());
                        ps.execute();
                    }

                    if (((Patient)human).getCurrentDisease() != null) {
                        Disease disease = ((Patient)human).getCurrentDisease();
                        selectSql = "Select * from diseases where (id = ?)";
                        selectPs = con.prepareStatement(selectSql);
                        selectPs.setInt(1, human.getId());
                        resSet =  selectPs.executeQuery();

                        if(!resSet.next()) {
                            sql = "INSERT INTO diseases(id,name,when_started,duration,patient_complaints," +
                                    "prescribed_treatment,was_treatment_success) " +
                                    "VALUES(?,?,?,?,?,?,?)";
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.setInt(1, disease.getId());
                            ps.setString(2, disease.getName());
                            ps.setString(3, disease.getWhenStarted());
                            ps.setInt(4, disease.getDuration());
                            ps.setString(5, disease.getPatientComplaints());
                            ps.setString(6, disease.getPrescribedTreatment());
                            ps.setBoolean(7, disease.getWasTreatmentSuccess());
                            ps.execute();
                        }
                    }
                }
            }

            sql = "INSERT INTO patients_diseases(patient_id,disease_id) VALUES(?,?)";
            for (Human human: humansList) {
                if (human instanceof Patient) {
                    String selectSql = "Select * from patients_diseases where (patient_id = ?) and (disease_id = ?)";
                    PreparedStatement selectPs = con.prepareStatement(selectSql);
                    selectPs.setInt(1,human.getId());
                    selectPs.setInt(2,((Patient)human).getCurrentDisease().getId());
                    ResultSet resSet =  selectPs.executeQuery();
                    if(!resSet.next()) {
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setInt(1, ((Patient)human).getCurrentDisease().getId());
                        ps.setInt(2, ((Patient)human).getCurrentDisease().getId());
                        ps.execute();
                    }
                }
            }

        }catch(ClassNotFoundException e){
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
