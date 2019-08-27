package com.vroom.dataservice.FileUpload;

public class FileUploadResponse {

    private String name;
    private String uri;
    private String type;
    private long size;

    public FileUploadResponse(String name, String uri, String type, long size) {
        this.name = name;
        this.uri = uri;
        this.type = type;
        this.size = size;
    }

    // getters and setters removed for the sake of brevity


}
