package com.amigoscode.fraud;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FraudCheckHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fraud_check_gen")
    @SequenceGenerator(name = "fraud_check_gen", sequenceName = "fraud_check_seq", allocationSize = 10)
    @Column(name = "id", nullable = false)
    private Long id;

    private Integer customerId;
    private Boolean isFraudster;
    private LocalDateTime createdAt;


}
