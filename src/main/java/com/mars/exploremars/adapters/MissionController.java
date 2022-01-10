package com.mars.exploremars.adapters;

import com.mars.exploremars.exceptions.InvalidDirectionException;
import com.mars.exploremars.exceptions.OutOfBoundsException;
import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.requests.LaunchProbeRequest;
import com.mars.exploremars.ports.responses.MissionStatusResponse;
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
    @RequestMapping("")
    public SimpleMissionResponse createMission(@RequestBody CreateMissionRequest request) {
        return missionService.createNewMission(request);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public SimpleMissionResponse getMission(@PathVariable Integer id) {
        checkMissionExistence(id);
        return missionService.getMission(id);
    }

    @PostMapping
    @RequestMapping("/{id}/launch")
    public SimpleProbeResponse launchProbe(@PathVariable Integer id, @RequestBody LaunchProbeRequest request) {
        checkMissionExistence(id);
        try {
            return missionService.launchNewProbe(id, request);
        } catch (OutOfBoundsException | InvalidDirectionException exception) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Probe could not be created: " + exception.getMessage());
        }
    }

    @GetMapping
    @RequestMapping("/{id}/status")
    public MissionStatusResponse getMissionStatus(@PathVariable Integer id) {
        checkMissionExistence(id);
        return missionService.getMissionStatus(id);
    }

    private void checkMissionExistence(Integer id) {
        if (!missionService.hasMission(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "mission not found");
    }
}
