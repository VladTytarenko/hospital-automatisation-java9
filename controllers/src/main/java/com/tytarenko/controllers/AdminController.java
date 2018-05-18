package com.tytarenko.controllers;

import com.tytarenko.entities.Doctor;
import com.tytarenko.entities.Patient;
import com.tytarenko.services.interfaces.DoctorService;
import com.tytarenko.services.interfaces.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping("/all_patients")
    public ModelAndView getAllPatients() {
        Map<String, Object> model = new HashMap<>();
        model.put("patients_list", patientService.getAllPatient());
        return new ModelAndView("admin/all-patients", model);
    }

    @GetMapping("/all_patients/{passport}")
    public ModelAndView getPatientById(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", patientService.getPatientByPassport(passport));
        return new ModelAndView("admin/patient", model);
    }

    @GetMapping("/all_patients/registration_patients")
    public ModelAndView registrationPatients() {
        return new ModelAndView("admin/registration");
    }

    @PostMapping("/all_patients/registration_patients")
    public ModelAndView registrationPatients(@ModelAttribute("patient") Patient patient) {
        patientService.insetNewPatient(patient);
        return new ModelAndView("redirect:/admin/all_patients");
    }

    @GetMapping("/all_patients/{passport}/update")
    public ModelAndView updatePatient(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", patientService.getPatientByPassport(passport));
        return new ModelAndView("admin/patient-update", model);
    }

    @PostMapping("/all_patients/{passport}/update")
    public ModelAndView updatePatient(@PathVariable("passport") String passport,
                                      @ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(patient, passport);
        return new ModelAndView("redirect:/admin/all_patients/" + patient.getPassport());
    }

    @DeleteMapping("/all_patients/{passport}/delete")
    public ModelAndView deletePatient(@PathVariable("passport") String passport) {
        patientService.deletePatientByPassport(passport);
        return new ModelAndView("redirect:/admin/all_patients");
    }

//---------------- doctor admin -----------------------
    @GetMapping("/all_doctors")
    public ModelAndView getAllDoctors() {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor_list", doctorService.getAllDoctors());
        return new ModelAndView("admin/all-doctor", model);
    }

    @GetMapping("/all_doctors/registration_doctor")
    public ModelAndView addDoctor() {
        return new ModelAndView("admin/registration-doctor");
    }

    @PostMapping("/all_doctors/registration_doctor")
    public ModelAndView addDoctor(@ModelAttribute("doctor") Doctor doctor) {
        doctorService.addDoctor(doctor);
        return new ModelAndView("redirect:/admin/all_doctors");
    }

    @GetMapping("/all_doctors/{passport}")
    public ModelAndView getDoctor(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor", doctorService.getByPassport(passport));
        return new ModelAndView("doctor", model);
    }

    @GetMapping("/all_doctors/{passport}/update")
    public ModelAndView updateDoctor(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor", doctorService.getByPassport(passport));
        return new ModelAndView("admin/doctor-update", model);
    }

    @PostMapping("/all_doctors/{passport}/update")
    public ModelAndView updateDoctor(@PathVariable("passport") String passport,
                                     @ModelAttribute("doctor") Doctor doctor) {
        doctorService.updateDoctor(doctor, passport);
        return new ModelAndView("redirect:/admin/all_doctors/" + doctor.getPassport());
    }

    @GetMapping("/all_doctors/{passport}/delete")
    public ModelAndView deleteDoctor(@PathVariable("passport") String passport) {
        doctorService.deleteDoctorByPassport(passport);
        return new ModelAndView("redirect:/admin/all_doctors");
    }
}
