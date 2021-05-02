package io.tub.pdp.pdpengine.repository;

import io.tub.pdp.pdpengine.model.Dataset;
import io.tub.pdp.pdpengine.model.DatasetRequest;
import io.tub.pdp.pdpengine.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface DatasetRepository extends JpaRepository<Dataset, UUID> {

    List<Dataset> findAllByPatientId(@Param("patient_id")UUID patient_id);

//    TODO : ensure single deployment of datasetAddress
//    Optional<Dataset> findByDatasetAddress(@Param("dataset_address")String dataset_address);
    Optional<List<Dataset>> findByDatasetAddress(@Param("dataset_address")String dataset_address);
}
