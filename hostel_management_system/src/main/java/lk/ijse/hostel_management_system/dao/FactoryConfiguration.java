package lk.ijse.hostel_management_system.dao;

import lk.ijse.hostel_management_system.entity.Room;
import lk.ijse.hostel_management_system.entity.Student;
import lk.ijse.hostel_management_system.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private static SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configuration = new Configuration()
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Room.class);
        sessionFactory = configuration.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
        if(factoryConfiguration==null){
            return factoryConfiguration =new FactoryConfiguration();
        }
        return new FactoryConfiguration();
    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}
