/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.citamedica.persistence;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mx.itson.citamedica.entities.Paciente;
import mx.itson.citamedica.utils.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Akane
 */
public class PacienteDAO {
    
    public static List<Paciente> getAll(){
        List<Paciente> pacientes = new ArrayList<>();
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            CriteriaQuery<Paciente> criteriaQuery = 
                    session.getCriteriaBuilder().createQuery(Paciente.class);
            criteriaQuery.from(Paciente.class);
            
            pacientes = session.createQuery(criteriaQuery).getResultList();
        }catch(Exception ex){ 
            System.err.println("Ocurrió un error: " + ex.getMessage());
        }
        return pacientes;
    }
    
}
