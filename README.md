# GeekText 
API Service to support an online web application bookstore which targets a particular niche in technology.

For the Java desktop application that we worked on before switching to the REST framework: [GeekText Desktop](https://github.com/raahul14/GeekTextDesktop)

System Requirements:
* [JDK 14.0.02+](https://www.oracle.com/in/java/technologies/javase-downloads.html)
* [MySQL 8.0.21+](https://dev.mysql.com/downloads/installer/)
* [Maven 3.3+](https://maven.apache.org/download.cgi)
* [Eclipse 2020+](https://www.eclipse.org/downloads/)

To run:
1. Clone repository into a folder
2.  Open Eclipse
    * File -> Open projects from file systems
    * Select GeekText folder
    * Right click on Project -> Configure build path -> resolve Java and Maven dependencies
4. Start MySQL server
    * Create empty schema 'geektext'
5. Edit src/main/resources/pom.xml
    * Update username, password for MySQL
6. Run Java Application
    * Run API calls using localhost:8080/demo/[call]
