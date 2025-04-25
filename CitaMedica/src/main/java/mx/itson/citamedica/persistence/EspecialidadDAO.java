/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.citamedica.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.citamedica.entities.Cita;
import mx.itson.citamedica.entities.Especialidad;
import mx.itson.citamedica.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Akane
 */
public class EspecialidadDAO {
    
    public static List<Especialidad> getAll(){
        List<Especialidad> especialidades = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Especialidad> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Especialidad.class);
            criteriaQuery.from(Especialidad.class);
            
            especialidades = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return especialidades;
    }
    
}
