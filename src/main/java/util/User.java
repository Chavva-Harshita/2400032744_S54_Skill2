package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class User {

    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // must be in src/main/resources
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("❌ SessionFactory creation failed");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
