package com.rongyue.efix.repository.neo4j.entity.node;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class SystemParam {

    @Id
    @GeneratedValue
    private Long id;

    @Index(unique = true)
    private String code;

    private String value;

    private String remark;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }



    public SystemParam(){

    }

    public SystemParam(String code, String value, String remark) {
        this.code = code;
        this.value = value;
        this.remark = remark;
    }
}
