package com.gcu.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("authorities")
public class AuthorityEntity {

    @Id
    long id;

    @Column("username")
    String username;

    @Column("authority")
    String authority;

    public AuthorityEntity() {
    }

    public AuthorityEntity(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    
    /** 
     * @return long
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    
}
