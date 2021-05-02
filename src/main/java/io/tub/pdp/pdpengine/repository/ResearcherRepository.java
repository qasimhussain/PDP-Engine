package io.tub.pdp.pdpengine.repository;

import io.tub.pdp.pdpengine.model.Patient;
import io.tub.pdp.pdpengine.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResearcherRepository extends JpaRepository<Researcher, UUID> {

    Optional<Researcher> findByWalletAddress(@Param("researcher_wallet_address")String researcher_wallet_address);

}
