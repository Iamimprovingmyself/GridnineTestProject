package com.gridnine.testing;

import java.util.List;

public interface Filterable {
    void ruleOfDepartureToCurrentMoment(List<Flight> flightList);
    void ruleOfSegmentsArrivalDateEarlier(List<Flight> flightList);
    void ruleOfTimeOnEarth(List<Flight> flightList);
}
