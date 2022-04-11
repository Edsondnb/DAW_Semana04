package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demi03 {

	public static void main(String[] args) {
		
		/* elimina usuario */
		
		//Fabrica => DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		//3. empezar mi transaccion --> regis, actu o eliminar
		em.getTransaction().begin();
			
		//4. eliminar ==> 1. eliminacion logica ==> actualizar estados
						 //2. eliminacion total ==> 
		Usuario u = new Usuario();
		u.setCodigo(13);
		
		em.remove(u); //ojo.. Necesita un objeto que se debe devolver
		
		//5.confirmacion
		em.getTransaction().commit();
		
		
		//6. confirmar la transaccion
		em.close();
		System.out.println("Ternimo Eliminacion.....");

	}

}
