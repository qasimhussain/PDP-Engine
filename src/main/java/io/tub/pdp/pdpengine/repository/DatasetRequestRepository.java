package io.tub.pdp.pdpengine.repository;

import io.tub.pdp.pdpengine.model.Dataset;
import io.tub.pdp.pdpengine.model.DatasetRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DatasetRequestRepository extends JpaRepository<DatasetRequest, UUID> {

    Optional<List<DatasetRequest>> findByDatasetId(@Param("dataset_id") UUID dataset_id);
    Optional<List<DatasetRequest>> findByResearcherId(@Param("researcher_id") UUID researcher_id);

}
