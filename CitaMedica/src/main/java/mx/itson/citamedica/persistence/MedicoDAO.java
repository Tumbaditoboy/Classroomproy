/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.citamedica.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.citamedica.entities.Medico;
import mx.itson.citamedica.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Akane
 */
public class MedicoDAO {
    
    public static List<Medico> getAll(){
        List<Medico> medicos = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Medico> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Medico.class);
            criteriaQuery.from(Medico.class);
            
            medicos = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return medicos;
    }
    
}
