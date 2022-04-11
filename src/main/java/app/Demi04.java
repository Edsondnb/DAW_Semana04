package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demi04 {

	public static void main(String[] args) {
		// Encontrar y devolver los datos de un usuario, Segun su codigo
		

		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		//select * from where id = ?
		Usuario u =  em.find(Usuario.class, 10);
		
		if (u == null) {
			System.out.println("Usuario no encontrado");
		}else {
			System.out.println(u);			
		}		

		//Cierre
		em.close();
		System.out.println("Ternimo Busqueda .....");

	}

}
