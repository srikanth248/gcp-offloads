package com.gcp.samples.controller;

import com.gcp.samples.model.PackageScanOffload;
import com.gcp.samples.model.PackageScanRequest;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class PackageScanController {

    @Autowired
    Firestore firestore;

    @PostMapping("/")
    public String packageScan(@RequestBody PackageScanRequest request) throws ExecutionException, InterruptedException {
        System.out.println("Barcode:" +request.getBarcode()+";Package Status: "+request.getPackageStatus());
        PackageScanOffload packageScanOffload = new PackageScanOffload(request.getBarcode(), request.getPackageStatus());
        WriteResult writeResult = this.firestore.document("pso/"+request.getBarcode()).set(packageScanOffload).get();
        return writeResult.getUpdateTime().toString();
    }

    @GetMapping("/")
    public PackageScanOffload getOffload(String barcode) throws ExecutionException, InterruptedException {
        ApiFuture<DocumentSnapshot> documentFuture =
                this.firestore.document("pso/"+barcode).get();

        PackageScanOffload packageScanOffload = documentFuture.get().toObject(PackageScanOffload.class);
        return packageScanOffload;
    }

}
