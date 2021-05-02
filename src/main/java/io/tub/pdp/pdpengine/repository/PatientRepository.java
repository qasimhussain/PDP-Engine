package io.tub.pdp.pdpengine.repository;

import io.tub.pdp.pdpengine.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {

    Optional<Patient> findByWalletAddress(@Param("patient_wallet_address")String patient_wallet_address);
}
