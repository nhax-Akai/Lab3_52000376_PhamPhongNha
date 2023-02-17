package utils;

import domain.Phone;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import domain.Manufacture;

public class HibernateUtils {
    private static final SessionFactory FACTORY;
    static {
        Configuration conf = new Configuration();
        conf.configure("hibernate.cfg.xml");

        conf.addAnnotatedClass(Phone.class);
        conf.addAnnotatedClass(Manufacture.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFactory() {
        return FACTORY;
    }
}
