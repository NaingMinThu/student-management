package com.me.studentmanagement.datamodel;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@MappedSuperclass
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonAutoDetect
@JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
public abstract class AbstractVersionTrack implements Serializable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date", updatable = false)
    @NotNull
    private Date createdDate;

    @Column(name = "created_user_id", updatable = false)
    @NotNull
    private long createdUserId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date")
    @NotNull
    private Date updatedDate;

    @Column(name = "updated_user_id")
    @NotNull
    private long updatedUserId;

    @Column(name = "version")
    @NotNull
    @Version
    private int version;

    @Column(name = "is_delete")
    @NotNull
    private boolean isDelete;
}
