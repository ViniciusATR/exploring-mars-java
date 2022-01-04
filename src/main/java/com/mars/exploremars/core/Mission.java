package com.mars.exploremars.core;

import com.mars.exploremars.exceptions.OutOfBoundsException;

import java.util.ArrayList;
import java.util.HashMap;

public class Mission {

    private final Integer id;
    private final Position upperLimit;
    private Integer currentId;
    private HashMap<Integer, Probe> probes;

    public Mission(int id, int maxX, int maxY) {
        this.id = id;
        this.currentId = 0;
        this.upperLimit = new Position(maxX, maxY);
        this.probes = new HashMap<Integer, Probe>();
    }

    public int launchProbe(Position position, Direction direction) throws OutOfBoundsException {
        Integer probeId = currentId;
        Probe probe = new Probe(probeId, position, direction);
        if (isOutOfBounds(probe.getPosition())) {
            throw new OutOfBoundsException("Could not launch probe", probe.getPosition());
        }
        probes.put(probeId, probe);
        currentId++;
        return probeId;
    }

    public ArrayList<Probe> getProbes() {
        ArrayList<Probe> probeList = new ArrayList<Probe>();
        for (Integer key : probes.keySet()) {
            Probe probe = probes.get(key);
            probeList.add(probe);
        }

        return probeList;
    }

    public Probe getProbe(int id) {
        return probes.get(id);
    }

    public boolean isOutOfBounds(Position position) {
        boolean isInXBound = position.getX() >= 0 && position.getX() <= upperLimit.getX();
        boolean isInYBound = position.getY() >= 0 && position.getY() <= upperLimit.getY();

        return !(isInXBound && isInYBound);
    }

    public int getId() {
        return id;
    }

    public Position getUpperLimit() {
        return upperLimit;
    }
}
