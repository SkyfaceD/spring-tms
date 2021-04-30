package org.skyfaced.tms.model.user;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;
import org.skyfaced.tms.model.Updatable;
import org.skyfaced.tms.model.role.RoleEntity;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user")
@DynamicUpdate
public class UserEntity implements Serializable, Updatable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(nullable = false)
    private UUID id;
    @Column(length = 32, nullable = false)
    private String username;
    @ColumnTransformer(write = "crypt(?, gen_salt('bf'))")
    @Column(nullable = false)
    private String password;
    @Nullable
    private String name;
    @Nullable
    private String email;
    @Column(name = "is_active", nullable = false)
    private boolean isActive;
    @ManyToOne()
    @JoinColumn(name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "fk_user_role_id_id"), nullable = false)
    private RoleEntity role;
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createdAt;

    protected UserEntity() {

    }

    /**
     * Default constructor for insert
     */
    public UserEntity(String username, String password, @Nullable String name, @Nullable String email, RoleEntity role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T update(Object object) throws Exception {
        if (!(object instanceof UserUpdate)) throw new Exception("Не мой тип, таких не знаю");

        UserUpdate user = (UserUpdate) object;

        setUsername(user.getUsername());
        setName(user.getName());
        setEmail(user.getEmail());

        return (T) this;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Nullable
    public String getName() {
        return name;
    }

    public void setName(@Nullable String name) {
        this.name = name;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(DateTime createdAt) {
        this.createdAt = createdAt;
    }
}
