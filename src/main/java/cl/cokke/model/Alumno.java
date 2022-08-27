package cl.cokke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor //lombok
@AllArgsConstructor //lombok
@Data //lombok
@Entity //jpa
@Table(name = "alumno") //jpa
@SequenceGenerator(name = "SQ_ALUMNO",initialValue = 1,allocationSize = 1,sequenceName = "SQ_ALUMNO")//ORACLE jpa
public class Alumno {

	@Id //jpa
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_ALUMNO") //jpa
	private Integer id;
	@Column(nullable = false, unique = true)
	private String rut;
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String apellido;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private Integer edad;
	@Column(nullable = false)
	private String fechaIngreso;
	@OneToOne
    @JoinColumn(name = "direccion_id", referencedColumnName = "id", nullable = false)
	private Direccion direccion;
	
	
	
}
