package com.rongyue.efix.repository.neo4j.entity.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Permission {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    private String resourceId; // 资源标识符

    private String operator; // 资源操作符 create read update delete









    public Permission(String resourceId, String operator) {
        this.resourceId = resourceId;
        this.operator = operator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
