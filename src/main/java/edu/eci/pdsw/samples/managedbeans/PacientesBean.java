/*
 * Copyright (C) 2016 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.samples.managedbeans;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.PacienteMapper;
import edu.eci.pdsw.samples.services.ExcepcionServiciosSuscripciones;
import edu.eci.pdsw.samples.services.ServiciosPacientesFactory;

import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hcadavid
 */
@ManagedBean(name = "mb")
@SessionScoped
public class PacientesBean {

    TipoIdentificacion tipoIdentificacion = TipoIdentificacion.CC;
    int id;

    Paciente paciente;
    List<Paciente> menoresContagiosos;

    public List<Paciente> getMenoresContagiosos() {
        return menoresContagiosos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TipoIdentificacion getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public List<Paciente> getData() throws Exception{
        try {
            return ServiciosPacientesFactory.getInstance().getForumsServices().consultarPacientes();
        } catch (ExcepcionServiciosSuscripciones ex) {
            throw ex;
        }
    }

    public void getPacientePorId(int id) throws Exception{
        try{
            paciente = ServiciosPacientesFactory.getInstance().getForumsServices().getPacientesPorId(id, tipoIdentificacion);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void consultarMenoresConEnfermedadContagiosa() throws Exception{
        try{
            menoresContagiosos = ServiciosPacientesFactory.getInstance().getForumsServices().consultarMenoresConEnfermedadContagiosa();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public TipoIdentificacion[] getTiposIdentificacion() {
        return TipoIdentificacion.values();
    }
    
}
