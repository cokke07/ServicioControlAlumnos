package cl.cokke.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name = "SQ_DIRECCION", initialValue = 1, allocationSize = 1,sequenceName = "SQ_DIRECCION")
public class Direccion {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "SQ_DIRECCION")
	private Integer id;
	@Column(nullable= false)
	private String calle;
	@Column(nullable= false)
	private String numero;
	@Column(nullable= false)
	private String ciudad;
	@Enumerated(EnumType.STRING)
	@Column(nullable= false)
	private TipoDireccion tipo;
}
