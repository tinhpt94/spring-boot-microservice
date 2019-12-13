package com.tinhpt.order.entities;

import com.tinhpt.order.utils.AuditHelper;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@NoArgsConstructor
@Data
@MappedSuperclass
public abstract class AuditEntity {
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "modified_by")
    private String modifiedBy;

    @Column(name = "created_on", nullable = false, updatable = false)
    private LocalDateTime createdOn;

    @Column(name = "modified_on")
    private LocalDateTime modifiedOn;

    @PrePersist
    public void prePersit(){
        String auditor = AuditHelper.getCurrentAuditor();
        if (auditor == null) {
            return;
        }
        createdBy = auditor;
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        String auditor = AuditHelper.getCurrentAuditor();
        if (auditor == null) {
            return;
        }
        modifiedOn= LocalDateTime.now();
        modifiedBy = auditor;
    }
}
