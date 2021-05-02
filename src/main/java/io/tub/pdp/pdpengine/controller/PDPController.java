package io.tub.pdp.pdpengine.controller;

import io.tub.pdp.pdpengine.model.*;
import io.tub.pdp.pdpengine.model.DTO.TaskVO;
import io.tub.pdp.pdpengine.model.ResponseStatus;
import io.tub.pdp.pdpengine.service.PDPManagemntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/pdp")
public class PDPController {

    @Autowired
    PDPManagemntService pdpManagemntService;

    @GetMapping("/")
    public @ResponseBody void test()  {
        LocalDate requestDate = LocalDate.now();
    }

    @PostMapping("/patient/{patient_wallet_address}/dataset")
    public @ResponseBody
    ResponseEntity<ResponseStatus<Dataset>> createDataset(
            @PathVariable("patient_wallet_address") String patientWalletAddress,
            @RequestBody Dataset dataset)  {
        LocalDate requestDate = LocalDate.now();

        try {
            dataset = pdpManagemntService.createDataset(patientWalletAddress, dataset);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(dataset));
    }

    @GetMapping("/datasets")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<Dataset>>> viewDatasets()  {
        LocalDate requestDate = LocalDate.now();
        List<Dataset> datasets = new ArrayList<>();
        try {
            datasets= pdpManagemntService.viewDatasets();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasets));
    }

    @GetMapping("patient/{patient_wallet_address}/datasets")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<Dataset>>> viewDatasetsForPatient(
            @PathVariable("patient_wallet_address") String patientWalletAddress)  {
        LocalDate requestDate = LocalDate.now();
        List<Dataset> datasets = new ArrayList<>();
        try {
            datasets= pdpManagemntService.viewDatasets();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasets));
    }



    @PostMapping("/dataset/{researcher_wallet_address}/request")
    public @ResponseBody
    ResponseEntity<ResponseStatus<DatasetRequest>> createDatasetRequest(
            @PathVariable(value = "researcher_wallet_address") String researcherWalletAddress,
            @RequestBody DatasetRequest datasetRequest)  {

        LocalDate requestDate = LocalDate.now();
        try {
            datasetRequest = pdpManagemntService.createDatasetRequest(researcherWalletAddress, datasetRequest);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasetRequest));
    }

    @GetMapping("/dataset/requests")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<DatasetRequest>>> viewDatasetRequests()  {

        LocalDate requestDate = LocalDate.now();
        List<DatasetRequest> datasetRequests = new ArrayList<>();
        try {
            datasetRequests= pdpManagemntService.viewDatasetRequests();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasetRequests));
    }


    @GetMapping("/researcher/{researcher_wallet_address}/dataset/requests")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<DatasetRequest>>> viewApprovedDatasetRequests(
            @PathVariable("researcher_wallet_address") String researcherWalletAddress)  {

        LocalDate requestDate = LocalDate.now();
        List<DatasetRequest> datasetRequests = new ArrayList<>();
        try {
            datasetRequests= pdpManagemntService.viewApprovedDatasetRequests(researcherWalletAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasetRequests));
    }


    @GetMapping("/patient/{patient_wallet_address}/dataset/requests")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<DatasetRequest>>> viewDatasetRequestForPatient(
            @PathVariable("patient_wallet_address") String patientWalletAddress)  {

        LocalDate requestDate = LocalDate.now();
        List<DatasetRequest> datasetRequests = new ArrayList<>();
        try {
            datasetRequests= pdpManagemntService.viewDatasetRequestsForPatient(patientWalletAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasetRequests));
    }

    @PostMapping("/dataset/request/accept")
    public @ResponseBody
    ResponseEntity<ResponseStatus<DatasetRequest>> acceptDatasetRequest(
            @RequestBody Object datasetRequestObj)  {

        String datasetRequestStr = (String)((LinkedHashMap) datasetRequestObj).get("datasetRequestId");
        DatasetRequest datasetRequest = null;
        try {
            datasetRequest = pdpManagemntService.acceptDatasetRequests(UUID.fromString(datasetRequestStr));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(datasetRequest));
    }



    @PostMapping("/researcher/{researcher_wallet_address}/application")
    public @ResponseBody
    ResponseEntity<ResponseStatus<App>> createApp(
            @PathVariable("researcher_wallet_address") String researcherWalletAddress,
            @RequestBody App app)  {
        LocalDate requestDate = LocalDate.now();

        try {
            app = pdpManagemntService.createApp(researcherWalletAddress, app);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(app));
    }

    @GetMapping("/apps")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<App>>> viewApps()  {
        LocalDate requestDate = LocalDate.now();
        List<App> apps = new ArrayList<>();
        try {
            apps= pdpManagemntService.viewApps();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(apps));
    }



    @PostMapping("/researcher/{researcher_wallet_address}/task")
    public @ResponseBody
    ResponseEntity<ResponseStatus<Task>> createTask(
            @PathVariable("researcher_wallet_address") String researcherWalletAddress,
            @RequestBody TaskVO taskVO)  {

        LocalDate requestDate = LocalDate.now();
        Task task = null;
        try {
            task = pdpManagemntService.createTask(researcherWalletAddress, taskVO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(task));
    }

    @GetMapping("/researcher/{researcher_wallet_address}/tasks")
    public @ResponseBody
    ResponseEntity<ResponseStatus<List<Task>>> viewTasks(
            @PathVariable("researcher_wallet_address") String researcherWalletAddress)  {
        LocalDate requestDate = LocalDate.now();
        List<Task> tasks = new ArrayList<>();
        try {
            tasks= pdpManagemntService.viewTasks(researcherWalletAddress);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                    body(ResponseStatus.code("unable_to_process_request" + e.getMessage()));
        }

        return ResponseEntity.ok(ResponseStatus.body(tasks));
    }
}
