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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 *
 * @author dzlan
 */

@Entity
public class Work {

    /**
     * @param assignment the assignment to set
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * @return the assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    
    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

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
     * @param file_Name the fileName to set
     */
    public void setFile_Name(String file_Name) {
        this.file_Name = file_Name;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    private int id;
    private Date date;
    private String file_Name;
    
    @ManyToOne
    @JoinColumn(name = "id_assignment")
    private Assignment assignment;
    
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    
   
            
}
