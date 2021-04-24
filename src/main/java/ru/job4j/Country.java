package ru.job4j;

public class Country {
    private String name;
    private int area;
    private int population;
    private String capital;
    private String language;

    @Override
    public String toString() {
        return "Country is " + name + "{" + "area = " + area + " , "
                + "population = " + population + " , "
                + "capital is " + capital + " , "
                + "language is " + language + "}";
    }

    static class Builder {
        private String name;
        private int area;
        private int population;
        private String capital;
        private String language;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildArea(int area) {
            this.area = area;
            return this;
        }

        Builder buildPopulation(int population) {
            this.population = population;
            return this;
        }

        Builder buildCapital(String capital) {
            this.capital = capital;
            return this;
        }

        Builder buildLanguage(String language) {
            this.language = language;
            return this;
        }

        Country build() {
            Country country = new Country();
            country.name = name;
            country.area = area;
            country.population = population;
            country.capital = capital;
            country.language = language;
            return country;
        }
    }

    public static void main(String[] args) {
        Country country01 = new Builder()
                .buildArea(100)
                .buildName("Russia")
                .buildCapital("Moscow")
                .build();
        System.out.println(country01);
        Country country02 = new Builder()
                .buildArea(300)
                .buildName("USA")
                .buildCapital("Washington")
                .buildPopulation(1000000)
                .buildLanguage("English")
                .build();
        System.out.println(country02);
    }
}
