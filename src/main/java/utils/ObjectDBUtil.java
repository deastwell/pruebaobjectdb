package utils;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ObjectDBUtil {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        //Nombre del archivo de la abse de datos generada por el proyecto
        entityManagerFactory = Persistence.createEntityManagerFactory("data.odb");
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }
}
