package com.unla.entities;

import java.time.LocalDateTime;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="Alumbrado")
public class Alumbrado extends Dispositivo{

	@Column(name="numAula")
	private int numAula;
	
	public Alumbrado() {}

	public Alumbrado(String nombre, LocalDateTime creacion, boolean activo, Set<Evento> eventos, int numAula) {
		super(nombre, creacion, activo, eventos);
		this.numAula = numAula;
	}
}
