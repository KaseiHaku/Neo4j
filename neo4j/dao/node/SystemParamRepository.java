package com.rongyue.efix.repository.neo4j.dao.node;

import com.rongyue.efix.repository.neo4j.entity.node.SystemParam;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SystemParamRepository extends Neo4jRepository<SystemParam, Long> {

    public SystemParam findByCode(String code);
}
