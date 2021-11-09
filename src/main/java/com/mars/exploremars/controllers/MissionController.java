package com.mars.exploremars.controllers;

import com.mars.exploremars.models.requests.CreateMissionRequest;
import com.mars.exploremars.models.responses.CreateMissionResponse;
import com.mars.exploremars.services.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/missions")
public class MissionController {

    @Autowired
    MissionService missionService;

    @PostMapping
    @RequestMapping("/create")
    public CreateMissionResponse createMission(@RequestBody CreateMissionRequest request) {
        int createdId = missionService.createNewMission(request.getLimitX(), request.getLimitY());
        CreateMissionResponse createMissionResponse = new CreateMissionResponse(createdId, request.getLimitX(), request.getLimitY());
        return createMissionResponse;
    }


}
