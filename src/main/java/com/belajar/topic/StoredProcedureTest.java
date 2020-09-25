package com.belajar.topic;

import com.belajar.topic.model.Topic;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.*;

public class StoredProcedureTest {
    private static EntityManagerFactory factory = null;
    private static EntityManager manager = null;

    @BeforeClass
    public static void init(){
        factory = Persistence.createEntityManagerFactory("jpa-db");
        manager = factory.createEntityManager();
    }

    @Test
    public void findTopicByYearWithNamedStored(){
        StoredProcedureQuery findByYearProcedure = manager.createNamedStoredProcedureQuery("findByYearProcedure");
        StoredProcedureQuery storedProcedureQuery = findByYearProcedure.setParameter("p_year", 2015);
        storedProcedureQuery.getResultList().forEach(t -> Assert.assertEquals(new Integer(2015), ((Topic) t).getYear()));
    }
    @Test
    public void findTopicsByYearNoNamedStored() {
        StoredProcedureQuery storedProcedure =
                manager
                        .createStoredProcedureQuery("FIND_TOPIC_BY_YEAR",Topic.class)
                        .registerStoredProcedureParameter(1, Integer.class, ParameterMode.IN)
                        .setParameter(1, 2015);

        storedProcedure.getResultList()
                .forEach(t -> Assert.assertEquals(new Integer(2015), ((Topic) t).getYear()));
    }
}

