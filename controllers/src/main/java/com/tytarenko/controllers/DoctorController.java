package com.tytarenko.controllers;

import com.tytarenko.entities.*;
import com.tytarenko.services.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private ReceptionService receptionService;

    @Autowired
    private ServiceInterface<Recommendation> recommendationService;

    @Autowired
    private ServiceInterface<Recipe> recipeService;

    @Autowired
    private ReferalService referalSerivice;

    @Autowired
    private SpecializationService specializationService;

    @GetMapping("/{passport}")
    public ModelAndView doctor(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor", doctorService.getByPassport(passport));
        return new ModelAndView("doctor", model);
    }

    @GetMapping("/{passport}/all_receptions")
    public ModelAndView getAllPatients(@PathVariable("passport") String passport) {
        Map<String, Object> model = new HashMap<>();
        model.put("receptions_list", receptionService.getReceptionOfDoctor(passport));
        model.put("doctor", doctorService.getByPassport(passport));
        return new ModelAndView("doctor/doctor-reception-list", model);
    }

    @GetMapping("/{passport}/all_receptions/{reception_id}")
    public ModelAndView getPatientById(@PathVariable("reception_id") long id,
                                       @PathVariable("passport") String docPassport) {
        Map<String, Object> model = new HashMap<>();
        Reception reception = receptionService.getReceptionById(id);
        model.put("reception", reception);
        model.put("patient", patientService.getPatientByPassport(reception.getPatientPassport()));
        model.put("doctor", doctorService.getByPassport(docPassport));
        return new ModelAndView("doctor/doctor-patient", model);
    }

    @GetMapping("/{passport}/all_receptions/{reception_id}/recommendations")
    public ModelAndView getRecomendation(@PathVariable("reception_id") long id,
                                         @PathVariable("passport") String passport) {
        Reception reception = receptionService.getReceptionById(id);
        Map<String, Object> model = new HashMap<>();
        model.put("recommendations_list", recommendationService.get(reception.getPatientPassport()));
        model.put("doctor", doctorService.getByPassport(passport));
        return new ModelAndView("doctor/recommendations", model);
    }

    @GetMapping("/{passport}/all_receptions/{reception_id}/add_recommendation")
    public ModelAndView addRecomendation(@PathVariable("passport") String passport,
                                         @PathVariable("reception_id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor", doctorService.getByPassport(passport));
        model.put("reception", id);//receptionService.getReceptionById(id));
        return new ModelAndView("doctor/add-recommendation", model);
    }

    @PostMapping("/{passport}/all_receptions/{reception_id}/add_recommendation")
    public ModelAndView addRecomendation(@PathVariable("passport") String passport,
                                         @PathVariable("reception_id") long id,
                                         @ModelAttribute("recommendation") Recommendation recommendation) {
        System.out.println(recommendation.getReception());
        recommendationService.add(recommendation);
        return new ModelAndView("redirect:/doctor/" + passport + "/all_receptions/" + id + "/recommendations");
    }

    @GetMapping("/{passport}/all_receptions/{reception_id}/recipes")
    public ModelAndView getRecipes(@PathVariable("passport") String passport,
                                   @PathVariable("reception_id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("recipes_list", recipeService.getByReception(id));
        return new ModelAndView("doctor/recipes", model);
    }


    @GetMapping("/{passport}/all_receptions/{reception_id}/add_recipe")
    public ModelAndView addRecipe(@PathVariable("passport") String passport,
                                  @PathVariable("reception_id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor", doctorService.getByPassport(passport));
        model.put("reception", id);
        return new ModelAndView("doctor/add-recipe", model);
    }

    @PostMapping("/{passport}/all_receptions/{reception_id}/add_recipe")
    public ModelAndView addRecipe(@PathVariable("passport") String passport,
                                  @PathVariable("reception_id") long id,
                                  @ModelAttribute("recipe") Recipe recipe) {
        recipeService.add(recipe);
        return new ModelAndView("redirect:/doctor/" + passport + "/all_receptions/" + id + "/recipes");
    }

    @GetMapping("/{passport}/all_receptions/{reception_id}/add_referal")
    public ModelAndView addReferal(@PathVariable("passport") String passport,
                                   @PathVariable("reception_id") long id) {
        Map<String, Object> model = new HashMap<>();
        model.put("doctor", passport);
        model.put("reception", id);
        model.put("specialization_list", specializationService.getAllSpecialization());
        return new ModelAndView("doctor/add-referal", model);
    }

    @PostMapping("/{passport}/all_receptions/{reception_id}/add_referal")
    public ModelAndView addReferal(@PathVariable("passport") String passport,
                                   @PathVariable("reception_id") long id,
                                   @ModelAttribute("specialization") int n) {
        referalSerivice.addReferal(new Referal(receptionService.getReceptionById(id).getPatientPassport(),
        passport, n));
        System.out.println("Success");
        return new ModelAndView("doctor/referal-success");
    }
}
