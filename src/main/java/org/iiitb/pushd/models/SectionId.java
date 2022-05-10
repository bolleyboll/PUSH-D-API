package org.iiitb.pushd.models;


import java.io.Serializable;


public class SectionId implements Serializable {
    private String username;
    private String sectionId;

    public SectionId(String username, String sectionId) {
        this.username = username;
        this.sectionId = sectionId;
    }

    public SectionId() {
    }
}
