package com.example.toursystem.entity;

public enum ApproveStatus {
    APPROVED("Approved"),
    WAITFORREVIEW("Wait For Review"),
    WAITFORRESUBMISSION("Wait For Resubmission"),
    RESUBMITTED("Resubmitted"),
    REJECTED("Rejected");

    private final String displayName;

    ApproveStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}