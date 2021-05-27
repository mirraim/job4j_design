package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.utils.AccProperties;
import ru.job4j.srp.utils.GeneralProperties;
import ru.job4j.srp.utils.HRPriperties;
import ru.job4j.srp.utils.ITProperties;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {
    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store, new GeneralProperties());
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired().getTime()).append(";")
                .append(worker.getFired().getTime()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenHTMLGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store, new ITProperties());
        String expect = "<!DOCTYPE HTML>\n"
                + "<html>\n"
                + " <head>\n"
                + "  <meta charset=\"utf-8\">\n"
                + "  <title>Employees</title>\n"
                + " </head>\n"
                + " <body>\n"
                + "  <table border=\"1\">\n"
                + "   <tr>   <th>Name</th>   <th>Hired</th>   <th>Fired</th>   <th>Salary</th></tr>\n"
                + "   <tr> <td>Ivan</td> <td>" + worker.getHired().getTime()
                + "</td> <td>" + worker.getFired().getTime() + "</td> <td>100.0</td></tr>\n"
                + "  </table>\n"
                + " </body>\n"
                + "</html>\n";
        assertThat(engine.generate(em -> true), is(expect));
    }

    @Test
    public void whenHR() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Employee employee = new Employee("Tom", now, now, 120);
        store.add(employee);
        Report engine = new ReportEngine(store, new HRPriperties());
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary; ")
                .append(System.lineSeparator())
                .append(employee.getName()).append(";")
                .append(employee.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenAccGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100.235);
        store.add(worker);
        Report engine = new ReportEngine(store, new AccProperties());
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary; ")
                .append(System.lineSeparator())
                .append("Ivan").append(";")
                .append(worker.getHired().getTime()).append(";")
                .append(worker.getFired().getTime()).append(";")
                .append("100 руб. 24 коп.").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}