package com.mars.exploremars.ports;

import com.mars.exploremars.core.Mission;
import com.mars.exploremars.exceptions.OutOfBoundsException;
import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.requests.LaunchProbeRequest;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
import com.mars.exploremars.ports.responses.SimpleProbeResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MissionService {

    private final HashMap<Integer, Mission> missions;
    private Integer currentId;

    public MissionService(){
        this.missions = new HashMap<>();
        this.currentId = 0;
    }

    public int createNewMission(CreateMissionRequest request) {
        Integer missionId = currentId;
        currentId++;
        Mission mission = new Mission(missionId, request.getLimitX(), request.getLimitY());
        missions.put(missionId, mission);

        return missionId;
    }

    public SimpleMissionResponse getMission(Integer id) {
        Mission mission = missions.get(id);
        if (mission == null) return null;
        return new SimpleMissionResponse(mission.getId(), mission.getUpperLimit().getX(), mission.getUpperLimit().getY());
    }

    public SimpleProbeResponse launchNewProbe(int id, LaunchProbeRequest request) throws OutOfBoundsException {

        Mission mission = missions.get(id);
        if (mission == null) return null;
        int probeId = mission.launchProbe(request.getPosition(), request.getDirection());
        return new SimpleProbeResponse(probeId, request.getDirection(), request.getPosition());
    }

    public void executeCommand(int missionId, int probeId, String commandString){}
}
