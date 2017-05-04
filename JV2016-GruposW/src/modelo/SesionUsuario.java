/** 
 * Proyecto: Juego de la vida.
 * Implementa el concepto de SesionUsuario según el modelo 2.
 * @since: prototipo1.0
 * @source: SesionUsuario.java 
 * @version: 2.0 - 2017.03.20
 * @author: ajp, AIS
 */

package modelo;

import java.io.Serializable;

import util.Fecha;

public class SesionUsuario implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	private Usuario usr;  
	private Fecha fecha; 
	public enum EstadoSesion { EN_PREPARACION, ACTIVA, CERRADA }
	private EstadoSesion estado;

	/**
	 * @param usr
	 * @param fecha
	 */
	public SesionUsuario(Usuario usr, Fecha fecha, EstadoSesion estado){
		
		setUsr(usr);
		setFecha(fecha);
		setEstado(estado);
		
	}

	public SesionUsuario() throws ModeloException {
		this(new Usuario(), new Fecha(), EstadoSesion.EN_PREPARACION);
	}

	public SesionUsuario(SesionUsuario su) throws ModeloException {
		this(su.usr, new Fecha(su.fecha), su.estado);
	}

	// Métodos de acceso

	public Usuario getUsr() {
		return usr;
	}

	public Fecha getFecha() {
		return fecha;
	}

	public EstadoSesion getEstado() {
		return estado;
	}
	/**
	 * Obtiene idSesion concatenando idUsr + un n�mero como texto:
	 * @return idSesion �nico generado.
	 */
	public String getIdSesion() {
		return	usr.getIdUsr() + "-" + fecha.getAño() + fecha.getMes() + fecha.getDia() 
		+ fecha.getHora() + fecha.getMinuto() + fecha.getSegundo();
	}

	public void setUsr(Usuario usr) {
		assert usr != null;
		this.usr = usr;
	}

	public void setFecha(Fecha fecha) {
		assert fechaSesionValida(fecha);
		this.fecha = fecha;
	}

	/**
	 * Comprueba validez de una fecha.
	 * @param fecha.
	 * @return true si cumple.
	 */
	private boolean fechaSesionValida(Fecha fecha){
		if (fecha != null
				&& fechaSesionCoherente(fecha)) {
			return true;
		}
		if(!fecha.getClass().equals(fecha)){
			new ModeloException("fecha no es de tipo fecha");
		}
		return false;
	}

	/**
	 * Comprueba coherencia de una fecha de sesión.
	 * @param fecha.
	 * @return true si cumple.
	 */
	private boolean fechaSesionCoherente(Fecha fecha) {
		// Comprueba que fechaSesion no es, por ejemplo, del futuro
		// --Pendiente--
		assert fecha!=null;
		return true;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoSesion estado) {
		assert estado!=null;
		this.estado = estado;
	}

	/**
	 * Redefine el método heredado de la clase Objecto.
	 * @return el texto formateado del estado (valores de atributos) 
	 * del objeto de la clase SesionUsuario  
	 */
	@Override
	public String toString() {
		return String.format("SesionUsuario \n[usr=%s, \nfecha=%s, \nestado=%s]",
				usr, fecha, estado);
	}

	/**
	 * hashCode() complementa al método equals y sirve para comparar objetos de forma 
	 * rápida en estructuras Hash. 
	 * Cuando Java compara dos objetos en estructuras de tipo hash (HashMap, HashSet etc)
	 * primero invoca al método hashcode y luego el equals.
	 * @return un número entero de 32 bit.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
			int result = 1;
			result = prime * result + ((estado == null) ? 0 : estado.hashCode());
			result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
			result = prime * result + ((usr == null) ? 0 : usr.hashCode());
		return result;
	}

	/**
	 * Dos objetos son iguales si: 
	 * Son de la misma clase.
	 * Tienen los mismos valores en los atributos; o son el mismo objeto.
	 * @return falso si no cumple las condiciones.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj != null && getClass() == obj.getClass()) {
			if (this == obj) {
				return true;
			}
			if (usr.equals(((SesionUsuario)obj).usr) &&
					fecha.equals(((SesionUsuario)obj).fecha) &&
					estado.equals(((SesionUsuario)obj).estado) 
					) {
				return true;
			}
		}
		if(obj==null){
			new ModeloException("el objeto es null ingrese otro");
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() {
		Object copia=null;
		try{
			copia=new SesionUsuario(this);
		} catch (ModeloException e){}
		return copia;
	}

} // class
