package com.temp.resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import sun.security.krb5.Config;


/**
 * Created by Jigar on 6/27/2016.
 */
public class HibernateUtil {

    private SessionFactory sessionFactory = null;
    private void initSessionFactory(){
        //NEW STYLE HIBERNATE http://docs.jboss.org/hibernate/orm/5.1/integrationsGuide/html_single/#services
        Configuration configuration = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder
    }
}
