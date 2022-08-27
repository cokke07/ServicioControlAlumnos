package cl.cokke.services;

import java.util.List;

import cl.cokke.model.Direccion;

public interface DireccionService {

	public List<Direccion> findAllDireccion();
	public void save(Direccion direccion);
	
}
