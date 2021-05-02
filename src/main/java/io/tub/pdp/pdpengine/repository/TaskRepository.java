package io.tub.pdp.pdpengine.repository;

import io.tub.pdp.pdpengine.model.Researcher;
import io.tub.pdp.pdpengine.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepository extends JpaRepository<Task, UUID> {

    List<Task> findByResearcherId(@Param("researcher_id")UUID researcher_id);

}
