package com.gcp.samples.model;

import java.time.Instant;
import java.util.Date;

public class PackageScanOffload {

    private String barcode;
    private Date createdDate;
    private String packageStatus;

    public PackageScanOffload(String barcode, String packageStatus) {
        this.barcode = barcode;
        this.createdDate = new Date();
        this.packageStatus = packageStatus;
    }

    public PackageScanOffload() {
    }

    public String getBarcode() {
        return barcode;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getPackageStatus() {
        return packageStatus;
    }
}
