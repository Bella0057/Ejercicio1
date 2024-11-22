package com.example;

import com.example.Entidad.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        crearCliente("jhon jairo", "jhonpro@gmail.com", 3215874621);
        cliente cliente1 = leerCliente(1l);
        if (cliente1 != null){
            System.out.println("El cliente fue encontrado: " + Cliente.getNombre)
        }
        actualizarCliente(1l);
        eliminarCliente(1l);
    }

    //crear cliente
    public static void crearCliente(String nombre, String email, int telefono){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Cliente cliente1 = new Cliente();
    cliente1.setNombre(nombre)
    cliente1.setEmail(email)
    cliente1.setTelefono(telefono)

    em.persist(cliente1)
    em.getTransaction().commit();
    em.close();
    }

    //leer cliente
    public static void leerCliente(long id){
        EntityManager em = emf.createEntityManager();
    Cliente cliente1 = em.find(Cliente.class, id);
    em.close();
    return cliente1;
    }

    //actualizar cliente
    public static void actualizarCliente (long id, String nuevoNombre, String nuevoEmail, int nuevoTelefono){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Cliente cliente1 = em.find(Cliente.class, id);
        if (cliente1 != null){
            Cliente.setNombre(nuevoNombre);
            Cliente.setEmail(nuevoEmail);
            Cliente.setTelefono(nuevoTelefono);
            em.merge(cliente1);
        }
        em.getTransaction().commit();
        em.close();
    }

    //Eliminar clientes
    public static void eliminarCliente(long id){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Cliente cliente1 = em.find(Cliente.class, id);
        if (cliente1 != null){
            em.remove(cliente1);
        }

        em.getTransaction().commit();
        em.close();
    }
}