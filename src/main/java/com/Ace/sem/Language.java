package com.Ace.sem;

public class Language {
    private String Language;
    private long total_population;
    private double percentage;

    // Use Encapsulation : Getter & Setter Method for each variable initialized in above
    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String Language) {
        this.Language = Language;
    }

    public long getTotal_Population() {
        return total_population;
    }

    public void setTotal_Population(long total_population) {
        this.total_population = total_population;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }
}
