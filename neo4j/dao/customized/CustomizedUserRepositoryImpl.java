package com.rongyue.efix.repository.neo4j.dao.customized;

import com.rongyue.efix.repository.neo4j.entity.node.User;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    @Autowired private Driver driver;

    @Override
    public void customizedMethod(User user) {
        // 在这里 拼 cypher

        Session session = driver.session();
        session.run("");
    }
}
