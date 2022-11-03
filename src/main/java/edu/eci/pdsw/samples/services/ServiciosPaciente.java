package edu.eci.pdsw.samples.services;


import java.util.List;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.PersistenceException;

/**
 *
 * @author 2106913
 */
public interface ServiciosPaciente {

    /**
     * Consultar todos los pacientes
     * @return
     * @throws ExcepcionServiciosSuscripciones 
     */
    public List<Paciente> consultarPacientes() throws ExcepcionServiciosSuscripciones;
        
    
    /**
     * Consulta un paciente a partir de su numero y tipo de identificacion
     * @param id numero de identificacion
     * @param tipoIdentificacion
     * @return el paciente con sus consultas ordenadas de la mas
     * reciente a la mas antigua
     * @throws ExcepcionServiciosSuscripciones si NO existe un paciente con dicha
     * identificacion, o si se presenta otro problema en las capas inferiores.
     */
    Paciente getPacientesPorId(int id, TipoIdentificacion tipoIdentificacion) throws ExcepcionServiciosSuscripciones, PersistenceException;
    
    /**
     * Consulta los pacientes menores de edad que han tenido enfermedades contagiosas
     * @return el listado de pacientes menores de edad que han tenido enfermedades contagiosas,
     * es decir, que tengan consultas que contengan en su texto palabras 'hepatitis' o
     * 'varicela'
     * @throws ExcepcionServiciosSuscripciones si se presenta otro problema en las capas inferiores.
     */
    public List<Paciente> consultarMenoresConEnfermedadContagiosa() throws ExcepcionServiciosSuscripciones, PersistenceException;
    

}
