package com.mars.exploremars.Models;

import com.mars.exploremars.Exceptions.OutOfBoundsException;

import java.util.ArrayList;

public class Mission {

    private final int id;
    private final Position upperLimit;
    private ArrayList<Probe> probes;

    public Mission(int id, int maxX, int maxY) {
        this.id = id;
        this.upperLimit = new Position(maxX, maxY);
        this.probes = new ArrayList<Probe>();
    }

    public int launchProbe(int x, int y, Direction direction) throws OutOfBoundsException {
        int nProbes = probes.size();
        Probe probe = new Probe(nProbes, x, y, direction);
        if (isOutOfBounds(probe.getPosition())) {
            throw new OutOfBoundsException("Could not launch probe", probe.getPosition());
        }
        probes.add(probe);
        return nProbes;
    }

    public ArrayList<Probe> getProbes() {
        return probes;
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
