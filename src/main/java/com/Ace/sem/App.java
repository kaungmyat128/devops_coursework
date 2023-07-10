package com.Ace.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    public String Name;
    public int Population;

    public static void main(String[] args) {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract employee salary information
        ArrayList<App> World = a.getWorldPop(10);

        a.displayInfo(World);

        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

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

    public ArrayList<App> getWorldPop(int num) {
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT Name,Population "
                            + "FROM city "
                            + "ORDER BY Population DESC LIMIT num";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<App> Worldpop = new ArrayList<App>();
            while (rset.next()) {
                App world = new App();
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
    public void displayInfo(ArrayList<App> World)
    {
        // Print header
        System.out.println(String.format("%-10s %-15s", "Name", "Population"));
        // Loop over all employees in the list
        for (App world : World)
        {
            String world_info =
                    String.format("%-10s %-15s",
                            world.Name, world.Population);
            System.out.println(world_info);
        }
    }
}