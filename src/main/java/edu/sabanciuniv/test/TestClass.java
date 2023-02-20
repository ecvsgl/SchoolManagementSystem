package edu.sabanciuniv.test;

import edu.sabanciuniv.model.*;
import edu.sabanciuniv.utils.EntityManagerUtils;
import jakarta.persistence.EntityManager;

public class TestClass {
    public static void main(String[] args) {

        //Creating Student Objects
        Student stu1 = new Student("Efe","16/05/1995","34734, Istanbul", "Male");
        Student stu2 = new Student("Selim","12/12/1967","34732, Istanbul", "Male");
        Student stu3 = new Student("Hale","24/06/1970","34730, Istanbul", "Female");
        Student stu4 = new Student("Yagmur","29/04/2005","34530, Istanbul", "Female");

        //Creating Instructor Objects
        Instructor inst1 = new PermanentInstructor("Matt", "06800 Ankara", "05353452245", 10750.00d);
        Instructor inst2 = new VisitingResearcher("Jane", "06800 Ankara", "05435671825", 35.75d);

        //Creating Course Objects
        Course it501 = new Course("Intro to IT", 3);
        Course it578 = new Course("Blockchain Contract Design", 5);
        Course it517 = new Course("Network Theory", 4);

        //Establishing Course - Instructor Relationship
        it501.setInstructor(inst1);
        it578.setInstructor(inst2);
        it517.setInstructor(inst1);

        //Establishing Course - Student Relationship
        it501.getStudentList().add(stu1);
        it501.getStudentList().add(stu2);
        it501.getStudentList().add(stu3);

        it578.getStudentList().add(stu3);
        it578.getStudentList().add(stu2);
        it578.getStudentList().add(stu4);

        it517.getStudentList().add(stu4);
        it517.getStudentList().add(stu1);
        it517.getStudentList().add(stu3);

        //JPA EntityManager Object Creation;
        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        //Commence Persistence
        try{
            entityManager.getTransaction().begin();

            entityManager.persist(stu1);
            entityManager.persist(stu2);
            entityManager.persist(stu3);
            entityManager.persist(stu4);

            entityManager.persist(inst1);
            entityManager.persist(inst2);

            entityManager.persist(it501);
            entityManager.persist(it578);
            entityManager.persist(it517);


            entityManager.getTransaction().commit();
            System.out.println("All data persisted!...");

        }catch (Exception e) {
            entityManager.getTransaction().rollback();
        }finally{
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }
}
