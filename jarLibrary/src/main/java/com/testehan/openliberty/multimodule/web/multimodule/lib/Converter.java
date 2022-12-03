package com.testehan.openliberty.multimodule.web.multimodule.lib;


public class Converter
{

    public static int getFeet(final int cm) {
        int feet = (int) (cm / 30.48);
        return feet;
    }

    public static int getInches(final int cm) {
        double feet = cm / 30.48;
        int inches = (int) (cm / 2.54) - ((int) feet * 12);
        return inches;
    }

}
