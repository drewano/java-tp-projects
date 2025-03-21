package com.devoir.devoir.controllers;

import com.devoir.devoir.entities.Employe;
import com.devoir.devoir.services.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RayonController {

    @Autowired
    private RayonService rayonService;

    @GetMapping("/rayon/{rayonId}/info")
    @ResponseBody
    public Map<String, Object> getRayonInfo(@PathVariable("rayonId") Integer rayonId) {
        Map<String, Object> response = new HashMap<>();
        response.put("employesByRayon", rayonService.findEmployesByRayonId(rayonId));
        response.put("totalHours", rayonService.findTotalHoursByRayonId(rayonId));
        response.put("allEmployes", rayonService.findAllEmployes());
        return response;
    }
}