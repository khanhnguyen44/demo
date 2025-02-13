/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.Students;

/**
 *
 * @author tungn
 */
public class Dao extends DBContext {

    public List<Students> getAll() {
        List<Students> list = new ArrayList();
        PreparedStatement stm;
        ResultSet rs;

        String sql = "Select s.StudentID,s.StudentName,s.BirthDate,s.Gender,sb.SubjectName From Students s Join Subjects sb ON s.SubjectID = sb.SubjectID";
        try {
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                String code = rs.getString("StudentID");
                String name = rs.getString("StudentName");
                Date date = rs.getDate("BirthDate");
                int value = rs.getInt("Gender");
                String gender = (value == 0) ? "Female" : "Male";
                String sub = rs.getString("SubjectName");

                Students s = new Students(code, name, date, gender, sub);
                list.add(s);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public int getSBID(String SBname) {
        PreparedStatement stm;
        ResultSet rs;
        int id = -1;
        String sql = "SELECT SubjectID FROM Subjects WHERE SubjectName = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setString(1, SBname);
            rs = stm.executeQuery();

            if (rs.next()) {
                id = rs.getInt("SubjectID");
            } else {
                System.out.println("No subject found with name: " + SBname);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public void addST(String code, String name, String date, int gender, String sub) {
        PreparedStatement stm;

        String sql = "insert into Students values(?,?,?,?,?)";
        try {

            int sbid = getSBID(sub);
            if (sbid == -1) {
                System.out.println("Not found!!!");
            }
            stm = connection.prepareStatement(sql);
            stm.setString(1, code);
            stm.setString(2, name);
            stm.setString(3, date);
            stm.setInt(4, gender);
            stm.setInt(5, sbid);

            stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Dao dao = new Dao();

        String studentID = "SE05152";   // Mã sinh viên
        String studentName = "Tran Van C"; // Tên sinh viên
        String birthDate = "2001-12-25";   // Ngày sinh
        int gender = 1;               // Giới tính (1 = Male, 0 = Female)
        String className = "Java core";  // Tên lớp

        dao.addST(studentID, studentName, birthDate, gender, className);

        // Kiểm tra danh sách sinh viên sau khi thêm
        List<Students> l = dao.getAll();
        for (Students student : l) {
            System.out.println(student.toString());
        }
    }
}
