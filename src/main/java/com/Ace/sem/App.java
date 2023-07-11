package com.Ace.sem;

import java.sql.*;
import java.util.ArrayList;

/**
 * contains objects to initialize and stop connection to the database
 * uses other classes to gather country data and display them.
 */
public class App {
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    public static void main(String[] args) {
        // Create new Application Object
        App a = new App();
        // Create new Country Object
        Country c = new Country();

        // Create new object with Country_report java Class
        Country_report cr = new Country_report();

        // Create new object for top countries population Class Java
        top_countries_population c2 = new top_countries_population();


        City_report c3 = new City_report();

        // Connect to database
        a.connect();

        // Display All Countries Population
        ArrayList<Country> CPop1 = cr.getCountryPop(a.con);
        System.out.println("All Countries Population in the World");
        c.displayCountries(CPop1);

        // Display country population based on continent
        ArrayList<Country> CPop2 = cr.getCounContPop(a.con);
        System.out.println("All Countries Population in the World categorized by Continents");
        c.displayCountries_Continent(CPop2);

        // Display country population based on region
        ArrayList<Country> CPop3 = cr.getCounRegPop(a.con);
        System.out.println("All Countries Population in the World categorized by Regions");
        c.displayCountries_Region(CPop3);

        // Display Top 20 Countries Population
        ArrayList<Country> CPop4 = c2.get_top_countries(a.con);
        System.out.println("Top 20 Countries Population in the World");
        c.displayCountries(CPop4);

        // Display Top 20 Countries Population in Each Continent
        ArrayList<Country> CPop5 = c2.get_top_countries_continents(a.con);
        System.out.println("Top 20 Countries Population in Each Continent");
        c.displayCountries_Continent(CPop5);

        // Display Top 10 Countries Population in Each Region
        ArrayList<Country> CPop6 = c2.get_top_countries_regions(a.con);
        System.out.println("Top 20 Countries Population in Each Region");
        c.displayCountries_Region(CPop6);
        // Display All City Population Around The World
        //ArrayList<City> World = a.getWorldPop();
        //a.displayInfo(World);

        // Disconnect from database
        a.disconnect();
    }



    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public ArrayList<City> getWorldPop() {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name,Population "
                            + "FROM city "
                            + "ORDER BY Population DESC LIMIT 10";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> Worldpop = new ArrayList<City>();
            while (rset.next()) {
                City world = new City();
                world.Name = rset.getString("city.Name");
                world.Population = rset.getInt("city.Population");
                Worldpop.add(world);
            }
            return Worldpop;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get salary details");
            return null;
        }
    }
    public void displayInfo(ArrayList<City> World)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s", "Name", "Population"));
        // Loop over all employees in the list
        for (City world : World)
        {
            String world_info =
                    String.format("%-10s %-15s",
                            world.Name, world.Population);
            System.out.println(world_info);
        }
    }
}