package com.Ace.sem;
//importing necessary java sql and util library
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class TopPopulatedCities {

    //Method to extract the data for top 20 cities in the world
    public ArrayList<City>
    getWorldPopByCity(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0){
                strSelect =
                        "SELECT (city.Name) AS CityName,country.Name AS CountryName,city.District,city.Population "
                                + "FROM city INNER JOIN country ON city.CountryCode = country.Code "
                                + "ORDER BY Population DESC LIMIT "+ lim;
            } else if (lim==0) {

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

    //Method to extract the data for top 20 cities in Each Continent
    public ArrayList<City>
    getContinentPopByCity(Connection con,int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0){
                 strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Continent AS Continent, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY Continent ASC, Population DESC";
            } else if (lim == 0) {
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

    //Method to extract the data for top 20 cities in Each Region
    public ArrayList<City>
    getRegionPopByCity(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0){
                 strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Region AS Region, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY Region ASC ,Population DESC";
            } else if (lim==0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, country.Region AS Region, city.Population AS Population "
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

    //Method to extract the data for top 20 cities in Each Country
    public ArrayList<City>
    getCountryPopByCity(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0){
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country LEFT JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY CountryName ASC, Population DESC";
            } else if (lim==0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
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

    //Method to extract the data for top 20 cities in Each District
    public ArrayList<City>
    getDistrictPopByCity(Connection con, int lim) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String strSelect = null;
            // Create string for SQL statement
            if (lim>0){
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country INNER JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "WHERE row_num <= " + lim
                                + " ORDER BY District ASC, Population DESC";
            } else if (lim==0) {
                strSelect =
                        "SELECT * FROM (SELECT ROW_NUMBER() OVER (PARTITION BY country.Continent ORDER BY city.Population DESC) AS row_num, city.Name AS CityName, country.Name AS CountryName, city.District AS District, city.Population AS Population "
                                + "FROM country INNER JOIN city ON country.Code = city.CountryCode) AS subquery "
                                + "ORDER BY District ASC, Population DESC";

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
}
