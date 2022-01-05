package com.mars.exploremars.ports.responses;

import com.mars.exploremars.core.Position;
import com.mars.exploremars.core.Probe;

import java.util.ArrayList;
import java.util.Objects;

public class MissionStatusResponse {

    private final ArrayList<Probe> probes;
    private final Position upperLimit;
    private final int probeQuantity;

    public MissionStatusResponse(ArrayList<Probe> probes, Position upperLimit) {
        this.probes = probes;
        this.upperLimit = upperLimit;
        this. probeQuantity = probes.size();
    }

    public ArrayList<Probe> getProbes() {
        return probes;
    }

    public Position getUpperLimit() {
        return upperLimit;
    }

    public int getProbeQuantity() {
        return probeQuantity;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MissionStatusResponse that = (MissionStatusResponse) o;
        return probeQuantity == that.probeQuantity && Objects.equals(probes, that.probes) && Objects.equals(upperLimit, that.upperLimit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(probes, upperLimit, probeQuantity);
    }

    @Override
    public String toString() {
        return "MissionStatusResponse{" +
                "probes=" + probes +
                ", upperLimit=" + upperLimit +
                ", probeQuantity=" + probeQuantity +
                '}';
    }
}
