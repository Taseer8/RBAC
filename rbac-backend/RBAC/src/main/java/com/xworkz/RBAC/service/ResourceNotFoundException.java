package com.xworkz.RBAC.service;

public class ResourceNotFoundException extends Exception {
    public ResourceNotFoundException() {
        super("Resource not found");
    }
}
