/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Francisca Carmona
 */
@Entity
@Table(name = "servicio")
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_servicio")
    private Integer idServicio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio", fetch = FetchType.LAZY)
    private List<Resena> resenaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio", fetch = FetchType.LAZY)
    private List<Hora> horaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idServicio", fetch = FetchType.LAZY)
    private List<TipoDeServicio> tipoDeServicioList;

    public Servicio() {
    }

    public Servicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Resena> getResenaList() {
        return resenaList;
    }

    public void setResenaList(List<Resena> resenaList) {
        this.resenaList = resenaList;
    }

    public List<Hora> getHoraList() {
        return horaList;
    }

    public void setHoraList(List<Hora> horaList) {
        this.horaList = horaList;
    }

    public List<TipoDeServicio> getTipoDeServicioList() {
        return tipoDeServicioList;
    }

    public void setTipoDeServicioList(List<TipoDeServicio> tipoDeServicioList) {
        this.tipoDeServicioList = tipoDeServicioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicio != null ? idServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idServicio == null && other.idServicio != null) || (this.idServicio != null && !this.idServicio.equals(other.idServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lp2.proyecto2.modelo.Servicio[ idServicio=" + idServicio + " ]";
    }
    
}
