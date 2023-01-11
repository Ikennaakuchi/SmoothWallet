package com.projects.SoundWallet.entities;

import com.projects.SoundWallet.enums.Status;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Document("users")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    private String id;

    @Indexed(unique = true)
    private String uuid;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50)
    private String emailAddress;

    @Column(nullable = false, length = 10)
    private Status status;

    @Column(nullable = false, length = 50)
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    User(){
        this.createdDate= new Date();
        this.updatedDate = new Date();
    }
    @PrePersist
    private void setCreatedAt(){
        createdDate = new Date();
    }
    @PrePersist
    private void setUpdatedDate(){
        updatedDate = new Date();
    }

}
