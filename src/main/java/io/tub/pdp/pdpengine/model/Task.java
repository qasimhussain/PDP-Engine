package io.tub.pdp.pdpengine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "task", schema = "public")
public class Task {
    private UUID id;
    private UUID researcherId;

    private UUID datasetId;
    private UUID appId;

    private String taskAddress;
    private String taskDescription;

    @Id
    @Column(name = "task_id")
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

    @Column(name = "dataset_id")
    public UUID getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(UUID datasetId) {
        this.datasetId = datasetId;
    }

    @Column(name = "app_id")
    public UUID getAppId() {
        return appId;
    }

    public void setAppId(UUID appId) {
        this.appId = appId;
    }

    @Column(name = "task_address")
    public String getTaskAddress() {
        return taskAddress;
    }

    public void setTaskAddress(String taskAddress) {
        this.taskAddress = taskAddress;
    }

    @Column(name = "task_description")
    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

}
