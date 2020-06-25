package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

class DateRules implements Filterable {

    public void allFlights(List<Flight> flightList) {    // все полеты
        System.out.println("Все совершенные рейсы");
        for (int i = 0; i < flightList.size() ; i++) {
            System.out.println(flightList.get(i));
        }
    }

    @Override
    public void ruleOfDepartureToCurrentMoment(List<Flight> flightList) { // вылеты до текущего момента
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Вылеты до текущего момента");
        flightList.forEach(flight -> flight.getSegments().stream().filter(segment ->
                segment.getDepartureDate().isBefore(dateTime)).forEach(segment -> System.out.println(
                segment.toString()
        )));
    }

    @Override
    public void ruleOfSegmentsArrivalDateEarlier(List<Flight> flightList) { // прибыл раньше,чем вылетел
        System.out.println("Дата прилета раньше даты вылета");
        flightList.forEach(flight -> flight.getSegments().stream().filter(segment ->
                segment.getArrivalDate().isBefore(segment.getDepartureDate())).forEach(segment ->
                System.out.println(segment.toString())));
    }
    public int different(LocalDateTime dateTime1, LocalDateTime dataTime2){ //вычисляем разницу между 2 датами в ч.
        return (int) ChronoUnit.HOURS.between(dateTime1,dataTime2);
    }

    @Override
    public void ruleOfTimeOnEarth(List<Flight> flightList) { //#3 ,проведено больше 2 часов на земле
        System.out.println("Общее время на земле больше двух часов");
        for(Flight flight : flightList) {
            for (int i = 0; i < flight.getSegments().size(); i++) {
                for (int indexNext = i+1; indexNext < flight.getSegments().size(); indexNext++) {
                    if (!(different(flight.getSegments().get(i).getArrivalDate(), flight.getSegments()
                            .get(indexNext).getDepartureDate())>2)){
                        indexNext++;
                    } else System.out.println(flight.getSegments());
                }
            }
        }
    }
}