package io.tub.pdp.pdpengine.service;

import io.tub.pdp.pdpengine.model.App;
import io.tub.pdp.pdpengine.model.DTO.TaskVO;
import io.tub.pdp.pdpengine.model.Dataset;
import io.tub.pdp.pdpengine.model.DatasetRequest;
import io.tub.pdp.pdpengine.model.Task;

import java.util.List;
import java.util.UUID;


public interface PDPManagemntService {

    Dataset createDataset(String walletAddress, Dataset dataset);

    List<Dataset> viewDatasets() throws Exception;

    List<Dataset> viewDatasetsForPatient(String patientWalletAddress) throws Exception;

    DatasetRequest createDatasetRequest(String researcherWalletAddress, DatasetRequest datasetRequest) throws Exception;

    List<DatasetRequest> viewDatasetRequestsForPatient(String patientWalletAddress) throws Exception;

    List<DatasetRequest> viewApprovedDatasetRequests(String researcherWalletAddress) throws Exception;

    List<DatasetRequest> viewDatasetRequests() throws Exception;

    DatasetRequest acceptDatasetRequests(UUID request) throws Exception;

    App createApp(String walletAddress, App app);
    List<App> viewApps() throws Exception;

    Task createTask(String walletAddress, TaskVO task);
    List<Task> viewTasks(String researcherWalletAddress) throws Exception;
}
