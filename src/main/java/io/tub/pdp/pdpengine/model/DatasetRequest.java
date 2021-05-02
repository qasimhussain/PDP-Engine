package io.tub.pdp.pdpengine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "dataset_request", schema = "public")
public class DatasetRequest {
    private UUID id;

    private UUID datasetId;
    private UUID researcherId;

    private String patientDatasetAddress;
    private String researcherAppAddress;
    private String datasetRequestInfo;

    private String status;
    @Id
    @Column(name = "dataset_request_id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "dataset_id")
    public UUID getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(UUID datasetId) {
        this.datasetId = datasetId;
    }

    @Column(name = "researcher_id")
    public UUID getResearcherId() {
        return researcherId;
    }

    public void setResearcherId(UUID researcherId) {
        this.researcherId = researcherId;
    }

    @Column(name = "patient_dataset_address")
    public String getPatientDatasetAddress() {
        return patientDatasetAddress;
    }

    public void setPatientDatasetAddress(String patientDatasetAddress) {
        this.patientDatasetAddress = patientDatasetAddress;
    }

    @Column(name = "researcher_app_address")
    public String getResearcherAppAddress() {
        return researcherAppAddress;
    }

    public void setResearcherAppAddress(String researcherAppAddress) {
        this.researcherAppAddress = researcherAppAddress;
    }

    @Column(name = "dataset_request_info")
    public String getDatasetRequestInfo() {
        return datasetRequestInfo;
    }

    public void setDatasetRequestInfo(String datasetRequestInfo) {
        this.datasetRequestInfo = datasetRequestInfo;
    }

    @Column(name = "dataset_request_status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
