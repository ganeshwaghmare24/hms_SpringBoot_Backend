package com.gsw.HMSDemoApp.Hospital.Management.System.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.management.AttributeNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gsw.HMSDemoApp.Hospital.Management.System.doclogin.entity.Appointment;
import com.gsw.HMSDemoApp.Hospital.Management.System.entity.Patient;
import com.gsw.HMSDemoApp.Hospital.Management.System.repository.PatientRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/v1")
public class PatientController {
	private PatientRepository patientrepository;

	public PatientController(PatientRepository patientrepository) {
		super();
		this.patientrepository = patientrepository;
	}

	@PostMapping("/patients")
	public Patient createPatient(@RequestBody Patient patient) {
		return patientrepository.save(patient);
	}

	@GetMapping("/patients")
	public List<Patient> getAllMedicines() {
		return patientrepository.findAll();
	}

	@DeleteMapping("/patients/{id}")
	public ResponseEntity<Map<String, Boolean>> deletePatient(@PathVariable long id) throws AttributeNotFoundException {
		Patient patient = patientrepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Appointment not found by Id" + id));
		patientrepository.delete(patient);

		Map<String, Boolean> response = new HashMap<String, Boolean>();

		response.put("Deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
	@PutMapping("/patients/{id}")
	public ResponseEntity<Patient> updatePatientById(@PathVariable long id, @RequestBody Patient patientDetails)
			throws AttributeNotFoundException {
		Patient patient = patientrepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Patient not found by Id" + id));
		
		patient.setAge(patientDetails.getAge());		
		patient.setName(patientDetails.getName());
		patient.setBlood(patientDetails.getBlood());		
		patient.setDose(patientDetails.getDose());
		patient.setFees(patientDetails.getFees());
		patient.setPrescription(patientDetails.getPrescription());
		patient.setUrgency(patientDetails.getUrgency());
		
		Patient savedPatient=patientrepository.save(patient);
		return ResponseEntity.ok(savedPatient);



	}
	@GetMapping("/patients/{id}")
	public ResponseEntity<Patient>getPatientById(@PathVariable long id) throws AttributeNotFoundException{
		Patient patient = patientrepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Patient not found by Id" + id));
		return ResponseEntity.ok(patient);
		
		
	}

}
