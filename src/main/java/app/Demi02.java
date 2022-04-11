package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demi02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//agrendao un nuevo usuario
		Usuario u = new Usuario();
		u.setCodigo(13);
		u.setNombre("Carla");
		u.setApellido("Toro");
		u.setUsuario("U013@gmail.com");
		u.setClave("10002");
		u.setFchnacim("2022-03-21");
		u.setTipo(2);
		u.setEstado(1);
		
		//proceso de registro
		
		//1. fabrica el acceso de datos
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//2. crea el manejador de entidades
		EntityManager em = fabrica.createEntityManager();
		
		try {
			//3. empezar mi transaccion
			em.getTransaction().begin();
			
			//4. actualizar usuarios
			em.merge(u);
			
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("error al actulizar usuario");
			/* em.getTransaction().rollback(); */
		}
		
		//5. confirmar la transaccion
		em.close();
		System.out.println("Ternimo.....");
		
	}
	

}
