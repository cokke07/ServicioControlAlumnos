package cl.cokke.services;

import java.util.List;
import java.util.Optional;

import cl.cokke.model.Alumno;

public interface AlumnoService {

	public List<Alumno> findAllAlumno();
	public Alumno save(Alumno alumno);
	public void update(Alumno alumno);
	public void delete(Alumno alumno);
	public Optional<Alumno> findById(Integer id);
}
