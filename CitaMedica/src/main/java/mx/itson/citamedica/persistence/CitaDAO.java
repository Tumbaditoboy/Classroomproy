/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.citamedica.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.citamedica.entities.Cita;
import mx.itson.citamedica.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Akane
 */
public class CitaDAO {
    
    public static List<Cita> getAll(){
        List<Cita> citas = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Cita> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Cita.class);
            criteriaQuery.from(Cita.class);
            
            citas = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return citas;
    }
    
    public static boolean save(Cita c) throws Exception {
    boolean resultado = false;
    Session session = null;

    try {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        if (c.getId() == 0) {
            
            session.save(c);
        } else {
            
            session.update(c);
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
}
