package com.mars.exploremars.adapters;

import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
import com.mars.exploremars.ports.MissionService;
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
    public SimpleMissionResponse createMission(@RequestBody CreateMissionRequest request) {
        int createdId = missionService.createNewMission(request.getLimitX(), request.getLimitY());
        SimpleMissionResponse simpleMissionResponse = new SimpleMissionResponse(createdId, request.getLimitX(), request.getLimitY());
        return simpleMissionResponse;
    }


}
