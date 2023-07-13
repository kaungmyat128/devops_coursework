<h3> USE CASE: 1 View All Countries Population Report</h3>

<b> CHARACTERISTIC INFORMATION </b>

<b> Goal in Context  </b><br>
As a data analyst, I want to see report of all countries 
- in the world 
- in each continent
- in each region 
ordered by largest to smallest populated countries so that I can easily know countries population based on this report.

<b> Scope </b><br>
Company.

<b> Level </b><br>
Primary Task.

<b> Preconditions </b><br>
We need to produce all countries population report that contains each country information and Capital City Name of each country. Database contains 'Country' table and 'City' table.


<b> Success End Condition </b><br>
A report is available for Data Analyst to view population report of all countries in the world / in each continent / in each region.

<b> Failed End Condition </b><br>
No report is produced.

<b> Primary Actor </b><br>
Data Analyst

<b> Trigger </b><br>
When Data Analyst generates the report

<b> MAIN SUCCESS SCENARIO </b><br>
Data Analyst views the population report of all countries successfully
1. Use sql query to produce data from the database tables - 'country' table and 'city' table
2. Create Methods to get data from database and display information
3. Display Report Correctly

<b> EXTENSIONS </b><br>
1. View Population report of all countries in the world 
2. View Population report of all countries in each continent
3. View Population report of all countries in each region

<b> SUB-VARIATIONS </b><br>
None.

<b> SCHEDULE </b><br>
DUE DATE: 14th of July, 2023

============================================================================================

<h3> USE CASE: 2 View Top N Most Populated Countries Report </h3>

<b> CHARACTERISTIC INFORMATION </b>

<b> Goal in Context </b><br>
As a data analyst, I want to view top N countries population 
- in the world 
- in each continent 
- in each region
ordered by largest to smallest populated countries 
so that I can easily view top most populated countries around the world

<b> Scope </b> <br>
Company.

<b> Level </b> <br>
Primary Task.

<b> Preconditions </b> <br>
We need to produce top N populated countries population report in the world that contains each country information and Capital City Name of each country. Database contains 'Country' table and 'City' table.

<b> Success End Condition </b><br>
Exactly N number of Countries will be returned. The report should display top N most populated Countries
in the world / in each continent / in each region
sorted by largest to smallest population.

<b> Failed End Condition </b><br>
No report is produced.

<b> Primary Actor </b><br>
Data Analyst

<b> Trigger </b><br>
When Data Analyst generates the report

<b> MAIN SUCCESS SCENARIO </b> <br>
Data Analyst views the population report of top N populated countries in the world successfully
1. Use sql query to produce data from the database tables - 'country' table and 'city' table
2. Create Methods to get data from database and display information
3. Display Report Correctly

<b> EXTENSIONS </b><br>
1. View Top N countries population in the world 
2. View Top N countries population in each continent
3. View Top N countries population in each region
   
<b> SUB-VARIATIONS </b><br>
None.

<b> SCHEDULE </b> 
DUE DATE: 14th of July, 2023

============================================================================

<h3> USE CASE: 3 View All Cities Population report </h3>

<b> CHARACTERISTIC INFORMATION</b>

<b> Goal in Context</b><br>
As a data analyst, I want to view population report of all cities 
- in the world
- in each continent 
- in each region
- in each country 
- in each district 
which have to be ordered by largest to smallest populated cities
so that I can easily know cities population around the world based on this report.

<b> Scope</b><br>
Company.

<b> Level</b><br>
Primary Task.

<b> Preconditions</b><br>
We need to produce cities population report in the world that contains information of each city and related country information. Database contains 'Country' table and 'City' table.

<b> Success End Condition</b><br>
A report is available for Data Analyst to view population report of all cities in the world / in each continent / in each region / 
in each country / in each district

<b> Failed End Condition</b><br>
No report is produced.

<b> Primary Actor</b><br>
Data Analyst

<b> Trigger</b><br>
When Data Analyst generates the report

<b> MAIN SUCCESS SCENARIO</b><br>
Data Analyst views the population report of cities successfully 
1. Use sql query to produce data from the database tables - 'country' table and 'city' table
2. Create Methods to get data from database and display information
3. Display Report Correctly

<b> EXTENSIONS</b><br>
1. View Population report of all cities in the world
2. View Population report of all cities in each continent
3. View Population report of all cities in each region
4. View Population report of all cities in each country
5. View Population report of all cities in each district

<b> SUB-VARIATIONS</b><br>
None.

<b> SCHEDULE</b><br>
due date - 14th of July, 2023

==========================================================================

<h3>USE CASE 4: View Top N Most Populated Cities Report </h3>

<b> CHARACTERISTIC INFORMATION </b>

<b>Goal in Context</b><br>
As a data analyst, I want to view top N cities population 
- in the world 
- in each continent 
- in each region 
- in each country 
- in each district
ordered by largest to smallest populated cities
so that I can easily view top most populated cities around the world.

<b>Scope</b><br>
Company

<b>Level</b><br>
Primary task

<b>Preconditions</b><br>
Available resource is world database with city and country tables.

<b>Success End Condition</b><br>
Exactly N number of Cities will be returned. The report should display top N most populated Cities
in the world / in each continent / in each region
sorted by largest to smallest population.

<b>Failed End Condition</b><br>
No list of cities will be produced

<b>Primary Actor</b><br>
Data Analyst

<b>Trigger</b><br>
When Data Analyst generates the report

<b>Main Success Scenario</b><br>
Data analyst views the population report of cities successfully.
1. Create an SQL query to extract the required information
2. Create methods for extracting and displaying of data
3. Results displayed correctly

<b>Extensions</b><br>
1. View Top N cities population in the world
2. View Top N cities population in each continent
3. View Top N cities population in each region
4. View Top N cities population in each country 
5. View Top N cities population in each district

<b>Sub-variations</b><br>
None

<b>Schedule</b><br>
due date - 14th of July, 2023

===============================================================

<h3>USE CASE 5: View All Capital Cities Population Report </h3>

<b> CHARACTERISTIC INFORMATION </b>

<b>Goal in Context</b><br>
As a data analyst, I want to view population report of Capital Cities of all countries 
- in the world 
- in each continent 
- in each region
ordered by largest to smallest population
so that I can easily know Capital Cities population based on this report.

<b>Scope</b><br>
Company

<b>Level</b><br>
Summary

<b>Preconditions</b><br>
Available resource is world database with city and country tables.

<b>Success End Condition</b><br>
Result returned with list of Capital Citys in the world / in each continent / in each region 
that sorted by largest to smallest population.

<b>Failed End Condition</b><br>
No list of Capital Cities report will be produced

<b>Primary Actor</b><br>
Data Analyst

<b>Trigger</b><br>
When Data Analyst generates the report

<b>Main Success Scenario</b><br>
Data analyst views population report of all capitals successfully.
1. Create an SQL query to extract the required information
2. Create methods for extracting and displaying of data
3. Results displayed correctly

<b>Extensions</b><br>
1. View Population report of all Capital Cities in the world
2. View Population report of all Capitals Cities in each continent
3. View Population report of all Capital Cities in each region

<b>Sub-variations</b><br>
None

<b>Schedule</b><br>
due date - 21st of July, 2023

===============================================================

<h3>USE CASE 6: View Top N Most Populated Capital Cities Report </h3>

<b> CHARACTERISTIC INFORMATION </b>

<b>Goal in Context</b><br>
As a data analyst, I want to view top N Capital Cities population 
- in the world
- in each continent 
- in each region
ordered by largest to smallest population
so that I can easily view top most populated Capital Cities around the world.

<b>Scope</b><br>
Company

<b>Level</b><br>
Primary Task

<b>Preconditions</b><br>
Available resource is world database with city and country tables.

<b>Success End Condition</b><br>
Exactly N number of Capital Cities will be returned. The report should display top N most populated Capital Cities
in the world / in each continent / in each region
sorted by largest to smallest population.

<b>Failed End Condition</b><br>
No list of Capital Cities report will be produced

<b>Primary Actor</b><br>
Data Analyst

<b>Trigger</b><br>
When Data Analyst generates the report

<b>Main Success Scenario</b><br>
Data analyst views population report of Top N populated capitals in the world successfully.
1. Create an SQL query to extract the required information
2. Create methods for extracting and displaying of data
3. Results displayed correctly

<b>Extensions</b><br>
1. View Top N most populated Capital Cities in the world
2. View Top N most populated Capital Cities in each Continent
3. View Top N most populated Capital Cities in each Region

<b>Sub-variations</b><br>
None

<b>Schedule</b><br>
due date - 21st of July, 2023

===============================================================

<h3>USE CASE 7: View Population of People who live in City & not living in City Report </h3>

<b> CHARACTERISTIC INFORMATION </b>

<b>Goal in Context</b><br>
As a data analyst, I want to view population of people living in the cities and not living in the cities 
- in each continent 
- in each region 
- in each country
so that I can understand the distribution of population around urban and rural areas in different continents.

<b>Scope</b><br>
Company

<b>Level</b><br>
Primary task

<b>Preconditions</b><br>
Available resource is world database with city and country tables.

<b>Success End Condition</b><br>
Produce Report of Population of People who live in Cities & not living in Cities 
in each Continent / in each Region / in each Country
sorted by largest to smallest population

<b>Failed End Condition</b><br>
Population not categorized and failed to produce to report.

<b>Primary Actor</b><br>
Data Analyst

<b>Trigger</b><br>
When Data Analyst generates the report

<b>Main Success Scenario</b><br>
Data Analyst successfully views rural and urban population report of each continent.
1. Create an SQL query to extract the required information
2. Create methods for extracting and displaying of data
3. Results displayed correctly

<b>Extensions</b><br>
1. View Population of People who live in Cities & not living in Cities in each Continent
2. View Population of People who live in Cities & not living in Cities in each Region
3. View Population of People who live in Cities & not living in Cities in each Country

<b>Sub-variations</b><br>
None

<b>Schedule</b><br>
due date - 21st of July, 2023

===============================================================

<h3>USE CASE 8: View Population reports based on multiple categories </h3>

<b> CHARACTERISTIC INFORMATION </b>

<b>Goal in Context</b><br>
As a data analyst, I want to see report of 
- population of the world
- population of each continent
- population of each Region
- population of each Country
- population of each District
- population of each City
ordered by largest to smallest populated countries
so that I can view population distribution of the world.

<b>Scope</b><br>
Company

<b>Level</b><br>
Primary task

<b>Preconditions</b><br>
Available resource is world database with city and country tables.

<b>Success End Condition</b><br>
Population Report of World, Continent, Region, Country, District and City will be produced.

<b>Failed End Condition</b><br>
Population not categorized and failed to produce to report.

<b>Primary Actor</b><br>
Data Analyst

<b>Trigger</b><br>
When Data Analyst generates the report

<b>Main Success Scenario</b><br>
Data Analyst successfully views Population Report of World, Continent, Region, Country, District and City will be produced.
1. Create an SQL query to extract the required information
2. Create methods for extracting and displaying of data
3. Results displayed correctly

<b>Extensions</b><br>
1. View Population of World Report
2. View Population of Each Continent Report
3. View Population of Each Region Report
4. View Population of Each Country Report
5. View Population of Each District Report
6. View Population of Each City Report

<b>Sub-variations</b><br>
None

<b>Schedule</b><br>
due date - 21st of July, 2023

===============================================================

<h3>USE CASE 32: Population Report Based on language</h3>

<b> CHARACTERISTIC INFORMATION </b>

<b>Goal in Context</b><br>
As a data analyst, I want to see population of people who speak Chinese, English, Hindi, Spanish & Arabic Languages from greatest number to smallest, including the percentage of the world population so that I can compare the most used languages around the world.

<b>Scope</b><br>
Company

<b>Level</b><br>
Summary

<b>Preconditions</b><br>
Available resource is world database with city, country, and countrylanguage tables.

<b>Success End Condition</b><br>
Population report based on language successfully created.

<b>Failed End Condition</b><br>
Report not created.

<b>Primary Actor</b><br>
Data Analyst

<b>Trigger</b><br>
When Data Analyst generates the report

<b>Main Success Scenario</b><br>
Data analyst successful views language by people report
1. Create an SQL query to extract the required information
2. Create methods for extracting and displaying of data
3. Results displayed correctly

<b>Extensions</b><br>
None

<b>Sub-variations</b><br>
None

<b>Schedule</b><br>
due date - 28th of July, 2023

===============================================================
