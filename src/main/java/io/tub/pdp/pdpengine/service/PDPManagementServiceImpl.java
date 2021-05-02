package io.tub.pdp.pdpengine.service;


import io.tub.pdp.pdpengine.model.*;
import io.tub.pdp.pdpengine.model.DTO.TaskVO;
import io.tub.pdp.pdpengine.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class PDPManagementServiceImpl implements PDPManagemntService {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DatasetRepository datasetRepository;

    @Autowired
    private ResearcherRepository researcherRepository;

    @Autowired
    private DatasetRequestRepository datasetRequestRepository;

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private TaskRepository taskRepository;

    private final Logger logger = LoggerFactory.getLogger(PDPManagementServiceImpl.class);

    @Override
    public Dataset createDataset(String walletAddress,Dataset dataset) {

        Optional<Patient> patient = this.patientRepository.findByWalletAddress(walletAddress);
        Patient patientObj = new Patient();
        if(!patient.isPresent()){

            patientObj.setId(UUID.randomUUID());
            patientObj.setWalletAddress(walletAddress);
            patientObj = this.patientRepository.save(patientObj);
        }else
            patientObj = patient.get();

        dataset.setId(UUID.randomUUID());
        dataset.setPatientId(patientObj.getId());
        dataset = this.datasetRepository.save(dataset);

        return dataset;
    }

    @Override
    public List<Dataset> viewDatasets() throws Exception {
        List<Dataset> datasets = this.datasetRepository.findAll();
        return datasets;
    }

    @Override
    public List<Dataset> viewDatasetsForPatient(String walletAddress) throws Exception {

        Optional<Patient> patient = this.patientRepository.findByWalletAddress(walletAddress);
        if (patient.isPresent())
            throw new NullPointerException(String.format("Unable find a patient for the wallet %s", walletAddress));


        List<Dataset> datasets = this.datasetRepository.findAllByPatientId(patient.get().getId());
        return datasets;
    }


    @Override
    public DatasetRequest createDatasetRequest(String walletAddress, DatasetRequest datasetRequest) throws Exception {

        Optional<List<Dataset>> datasets = this.datasetRepository.findByDatasetAddress(datasetRequest.getPatientDatasetAddress());
        if(!datasets.isPresent()){
            throw new NullPointerException(String.format("Unable find a dataset for that address %s", datasetRequest.getPatientDatasetAddress()));
        }

//       TODO : ensure single deployment of dataset
        Dataset dataset = datasets.get().get(0);


        Optional<Researcher> researcher = this.researcherRepository.findByWalletAddress(walletAddress);
        Researcher researcherObj = new Researcher();
        if(!researcher.isPresent()){

            researcherObj.setId(UUID.randomUUID());
            researcherObj.setWalletAddress(walletAddress);
            researcherObj = this.researcherRepository.save(researcherObj);
        }else
            researcherObj = researcher.get();

        datasetRequest.setId(UUID.randomUUID());
        datasetRequest.setResearcherId(researcherObj.getId());
        datasetRequest.setDatasetId(dataset.getId());
        datasetRequest = this.datasetRequestRepository.save(datasetRequest);

        return datasetRequest;
    }

    @Override
    public List<DatasetRequest> viewDatasetRequestsForPatient(String patientWalletAddress) throws Exception {

        List<DatasetRequest> patientDataRequest = new ArrayList<>();
        Optional<Patient> patient = this.patientRepository.findByWalletAddress(patientWalletAddress);
        if (patient.isPresent()) {

            List<Dataset> datasets = this.datasetRepository.findAllByPatientId(patient.get().getId());

            if (datasets.size()> 0) {
                for (Dataset dataset : datasets) {

                    Optional<List<DatasetRequest>> datasetReqests = this.datasetRequestRepository.findByDatasetId(dataset.getId());
                    if (datasetReqests.isPresent()) {
                        for (DatasetRequest datasetRequest : datasetReqests.get()) {

                            if(datasetRequest.getStatus().equals("REQUESTED"))
                                patientDataRequest.add(datasetRequest);
                        }
                    }
                }

            }
            return patientDataRequest;
        }else
            throw new NullPointerException(String.format("Unable find a patient for that wallet address %s", patientWalletAddress));

    }


    @Override
    public List<DatasetRequest> viewApprovedDatasetRequests(String researcherWalletAddress) throws Exception {

        List<DatasetRequest> approvedRequests = new ArrayList<>();
        Optional<Researcher> researcher = this.researcherRepository.findByWalletAddress(researcherWalletAddress);
        if (researcher.isPresent()) {

            Optional<List<DatasetRequest>> datasetRequests = this.datasetRequestRepository.findByResearcherId(researcher.get().getId());

            if (datasetRequests.isPresent()) {
                for (DatasetRequest datasetRequest : datasetRequests.get()) {

                    if (datasetRequest.getStatus().equals("APPROVED")) {
                       approvedRequests.add(datasetRequest);
                    }
                }

            }
            return approvedRequests;
        }else
            throw new NullPointerException(String.format("Unable find a patient for that wallet address %s", researcherWalletAddress));

    }

    @Override
    public List<DatasetRequest> viewDatasetRequests() throws Exception {
        List<DatasetRequest> datasetReqests = this.datasetRequestRepository.findAll();
        return datasetReqests;
    }

    @Override
    public DatasetRequest acceptDatasetRequests(UUID requestId) throws Exception {
        Optional<DatasetRequest> datasetRequest = this.datasetRequestRepository.findById(requestId);
        if(!datasetRequest.isPresent())
            throw new NullPointerException(String.format("Unable find a dataset request for the id %s", requestId));

        datasetRequest.get().setStatus("APPROVED");
        return this.datasetRequestRepository.save(datasetRequest.get());
    }


    @Override
    public App createApp(String walletAddress, App app) {

        Optional<Researcher> researcher = this.researcherRepository.findByWalletAddress(walletAddress);
        Researcher researcherObj = new Researcher();
        if(!researcher.isPresent()){

            researcherObj.setId(UUID.randomUUID());
            researcherObj.setWalletAddress(walletAddress);
            researcherObj = this.researcherRepository.save(researcherObj);
        }else
            researcherObj = researcher.get();

        app.setId(UUID.randomUUID());
        app.setResearcherId(researcherObj.getId());
        app = this.appRepository.save(app);

        return app;
    }

    @Override
    public List<App> viewApps() throws Exception {
        List<App> apps = this.appRepository.findAll();
        return apps;
    }

    @Override
    public Task createTask(String walletAddress, TaskVO taskVO) {

        Optional<Researcher> researcher = this.researcherRepository.findByWalletAddress(walletAddress);
        Researcher researcherObj = new Researcher();
        if(!researcher.isPresent()){

            researcherObj.setId(UUID.randomUUID());
            researcherObj.setWalletAddress(walletAddress);
            researcherObj = this.researcherRepository.save(researcherObj);
        }else
            researcherObj = researcher.get();

//      TODO: add dataset address in task
        Optional<List<Dataset>> datasets = this.datasetRepository.findByDatasetAddress(taskVO.getDatasetAddress());
        if (!datasets.isPresent())
            throw new NullPointerException(String.format("Unable find a dataset for this address %s", taskVO.getDatasetAddress()));

//     !!TODO : ensure single deployment of dataset
        Dataset dataset = datasets.get().get(0);

        Optional<App> app = this.appRepository.findByAppAddress(taskVO.getAppAddress());
        if (!app.isPresent())
            throw new NullPointerException(String.format("Unable find an app for this address %s", taskVO.getAppAddress()));

        
        Task task = new Task();
        task.setId(UUID.randomUUID());
        task.setResearcherId(researcherObj.getId());
        task.setDatasetId(dataset.getId());
        task.setAppId(app.get().getId());
        task.setTaskAddress(taskVO.getTaskAddress());
        task.setTaskDescription(taskVO.getTaskDescription());
        task = this.taskRepository.save(task);

        return task;
    }

    @Override
    public List<Task> viewTasks(String walletAddress) throws Exception {
        Optional<Researcher> researcher = this.researcherRepository.findByWalletAddress(walletAddress);
        if(!researcher.isPresent())
            throw new NullPointerException(String.format("Unable find a researcher for this wallet %s", walletAddress));

        List<Task> tasks = this.taskRepository.findByResearcherId(researcher.get().getId());

        return tasks;
    }
}
