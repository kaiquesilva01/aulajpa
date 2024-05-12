package application;

import dominio.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();
            //ADICIONAR TABELA
        Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
        Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
        Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");


        em.getTransaction().begin();
        em.persist(p1);
        em.persist(p2);
        em.persist(p3);
        em.getTransaction().commit();
        //PROCURAR POR ID
        Pessoa p4 = em.find(Pessoa.class,2);




        // PARA REMOÇÃO PRECISA SER UMA ENTIDADE MONITORADA ( ACABADO DE SER INSERIDA OU RECUPERADA DO BANCO DE DADOS
        // EXEMPLO "find"
        Pessoa p5 = em.find(Pessoa.class, 2);
        em.getTransaction().begin();
        em.remove(p5);
        em.getTransaction().commit();

    }
}