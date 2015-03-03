/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author LeoAndresM
 */
@Entity
@Table(name = "ficha")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f"),
    @NamedQuery(name = "Ficha.findByFicha", query = "SELECT f FROM Ficha f WHERE f.ficha = :ficha"),
    @NamedQuery(name = "Ficha.findByNombre", query = "SELECT f FROM Ficha f WHERE f.nombre = :nombre"),
    @NamedQuery(name = "Ficha.findByCiudad", query = "SELECT f FROM Ficha f WHERE f.ciudad = :ciudad")})
public class Ficha implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ficha")
    private Integer ficha;
    @Size(max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 7)
    @Column(name = "ciudad")
    private String ciudad;
    @OneToMany(mappedBy = "ficha")
    private List<Estudiante> estudianteList;

    public Ficha() {
    }

    public Ficha(Integer ficha) {
        this.ficha = ficha;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ficha != null ? ficha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.ficha == null && other.ficha != null) || (this.ficha != null && !this.ficha.equals(other.ficha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "No. " + getFicha();
    }
    
}
