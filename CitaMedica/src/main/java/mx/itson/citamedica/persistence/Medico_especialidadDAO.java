/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.citamedica.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.citamedica.entities.Medico_especialidad;
import mx.itson.citamedica.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Akane
 */
public class Medico_especialidadDAO {
    
    public static List<Medico_especialidad> getAll(){
        List<Medico_especialidad> medicoEspecialidadLista = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Medico_especialidad> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Medico_especialidad.class);
            criteriaQuery.from(Medico_especialidad.class);
            
            medicoEspecialidadLista = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return medicoEspecialidadLista;
    }
    
}
