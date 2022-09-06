package com.jap.ticketing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.Assert.*;

public class TicketsRecordAnalyzerTest {
    TicketsRecord ticketsRecord;
    TicketsRecordAnalyzer ticketsRecordAnalyzer;

    String filename = "sample.csv";
    String filename2 = "simple.csv";
    @Before
    public void setUp() throws Exception {
        ticketsRecordAnalyzer = new TicketsRecordAnalyzer();
        ticketsRecord = new TicketsRecord("KIAS-12/5","KIAS-12UP",9387,1,11359,39,"01/09/2018","02:02:58",281,49.3);
    }

    @After
    public void tearDown() throws Exception {
        ticketsRecordAnalyzer = null;
        ticketsRecord = null;
    }

    @Test
    public void readFile() {
        List<TicketsRecord> actual = ticketsRecordAnalyzer.readFile(filename);
        assertEquals("Ticket Records objects not returned correctly",49,actual.size());
    }

    @Test
    public void sortDataByDistanceTravelled() {
        List<TicketsRecord> actual = ticketsRecordAnalyzer.readFile(filename);
        assertEquals(49.5,ticketsRecordAnalyzer.sortDataByDistanceTravelled(actual).get(0).getTravelling_distance(),0);
    }

    @Test
    public void totalTicketAmount() {
        List<TicketsRecord> actual = ticketsRecordAnalyzer.readFile(filename);
        assertEquals(10348,ticketsRecordAnalyzer.totalTicketAmount(actual),0);
    }
}