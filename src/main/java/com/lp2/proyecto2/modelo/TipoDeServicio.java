/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lp2.proyecto2.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Francisca Carmona
 */
@Entity
@Table(name = "`tipo_de_servicio`")
@NamedQueries({
    @NamedQuery(name = "TipoDeServicio.findAll", query = "SELECT t FROM TipoDeServicio t")})
public class TipoDeServicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 25)
    @Column(name = "`nombre`")
    private String nombre;
    @Column(name = "`precio`")
    private Integer precio;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "`id_tipo_servicio`")
    private Integer idTipoServicio;
    @Size(max = 255)
    @Column(name = "`descripcion`")
    private String descripcion;
    @JoinColumn(name = "`id_servicio`", referencedColumnName = "`id_servicio`")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Servicio idServicio;

    public TipoDeServicio() {
    }

    public TipoDeServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getIdTipoServicio() {
        return idTipoServicio;
    }

    public void setIdTipoServicio(Integer idTipoServicio) {
        this.idTipoServicio = idTipoServicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Servicio getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Servicio idServicio) {
        this.idServicio = idServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoServicio != null ? idTipoServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDeServicio)) {
            return false;
        }
        TipoDeServicio other = (TipoDeServicio) object;
        if ((this.idTipoServicio == null && other.idTipoServicio != null) || (this.idTipoServicio != null && !this.idTipoServicio.equals(other.idTipoServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lp2.proyecto2.modelo.TipoDeServicio[ idTipoServicio=" + idTipoServicio + " ]";
    }
    
}
