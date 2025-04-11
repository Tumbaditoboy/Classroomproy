/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.classroom.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.classroom.entities.Assignment;
import mx.itson.classroom.entities.Student;
import mx.itson.classroom.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author dzlan
 */
public class AssignmentDAO {
    
        public static List<Assignment> getAll(){
        List<Assignment> assignments = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Assignment> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Assignment.class);
            criteriaQuery.from(Assignment.class);
            
            assignments = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return assignments;
    }
    

    
    public static boolean save(Assignment a) throws Exception {
    boolean resultado = false;
    Session session = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        if (a.getId() == 0) {
            // Si el ID es 0, significa que es un nuevo estudiante, entonces usamos save
            session.save(a);
        } else {
            // Si el ID ya tiene valor, significa que es un estudiante existente, entonces usamos update
            session.update(a);
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
    
    public static boolean delete(Assignment assignment) {
    boolean resultado = false;

    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(assignment); // elimina el objeto
        session.getTransaction().commit();

        resultado = true;
    } catch (Exception ex) {
        System.err.println("Ocurrió un error al eliminar: " + ex.getMessage());
    }

    return resultado;
}
    
    public static Assignment getById(int id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Assignment a = session.get(Assignment.class, id);
    session.close();
    return a;
}

    
    
}
