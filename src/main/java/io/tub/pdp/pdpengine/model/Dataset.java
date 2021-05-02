package io.tub.pdp.pdpengine.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "dataset", schema = "public")
public class Dataset {
    private UUID id;
    private UUID patientId;

//    private String walletAddress;
    private String datasetAddress;
    private BigDecimal datasetPrice;
    private BigDecimal datasetVolume;
    private String datasetDescription;

    @Id
    @Column(name = "dataset_id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


    @Column(name = "patient_id")
    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

//    @Column(name = "patient_wallet_address")
//    public String getWalletAddress() {
//        return walletAddress;
//    }
//
//    public void setWalletAddress(String walletAddress) {
//        this.walletAddress = walletAddress;
//    }

    @Column(name = "dataset_address")
    public String getDatasetAddress() {
        return datasetAddress;
    }

    public void setDatasetAddress(String datasetAddress) {
        this.datasetAddress = datasetAddress;
    }

    @Column(name = "dataset_price")
    public BigDecimal getDatasetPrice() {
        return datasetPrice;
    }

    public void setDatasetPrice(BigDecimal datasetPrice) {
        this.datasetPrice = datasetPrice;
    }

    @Column(name = "dataset_volume")
    public BigDecimal getDatasetVolume() {
        return datasetVolume;
    }

    public void setDatasetVolume(BigDecimal datasetVolume) {
        this.datasetVolume = datasetVolume;
    }

    @Column(name = "dataset_description")
    public String getDatasetDescription() {
        return datasetDescription;
    }

    public void setDatasetDescription(String datasetDescription) {
        this.datasetDescription = datasetDescription;
    }
}
