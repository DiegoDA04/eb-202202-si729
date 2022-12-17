package com.ecodrive.platform.u20201c334.si729ebu20201c334.behaviour.domain.model.entity;

import com.ecodrive.platform.u20201c334.si729ebu20201c334.shared.domain.model.AuditModel;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@With
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "scores")
public class Score extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "driver_id")
    @NotNull
    private Long driverId;

    @NotNull
    private Float value;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registered_at", nullable = false, updatable = false)
    @CreatedDate
    private Date registeredAt;
}
