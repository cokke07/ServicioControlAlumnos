package cl.cokke.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.cokke.model.Direccion;
import cl.cokke.repository.DireccionRepository;

@Service
public class DireccionServiceImp implements DireccionService {

	@Autowired
    private DireccionRepository dao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Direccion> findAllDireccion() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	@Transactional
	public void save(Direccion direccion) {
		dao.save(direccion);
	}

}
