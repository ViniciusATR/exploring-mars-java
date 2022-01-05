package com.mars.exploremars.ports;

import com.mars.exploremars.core.Direction;
import com.mars.exploremars.core.Mission;
import com.mars.exploremars.core.Position;
import com.mars.exploremars.core.Probe;
import com.mars.exploremars.exceptions.InvalidDirectionException;
import com.mars.exploremars.exceptions.OutOfBoundsException;
import com.mars.exploremars.ports.requests.CreateMissionRequest;
import com.mars.exploremars.ports.requests.LaunchProbeRequest;
import com.mars.exploremars.ports.responses.MissionStatusResponse;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
import com.mars.exploremars.ports.responses.SimpleProbeResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class MissionService {

    private final HashMap<Integer, Mission> missions;
    private Integer currentId;

    public MissionService(){
        this.missions = new HashMap<>();
        this.currentId = 0;
    }

    public boolean hasMission(Integer id) {
        return missions.containsKey(id);
    }

    public SimpleMissionResponse createNewMission(CreateMissionRequest request) {
        Integer missionId = currentId;
        currentId++;
        Mission mission = new Mission(missionId, request.getLimitX(), request.getLimitY());
        missions.put(missionId, mission);

        return new SimpleMissionResponse(missionId, request.getLimitX(), request.getLimitY());
    }

    public SimpleMissionResponse getMission(Integer id) {
        Mission mission = missions.get(id);
        if (mission == null) return null;
        return new SimpleMissionResponse(mission.getId(), mission.getUpperLimit().getX(), mission.getUpperLimit().getY());
    }

    public SimpleProbeResponse launchNewProbe(int id, LaunchProbeRequest request) throws OutOfBoundsException, InvalidDirectionException {

        Mission mission = missions.get(id);
        if (mission == null) return null;

        Position probePosition = new Position(request.getX(), request.getY());
        Direction probeDirection = Direction.fromString(request.getDirection());

        int probeId = mission.launchProbe(probePosition, probeDirection);
        return new SimpleProbeResponse(probeId, probeDirection, probePosition);
    }

    public MissionStatusResponse getMissionStatus(int id) {
        Mission mission = missions.get(id);
        if (mission == null) return null;
        ArrayList<Probe> probes = mission.getProbes();

        return new MissionStatusResponse(probes, mission.getUpperLimit());
    }

    public void executeCommand(int missionId, int probeId, String commandString){}
}
