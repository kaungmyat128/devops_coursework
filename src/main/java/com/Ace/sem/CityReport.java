package com.Ace.sem;
//importing necessary java sql and util library
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Creates methods to write sql queries and create arraylists of countries population
 * This Java Class File contains 5 java methods that contains 2 parameters - database connection & int limit parameters -
 * getCityPop(), getCityPopByContinent(), getCityPopByRegion() , getCityPopByCountry(), getCityPopByDistrict()
 * This class also contains other 5 java methods that contains ArrayList Parameter to display results
 * displayCities(), displayCityContinents(), displayCityRegion(), displayCityCountries() , displayCityDistrict()
 * */
public class CityReport {

    // Create new object of CountryReport to use human_readable_format() method from country.java
    CountryReport formatPopulation = new CountryReport();

    /**
     * getWorldPopByCity() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries in the world
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<City> getCityPop(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0){
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Cities
                strSelect =
                        "SELECT (city.Name) AS CityName,country.Name AS CountryName,city.District,city.Population "
                                + "FROM city INNER JOIN country ON city.CountryCode = country.Code "
                                + "ORDER BY Population DESC LIMIT "+ lim;
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch all queries
                strSelect =
                        "SELECT (city.Name) AS CityName,country.Name AS CountryName,city.District,city.Population "
                                + "FROM city INNER JOIN country ON city.CountryCode = country.Code "
                                + "ORDER BY Population DESC";
            }
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information from database
            ArrayList<City> worldPop = new ArrayList<City>();
            while (rset.next()) {
                City world = new City();
                world.setCityName(rset.getString("CityName"));
                world.setCountryName(rset.getString("CountryName"));
                world.setDistrict(rset.getString("District"));
                world.setPopulation(rset.getInt("Population"));
                worldPop.add(world);
            }
            return worldPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of City by World");
            return null;
        }
    }

    /**
     * getCityPopByContinent() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries in each Continent
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<City> getCityPopByContinent(Connection con,int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0){
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Cities for each continent
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Continent AS Continent, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY Continent ASC, Population DESC";
            } else if (lim == 0) {
                // Create string for SQL statement with no limit - fetch Cities population for each continent
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Continent AS Continent, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "ORDER BY Continent ASC, Population DESC";
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information for Each Continent from Database
            ArrayList<City> continentPop = new ArrayList<City>();
            while (rset.next()) {
                City continent = new City();
                continent.setCityName(rset.getString("CityName"));
                continent.setCountryName(rset.getString("CountryName"));
                continent.setDistrict(rset.getString("District"));
                continent.setContinents(rset.getString("Continent"));
                continent.setPopulation(rset.getInt("Population"));
                continentPop.add(continent);
            }
            return continentPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of City by Continent");
            return null;
        }
    }

    /**
     * getCityPopByRegion() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries in each Region
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<City> getCityPopByRegion(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0){
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Cities for each region
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Region AS Region, city.Population AS Population, "
                                + "ISNULL(city.District, '(blank)'), "
                                + "ISNULL(city.District, '(blank)'), "
                                + "CASE city.District WHEN 'null' then '(blank'), "
                                + "CASE city.District WHEN NULL then '(blank'), "
                                + "COALESCE(city.District, NULL, '(blank)' "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY Region ASC ,Population DESC";
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch All Cities Countries for each continent
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Region ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Region AS Region, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "ORDER BY Region ASC ,Population DESC";
            }

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information for Each Region From Database
            ArrayList<City> regionPop = new ArrayList<City>();
            while (rset.next()) {
                City region = new City();
                region.setCityName(rset.getString("CityName"));
                region.setCountryName(rset.getString("CountryName"));
                region.setDistrict(rset.getString("District"));
                region.setRegion(rset.getString("Region"));
                region.setPopulation(rset.getInt("Population"));
                regionPop.add(region);
            }
            return regionPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of City by Region");
            return null;
        }
    }

    /**
     * getCityPopByCountry() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries in each Country
     * with descending order of population'
     * Then return the data as array list.
     * */
    public ArrayList<City> getCityPopByCountry(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0){
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Cities for each country
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Name ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY CountryName ASC, Population DESC";
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch All Cities Countries for each continent
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Name ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "ORDER BY CountryName ASC, Population DESC";
            }
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information for Each country From Database
            ArrayList<City> countryPop = new ArrayList<City>();
            while (rset.next()) {
                City country = new City();
                country.setCityName(rset.getString("CityName"));
                country.setCountryName(rset.getString("CountryName"));
                country.setDistrict(rset.getString("District"));
                country.setPopulation(rset.getInt("Population"));
                countryPop.add(country);
            }
            return countryPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of City by Country");
            return null;
        }
    }

    /**
     * getCityPopByDistrict() method contains connection parameters for database connection and limit parameter
     * write sql query to produce 'ALL or Top N most populated countries in each District
     * with descending order of population'
     * Then return the data as array list.
     * */    public ArrayList<City> getCityPopByDistrict(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            if (lim>0){
                // Create string for SQL statement with limit 'N' - fetch Top N Populated Cities for each district
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY city.District ORDER BY city.Population DESC) AS row_num, "
                        + "city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country INNER JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " AND District != SPACE(1) ORDER BY District ASC, Population DESC";
            } else if (lim==0) {
                // Create string for SQL statement with no limit - fetch All Cities Countries for each district
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY city.District ORDER BY city.Population DESC) AS row_num, "
                                + "city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country INNER JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE District != SPACE(1) ORDER BY District ASC, Population DESC";

            }
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract City information for Each District From Database
            ArrayList<City> districtPop = new ArrayList<City>();
            while (rset.next()) {
                City district = new City();
                district.setCityName(rset.getString("CityName"));
                district.setCountryName(rset.getString("CountryName"));
                district.setDistrict(rset.getString("District"));
                district.setPopulation(rset.getInt("Population"));
                districtPop.add(district);
            }
            return districtPop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Population of City By District");
            return null;
        }
    }


    /** Display Cities Report using getter() method
     *
     * @param cities_list
     */
    public void displayCities(ArrayList<City> cities_list)
    {
        // Print header

        System.out.println("============================================================");

        System.out.println(String.format("%-40s |%-30s |%-30s |%-20s", "City", "Country", "District", "Population"));
        // Loop over all cities population in the list
        for (City cityR : cities_list)
        {
            String countries_info =
                    String.format("%-40s |%-30s |%-30s |%-20s",
                            cityR.getCityName(), cityR.getCountryName(), cityR.getDistrict(),
                            formatPopulation.human_readable_format(cityR.getPopulation()));
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    /** display cities report based on continents using getter() and setter() methods
     * Use if condition to check whether current continent change and print out current continent as title
     * @param continent_list
     */
    public void displayCityContinents(ArrayList<City> continent_list)
    {
        // Print header
        System.out.println("============================================================");

        // Initialize Current Continent variable
        String currentContinent = null;

        // Loop over all continents and cities population in the list
        for (City cityR : continent_list)
        {
            if(!cityR.getContinents().equals(currentContinent)){
                System.out.println("\n Cities sorted by Population in " + cityR.getContinents() + " Continents");
                System.out.println("===========================================");
                currentContinent = cityR.getContinents();
                System.out.println(String.format("%-40s |%-30s |%-30s |%-30s |%-20s", "City", "Country", "Continent", "District", "Population"));
            }
            String continent_info =
                    String.format("%-40s |%-30s |%-30s |%-30s |%-20s",
                            cityR.getCityName(), cityR.getCountryName(), cityR.getContinents(),
                            cityR.getDistrict(), formatPopulation.human_readable_format(cityR.getPopulation()));
            System.out.println(continent_info);
        }
        System.out.println("============================================================");
    }

    /** display cities report based on regions using getter() and setter() methods
     * Use if condition to check whether current region change and print out current region as title
     * @param region_list
     */
    public void displayCityRegion(ArrayList<City> region_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Region variable
        String currentRegion = null;

        // Loop over all region population in the list
        for (City cityR : region_list){
            if(!cityR.getRegion().equals(currentRegion)){
                System.out.println("\n Cities sorted by Population in " + cityR.getRegion() + " Region");
                System.out.println("===========================================");
                currentRegion = cityR.getRegion();
                System.out.println(String.format("%-40s |%-30s |%-30s |%-30s |%-20s", "City", "Country", "District", "Region", "Population"));
            }
            String region_info =
                    String.format("%-40s |%-30s |%-30s |%-30s |%-20s",
                            cityR.getCityName(), cityR.getCountryName(), cityR.getDistrict(),
                            cityR.getRegion(), formatPopulation.human_readable_format(cityR.getPopulation()));
            System.out.println(region_info);
        }
        System.out.println("============================================================");
    }

    /** display cities report based on countries using getter() and setter() methods
     * Use if condition to check whether current country change and print out current country as title
     * @param countries_list
     */
    public void displayCityCountries(ArrayList<City> countries_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Country variable
        String currentCountry = null;

        // Loop over all countries population in the list
        for (City cty : countries_list){
            if (!cty.getCountryName().equals(currentCountry)){
                System.out.println("\n Cities sorted by Population in " + cty.getCountryName() + " Country");
                System.out.println("===========================================");
                currentCountry = cty.getCountryName();
                System.out.println(String.format("%-40s |%-30s |%-30s |%-30s |%-20s", "City", "Country", "District", "Population"));
            }
            String countries_info =
                    String.format("%-40s |%-30s |%-30s |%-30s |%-20s",
                            cty.getCityName(), cty.getCountryName(), cty.getDistrict(),
                            formatPopulation.human_readable_format(cty.getPopulation()));
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }

    /** display cities report based on districts using getter() and setter() methods
     * Use if condition to check whether current districts change and print out current districts as title
     * @param districts_list
     */
    public void displayCityDistrict(ArrayList<City> districts_list)
    {
        // Print header
        System.out.println("============================================================");
        // Initialize Current Country variable
        String currentDistrict = null;

        for (City cty : districts_list){
            if (!cty.getDistrict().equals(currentDistrict)){
                System.out.println("\n Cities sorted by Population in " + cty.getDistrict() + " District");
                System.out.println("===========================================");
                currentDistrict = cty.getDistrict();
                System.out.println(String.format("%-40s |%-30s |%-30s |%-30s |%-20s", "City", "Country", "District", "Population"));
            }
            String countries_info =
                    String.format("%-40s |%-30s |%-30s |%-30s |%-20s",
                            cty.getCityName(), cty.getCountryName(), cty.getDistrict(),
                            formatPopulation.human_readable_format(cty.getPopulation()));
            System.out.println(countries_info);
        }
        System.out.println("============================================================");
    }
}
