package com.rongyue.efix.repository.neo4j.entity.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Verification {
    @Id
    @GeneratedValue
    private Long id;

    private String identifier;
    private Integer identifierType;
    private String certificate;

    @Relationship(type="AUTHENTICATE_BY", direction=Relationship.INCOMING)
    private User user;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public Integer getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(Integer identifierType) {
        this.identifierType = identifierType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
