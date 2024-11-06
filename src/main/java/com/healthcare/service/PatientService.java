package com.healthcare.service;

import com.healthcare.model.Patient;
import java.util.List;
import java.util.ArrayList;

public class PatientService {
    private List<Patient> patients = new ArrayList<>();

    public void registerPatient(Patient patient) {
        patients.add(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}
