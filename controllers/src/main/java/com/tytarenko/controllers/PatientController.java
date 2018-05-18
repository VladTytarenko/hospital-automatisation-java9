package com.tytarenko.controllers;

import com.tytarenko.entities.*;
import com.tytarenko.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private ReceptionService receptionService;

    @Autowired
    private ServiceInterface<Recommendation> recommendationService;

    @Autowired
    private ServiceInterface<Recipe> recipeService;

    @Autowired
    private ReferalService referalService;

    @Autowired
    private TelephoneService<Patient> telephoneService;


    @GetMapping("/{passport}")
    public ModelAndView getPatient(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", patientService.getPatientByPassport(passport));
        return new ModelAndView("patient/cabinet", model);
    }

    @GetMapping("/{passport}/update")
    public ModelAndView updatePatient(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", patientService.getPatientByPassport(passport));
        return new ModelAndView("patient/update", model);
    }

    @PostMapping("/{passport}/update")
    public ModelAndView updatePatient(@PathVariable("passport") String passport,
                                      @ModelAttribute("patient") Patient patient) {
        patientService.updatePatient(patient, passport);
        return new ModelAndView("redirect:/patient/" + patient.getPassport());
    }

    @GetMapping("/{passport}/recommendations")
    public ModelAndView getRecomendation(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", passport);
        model.put("recommendations_list", recommendationService.get(passport));
        return new ModelAndView("patient/recommendations", model);
    }

    @GetMapping("/{passport}/recipes")
    public ModelAndView getRecipes(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", passport);
        model.put("recipes_list", recipeService.get(passport));
        return new ModelAndView("patient/recipes", model);
    }

    @GetMapping("/{passport}/referals")
    public ModelAndView getReferals(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", passport);
        model.put("referals_list", referalService.getReferalOfPatient(passport));
        return new ModelAndView("patient/referals", model);
    }

    @GetMapping("/{passport}/referals/{specialization}")
    public ModelAndView getReferals(@PathVariable("passport") String passport,
                                    @PathVariable("specialization") int id) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", passport);
        model.put("doctor_list", doctorService.getBySpecialization(id));
        return new ModelAndView("patient/doctors", model);
    }

    @GetMapping("/{passport}/receptions")
    public ModelAndView getReceptions(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", passport);
        model.put("receptions_list", receptionService.getReceptionOfPatient(passport));
        return new ModelAndView("patient/receptions", model);
    }

    @GetMapping("/{passport}/referals/{doc_passport}")
    public ModelAndView getRegistration(@PathVariable("passport") String passport,
                                        @PathVariable("doc_passport") String docPassport) {
        Map<String, Object> model = new HashMap<>();
        model.put("patient", passport);
        model.put("doc_passport", docPassport);
        return new ModelAndView("patient/registration", model);
    }

    @PostMapping("/{passport}/referals/{doc_passport}")
    public ModelAndView getRegistration(@PathVariable("passport") String passport,
                                        @PathVariable("doc_passport") String docPassport,
                                        @ModelAttribute("datetime") Date date) {
        receptionService.addReception(new Reception(docPassport, passport, date, 0));
        return new ModelAndView("redirect:/patient/" + passport + "/receptions");
    }

    @GetMapping("/patient/{passport}/telephone")
    public ModelAndView getTelephone(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("telephone_list", telephoneService.getTelephone(passport));
        return new ModelAndView("patient/telephone", model);
    }

    @GetMapping("/patient/{passport}/add_telephone")
    public ModelAndView addTelephone(@PathVariable("passport") String passport) {
        return new ModelAndView("patient/add_telephone");
    }

    @PostMapping("/patient/{passport}/add_telephone")
    public ModelAndView addTelephone(@PathVariable("passport") String passport,
                                     @ModelAttribute("telephone")Telephone<Patient> patientTelephone) {
        telephoneService.addTelephone(patientTelephone);
        return new ModelAndView("redirect:/patient/" + passport + "/telephone");
    }

    @PostMapping("/patient/{passport}/telephone/{tel}/delete")
    public ModelAndView deleteTelephone(@PathVariable("passport") String passport,
                                        @PathVariable("tel") long telephone) {
        telephoneService.delete(telephone);
        return new ModelAndView("redirect:/patient/" + passport + "/telephone");
    }

    @GetMapping("/patient/{passport}/telephone/{tel}/update")
    public ModelAndView addTelephone(@PathVariable("passport") String passport,
                                     @PathVariable("tel") long telephone) {
        return new ModelAndView("patient/update_telephone");
    }

    @PostMapping("/patient/{passport}/telephone/{tel}/update")
    public ModelAndView updateTelephone(@PathVariable("passport") String passport,
                                        @PathVariable("tel") long telephone,
                                        @ModelAttribute("telephone") long newTel) {
        telephoneService.update(telephone, newTel);
        return new ModelAndView("redirect:/patient/" + passport + "/telephone");
    }

}
