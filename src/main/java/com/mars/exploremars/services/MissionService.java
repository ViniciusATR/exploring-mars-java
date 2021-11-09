package com.mars.exploremars.services;

import com.mars.exploremars.models.Mission;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MissionService {

    private HashMap<Integer, Mission> missions;
    private Integer currentId;

    public MissionService(){
        this.missions = new HashMap<Integer, Mission>();
        this.currentId = 0;
    }

    public int createNewMission(int maxX, int maxY) {
        Integer missionId = currentId;
        currentId++;
        Mission mission = new Mission(missionId, maxX, maxY);
        missions.put(missionId, mission);

        return missionId;
    }

    public void launchNewProbe(int missionId){}

    public void executeCommand(int missionId, int probeId, String commandString){}
}
