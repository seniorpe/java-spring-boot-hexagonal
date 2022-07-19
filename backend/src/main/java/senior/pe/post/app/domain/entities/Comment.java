package senior.pe.post.app.domain.entities;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder(toBuilder = true)
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @Column(name = "id", updatable = false)
    private UUID id;

    @Column(name = "reply", nullable = false)
    @Basic(optional = false)
    private String reply;

    @ManyToOne
    @JoinColumn(name = "postId", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "post_comment"))
    private Post post;
}
