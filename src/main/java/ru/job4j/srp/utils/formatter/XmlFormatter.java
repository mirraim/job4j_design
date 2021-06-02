package ru.job4j.srp.utils.formatter;

import ru.job4j.srp.Employee;
import ru.job4j.srp.utils.Employees;
import ru.job4j.srp.utils.fieldlist.FieldList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

public class XmlFormatter implements ReportFormatter {
    @Override
    public String format(List<Employee> employeeList, FieldList fieldList) {
        String xml = "";
        Employees employees = new Employees();
        employees.setEmployees(employeeList);
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            try (StringWriter writer = new StringWriter()) {
                marshaller.marshal(employees, writer);
                xml = writer.getBuffer().toString();
            }
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        return xml;
    }
}
