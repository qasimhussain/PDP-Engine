package io.tub.pdp.pdpengine.model.DTO;

import io.tub.pdp.pdpengine.model.Task;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

public class TaskVO extends Task {

    private String datasetAddress;
    private String appAddress;

    public String getDatasetAddress() {
        return datasetAddress;
    }

    public void setDatasetAddress(String datasetAddress) {
        this.datasetAddress = datasetAddress;
    }

    public String getAppAddress() {
        return appAddress;
    }

    public void setAppAddress(String appAddress) {
        this.appAddress = appAddress;
    }
}
