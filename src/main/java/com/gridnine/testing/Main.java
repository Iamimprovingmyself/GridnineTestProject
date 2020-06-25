package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {

        DateRules dateRules = new DateRules();
        dateRules.allFlights(FlightBuilder.createFlights());
        dateRules.ruleOfDepartureToCurrentMoment(FlightBuilder.createFlights());
        dateRules.ruleOfSegmentsArrivalDateEarlier(FlightBuilder.createFlights());
        dateRules.ruleOfTimeOnEarth(FlightBuilder.createFlights());
    }
}