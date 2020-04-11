package com.rongyue.efix.repository.neo4j.entity.relation;


import com.rongyue.efix.repository.neo4j.entity.node.User;
import com.rongyue.efix.repository.neo4j.entity.node.Verification;
import org.neo4j.ogm.annotation.*;

@RelationshipEntity(type="VERIFIED_BY")
public class VerifiedBy {


    @Id
    @GeneratedValue
    private Long relationshipId;

    @StartNode
    private User user;

    @EndNode
    private Verification verification;

    @Property
    private String title;










    public Long getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(Long relationshipId) {
        this.relationshipId = relationshipId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }
}
