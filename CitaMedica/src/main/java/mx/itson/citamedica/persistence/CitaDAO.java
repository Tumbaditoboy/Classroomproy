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
    
}
