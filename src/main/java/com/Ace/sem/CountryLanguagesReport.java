package com.Ace.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
/**
 * Creates methods to write sql queries and
 * create arraylists of population of people who speak specific languages
 * contain getLanguageReport(), displayLanguagesPopulation() and
 * humanReadableFormat() methods
 * */
public class CountryLanguagesReport {

    /**
     * contains connection parameters for database connection
     * from the greatest number to smallest,
     * including the percentage of the world population:
     * Chinese, English, Hindi, Spanish and Arabic.
     * Then return the data as array list.
     * */
    public List<Language> getLanguagesReport(final Connection con) {
        // Create array list and add query result into array list
        final List<Language> lanPop = new ArrayList();
        // Create string for SQL statement with no limit - fetch all queries
        String strSelect = "SELECT language_table.Language, language_table.Total_Population, " +
                "( language_table.Total_Population / world_population.Total_Population * 100 ) AS Percentage " +
                "FROM (SELECT countrylanguage.Language, SUM(country.Population * countrylanguage.Percentage / 100) " +
                "AS Total_Population FROM countrylanguage JOIN country ON country.Code = countrylanguage.CountryCode " +
                "WHERE Language IN ('Chinese', 'English', 'Hindi', 'Spanish', 'Arabic') GROUP BY Language) AS language_table " +
                "CROSS JOIN (SELECT SUM(Population) AS Total_Population FROM country) AS world_population " +
                "ORDER BY language_table.Total_Population DESC";

        try(Statement stmt = con.createStatement(); ResultSet query1 = stmt.executeQuery(strSelect)){
            // Extract population of countries information and store into array list
            while (query1.next()) {
                final Language languagePop = new Language();
                languagePop.setLanguage(query1.getString("Language"));
                languagePop.setTotalPopulation(query1.getLong("Total_Population"));
                languagePop.setPercentage(query1.getDouble("Percentage"));
                lanPop.add(languagePop);
            }
            return lanPop;

        } catch (SQLException e1) {
            System.out.println("Failed to get Population of People who speaks different kind of languages [language report]");
            return lanPop;
        }
        catch (Throwable e2) {
            System.out.println(e2.getMessage());
            return lanPop;
        }
    }

    /** Display Population of Languages
     *  Report using getter() method
     *
     * @param arrList
     */
    public void displayLanguagesPopulation(final List<Language> arrList)
    {
        try{
            // Print header
            System.out.println("==================================================================================================");
            System.out.println(String.format("%-20s | %-30s |", "Language", "Total Population of People who Speak This Language"));
            // Loop over all cities population in the list
            for (final Language l : arrList)
            {
                final String percent = String.format("%05.2f",l.getPercentage()) + "%";
                final String lanPop =
                        String.format("%-20s | %-20s ( %-5s ) |",
                                l.getLanguage(), humanReadableFormat(l.getTotalPopulation()),
                                percent);
                System.out.println(lanPop);
            }
            System.out.println("================================================================================================");
        }
        catch (NullPointerException e1){
            System.out.println("Nothing to display : No Language Population Report Found.[language report]");
        }
        catch (Throwable e2) {
            System.out.println("Cannot display : Error occurred.[language report] \n" + e2.getMessage());
        }
    }
    /**
     * human_readable_format method used to
     * format the population numbers for long variables
     * e.g. 3242344 => 3,242,344
     */
    public String humanReadableFormat(final long population){
        final NumberFormat numf = NumberFormat.getInstance(new Locale("en", "US"));
        return numf.format(population);
    }
}
