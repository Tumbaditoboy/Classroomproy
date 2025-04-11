/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.classroom.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.classroom.entities.Assignment;
import mx.itson.classroom.entities.Work;
import mx.itson.classroom.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author dzlan
 */
public class WorkDAO {

        public static List<Work> getAll(){
        List<Work> works = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Work> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Work.class);
            criteriaQuery.from(Work.class);
            
            works = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return works;
    }
    

    
    
    public static boolean save(Work w){
        boolean resultado = false;
        try{
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        session.save(w);
        session.getTransaction().commit();
        
        resultado = w.getId() != 0;
        }catch(Exception ex){
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return resultado;
    } 
    
        public static boolean delete(Work work) {
    boolean resultado = false;

    try {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(work); // elimina el objeto
        session.getTransaction().commit();

        resultado = true;
    } catch (Exception ex) {
        System.err.println("Ocurrió un error al eliminar: " + ex.getMessage());
    }

    return resultado;
}
    
    
}
