package ru.job4j.srp.utils.formatter;

import java.util.List;

public class HTMLFormatter implements ReportFormatter {
    @Override
    public String format(List<String> args) {
        StringBuilder builder = new StringBuilder("   <tr>");
        for (String arg: args) {
            builder.append(" <td>")
                    .append(arg)
                    .append("</td>");
        }
        return builder.append("</tr>").append(System.lineSeparator()).toString();
    }

    @Override
    public StringBuilder createHead(List<String> args) {
        StringBuilder builder = new StringBuilder("<!DOCTYPE HTML>")
                .append(System.lineSeparator())
                .append("<html>")
                .append(System.lineSeparator())
                .append(" <head>")
                .append(System.lineSeparator())
                .append("  <meta charset=\"utf-8\">")
                .append(System.lineSeparator())
                .append("  <title>Employees</title>")
                .append(System.lineSeparator())
                .append(" </head>")
                .append(System.lineSeparator())
                .append(" <body>")
                .append(System.lineSeparator())
                .append("  <table border=\"1\">")
                .append(System.lineSeparator())
                .append("   <tr>");
        for (String arg : args) {
            builder.append("   <th>").append(arg).append("</th>");
        }
        return builder.append("</tr>").append(System.lineSeparator());
    }

    @Override
    public String close() {
        StringBuilder builder = new StringBuilder("  </table>").append(System.lineSeparator());
        builder.append(" </body>")
                .append(System.lineSeparator())
                .append("</html>")
                .append(System.lineSeparator());
        return builder.toString();
    }
}
