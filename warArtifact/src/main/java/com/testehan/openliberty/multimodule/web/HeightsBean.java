package com.testehan.openliberty.multimodule.web;

import com.testehan.openliberty.multimodule.web.multimodule.lib.Converter;

import java.io.Serializable;

public class HeightsBean implements Serializable {
    private String heightCm;
    private String heightFeet;
    private String heightInches;
    private int cm;
    private int feet;
    private int inches;

    public HeightsBean() {
    }

    // Capitalize the first letter of the name i.e. first letter after get
    // If first letter is not capitalized, it must match the property name in
    // index.jsp
    public String getHeightCm() {
        return heightCm;
    }

    public String getHeightFeet() {
        return heightFeet;
    }

    public String getHeightInches() {
        return heightInches;
    }

    public void setHeightCm(final String heightCm) {
        this.heightCm = heightCm;
    }

    // Need an input as placeholder, you can choose not to use the input
    // without the unused parameter, an exception is thrown
    public void setHeightFeet(String heightfeet) {
        this.cm = Integer.valueOf(heightCm);

        this.feet = Converter.getFeet(cm);

        String result = String.valueOf(feet);
        this.heightFeet = result;
    }

    // Need an input as placeholder, you can choose not to use the input
    // without the unused parameter, an exception is thrown
    public void setHeightInches(String heightinches) {
        this.cm = Integer.valueOf(heightCm);

        this.inches = Converter.getInches(cm);

        String result = String.valueOf(inches);
        this.heightInches = result;
    }

}
