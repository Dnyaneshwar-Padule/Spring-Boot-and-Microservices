package com.tca.entity;

public enum Language {
    ENGLISH("EN"),
    MARATHI("MR"),
    HINDI("HI"),
    SPANISH("ES"),
    FRENCH("FR"),
    GERMAN("DE"),
    JAPANESE("JA"),
    CHINESE("ZH"),
    PORTUGUESE("PT"),
    ITALIAN("IT"),
    RUSSIAN("RU"),
    KOREAN("KO"),
    ARABIC("AR"),
    BENGALI("BN"),
    TAMIL("TA"),
    TELUGU("TE"),
    GUJARATI("GU"),
    KANNADA("KN"),
    MALAYALAM("ML"),
    PUNJABI("PA"),
    ODIA("OR"),
    URDU("UR");

    private String name;

    private Language(String name){
        this.name = name;
    }

    public String toString(){
        return this.name;
    }

}
