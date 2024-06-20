package com.gsw.HMSDemoApp.Hospital.Management.System.docloginRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gsw.HMSDemoApp.Hospital.Management.System.doclogin.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
