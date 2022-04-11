package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demio7 {
	
	public static void main(String[] args) {
		
		/* listar usuarios segun el tipo */
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		// select * from tb_usuarios ehre idtipo = ?
		TypedQuery<Usuario> consulta = em.createQuery("SELECT u FROM Usuario u where tipo = :xtipo", Usuario.class);
		//establcer parametros
		consulta.setParameter("xtipo",1);
		List<Usuario> lstUsuarios = consulta.getResultList();
		
		//recorriendo la consulta
		for (Usuario u : lstUsuarios) {
			System.out.println(u);
		}
		
		//Cierre
		em.close();
		System.out.println("Ternimo el listado de usuarios por TIPO.....");
		
		
	}

}
