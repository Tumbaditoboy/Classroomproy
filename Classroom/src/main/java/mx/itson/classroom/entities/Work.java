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
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the idAssignment
     */
    public int getIdAssignment() {
        return idAssignment;
    }

    /**
     * @param idAssignment the idAssignment to set
     */
    public void setIdAssignment(int idAssignment) {
        this.idAssignment = idAssignment;
    }

    /**
     * @return the idStudent
     */
    public int getIdStudent() {
        return idStudent;
    }

    /**
     * @param idStudent the idStudent to set
     */
    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    private Date date;
    private String fileName;
    private int idAssignment;
    private int idStudent;
            
}
