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

How it works:
1. Repository interfaces are children of the parent class JPARepository
2. JPARepository has templates for SQL functionalities, the methods in the children repositories define those methods.
   - Special methods like findAll are methods that do not need a definition in the repository.
3. The respective service classes call the relevant repository methods and return an entity or a successful insert depending on the query type.
4. MainController enables access to all the functionalities, and a connection to your localhost, through API mappings:
   - @GetMapping
   - @PostMapping
5. If you want more information on JPA click the following link https://www.youtube.com/watch?v=dQw4w9WgXcQ

Mapped Commands:
1. /getAllBooks
   -no parameter
2. /getAllReviews
   -no parameter
3. /topSellers
   -no parameter
4. /browseByNum
   - Integer numBooks
5. /browseByGenre
   - String genre
6. /browseByRating
   - Double rating
7. /getAllAuthors
   -no parameter
8. /getBookByISBN
   - Integer book_code
9. /getBookByAuthor
   - String author_last
10. /addAuthor
   - Integer author_num (primary key)
   - String author_first
   - String author_last
   - String author_bio
11. /addBook
   - Integer book_code (primary key)
   - Integer author_num
   - String title
   - Integer publisher_code
   - Double price
   - String genre
   - Date year_pub
   - Integer copies_sold
   - String book_description
   - Double average_rating (can be NULL)
12. /addReview
   - Integer review_id (primary key)
   - Integer book_code
   - Integer user_id
   - Double rating
   - String comment
   - Date datestamp
13. /addItem
 
14. /removeItem
15. /listItems
16. /getAllUsers
