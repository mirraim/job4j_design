package ru.job4j.io.filefinder;

public class ArgAnalyser {
    private String directory;
    private String fileInfo;
    private String searchType;
    private String output;

    private ArgAnalyser() {
    }

    public static ArgAnalyser of(String[] args) {
        ArgAnalyser argAnalyser = new ArgAnalyser();
        if (args.length == 0) {
            throw new IllegalArgumentException("List of params is empty");
        }
        argAnalyser.init(args);
        return argAnalyser;
    }

    public String getDirectory() {
        return directory;
    }

    public String getFileInfo() {
        return fileInfo;
    }

    public String getSearchType() {
        return searchType;
    }

    public String getOutput() {
        return output;
    }

    private void init(String[] args) {
        for (String param : args) {
            String[] pair = param.split("=");
            if (pair.length == 2) {
                isDirectory(pair[0], pair[1]);
                isFileInfo(pair[0], pair[1]);
                isSearchType(pair[0], pair[1]);
                isOutput(pair[0], pair[1]);
            }
        }
        if (directory == null) {
            throw new IllegalArgumentException("directory is empty");
        }
        if (fileInfo == null) {
            throw new IllegalArgumentException("there is no information about file");
        }
        if (searchType == null) {
            throw new IllegalArgumentException("the type of search is empty");
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

    private boolean isFileInfo(String param, String value) {
        boolean rsl = param.equals("-n");
        if (rsl) {
            fileInfo = value;
        }
        return rsl;
    }

    private boolean isSearchType(String param, String value) {
        boolean rsl = param.equals("-t");
        if (rsl) {
            searchType = value;
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
