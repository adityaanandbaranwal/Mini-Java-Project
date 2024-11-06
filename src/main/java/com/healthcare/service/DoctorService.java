package com.healthcare.service;

import com.healthcare.model.Doctor;
import java.util.List;
import java.util.ArrayList;

public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }
}
