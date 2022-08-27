package cl.cokke.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.cokke.model.Alumno;
import cl.cokke.repository.AlumnoRepository;

@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	private AlumnoRepository dao; //Aca llamamos al REPOSITORY!!!

	@Override
	@Transactional(readOnly = true)
	public List<Alumno> findAllAlumno() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public Alumno save(Alumno alumno) {
		// TODO Auto-generated method stub
		return dao.save(alumno);
	}

	@Override
	@Transactional
	public void update(Alumno alumno) {
		dao.save(alumno);
	}

	@Override
	public void delete(Alumno alumno) {
		dao.delete(alumno);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Alumno> findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
}