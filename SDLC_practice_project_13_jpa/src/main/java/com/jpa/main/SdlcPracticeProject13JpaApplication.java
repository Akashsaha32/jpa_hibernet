package com.jpa.main;


import com.jpa.main.dao.StudentDAO;
import com.jpa.main.entity.Student;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.function.Consumer;

@SpringBootApplication
public class SdlcPracticeProject13JpaApplication {
    final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pgsql-unit");
    static final EntityManager em = emf.createEntityManager();

    /*@Autowired
    private StudentDAO studentDAO;
    @Autowired
    private EntityManager entityManager;*/

    public static void main(String[] args) {
        //Learn From EntityManager

        /*Student st = new Student();
        st.setName("Akash saha");
        st.setCgpa(3.28f);

        em.getTransaction().begin(); //for every em 1 Transaction
        em.persist(st); // for hold data in Cache
        em.getTransaction().commit(); // for save data in db
        em.close();
        emf.close();*/

        //var s2 = new Student(10, "Akash saha", 3.99f);

        //transaction(em -> {

            /*Query q = em.createQuery("select s from Student s where s.id=1");
            Student s = (Student) q.getSingleResult();
            System.out.println(s);

            q = em.createQuery("select s from Student s");
            q.setFirstResult(2);
            q.setMaxResults(2);

            q.getResultList().forEach(ss -> System.out.println(ss));*/

            /*em.createQuery("select s from Student s", Student.class)
                    .setFirstResult(1)
                    .setMaxResults(3)
                    .getResultList()
                    .forEach(System.out::println);*/

            /*Student s = new Student();
            s.setName("Karim sir");
            s.setCgpa(3.44f);
            em.persist(s);
            s.setName("ABC DEF");*/

            /*var map = em.getProperties();
            map.forEach((k, v) -> System.out.println(k + " => "+v));*/

            //var s = em.find(Student.class, 7);
            /*System.out.println(em.contains(s));
            System.out.println(em.contains(s2));
            s.setCgpa(3.33f);
            em.detach(s);
            em.merge(s);
            s.setName("Akash Saha");*/
            /*if(em.contains(s)) {
                em.remove(s);
            }*/
            //var s1 = em.getReference(Student.class, 9);

            //System.out.println(s);
            //System.out.println(s1);

        //});
// lecture 58
        transaction((em) -> {

        });
    }

    static void transaction(Consumer<EntityManager> consumer){
        em.getTransaction().begin(); //before advice
        try {
            consumer.accept(em);
        }catch (Exception e){
            em.getTransaction().rollback();//after throwing exception
            e.printStackTrace();
        }
        em.getTransaction().commit();//after advice
        em.close();
        emf.close();
    }

    /*@Override
    public void run(String... args) throws Exception {
        studentDAO.save(new Student(null, "Akash saha", 3.28f));
        System.out.println(entityManager.find(Student.class, 1));
    }*/
}
