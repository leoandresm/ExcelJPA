/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controllers;

import com.example.jpa.entities.Estudiante;
import com.example.jpa.sessions.EstudianteFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author LeoAndresM
 */
@ManagedBean
@SessionScoped
public class EstudianteController {

    private Estudiante estudianteActual;
    private List<Estudiante> listaEstudiantes = null;

    @EJB
    private EstudianteFacade estudianteFacade;

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {
    }

    public Estudiante getEstudianteActual() {
        if (estudianteActual == null) {
            estudianteActual = new Estudiante();
        }
        return estudianteActual;
    }

    public void setEstudianteActual(Estudiante estudianteActual) {
        this.estudianteActual = estudianteActual;
    }

    public List<Estudiante> getListaEstudiantes() {
        if (listaEstudiantes == null) {
            try {
                listaEstudiantes = estudianteFacade.findAll();
            } catch (Exception ex) {
                System.out.println("Error consultando estudiantes");
            }
        }
        return listaEstudiantes;
    }

    public void save() {
        if (estudianteActual != null) {
            try  {
                if (estudianteFacade.find(estudianteActual.getCedula()) == null) {
                    estudianteFacade.create(estudianteActual);
                    estudianteActual = null;
                    listaEstudiantes = null;
                } else {
                    estudianteFacade.edit(estudianteActual);
                    estudianteActual = null;
                    listaEstudiantes = null;
                }

            } catch (Exception ex) {
                System.out.println("Error creando estudiante");
            }
        }
    }
    
     public List<Estudiante> getItemsAvailableSelectMany() {
        return estudianteFacade.findAll();
    }

    public List<Estudiante> getItemsAvailableSelectOne() {
        return estudianteFacade.findAll();
    }

}
