package senior.pe.post.app.domain.entities;


import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "title", nullable = false)
    @Basic(optional = false)
    private String title;

    @Column(name = "content", nullable = false)
    @Basic(optional = false)
    private String content;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "user_post"))
    private User user;
}
