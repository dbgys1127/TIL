package me.jwt.jwttutorial.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import javax.persistence.*;
@Entity
@Table(name = "authority")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Authority {
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @Column(name = "authority_name", length = 50)
    private String authorityName;
}
