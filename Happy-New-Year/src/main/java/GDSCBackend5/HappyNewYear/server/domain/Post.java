package GDSCBackend5.HappyNewYear.server.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postid;

    private String sender;

    private String token;

    private String title;

    private String content;

    private Date regdate;

    public void posting(String sender, String title, String content) {
        this.regdate = new Date();
        this.token = UUID.randomUUID().toString();
        this.sender = sender;
        this.title = title;
        this.content = content;
    }
}
