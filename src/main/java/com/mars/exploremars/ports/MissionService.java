package com.mars.exploremars.ports;

import com.mars.exploremars.core.Mission;
import com.mars.exploremars.ports.responses.SimpleMissionResponse;
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

    public int createNewMission(int maxX, int maxY) {
        Integer missionId = currentId;
        currentId++;
        Mission mission = new Mission(missionId, maxX, maxY);
        missions.put(missionId, mission);

        return missionId;
    }

    public SimpleMissionResponse getMission(Integer id) {
        Mission mission = missions.get(id);
        return new SimpleMissionResponse(mission.getId(), mission.getUpperLimit().getX(), mission.getUpperLimit().getY());
    }

    public void launchNewProbe(int missionId){}

    public void executeCommand(int missionId, int probeId, String commandString){}
}
