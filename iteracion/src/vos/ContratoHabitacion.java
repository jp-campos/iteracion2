package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa un contrato de habitaci�n
 * @author jp.campos
 *
 */
public class ContratoHabitacion extends Reserva{
	
	@JsonProperty(value="accesoCocina")
	private boolean accesoCocina;

	
	@JsonProperty(value="ba�oPrivado")
	private boolean ba�oPrivado;
	
	@JsonProperty(value="comidas")
	private boolean comidas;
	
	@JsonProperty(value="duracion")
	private int duracion;
	
	@JsonProperty(value="habitacionIndividual")
	private boolean habitacionIndividual;
	
	@JsonProperty(value="precioServicios")
	private int precioServicios;
	
	@JsonProperty(value="habitacion")
	private Habitacion habitacion;
	
	

	
	public ContratoHabitacion(@JsonProperty(value="id")int id,@JsonProperty(value = "fechaInicial")String fechaInicial, @JsonProperty(value = "fechaFinal")String fechaFinal,@JsonProperty(value = "precio")int precio,	@JsonProperty(value="accesoCocina")boolean accesoCocina,@JsonProperty(value="ba�oPrivado") boolean ba�oPrivado,
			@JsonProperty(value="comidas")boolean comidas, @JsonProperty(value="duracion")int duracion,
			@JsonProperty(value="habitacionIndividual")boolean habitacionIndividual, @JsonProperty(value="precioServicios")int precioServicios) {
		
		super(id, fechaInicial, fechaFinal, precio);
		
		this.accesoCocina = accesoCocina;
		this.ba�oPrivado = ba�oPrivado;
		this.comidas = comidas;
		this.duracion = duracion;
		this.habitacionIndividual = habitacionIndividual;
		this.precioServicios = precioServicios;
		
		habitacion = null;
	}

	
	public Habitacion getHabitacion() {
		return habitacion;
	}


	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}


	public boolean isAccesoCocina() {
		return accesoCocina;
	}

	public void setAccesoCocina(boolean accesoCocina) {
		this.accesoCocina = accesoCocina;
	}

	public boolean isBa�oPrivado() {
		return ba�oPrivado;
	}

	public void setBa�oPrivado(boolean ba�oPrivado) {
		this.ba�oPrivado = ba�oPrivado;
	}

	public boolean isComidas() {
		return comidas;
	}

	public void setComidas(boolean comidas) {
		this.comidas = comidas;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isHabitacionIndividual() {
		return habitacionIndividual;
	}

	public void setHabitacionIndividual(boolean habitacionIndividual) {
		this.habitacionIndividual = habitacionIndividual;
	}

	public int getPrecioServicios() {
		return precioServicios;
	}

	public void setPrecioServicios(int precioServicios) {
		this.precioServicios = precioServicios;
	}

	
	
	
}
