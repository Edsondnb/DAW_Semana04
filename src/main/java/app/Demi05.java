package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demi05 {

	public static void main(String[] args) {
		// mejorar Eliminar
		

			EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			EntityManager em = fabrica.createEntityManager();
				

			//select * from where id = ?
			Usuario u =  new Usuario();
			u.setCodigo(13);
			
			if (em.find(Usuario.class, u.getCodigo()) == null) {
				System.out.println("Usurio no existe");
			} else {
				em.getTransaction().begin();
				em.remove(em.find(Usuario.class, u.getCodigo()));
				em.getTransaction().commit();
				System.out.println("Usuario eliminado correctamente");
			}

			//Cierre
			em.close();
			System.out.println("Ternimo la eliminacion .....");	

	}

}
