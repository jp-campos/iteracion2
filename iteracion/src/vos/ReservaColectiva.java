package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ReservaColectiva {
	

/**
 * Clase que representa una reserva
 * 
	El formato del archivo Json es
	
	{
	
	"reserva":{
		"fechaInicial": "13-03-2018", 
		"fechaFinal": "13-03-2018",
		"precio": 150, 
		"id": 1,
		"cliente" : null
	}, 
	 "servicios":{
 		"id": 1, 
 		"agua": true, 
 		"ba�era": true, 
 		"cocineta": false, 
 		"parquedero": true, 
 		"piscina": true, 
 		"recepcion24h": false, 
 		"restaurante" : true, 
 		"sala": false, 
 		"tv": true, 
 		"wifi": true, 
 		"yacuzzi": false
 	},
 	"descripcion": "Habitaci�n Sencilla", 
 	"id": 1,
 	"numeroReservas":10,
 	"clienteId": 4
 	}
	
 * @author jp.campos
 *
 */
	
	
	@JsonProperty(value="descripcion")
	private String descripcion;
	
	

	@JsonProperty(value="clienteId")
	private int clienteId;
	
	
	@JsonProperty(value="numeroReservas")
	private int numeroReservas;
	
	
	@JsonProperty(value="servicios")
	private Servicios servicios ;
	
	
	@JsonProperty(value="id")
	private int id;

	@JsonProperty(value="reserva")
	private Reserva reserva;
	
	@JsonProperty(value="contratoApto")
	private ContratoApto contratoApto;
	
	
	public ReservaColectiva(@JsonProperty(value="contratoApto")ContratoApto contratoApto, @JsonProperty(value="clienteId")int clienteId, @JsonProperty(value="reserva") Reserva reserva,@JsonProperty(value="descripcion")String descripcion, @JsonProperty(value="numeroReservas")int numeroReservas, @JsonProperty(value="servicios")Servicios servicios,@JsonProperty(value="id") int id) {
		super();
		this.contratoApto = contratoApto; 
		this.reserva = reserva;
		this.descripcion = descripcion;
		this.numeroReservas = numeroReservas;
		this.servicios = servicios;
		this.id = id;
		this.clienteId= clienteId; 
	}


	
	
	
	
	
	public ContratoApto getContratoApto() {
		return contratoApto;
	}


	public void setContratoApto(ContratoApto contratoApto) {
		this.contratoApto = contratoApto;
	}







	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}


	public Reserva getReserva() {
		return reserva;
	}


	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public int getNumeroReservas() {
		return numeroReservas;
	}


	public void setNumeroReservas(int numeroReservas) {
		this.numeroReservas = numeroReservas;
	}


	public Servicios getServicios() {
		return servicios;
	}


	public void setServicios(Servicios servicios) {
		this.servicios = servicios;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
	
	
	
	
	

}
