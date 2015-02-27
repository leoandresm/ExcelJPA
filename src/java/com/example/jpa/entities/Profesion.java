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
@Table(name = "profesion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Profesion.findAll", query = "SELECT p FROM Profesion p"),
    @NamedQuery(name = "Profesion.findByCodProf", query = "SELECT p FROM Profesion p WHERE p.codProf = :codProf"),
    @NamedQuery(name = "Profesion.findByProfesion", query = "SELECT p FROM Profesion p WHERE p.profesion = :profesion")})
public class Profesion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "cod_prof")
    private Integer codProf;
    @Size(max = 30)
    @Column(name = "profesion")
    private String profesion;
    @OneToMany(mappedBy = "codProf")
    private List<Estudiante> estudianteList;

    public Profesion() {
    }

    public Profesion(Integer codProf) {
        this.codProf = codProf;
    }

    public Integer getCodProf() {
        return codProf;
    }

    public void setCodProf(Integer codProf) {
        this.codProf = codProf;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
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
        hash += (codProf != null ? codProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Profesion)) {
            return false;
        }
        Profesion other = (Profesion) object;
        if ((this.codProf == null && other.codProf != null) || (this.codProf != null && !this.codProf.equals(other.codProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.jpa.entities.Profesion[ codProf=" + codProf + " ]";
    }
    
}
