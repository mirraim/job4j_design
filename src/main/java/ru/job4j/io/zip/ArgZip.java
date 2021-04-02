package ru.job4j.io.zip;

public class ArgZip {
    private String directory;
    private String exclude;
    private String output;

    private ArgZip() {
    }

    public static ArgZip of(String[] args) {
        ArgZip argZip = new ArgZip();
        if (args.length == 0) {
            throw new IllegalArgumentException("List of params is empty");
        }
        argZip.init(args);
        return argZip;
    }

    public String getDirectory() {
        return directory;
    }

    public String getExclude() {
        return exclude;
    }

    public String getOutput() {
        return output;
    }

    private void init(String[] args) {
        for (String param : args) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                isDirectory(pair[0], pair[1]);
                isExclude(pair[0], pair[1]);
                isOutput(pair[0], pair[1]);
            }
        }
        if (directory == null) {
            throw new IllegalArgumentException("directory is empty");
        }
        if (exclude == null) {
            throw new IllegalArgumentException("exclude is empty");
        }
        if (output == null) {
            throw new IllegalArgumentException("output is empty");
        }
    }

    private boolean isDirectory(String param, String value) {
        boolean rsl = param.equals("-d");
        if (rsl) {
            directory = value;
        }
        return rsl;
    }

    private boolean isExclude(String param, String value) {
        boolean rsl = param.equals("-e");
        if (rsl) {
            exclude = value;
        }
        return rsl;
    }

    private boolean isOutput(String param, String value) {
        boolean rsl = param.equals("-o");
        if (rsl) {
            output = value;
        }
        return rsl;
    }
}
