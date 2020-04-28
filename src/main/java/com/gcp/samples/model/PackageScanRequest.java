package com.gcp.samples.model;

public class PackageScanRequest {

    private String barcode;
    private String packageStatus;

    public PackageScanRequest(String barcode, String packageStatus) {
        this.barcode = barcode;
        this.packageStatus = packageStatus;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(String packageStatus) {
        this.packageStatus = packageStatus;
    }
}
