package com.rongyue.efix.repository.neo4j.entity.node;


import org.neo4j.ogm.annotation.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@NodeEntity(label="User")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    private String account;

    @Property(name = "nickname")
    private String nickname;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss:SSS")
    private Date createTime;

    @Relationship(type="AUTHENTICATE_BY", direction=Relationship.OUTGOING)
    private Set<Verification> authenticateBy;

    private Set<Permission> permissions;  // 当前权限组包含的独立权限 include 关系
    private Set<PermissionGroup> permissionGroups; // 当前权限组包含的其他权限组 import 关系








    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Set<Verification> getAuthenticateBy() {
        return authenticateBy;
    }

    public void setAuthenticateBy(Set<Verification> authenticateBy) {
        this.authenticateBy = authenticateBy;
    }
}
