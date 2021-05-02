package io.tub.pdp.pdpengine.repository;

import io.tub.pdp.pdpengine.model.App;
import io.tub.pdp.pdpengine.model.Dataset;
import io.tub.pdp.pdpengine.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AppRepository extends JpaRepository<App, UUID> {

    Optional<App> findByAppAddress(@Param("app_address")String app_address);

}
