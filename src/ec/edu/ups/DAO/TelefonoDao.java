package ec.edu.ups.DAO;

import ec.edu.ups.modelo.Telefono;

public interface TelefonoDao extends GenericDAO<Telefono, Integer> {
	public int contadorTelefono();
}
