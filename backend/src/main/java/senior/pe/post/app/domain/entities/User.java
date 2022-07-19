package senior.pe.post.app.domain.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false)
    @Basic(optional = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Basic(optional = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    @Basic(optional = false)
    private String email;

    @Column(name = "gender", nullable = false)
    @Basic(optional = false)
    private String gender;

    @Column(name = "ip_address", nullable = false)
    @Basic(optional = false)
    private String ipAddress;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Post> posts;
}
