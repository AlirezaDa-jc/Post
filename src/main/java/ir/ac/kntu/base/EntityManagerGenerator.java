/*
 * @author Alireza.d.a
 */

package ir.ac.kntu.base;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGenerator {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("my-persistence-unit");
    private static EntityManager entityManager;

    private EntityManagerGenerator() {
    }

    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    public static EntityManagerFactory getEmf() {
        return emf;
    }
}
