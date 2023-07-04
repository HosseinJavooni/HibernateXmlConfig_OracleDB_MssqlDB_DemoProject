package org.example;


import org.example.model.Person;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        var person = new Person();
        person.setAge(789);
        person.setLastName("Jabani");
        person.setFirstName("Hossein");
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {

            // start the transaction
            transaction = session.beginTransaction();

            // save person object
            session.persist(person);

            // commit transaction
            transaction.commit();
        } catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
        }
        System.out.println("Hello world!");
    }
}