/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.classroom.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.classroom.entities.Student;
import mx.itson.classroom.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author dzlan
 */
public class StudentDAO {
    
    public static List<Student> getAll(){
        List<Student> students = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Student> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Student.class);
            criteriaQuery.from(Student.class);
            
            students = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return students;
    }
    

    
    
    public static boolean save(Student s) throws Exception {
    boolean resultado = false;
    Session session = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        if (s.getId() == 0) {
            // Si el ID es 0, significa que es un nuevo estudiante, entonces usamos save
            session.save(s);
        } else {
            // Si el ID ya tiene valor, significa que es un estudiante existente, entonces usamos update
            session.update(s);
        }

        session.getTransaction().commit();
        resultado = true;

    } catch (Exception ex) {
        if (session != null && session.getTransaction().isActive()) {
            session.getTransaction().rollback();
        }
        throw ex; // Para que la excepción llegue fuera del DAO
    } finally {
        if (session != null) {
            session.close();
        }
    }

    return resultado;
}

    
    public static boolean delete(Student student) {
    boolean resultado = false;

    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(student); // elimina el objeto
        session.getTransaction().commit();

        resultado = true;
    } catch (Exception ex) {
        System.err.println("Ocurrió un error al eliminar: " + ex.getMessage());
    }

    return resultado;
}
    
    public static Student getById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Student s = session.get(Student.class, id);
    session.close();
    return s;
}

  

    
}
