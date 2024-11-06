package com.healthcare.service;

import com.healthcare.model.Appointment;
import java.util.List;
import java.util.ArrayList;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public void bookAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
