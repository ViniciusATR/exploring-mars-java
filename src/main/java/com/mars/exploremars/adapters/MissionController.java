package com.mars.exploremars.adapters;

import com.mars.exploremars.exceptions.OutOfBoundsException;
import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.requests.LaunchProbeRequest;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
import com.mars.exploremars.ports.MissionService;
import com.mars.exploremars.ports.responses.SimpleProbeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/v1/missions")
public class MissionController {

    @Autowired
    MissionService missionService;

    @PostMapping
    @RequestMapping("/create")
    public SimpleMissionResponse createMission(@RequestBody CreateMissionRequest request) {
        int createdId = missionService.createNewMission(request);
        return new SimpleMissionResponse(createdId, request.getLimitX(), request.getLimitY());
    }

    @GetMapping
    @RequestMapping("/{id}")
    public SimpleMissionResponse getMission(@PathVariable Integer id) {
        SimpleMissionResponse mission = missionService.getMission(id);
        if (mission == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "mission not found");
        return missionService.getMission(id);
    }

    @PostMapping
    @RequestMapping("/{id}/launch")
    public SimpleProbeResponse launchProbe(@PathVariable Integer id, @RequestBody LaunchProbeRequest request) {
        try {
            SimpleProbeResponse response = missionService.launchNewProbe(id, request);
            if (response == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "mission not found");
            return response;
        } catch (OutOfBoundsException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "command results in out of bounds" + exception.getMessage());
        }
    }

}
