package com.gsw.HMSDemoApp.Hospital.Management.System.doclogincontroller;

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

import com.gsw.HMSDemoApp.Hospital.Management.System.doclogin.entity.Medicine;
import com.gsw.HMSDemoApp.Hospital.Management.System.docloginRepository.MedicineRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v3")
public class MedicineController {

	MedicineRepository medicineRepository;

	public MedicineController(MedicineRepository medicineRepository) {
		super();
		this.medicineRepository = medicineRepository;
	}

	@PostMapping("/medicines")
	public Medicine createMedicine(@RequestBody Medicine medicine) {
		return medicineRepository.save(medicine);
	}

	@GetMapping("/medicines")
	public List<Medicine> getAllMedicines() {
		return medicineRepository.findAll();
	}

	@GetMapping("/medicines/{id}")
	public ResponseEntity<Medicine> getMedicineById(@PathVariable long id) throws AttributeNotFoundException {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine not found by Id" + id));
		return ResponseEntity.ok(medicine);

	}

	@PutMapping("/medicines/{id}")
	public ResponseEntity<Medicine> updateMedicine(@PathVariable long id, @RequestBody Medicine medicineDeatils)
			throws AttributeNotFoundException {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine not found by id" + id));
		medicine.setDrugName(medicineDeatils.getDrugName());
		medicine.setStock(medicineDeatils.getStock());
		medicineRepository.save(medicine);
		return ResponseEntity.ok(medicine);
	}

	@DeleteMapping("/medicines/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable long id) throws AttributeNotFoundException {
		Medicine medicine = medicineRepository.findById(id)
				.orElseThrow(() -> new AttributeNotFoundException("Medicine not found by id" + id));
		medicineRepository.delete(medicine);
		Map<String, Boolean> response = new HashMap<String, Boolean>();
		return ResponseEntity.ok(response);

	}

}
