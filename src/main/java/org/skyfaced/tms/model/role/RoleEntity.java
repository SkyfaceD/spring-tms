package org.skyfaced.tms.model.role;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class RoleEntity implements Serializable {
    private short id;
    private long power;
    private String meaning;

    protected RoleEntity() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public long getPower() {
        return power;
    }

    public void setPower(long power) {
        this.power = power;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
