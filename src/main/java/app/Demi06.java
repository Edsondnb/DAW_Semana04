package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demi06 {

	public static void main(String[] args) {
		// Listado de todos los usuarios
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		//establcer parametros
		List<Usuario> lstUsuarios = consulta.getResultList();
		
		//recorriendo la consulta
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		}
		
		//Cierre
		em.close();
		System.out.println("Ternimo el listado de usuarios.....");	

	}

}
