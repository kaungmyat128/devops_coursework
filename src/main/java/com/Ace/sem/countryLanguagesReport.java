package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class countryLanguagesReport {

    /**
     * getLanguagesReport() method contains connection parameters for database connection
     * The number of people who speak the following languages from greatest number to smallest,
     * including the percentage of the world population:
     * Chinese, English, Hindi, Spanish and Arabic.
     * Then return the data as array list.
     * */
    public ArrayList<Language> getLanguagesReport(Connection con) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement with no limit - fetch all queries
            String strSelect = "SELECT countrylanguage.Language AS Language, "
                    + "SUM(country.Population) AS TotalPopulation, "
                    + "(SUM(country.Population) / (SELECT SUM(country.Population) FROM country)) * 100 AS Percentage "
                    + "FROM countrylanguage JOIN country ON countrylanguage.CountryCode = country.Code "
                    + "WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') "
                    + "GROUP BY Language ORDER BY TotalPopulation DESC";

            // Execute SQL statement
            ResultSet query1 = stmt.executeQuery(strSelect);
            // Create array list and add query result into array list
            ArrayList<Language> LanguagePopulation = new ArrayList<Language>();

            // Extract population of countries information and store into array list
            while (query1.next()) {
                Language languagePop = new Language();
                languagePop.setLanguage(query1.getString("Language"));
                languagePop.setTotal_Population(query1.getLong("TotalPopulation"));
                languagePop.setPercentage(query1.getDouble("Percentage"));
                LanguagePopulation.add(languagePop);
            }
            return LanguagePopulation;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of People who speaks different kind of languages [language report]");
            return null;
        }
    }

    /** Display Population of Languages
     *  Report using getter() method
     *
     * @param arrList
     */
    public void displayLanguagesPopulation(ArrayList<Language> arrList)
    {
        try{
            // Print header
            System.out.println("============================================================");
            System.out.println(String.format("%-40s | %-30s", "Language", "Total Population of People who Speak This Language"));
            // Loop over all cities population in the list
            for (Language l : arrList)
            {
                String percent = String.format("%05.2f",l.getPercentage()) + "%";
                String language_population =
                        String.format("%-40s | %-20s ( %-5s )",
                                l.getLanguage(), humanReadableFormat(l.getTotal_Population()),
                                percent);
                System.out.println(language_population);
            }
            System.out.println("============================================================");
        }catch (Exception e) {
            //System.out.println(e.getMessage());
            System.out.println("Nothing to display : No Language Population Report Found.[language report]");
        }
    }


    /**
     * human_readable_format method used to format the population numbers for long variables
     * e.g. 3242344 => 3,242,344
     * @param population
     * @return
     */
    public String humanReadableFormat(long population){
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String formattedCode = nf.format(population);
        return formattedCode;
    }
}
