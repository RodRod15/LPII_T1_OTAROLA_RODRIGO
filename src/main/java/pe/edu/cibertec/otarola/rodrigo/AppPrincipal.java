package pe.edu.cibertec.otarola.rodrigo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import pe.edu.cibertec.otarola.rodrigo.Persona;
import pe.edu.cibertec.otarola.rodrigo.Rol;
import pe.edu.cibertec.otarola.rodrigo.Usuario;

public class AppPrincipal {

	public static void main(String[] args) {
		
		int opcion = 0;
		Scanner scanner = new Scanner(System.in);
		Persona persona;
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("CRUD");
		EntityManager manager = factory.createEntityManager();
		
		
		//El CRUD siguiente es para la tabla Persona. Ejecutar esta clase para ver las opciones en la Consola.
		
		while (opcion != 5) {
			
			System.out.println("1. Crear persona");	
			System.out.println("2. Buscar persona");	
			System.out.println("3. Actualizar persona");	
			System.out.println("4. Eliminar persona");	
			System.out.println("5. Salir");	
			System.out.println("Elegir opción: ");
			
			opcion = scanner.nextInt();
				
				switch (opcion) {
				case 1:
					System.out.println("Digite el nombre de la persona: ");
					persona = new Persona();
					scanner.nextLine();
					persona.setNombre(scanner.nextLine());
					
					System.out.println("Digite el apellido de la persona: ");
					persona.setApellido(scanner.nextLine());
					
					System.out.println("Digite el correo de la persona: ");
					persona.setCorreo(scanner.nextLine());
					
					manager.getTransaction().begin();
					manager.persist(persona);
					manager.getTransaction().commit();
					
					System.out.println("Persona registrada");
					System.out.println();
					break;
					
				case 2:
					
					System.out.println("Digite el ID de la persona a buscar: ");
					persona = new Persona();
					persona = manager.find(Persona.class, scanner.nextInt());
					if(persona != null) {
						
						System.out.println("ID: " + persona.getIdperson());
						System.out.println("Nombre: " + persona.getNombre());
						System.out.println("Apellido: " + persona.getApellido());
						System.out.println("Correo: " + persona.getCorreo());
						System.out.println();
						
					}else {
						System.out.println();
						System.out.println("Persona no encontrada. Lista de personas registradas: ");
						List<Persona> listaPersonas = new ArrayList<>();
						Query query = manager.createQuery("SELECT p FROM Persona p");
						listaPersonas = query.getResultList();
						for(Persona p : listaPersonas) {
							
							System.out.println("ID: " + p.getIdperson());
							System.out.println("Nombre: " + p.getNombre());
							System.out.println("Apellido: " + p.getApellido());
							System.out.println("Correo:" + p.getCorreo());
							System.out.println();
						}
						
						
						System.out.println();
						
					}
					
					break;
				
				case 3:
					
					System.out.println("Digite el ID de la persona a actualizar: ");
					persona = new Persona();
					
					persona = manager.find(Persona.class, scanner.nextInt());
					if(persona != null) {
						
						System.out.println(persona.getNombre());
						System.out.println(persona.getApellido());
						System.out.println("Digite el nuevo nombre: ");
						scanner.nextLine();
						
						persona.setNombre(scanner.nextLine());
						System.out.println("Digite el nuevo apellido: ");
						persona.setApellido(scanner.nextLine());
						
						System.out.println("Digite el nuevo correo: ");
						persona.setCorreo(scanner.nextLine());
						
						manager.getTransaction().begin();
						manager.merge(persona);
						manager.getTransaction().commit();
						
						System.out.println("Persona registrada");
						System.out.println();
						
					}else {
						
						System.out.println("Persona no encontrada");
						System.out.println();
						
					}
					
					break;
					
				case 4:
					
					System.out.println("Digite el ID de la persona a eliminar: ");
					
					persona = new Persona();
					persona = manager.find(Persona.class, scanner.nextInt());
					
					
					if (persona != null) {
						
						manager.getTransaction().begin();
						manager.remove(persona);
						manager.getTransaction().commit();
						
						System.out.println("Persona eliminada");
						
						
					} else {
						
						System.out.println("Persona no encontrada");
						
					}
					
					break;
					
				case 5:
					System.out.println();
					scanner.close();
						
				}
			
		}
		
		
		try {
			
				System.out.println("Sesión cerrada");
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
