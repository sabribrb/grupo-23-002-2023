package com.unla.repositories;

import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.List;

import com.unla.entities.Banio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unla.entities.Alumbrado;
import com.unla.entities.Banio;
import com.unla.entities.Dispositivo;
import com.unla.entities.Estacionamiento;
import org.springframework.web.bind.annotation.ModelAttribute;


@Repository("dispositivoRepository")
public interface IDispositivoRepository extends JpaRepository<Dispositivo, Serializable> {

	public Dispositivo findByIdDispositivo(int idDispositivo);

	
	@Query("SELECT e FROM Estacionamiento e")
	public List<Estacionamiento> getAllEstacionamiento();
	
	@Query("SELECT e FROM Estacionamiento e WHERE DATE(e.creacion) = :creacion")
    List<Estacionamiento> findEstacionamientosByFecha(@Param("creacion") LocalDateTime creacion);

	
	@Query("SELECT e FROM Estacionamiento e WHERE e.activo = (:activo)")
	 List<Estacionamiento> findEstacionamientosByEnabled(@Param("activo") boolean activo); 

	@Query("SELECT b FROM Banio b")
	public List<Banio> getAllBanios();
	
	@Query("SELECT a FROM Alumbrado a WHERE a.activo = (:activo)")
	 List<Alumbrado> findAlumbradosByEnabled(@Param("activo") boolean activo); 

	//public Dispositivo findByNombreDispositivo(String nombre);

}
