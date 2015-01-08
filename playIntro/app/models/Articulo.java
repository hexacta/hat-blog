package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Query;
import javax.persistence.Table;

import play.db.jpa.JPA;

@Entity
@Table(name = "ARTICULO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Articulo {

	@Column(name = "CODIGO", precision = 10, nullable = false, columnDefinition = "NUMBER(10)")
	@Id
	private Integer codigo;
	
	@Column(name = "NOMBRE", length = 30, nullable = false)
	private String nombre;

	
	public static Articulo findById(int codigo) {
		return JPA.em().find(Articulo.class, codigo);
	}
	
	public static List<Articulo> getAll() {		
		Query query = JPA.em().createQuery("select a from Articulo a");
	    List<Articulo> articulos = query.getResultList();
		return articulos;
	}
	
	

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return this.getNombre();
	}
}
