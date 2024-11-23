package com.example;

import com.example.Entidad.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadPersistencia");

    public static void main(String[] args) {
        crearCliente("Isabella Pedraza", "iszp999@gmail.com", 32225072931);
        Cliente cliente1 = leerCliente(1L);
        if (cliente1 != null){
            System.out.println("El cliente fue encontrado: " + cliente1.getNombre());
        }
        actualizarCliente(1L, "Jhon Jairo Updated", "jhonupdated@gmail.com", 3215874622);
        eliminarCliente(1L);
    }

    // Crear cliente
    public static void crearCliente(String nombre, String email, int telefono){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Cliente cliente1 = new Cliente();
        cliente1.setNombre(nombre);
        cliente1.setEmail(email);
        cliente1.setTelefono(telefono);

        em.persist(cliente1);
        em.getTransaction().commit();
        em.close();
    }

    // Leer cliente
    public static Cliente leerCliente(long id){
        EntityManager em = emf.createEntityManager();
        Cliente cliente1 = em.find(Cliente.class, id);
        em.close();
        return cliente1;
    }

    // Actualizar cliente
    public static void actualizarCliente(long id, String nuevoNombre, String nuevoEmail, int nuevoTelefono){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Cliente cliente1 = em.find(Cliente.class, id);
        if (cliente1 != null){
            cliente1.setNombre(nuevoNombre);
            cliente1.setEmail(nuevoEmail);
            cliente1.setTelefono(nuevoTelefono);
            em.merge(cliente1);
        }
        em.getTransaction().commit();
        em.close();
    }

    // Eliminar cliente
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
