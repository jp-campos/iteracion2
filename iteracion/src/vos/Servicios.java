package vos;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Clase que representa los servicios de un alojamiento
 * @author jp.campos
 
 	{
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
 	}
 	
 
 
 
 */


public class Servicios {

	@JsonProperty(value="id")
	private int id; 
	
	@JsonProperty(value ="agua")
	private boolean agua; 
	
	@JsonProperty(value = "ba�era")
	private boolean ba�era; 
	
	@JsonProperty(value = "cocineta")
	private boolean cocineta;
	
	@JsonProperty(value = "parquedero")
	private boolean parquedero;
	
	
	@JsonProperty(value = "piscina")
	private boolean piscina;
	
	@JsonProperty(value = "recepcion24h")
	private boolean recepcion24h;
	
	@JsonProperty(value = "restaurante")
	private boolean restaurante;
	
	@JsonProperty(value = "sala")
	private boolean sala;
	
	@JsonProperty(value = "tv")
	private boolean tv;
	
	@JsonProperty(value = "wifi")
	private boolean wifi;
	
	@JsonProperty(value = "yacuzzi")
	private boolean yacuzzi;

	public Servicios(@JsonProperty(value = "id")int id, @JsonProperty(value ="agua")boolean agua, @JsonProperty(value = "ba�era")boolean ba�era, @JsonProperty(value = "cocineta")boolean cocineta,@JsonProperty(value = "parquedero") boolean parquedero, @JsonProperty(value = "piscina")boolean piscina,
			@JsonProperty(value = "recepcion24h")boolean recepcion24h,@JsonProperty(value = "restaurante") boolean restaurante, @JsonProperty(value = "sala")boolean sala,@JsonProperty(value = "tv") boolean tv, @JsonProperty(value = "wifi")boolean wifi,	@JsonProperty(value = "yacuzzi") boolean yacuzzi) {
	
		this.id = id; 
		this.agua = agua;
		this.ba�era = ba�era;
		this.cocineta = cocineta;
		this.parquedero = parquedero;
		this.piscina = piscina;
		this.recepcion24h = recepcion24h;
		this.restaurante = restaurante;
		this.sala = sala;
		this.tv = tv;
		this.wifi = wifi;
		this.yacuzzi = yacuzzi;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAgua() {
		return agua;
	}

	public void setAgua(boolean agua) {
		this.agua = agua;
	}

	public boolean isBa�era() {
		return ba�era;
	}

	public void setBa�era(boolean ba�era) {
		this.ba�era = ba�era;
	}

	public boolean isCocineta() {
		return cocineta;
	}

	public void setCocineta(boolean cocineta) {
		this.cocineta = cocineta;
	}

	public boolean isParquedero() {
		return parquedero;
	}

	public void setParquedero(boolean parquedero) {
		this.parquedero = parquedero;
	}

	public boolean isPiscina() {
		return piscina;
	}

	public void setPiscina(boolean piscina) {
		this.piscina = piscina;
	}

	public boolean isRecepcion24h() {
		return recepcion24h;
	}

	public void setRecepcion24h(boolean recepcion24h) {
		this.recepcion24h = recepcion24h;
	}

	public boolean isRestaurante() {
		return restaurante;
	}

	public void setRestaurante(boolean restaurante) {
		this.restaurante = restaurante;
	}

	public boolean isSala() {
		return sala;
	}

	public void setSala(boolean sala) {
		this.sala = sala;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public boolean isWifi() {
		return wifi;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
	}

	public boolean isYacuzzi() {
		return yacuzzi;
	}

	public void setYacuzzi(boolean yacuzzi) {
		this.yacuzzi = yacuzzi;
	}
	
	
	
	public boolean cumpleCondiciones(Servicios servicio)
	{
			
		 if(agua)
		 {
			 if(!servicio.agua)return false;
		 }
		 
		 if(ba�era)
		 {
			 if(!servicio.ba�era)return false;
		 }
		 
		 if(cocineta)
		 {
			 if(!servicio.cocineta) return false;
		 }
		 
		 if(parquedero)
		 {
			 if(!servicio.parquedero) return false;
		 }
		 
		 if(piscina)
		 {
			 if(!servicio.piscina)return false;
		 }
		 if(recepcion24h)
		 {
			 if(!servicio.recepcion24h)return false;
		 }
		 if(restaurante)
		 {
			 if(!servicio.restaurante)return false;
		 }
		 if(sala)
		 {
			 if(!servicio.sala)return false;
			 
		 }
		 if(tv)
		 {
			 if(!servicio.tv)return false;
		 }
		 
		 if (wifi) 
		 {
			if(!servicio.wifi)return false;
		 }
		 
		 if(yacuzzi)
		 {
			 if(!servicio.yacuzzi)return false;
		 }
		 
		 
		 return true;
		 
	}
	
	
	
	
	
	
}
