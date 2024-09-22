package main;

import beans.Rank;
import beans.Student;
import hibernateutils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

    public static void main(String[] args){

        Session session= HibernateUtils.getSessionFactory().openSession();
        Transaction transaction=session.beginTransaction();
        System.out.println(session);

        try{

            Student student=new Student();
            student.setName("Saket");
            student.setCourse("MCA");


            Rank rank=new Rank();
            rank.setStud_rank(1);

            student.setRank(rank);

            session.persist(student);
            transaction.commit();
        }catch (HibernateException e){
            e.printStackTrace();
            transaction.rollback();
        }finally {
            session.close();
        }



    }
}
