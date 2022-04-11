package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demi01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//agrendao un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(10);
		u.setNombre("Edler");
		u.setApellido("Oliver");
		u.setUsuario("edler@gmail.com");
		u.setClave("edler");
		u.setFchnacim("2000-01-25");
		u.setTipo(1);
		u.setEstado(1);
		
		//proceso de registro
		
		//1. fabrica el acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		try {
			//3. empezar mi transaccion
			em.getTransaction().begin();
			
			//4. Registrar usuarios
			em.persist(u);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("error al registrar usuario");
			/* em.getTransaction().rollback(); */
		}
		
		//5. confirmar la transaccion
		em.close();
		System.out.println("Ternimo.....");
		
	}
	

}
