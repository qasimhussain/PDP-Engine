package io.tub.pdp.pdpengine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "research_application", schema = "public")
public class App {
    private UUID id;
    private UUID researcherId;

    private String appName;
    private String appAddress;
    private String appDescription;

    @Id
    @Column(name = "app_id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "researcher_id")
    public UUID getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(UUID researcherId) {
        this.researcherId = researcherId;
    }

    @Column(name = "app_name")
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Column(name = "app_address")
    public String getAppAddress() {
        return appAddress;
    }

    public void setAppAddress(String appAddress) {
        this.appAddress = appAddress;
    }

    @Column(name = "app_description")
    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

}
