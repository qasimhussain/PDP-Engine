package io.tub.pdp.pdpengine.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "patient", schema = "public")
public class Patient {
    private UUID id;

    private String walletAddress;

    @Id
    @Column(name = "patient_id")
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Column(name = "patient_wallet_address")
    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }
}
