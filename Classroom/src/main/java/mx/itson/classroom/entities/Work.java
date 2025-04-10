/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.classroom.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author dzlan
 */

@Entity
public class Work {

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the fileName
     */
    public String getFile_Name() {
        return file_Name;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }

    /**
     * @return the idAssignment
     */
    public int getId_Assignment() {
        return id_Assignment;
    }

    /**
     * @param id_Assignment the idAssignment to set
     */
    public void setId_Assignment(int id_Assignment) {
        this.id_Assignment = id_Assignment;
    }

    /**
     * @return the idStudent
     */
    public int getId_Student() {
        return id_Student;
    }

    /**
     * @param id_Student the idStudent to set
     */
    public void setId_Student(int id_Student) {
        this.id_Student = id_Student;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    private Date date;
    private String file_Name;
    private int id_Assignment;
    private int id_Student;
            
}
