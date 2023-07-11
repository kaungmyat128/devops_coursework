package com.Ace.sem;

import java.util.ArrayList;

public class District {
    public static void main(String[] args) {

    }
    /**
     * City Code
     */
    public int Code;
    /**
     * District Name
     */
    public String District;

    /**
     * Region
     */
    public String Region;

    /**
     * City Continent
     */
    public String Continent;

    /**
     * City Population
     */
    public int Population;

    /**
     * City Capital
     */
    public int Capital;
}
    //display all districts
    public void displayDistrict(ArrayList<City> districts_list)
    {
        // Print header
        System.out.println("============================================================");
        System.out.println("All districts sorted by population in the world ");

        System.out.println(String.format("%-10s %-40s %-15s %-20s %-15s %-15s", "Code", "District", "Continent", "Region", "Population", "Capital City"));
        // Loop over all district population in the list
        for (District dis : districts_list)
        {
            String districts_info =
                    String.format("%-10s %-40s %-15s %-20s %-15s %-15s",
                            dis.Code, dis.District, dis.Continent, dis.Region, dis.Population, dis.Capital);
            System.out.println(districts_info);
        }
        System.out.println("============================================================");
    }

    //display regions based on continents
    public void displayDistrict_Continent(ArrayList<District> districts_list)
    {
        // Print header
        System.out.println("============================================================");

        // Initialize Current Continent variable
        String currentContinent = null;

        // Loop over all countries population in the list
        for (District dis : districts_list)
        {
            // Check the current continent changed or not
            if (!dis.Continent.equals(currentContinent)) {
                // Print the continent header
                System.out.println("\n District sorted by Population in " + dis.Continent + " Continent");
                System.out.println("===========================================");
                currentContinent = dis.Continent;
                System.out.println(String.format("%-10s %-40s %-15s %-20s %-15s %-15s", "Code", "District", "Continent", "Region", "Population", "Capital City"));

            }

            String districts_info =
                    String.format("%-10s %-40s %-15s %-20s %-15s %-15s",
                            dis.Code, dis.District, dis.Continent, dis.Region, dis.Population, dis.Capital);
            System.out.println(districts_info);
        }
        System.out.println("============================================================");
    }

    //display districts based on region
    public void displayDistrict_Region(ArrayList<District> districts_list)
    {
        // Print header
        System.out.println("============================================================");

        // Initialize Current Region variable
        String currentRegion = null;

        // Loop over all countries population in the list
        for (District dis : districts_list)
        {
            // Check the current continent changed or not
            if (!dis.Region.equals(currentRegion)) {
                // Print the continent header
                System.out.println("\n Districts sorted by Population in " + cp.Region + " Region");
                System.out.println("===========================================");
                currentRegion = dis.Region;
                System.out.println(String.format("%-10s %-40s %-15s %-20s %-15s %-15s", "Code", "District", "Continent", "Region", "Population", "Capital City"));

            }

            String districts_info =
                    String.format("%-10s %-40s %-15s %-20s %-15s %-15s",
                            dis.Code, dis.District, dis.Continent, dis.Region, dis.Population, dis.Capital);
            System.out.println(districts_info);
        }
        System.out.println("============================================================");
    }
}
