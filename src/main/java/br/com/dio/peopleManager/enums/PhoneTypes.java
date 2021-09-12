package br.com.dio.peopleManager.enums;

public enum PhoneTypes {
    HOME("Home"),
    MOBILE("Mobile"),
    COMMERCIAL("Commercial");

    final private String description;

    PhoneTypes(String description) {
        this.description = description;
    }
}
