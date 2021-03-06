package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vos.Cliente;
import vos.ContratoApto;
import vos.ContratoHabitacion;
import vos.ContratoVivienda;
import vos.Habitacion;
import vos.PersonaOperador;
import vos.RFC1;
import vos.RFC1;

public class DAORFC1 {

	//----------------------------------------------------------------------------------------------------------------------------------
	// CONSTANTES
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Constante para indicar el usuario Oracle del estudiante
	 */
	public final static String USUARIO = "ISIS2304A791810";


	//----------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Arraylits de recursos que se usan para la ejecucion de sentencias SQL
	 */
	private ArrayList<Object> recursos;

	/**
	 * Atributo que genera la conexion a la base de datos
	 */
	private Connection conn;

	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS DE INICIALIZACION
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo constructor de la clase DAORFC1 <br/>
	 */
	public DAORFC1() {
		recursos = new ArrayList<Object>();
	}

	public ArrayList<RFC1> getDineroOperadores() throws SQLException
	{

		String sql = String.format("SELECT co.NOMBRE, ing.ingreso\r\n" + 
				"FROM\r\n" + 
				"(SELECT aco.COMUNIDADID, SUM(r.PRECIO) AS ingreso\r\n" + 
				"FROM\r\n" + 
				"(SELECT ao.COMUNIDADID, rha.RESERVAID\r\n" + 
				"FROM %1$s.RESERVASHISTORICASAPTOS rha,\r\n" + 
				"(SELECT a.APARTAMENTOID, a.COMUNIDADID\r\n" + 
				"FROM %1$s.APARTAMENTO a) ao\r\n" + 
				"WHERE ao.APARTAMENTOID = rha.APTOID\r\n" + 
				"UNION\r\n" + 
				"SELECT vo.COMUNIDADID, rhv.RESERVAID\r\n" + 
				"FROM %1$s.RESERVASHISTORICASVIVIENDAS rhv,\r\n" + 
				"(SELECT v.VIVIENDAID, v.COMUNIDADID\r\n" + 
				"FROM %1$s.VIVIENDA v) vo\r\n" + 
				"WHERE vo.VIVIENDAID=rhv.VIVIENDAID\r\n" + 
				"UNION\r\n" + 
				"SELECT ho.COMUNIDADID, rhh.RESERVAID\r\n" + 
				"FROM %1$s.RESERVASHISTORICASHABITACIONES rhh,\r\n" + 
				"(SELECT h.HABITACIONID, h.COMUNIDADID\r\n" + 
				"FROM %1$s.HABITACION h) ho\r\n" + 
				"WHERE ho.HABITACIONID=rhh.HABITACIONID) aco, %1$s.RESERVA r\r\n" + 
				"WHERE aco.RESERVAID=r.RESERVAID\r\n" + 
				"GROUP BY aco.COMUNIDADID) ing, %1$s.COMUNIDAD co\r\n" + 
				"WHERE ing.COMUNIDADID=co.COMUNIDADID", USUARIO); 
		
		PreparedStatement prepStmt = conn.prepareStatement(sql);
		

		recursos.add(prepStmt);
		ResultSet rs = prepStmt.executeQuery();
		System.out.println("Sentencia = "+rs);
		ArrayList<RFC1> reservas = new ArrayList<>();

		while (rs.next()) {
			System.out.println("entra al next RFC1");

			RFC1 reserva = convertResultSetToReserva(rs);

			if(reserva!= null)
			reservas.add(reserva);
		}
		return reservas;

	}
	
	

	//----------------------------------------------------------------------------------------------------------------------------------
	// METODOS AUXILIARES
	//----------------------------------------------------------------------------------------------------------------------------------

	/**
	 * Metodo encargado de inicializar la conexion del DAO a la Base de Datos a partir del parametro <br/>
	 * <b>Postcondicion: </b> el atributo conn es inicializado <br/>
	 * @param connection la conexion generada en el TransactionManager para la comunicacion con la Base de Datos
	 */
	public void setConn(Connection connection){
		this.conn = connection;
	}


	/**
	 * Metodo que cierra todos los recursos que se encuentran en el arreglo de recursos<br/>
	 * <b>Postcondicion: </b> Todos los recurso del arreglo de recursos han sido cerrados.
	 */
	public void cerrarRecursos() {
		for(Object ob : recursos){
			if(ob instanceof PreparedStatement)
				try {
					((PreparedStatement) ob).close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
		}
	}


	/**
	 * Metodo que transforma el resultado obtenido de una consulta SQL (sobre la tabla RESERVAS) en una instancia de la clase Cliente	 * @param resultSet ResultSet con la informacion de un bebedor que se obtuvo de la base de datos.
	 * @return Reserva cuyos atributos corresponden a los valores asociados a un registro particular de la tabla Reservas.
	 * @throws SQLException Si existe algun problema al extraer la informacion del ResultSet.
	 */
	public RFC1 convertResultSetToReserva(ResultSet resultSet) throws SQLException {


		RFC1 rfc1 = null;

		String nombre = resultSet.getString("NOMBRE");
		int ingreso = resultSet.getInt("INGRESO");

		rfc1 = new RFC1(nombre, ingreso);

		return rfc1;
	}
}
