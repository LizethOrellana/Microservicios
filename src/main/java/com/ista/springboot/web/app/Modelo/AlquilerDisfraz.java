package com.ista.springboot.web.app.Modelo;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class AlquilerDisfraz implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alquiler;
	
	@Column(name="fecha_prestamo")
	@Temporal(TemporalType.DATE)
	private Date fecha_prestamo;
	
	@Column(name="fecha_devolucion")
	@Temporal(TemporalType.DATE)
	private Date fecha_devolucion;
	
	private String comentarios_alquiler;
	private Integer cantidad_disfraces;
	private Integer total_alquiler;
	
	@ManyToOne
	@JoinColumn(name="id_cliente", referencedColumnName = "id_cliente")
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(name = "id_disfraz", referencedColumnName = "id_disfraz")
	private Disfraz disfraz;
 
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Disfraz getDisfraz() {
		return disfraz;
	}
	public void setDisfraz(Disfraz disfraz) {
		this.disfraz = disfraz;
	}
	public Long getId_alquiler() {
		return id_alquiler;
	}
	public void setId_alquiler(Long id_alquiler) {
		id_alquiler = id_alquiler;
	}
	
	public Date getFecha_prestamo() {
		return fecha_prestamo;
	}
	public void setFecha_prestamo(Date fecha_prestamo) {
		this.fecha_prestamo = fecha_prestamo;
	}
	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}
	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}
	public String getComentarios_alquiler() {
		return comentarios_alquiler;
	}
	public void setComentarios_alquiler(String comentarios_alquiler) {
		this.comentarios_alquiler = comentarios_alquiler;
	}
	public Integer getCantidad_disfraces() {
		return cantidad_disfraces;
	}
	public void setCantidad_disfraces(Integer cantidad_disfraces) {
		this.cantidad_disfraces = cantidad_disfraces;
	}
	public Integer getTotal_alquiler() {
		return total_alquiler;
	}
	public void setTotal_alquiler(Integer total_alquiler) {
		this.total_alquiler = total_alquiler;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
