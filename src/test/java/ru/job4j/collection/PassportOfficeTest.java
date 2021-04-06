package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PassportOfficeTest {

    @Test
    public void add() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport()), is(citizen));
    }

    @Test
    public void addTwo() {
        Citizen citizen = new Citizen("54625", "Danil");
        Citizen citizen1 = new Citizen("54625", "Danil");
        PassportOffice office = new PassportOffice();
        boolean rsl = office.add(citizen);
        assertThat(rsl, is(false));
        boolean rsl1 = office.add(citizen1);
        assertThat(rsl1, is(true));
    }
}