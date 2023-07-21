# Java Boot camp from 17th July-24th July

Banuprakash C

Full Stack Architect, 

Co-founder & CTO of Lucida Technologies Pvt Ltd., 

Corporate Trainer,

Email: banuprakashc@yahoo.co.in; banu@lucidatechnologies.com

https://www.linkedin.com/in/banu-prakash-50416019/

https://github.com/BanuPrakash/NCG_JAVA

===================================

Softwares Required:
1) JDK 17:
https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
OR  
openJDK 17
https://jdk.java.net/java-se-ri/17

2) Eclipse for JEE  
    https://www.eclipse.org/downloads/packages/release/2022-09/r/eclipse-ide-enterprise-java-and-web-developers

Lombok
Download:
https://repo1.maven.org/maven2/org/projectlombok/lombok/1.18.28/lombok-1.18.28.jar
install:
java -jar lombok.1.18.28.jar

3) MySQL  

Install Docker Desktop
https://www.docker.com/products/docker-desktop/

MySQL installation on Docker steps:

```
a) docker pull mysql

b) 
For Windows:
docker run --name local-mysql –p 3306:3306 -e MYSQL_ROOT_PASSWORD=Welcome123 -d mysql

container name given here is "local-mysql"

For Mac:
docker run -p 3306:3306 -d --name local-mysql -e MYSQL_ROOT_PASSWORD=Welcome123 mysql


c) CONNECT TO A MYSQL RUNNING CONTAINER:

$ docker exec -t -i local-mysql bash

d) Run MySQL client:

bash terminal> mysql -u "root" -p

mysql> exit
```

```
<pluginManagement>
			<plugins>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.11.0</version>
					<configuration>
						<source>17</source>
						<target>17</target>
					</configuration>
				</plugin>
				<plugin>
					<groupId>org.apache.maven.plugins</groupId>
					<artifactId>maven-war-plugin</artifactId>
					<version>3.4.0</version>
					<configuration>
						<failOnMissingWebXml>false</failOnMissingWebXml>
					</configuration>
				</plugin>
				<!-- embedded JETTY server -->
				<plugin>
					<groupId>org.eclipse.jetty</groupId>
					<artifactId>jetty-maven-plugin</artifactId>
					<version>11.0.15</version>
				</plugin>
			</plugins>
		</pluginManagement>
```
Reference Books & Links:
1) Head First Java, Kathy Sierra
2) Effective Java
3) Java: The Complete Reference, Herbert Schildt, 
4) Servlet & JSP: https://www.redbooks.ibm.com/redbooks/pdfs/sg245755.pdf
5) JPA: 
https://thorben-janssen.com/ultimate-guide-association-mappings-jpa-hibernate/
https://thorben-janssen.com/persist-localdate-localdatetime-jpa/
6) Spring:
https://spring.io/projects/spring-boot

================

OOP ==> Writing programs which resemble real world

Object first approach:
Object contains state and behaviour [action / message]
What messages an object can take is exposed thro its interface

Blue print: --> function, class , type

SOLID Design Principle
S ==> Single Responsibility 
O ==> OCP ==> Closed for Change; open for extension
L ==> Liskov Substitution Principle
I ==> Interface segreggation
D ==> Dependency Injection
===========================

What is Java?
Java is a technology; Java enabled machines
Java ==> platform for executing bytecode

Compile time environment:
```
Book.java 
public class Book {
    private String title; // instance variables
    private double price; // instance variables

    public void setTitle(String t) {
        this.title = t;
    }

    public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }
}

JDK ==> Java Development KIT
javac Book.java ==> Book.class [bytecode]

Example.java
public class Example {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.setTitle("Head First Java");

        Book b2 = new Book();
        b2.setTitle("Spring in Action");

        System.out.println(b1.getTitle() + ", " + b1.getPrice());
        System.out.println(b2.getTitle() + ", " + b2.getPrice());
    }
}

javac Example.java ==> Example.class [ bytecode]
```

set classpath=.;c:\users\banu\codes;d:\project;

Runtime environment in Target Platform:
java Example

```
1) Classloader
loads bytecode from secondary storage [ HDD or Network ] to primary storage [ RAM --> Java platform ]
a) findLoadedClass()
b) loadClass() --> loads from current folder or checks the CLASSPATH
  Example.class --> loaded into RAM
  String.class -- not found in CLASSPATH
c) loadSystemClass() --> provided by JDK ==> rt.jar ==> or base module
d) Book.class ==> CLASSPATH ==> loadClass()
e) defineClass() ==> bytecode to platform dependent code
```

constructors()
instance methods
static methods


Requirement: i need to track how many instances of book is created
```
public class Book {
    private String title; // instance variables
    private double price; // instance variables
    private static int count; // class member

    public Book() {
        count++;
    }

    public Book(String title, double price) {
        this.title = title;
        this.price = price;
        count++;
    }

    public static int getCount() {
        return count;
    }

    public void setTitle(String t) { 
        this.title = t;
    }

public String getTitle() {
        return this.title;
    }

    public double getPrice() {
        return this.price;
    }
}

```

Logical grouping of classes in enterprise applications:
1) entity classes
    ==> business domain / model classes
    they represent business data; genrally mapped to persistent store like RDBMS / MonogDB Collection/ Redis data
2) DAO classes ==> Data Access Object ==> they contain CRUD operations
3) Service classes ==> they are a facade over DAO classes ==> giving more fine grained operations over coarse grained operations done by DAO; also exposing different interfaces based on ROLES
4) Exception classes ==> they represent any abnormal condition in application
5) Utility classes ==> any helper classes like ==> DATE format depending on Locale
6) Controller classes / UI ==> endpoint for APIs

packages in java ==> logical grouping of classes.


Task 1:
```
package com.adobe.prj.entity
public class Time {
    ..
} 

package com.adobe.prj.ui;

public class TimeExample {
    public static void main(String[] args) {
        Time t1 = new Time(3, 45);
        Time t2 = new time(2, 20);
        Time t3 = Time.add(t1, t2); 

        s.o.p(t3.getHours() + " : " + t3.getMin()) ; // 6 : 15

        Time t4 = t1.addTime(t2); 
        s.o.p(t4.getHours() + " : " + t4.getMin()) ; // 6 : 15

        s.o.p(t1.getHours() + " : " + t2.getMin()) ; // 3 : 45
        s.o.p(t2.getHours() + " : " + t2.getMin()) ; //2 : 30
    }
}

```
Relationship between objects
1) Generalization and Specialization --> IS A
2) Realization
3) Association --> HAS A
4) Uses A

Java Build tools:
1) Maven / Gradle ==> Compile / Bundle ...
2) JUNIT --> unit testing
3) Mocikto ==> Mocking dependencies
4) Sonar ==> Static code analysis
5) Jenkins ==> CI / CD
6) Git

Static Code analysis
1) Coding Conventions  ==> Naming Conventsions, Comments , space, tabs ...
2) Coding Stds ==> Good programming practice 
    2.1) no dead code
    2.2) proper catch blocks in exception handling
    2.3) proper conditional statements
    2.4) Copy & Paste Code

Generalization and Specialization --> using Inheritance --> IS A

Lombok ==> ByteCodeInstrumentation to modify compiled code

==

Generic classes for which object doesn't exist in real world: Account, Product ==> abstract

method where we can't provide behaviour ==> abstract; this enforces all inherited classes to compulsorily override the method

===

Rules of inheritance:
1) class can extends only from one class; multiple inheritance is not supported
2) keyword "extends" is used for Specialization
3) java.lang.Object is the root class for all objects
4) important methods from Object class:
hashCode(), toString(), equals(), getClass()
For concurrency ==> wait(), notifyAll() and notify()

toString() ==> whenever an object is passed as argument to System.to.println(obj); on that object toString()


====

Object equality == vs equals()

Rectangle r1 = new Rectangle(4,5);
Rectangle r2 = new Rectangle(4,5 );

r1 = null;

=====

Garbage Collection ==> GC
"new" keyword allocates objects on heap area
Garbage collector is going to release un-used [ not referenced ] heap area

Garbage Collector is low priority thread ==> System thread in JRE

MarkSweepCompact GC
G1GC
EpsilonGC

========
Today: Exception Handling self study and Java Naming Conventions, comments

Realization relationship
Java Datacontainers

Day 3: Web application development with MySQL as database
Day 4-6: JPA and Spring Boot


==================

Day 2:

Day 1 Recap: 
```
Object and Class, 
instance variables --> HEAP area, 
static variable --> per class --> Metadata, shared by all objects of a class
instance methods ==> object.method() ==> context of invoking is object
static methods ==> Clazz.method() ==> context of invoking is Class ==> inside the static method we can't access "this"

JRE --> ClassLoader --> JVM [ Metadata / metaspace --> loaded classes reside, stack, heap]

Stack is one per thread ==> default we have main thread

Generalization and Specilazation relationship ==> IS A relationship [ inheritance using "extends" keyword]

override, constructor chaning using "super", polymorhiphsm ==> dynamic binding
Upcasting and downcasting, abstract methods and abstract classes
```

Why Service facade?
1) convert fine grained operations into atomic coarse grained operation

```
public class AccountDao {
    updateAccount(Account acc) {
        SQL --> update accounts set balance =....
    }

    insertAccount(Account acc) {
        SQL --> insert into ...
    }

    Account getBalance(Account acc) {
        SQL --> select balance from accounts where ...
    }

    lockAccount(Account acc) {

    }

    getBalanceinAllAccounts() {

    }
}

public class TransactionDao {
    insertTransaction(TransactionData data) {
        SQL --> insert into transaction values(...)
    }
}

public class BankingService {
    AccountDao accountDao = new AccountDao();
    TransactionDao txDAo = new TrnasactionDao();
    SMSService service = ...
    // coarse grained atomic opertion 
    public void transferFunds(Account fromAcc, Account toAcc, double amt) {
        try {
            begin Transaction
            double bal = accoountDao.getBalance(fromAcc);
            if(amt < bal) {
                accountDao.updateAccount(fromAcc);
                 accountDao.updateAccount(toAcc);
                txDAo.insertTransaction(...);
                Send SMS
            }
            commit transaction
        } catch(Exception ex) {
            rollback transaction
        }
    }
}


```

Client --> Drop down to select Beneficiary
           Text Box to enter amount 
           clicks on "Transfer" button



2) uses services for Interface segregattion

```
class AdminService {
    AccountDao accountDao = new AccountDao();

     insertAccount(Account acc) {
        accountDao.insertAccount(acc);
    }

    Account getBalance(Account acc) {
       return accountDao.getBalance(acc);
    }

    lockAccount(Account acc) {
        accountDao.lockAccount(acc);
    }

    getBalanceinAllAccounts() {
        accountDao.getBalanceInAllAccount();
    }
}

Admin Login --> he / she is given AdminService interface 

class CustomerService {
    AccountDao accountDao = new AccountDao();
    updateAccount(Account acc) {
            accountDao.updateAccount(..)
    }

    insertAccount(Account acc) {
        accountDao.insertAccount(..);
    }

    Account getBalance(Account acc) {
       accountDao.getBalance(acc);
    }
}

```

====================

Day 2:

Realization Relationship

Contract/rules between two elements/models/objects where one element specifies the behaviour and other realizes the behaviour in order to communicate

interface interfaceName {
    abstract methods()
}

Why program to interface?
1) DESIGN
2) IMPLEMENTATION
3) TESTING  
4) INTEGRATION
5) LOOSE COUPLING

interface EmployeeDao {
    void addEmployee(Employee e); // public and abstract by default
    Employee getEmployee(int id);
}

keyword "implements" is for realization relationship
Classloader loads a class if it's referenced anywhere in code.

Explicitly loading of class into JRE
Class.forName("java.util.Date"); ==> Date.class is loaded into JVM

ways to create object:
1) using a "new" keyword if we know class name in advance
new Rectangle()

2) using Reflection API
Class.forName("name of class got from extenal resource").newInstance();

====

Anonymous class: class without a name

```
Flyable.java
interface Flyable {
    void fly();
}

Bird.java
public class Bird implements Flyable {
    name; age; color; weight;
    eat() sleep()

    public void fly() {
        // 
    }
}

AeroPlane.java
public class AeroPlane implements Flyable {
    name; seat; engine
    start() stop() 
    public void fly() {
        // engine
    }
}

Dummy1.java
public class Dummy1 implements Flyable {
    public void fly() {
        // jump from 10th floor
    }
}

Dummy2.java
public class Dummy2 implements Flyable {
    public void fly() {
        // fast train ...
    }
}

Solution:  Anonymous class
Flyable f = new Flyable() {
     public void fly() {
        // jump from 10th floor
    }
}; 
f.fly();
```

If interface has only one method to implement ==> @FunctionalInterface we can use Lambda expression instead of anonymous class

=====

Generics in Java
--> can have only Object type as genrics; not primitive type
Integer is a type wrapper for int
Double is a type wrapper for double

int x = 10;
Integer iX = x; // boxing

int y = iX; // unboxing
y++;

```
public class Rectangle {
	private int width;
	private int breadth;
    ///
}

public class Rectangle<T> {
	private T width;
	private T breadth;
    //
}

Reactangle<Integer> r1 = new Rectangle<>(3,5);
Rectangle<Double> r2 = new Rectangle<>(2.2 , 4.2);

public class LinkedList<T> {
    Node<T> nodes[];
}

class Node<T> {
    T data;
    int next;
    int prev;
}

LinkedList<Employee> empList = ...
LinkedList<Product> productList = ...

```

Existing code:
```
public interface IComparable {
	int compare(Object other);
}

public abstract class Product implements IComparable {
    @Override
	public int compare(Object other) {
		Product p = (Product) other;
		return Double.compare(this.price, p.price);
	}
}
```
Generic interface and methods:
```
    public interface IComparable<T> {
        int compare(T other);
    }
    public abstract class Product implements IComparable<Product> {
    @Override
	public int compare(Product other) {
        return Double.compare(this.price, other.price);
    }
```

Abstract class:
* can have state and behaviour
* meant for generalization; having common behaviour up the tree
* single inheritance

interfaces:
* can't have state
* for realization
* class can implement multiple interfaces

===

Java Collection Framework

Comparable and Comparator interfaces are used to compare for operations like sort(), max, min(), ...

```
Logic for comparision is part of Object which is getting comparated:
for example to compare String logic is in String class
to compare Product logic will be in Product class

Most of the cases we use this to compare based on PRIMARY key of field [ like id of product, id of employee, Lexiacal ordering for String]
public interface Comparable<T> {
      int compareTo(T o);
}

In case of Comparator, logic will be in client code and not in Object which is getting compared
public interface Comparator<T> {
     int compare(T o1, T o2);
}
```

Arrays class contains algorithms like sort(), max(), min(), binarySearch() .. to be used on array type data container
It uses Comparable or Compartor for comparision

Array type of data container should be the first choice for data container.
* size is fixed
* adding / removing in arbitrary position is difficult O(n)
array of 100 elements; if i add data in 10th position 
* Contiguous memory

Java Collection Framework:
1) interfaces
2) implementation classes
3) Algorithm / utility classes

Collection is a interface which contains all basic mehtods required for data container
List extends Collection
Set extends Collection
Queue extends Collection

List:
1) index based operations are possible
2) ordered
3) duplicates are allowed
4) re-ordered: sort, shuffle, reverse

Set:
1) unique 
2) no duplicated
3) ordering is based on different algorithms
4) can't re-order

Vector, Stack are legacy collections introduced in Java 1.2; issues with them is they are very slow
operations in these containers uses locking mechanism. [ synchronized]
They did this to avoid data corruption in multi-user env [ multi-threaded]
i need to add data in Vector
1) Lock the vector
2) add data
3) UnLock

```
// Avoid
ArrayList list = new ArrayList();

// program to interface
List list = new ArrayList(); 
List list = new LinkedList();

list.add("A");
list.add(22);
list.add(new Date());

if(list.get(2) instanceof Date) {
    Date d = (Date) list.get(2);
}

Use Generics all the time; which is type-safe
List<String> list = new  ArrayList<>();
list.add("A"); // valid
list.add(22); // compilation error
String str = list.get(0);
```

enhanced for loop and iterator are safe iteration; fail fast exception; internally it uses locking mechanism
doesn;t allow concurrent access

Task:
ListExample.java

Sort products based on Name [ case-insensitive]; Don't modify Product.java

===================

HashCode 
Numerical representation of an object.
* 2 similar objects should have same hashcode
* objects which are not similar can also have same hashcode

public class Rectangle {
    ///

    // bad hashcode
    public int hashCode() {
        return w * b;
    }

    // good code
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + breadth;
		result = prime * result + width;
		return result;
	}
}

Rectangle 4,5 ==> 20
Reactangle 20,1 ==> 20
Rectangle 5,4 ==> 20
Rectangle 10, 2 ==> 20

HashCode is used for Hashbased data containers ==> Hashtable / HashMap / HashSet

Quick look into HashSet and Hashtable

Map --> data container in the form of key/value pairs
key --> unique
value -> can be duplicate

Dictionary --> Map type
Registry --> Map type

Task: use Map
Map --> HashMap / TreeMap

=====================

Annotation: Metadata
Annotations contains only properties; no methods and fields/variable

1) Who uses?
* COMPILER
* CLASSLOADER
* RUNTIME
2) Where can i apply?
* TYPE [class / interface / annotation / record / enum]
* method
* parameters
* field

```
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Override {
}

```


Using Annotations I am going to generate SQL for entity classes

Avoid String concatination:
String s = "Hello"; // immutable
s += "World"; // here a new string is created in heap area
s += "123"; // here a new string is created in heap area

Task Day 2:
Complete 
SQL = SQLUtil.generateInsertSQL(e);

Check HashSet and ArrayBlockingQueue

HashSet: uses hashCode() and equals() to identity duplicates and deciding position of added elements
equals() is called only when hashCode() is same

TreeSet: uses Comparable to identify duplicates and ordering

Set<String> set = new TreeSet<>(); // Comparable

Set<Product> set = new TreeSet<>((p1,p2) -> p1.getName().compareTo(p2.getName())) ; // comparator

============

Day 3:

Maven --> Java Build tool
* Manage dependencies ==> 3rd party libraries for the project
* Automate Compile, testing, build, deploy
* Plugin configuration 
* Uniformity across the team members, IDEs

pom.xml ==> Project Object Model ==> Configuration file where dependencies, plugins, etc are configured

pom.xml
```
<dependencies>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.0.33</version>
    </dependency>
</dependencies>

com
 mysql
   mysql-connector-j
     8.0.33
        mysql-connector-j-8.0.33.jar


settings.xml
Remote repository
<servers>
    <server>
      <id>adobe proxy server</id>
      <username>my_login</username>
      <password>my_password</password>
      <privateKey>${user.home}/.ssh/id_dsa</privateKey>
      <passphrase>some_passphrase</passphrase>
      <filePermissions>664</filePermissions>
      <directoryPermissions>775</directoryPermissions>
      <configuration></configuration>
    </server>
  </servers>


Central repositoreries
<url>https://oss.sonatype.org/content/repositories/snapshots</url>
<url>https://repo1.maven.org/maven2/</url>

```

JDBC --> Java Database Connectivity 
JDBC provides interfaces; implementation classes are provided by database vendors

Steps to interact with relational database:
1) Load vendor specific drivers into JRE

Class.forName("driverClassName");

Example: Class.forName("com.mysql.jdbc.cj.Driver"); --> mysql-connector-8.0.33.jar
Class.forName("oracle.jdbc.Driver"); 

2) Establish database connection

java.sql.Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

getConnection() is a factory method; based on URL passed it creates OracleConnection / PostgressConnection / MySqlConnection

Connection is a interface

java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://198.02.34.11:3306/emp_db", USERNAME, PASSWORD);
java.sql.Connection con = DriverManager.getConnection("jdbc:oracle:thin://198.02.34.11:1521/emp_db", USERNAME, PASSWORD);

3) Send SQL 
3.1) Statement
 use this if SQL is fixed; same sql for n Requests
 select * from products

 http://server.com?id=10

 http://server.com?id=  ' UNION SLEEP(10);--

 String query = "SELECT * FROM accounts WHERE custID='" + request.getParameter("id") + "'";

http://server.com?id=  ' or 1 = 1

3.2) PreparedStatement
Use this in case of SQL depends on IN parameters (?)

select * from accounts where account_id =?

insert into products values (?,?,?,?);
https://owasp.org/www-project-top-ten/

3.3) CallableStatement
is used to invoke stored procedure of database

4) ResultSet

4) always close resources in finally block [ compulsory execute code]

executeQuery() for SELECT SQL
executeupdate() for INSERT, DELETE, UPDATE SQL

try {
    /..
    ////
    ///
} catch(SQLException ex) {
    //
} finally {
    ///
}

====
```

mysql> create database order_app_db;

mysql> use order_app_db;

mysql> create table products (id int PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100), price Double, quantity int, category VARCHAR


mysql> insert into products values (0, 'Sony Bravia', 210000.00, 100, 'tv');

mysql> insert into products values (0, 'iPhone 14', 120000.00, 100, 'mobile');


mysql> insert into products values (0, 'OnePlus Nord', 98000.00, 100, 'mobile');


mysql> select * from products;
+----+--------------+--------+----------+----------+
| id | name         | price  | quantity | category |
+----+--------------+--------+----------+----------+
|  1 | Sony Bravia  | 210000 |      100 | tv       |
|  2 | iPhone 14    | 120000 |      100 | mobile   |
|  3 | OnePlus Nord |  98000 |      100 | mobile   |
+----+--------------+--------+----------+----------+


```
Task:
complete getProduct(int id) and write a client to test it.

convert this application into ==> Web application

=========================

Web application Development using Servlet technology

Servlet --> Server side Java object which runs within Servlet Container

http://localhost:8080/login

http://localhost:8080/register

HttpServletRequest ==> object is instantiated by the Servlet engine/ web container to encapsulate all the data from client[FORM data, payload, Browser, OS data]

HttpServletResponse ==> object is used to write data back to client

For every request HttpServletRequest & HttpServletResponse objects are created; they are destroyed once response is commited to client

10 concurrent users means 10 threads for Thread pool is used; at that point in Servlet engine ten instances of HttpServletRequest & HttpServletResponse objects exist in container.

Servlet:
```
GET http://localhost:8080/products

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Servlet code
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
            // Servlet code
    }
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    // Servlet code
    }
    public void doUpdate(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    // Servlet code
    }
}

HTTP Methods: GET , POST, PUT and DELETE

Address bar and hyperlink ==> GET request
FORM data ==> can be POST

```

1) Apache Tomcat (or simply Tomcat) is an open source web server and servlet container developed by the Apache Software Foundation (ASF)

2) Jetty: Eclipse Jetty is a Java web server and Java Servlet container. 

3) Netty: provides NIO based Web server and servlet container

We can have a phyiscal installation or use Maven plugin [ good enough for development]

in "war" files compiled code will be in "WEB-INF" folder

By default Servlet Container / engine looks for web.xml as deployment descriptor

```

public class EmployeeServlet extends HttpServlet {

}

web.xml
<servlet>
    <servlet-name>First</sevlet-name>
    <servlet-class>com.adobe.prj.web.EmployeeServlet</servlet-class>
</servlet>

<servlet-mapping>
     <servlet-name>First</sevlet-name>
     <url-pattern>/employee</url-pattern>
</servlet-mapping>

```

By using Annotation no need for web.xml
@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet {

database > right click ==>  Run As ==> Maven build [second one]
goals: jetty:run

===

1)
customers database table

email [PK] first_name last_name

2)
CustomerDao iterface
addCustomer(Customer c)
List<Customer> getCustomers()

CustomerDaoJdbcImpl
INSERT and SELECT

3)
CustomerController Servlet

4)
index.html
<a href="customers">Customers </a>
<a href="customerForm.html">Add Customer </a>


Servlet Container ==> application on JVM; life-cycle management and DI of HttpServletRequest and HttpServletResponse
Limited to Web tier [ servlets]

Java 8 Streams ==> Pending 

Spring and JPA frameworks

Spring Framework : It's a container which manages life-cycle of bean and wires dependencies.
Bean --> any object managed by Spring Container.
Spring Container is a Inversion Of Control container [ DI is acheived using IOC ]


Spring instantiates class which has one of these annotations:
1) @Component --> utility / helper classes
2) @Repository --> DAO classes
3) @Service --> Service classes
4) @Configuration -> reading properties nad factory methods
5) @Controller --> Traditional Web applications like [ servlet and JSP] 
6) @RestController --> Building RESTful Web Services



public class Book {}

public interface BookDao {
    void addBook(Book b);
}

@Repository
public class BookDaoJdbcImpl implements BookDao {
    public void addBook(Book b) {
        ///
    }
}

@Service
public class AppService {
    @Autowired
    BookDao bookDao;

    public void insertBook(Book b) {
        bookDao.addBook(b);
    }
}

@SpringBootApplication
public class Example {
    public static void main(String[] args) {
       ApplicationContext ctx = SpringApplication.run(Example.class);
       AppService service = ctx.getBean("appService", AppService.class);
       Book b = new Book(...);
       service.insertBook(b);
    }
}

Spring depends on ByteBuddy / JavaAssist / CGLLIB libraries for wiring dependencies, creating proxies by using ByteCode Instrumentation

====
Problem if more than one bean for a given interface exists:

```
Solution 1: make one of the bean @Primary

@Repository
@Primary
public class BookDaoJdbcImpl implements BookDao {

@Repository
public class BookDaoMongoImpl implements BookDao {


Solution 2: use Qualifier
@Repository
public class BookDaoMongoImpl implements BookDao {

@Repository
public class BookDaoJdbcImpl implements BookDao {


@Service
public class LibraryService {
	@Autowired
	@Qualifier("bookDaoJdbcImpl")
	private BookDao bookDao; // interface ==> Spring Container is going to wire the dependency

```
======

30 min ==> Java 8 streams ==> map(), filter() and reduce()

Factory methods in Spring:
* Sometimes we need to create objects of classes which are from 3rd party libraries;
classes of 3rd party libraries can't have any of above mentioned 6 annotations
The created objects has to be manged by spring container

Example:

DriverManger.getConnection() ==> creates a single connection
issues ==> every time you invoke method connection is establised and released in the end of the method.
This leads to latency

In Enterprise application we need to have pool of database connections

DataSource ==> pool of database Connection
Connetion pool is done by 3rd party libraries
https://github.com/brettwooldridge/HikariCP
https://www.mchange.com/projects/c3p0/


=============

ORM Framework ==> Object Relational Mapping
* Hibernate
* TopLink
* KODO
* JDO
* OpenJPA
* EclipseLink

JPA --> Java Persistence API : Specification for ORM frameworks [ consider interfaces]

Spring Simplifies using JPA ==> "Spring Data JPA" simplifies using JPA

Steps:
1) New Spring Starter Project
Name: orderapp
Type: Maven
Language: Java
Version: 17
Group: com.adobe
artifact: orderapp
package: com.adobe.prj


2) Next
Add the following dependencies:
2.1) mysql driver
2.2) jpa ==> Spring Data JPA
2.3) lombok

Finish

3) Spring boot is highly opiniated Framework on top of Spring
If I include Spring Data JPA, it adds the below configs:
a) uses HikariCP as DataSource ==> pool of database connection based on entries in "application.properties"
https://docs.spring.io/spring-boot/docs/current/reference/html/application-properties.html

b) configures Hibernate as the ORM framework

c) create DAO interfaces ==> Implementation classes are generated by Spring Data JPA
--> No need for @Repository classes


spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
We need ORM to generate SQL compatable to MySQL

spring.jpa.hibernate.ddl-auto=update
update ==> for the mapping done [class -> table], if table exists use it; if not create table; if required alter

spring.jpa.hibernate.ddl-auto=create
create=> drop table when application shutsdown; create when application starts; only good for testing

spring.jpa.hibernate.ddl-auto=verify
verify => use provided tables without altering; if mismatch throw error

```

Association Mapping
1) Metting Room booking
* Employee
* MeetingRoom [Chandra / Awastha / SIRMV/..]
* Training
* Booking

meeting_room
ID  NAME        LOCATION  CAPACITY
21  CHANDRA     15        NOIDA
22  SIR MV      40        BENGALURU


employees
ID  NAME DESIGNATION  EMAIL
18  A    MANAGER      a@adobe.com
61  B    TEAM LEAD    b@adobe.com

trainings
ID NAME TRAINER 
1  JAVA  T
2  WEB   R
3  C++   X


bookings
ID    booked_by      booked_date  training   room
800   b@adobe.com     19-JUL-23   2          22 
801   a@adobe.com     20-JUL-23   1          21
802   a@adobe.com     21-JUL-23   2          21

```

Order application:
```
orders
ORDER_ID  ORDER_DATE  TOTAL  customer_fk
123       19-JUL-23   89011  sam@adobe.com
124       20-JUL-23   600    raj@adobe.com
125       20-JUL-23   9800   sam@adobe.com


line_items
ITEM_ID  PRODUCT_FK  ORDER_FK QTY  AMOUNT
422       4           123       2   9000.00
423       6           123       1   8900.00
425       4           124       1   4500.00
```

ASSOCITION MAPPING:
1) OneToOne
2) OneToMany
3) ManyToOne
4) ManyToMany

```
ManyTo introduces FK in owning table
@ManyToOne
	@JoinColumn(name="CUSTOMER_FK") --> orders table
	private Customer customer; 
	
OneToMany introduces FK in child table
	@Builder.Default
	@OneToMany
	@JoinColumn(name="ORDER_FK") --> items table
	private List<LineItem> items = new ArrayList<>();
```

1 Order has 4 lineitems;

```
1) Without Cascade
@OneToMany
	@JoinColumn(name="ORDER_FK")
	private List<LineItem> items = new ArrayList<>();
 orderDao.save(order);
 itemDao.save(i1);
 itemDao.save(i2);
 itemDao.save(i3);
 itemDao.save(i4);

Delete:
orderDao.delete(order);
itemDao.delete(i1);
itemDao.delete(i2);
itemDao.delete(i3);
itemDao.delete(i4);

2) With Cascade
@OneToMany(cascade = CascadeType.ALL)
 @JoinColumn(name="ORDER_FK")
 private List<LineItem> items = new ArrayList<>();
 orderDao.save(order); // saves order and it's line items

 orderDao.delete(order); // delete order and lineitems
```

Fetch Strategy: LAZY BY DEFAULT

```
@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="ORDER_FK")
	private List<LineItem> items = new ArrayList<>();
orderDao.findById(2);
// select * from orders where id = 2
```

EAGER Fetching:

```
@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
@JoinColumn(name="ORDER_FK")
private List<LineItem> items = new ArrayList<>();
orderDao.findById(2);
// select * from orders where id = 2
// select items from line_items where order_fk = 2
```


@Transactional  makes the operations in method atomic

@Transactional: code in @Transactional will be flushed to database if it undergoes a change ==> Dirty checking

Client sends the order by REACT / Android / Swift client

Order in JSON format:
```
{
    "customer": {email:"sam@adobe.com"},
    "items" : [
        {"product": {id: 3}, qty: 1},
        {"product": {id: 1}, qty: 2}
    ]
}
```

Dirty Checking:
```
@Transactional
public void updateProduct(int id, int qty) {
    Product p = productDao.findById(id).get();
    p.setQuantity(qty); // dirty ==> update
}
```

Day 4 Recap:

Spring Boot Framework: this is a framework on top of Spring Framework, which is highly opinated [ lots of configuration comes out of box]
Opinated:
1) If we choose Spring Data JPA
a) We get Database connection pooling using HikariCP library [ uses database entires in application.properties ]
b) we get Hibernate as ORM provider

2) If we decide to build web application
a) Tomcat is configured as default Servlet engine / web container
b) Jackson library as HttpMessageConverter Java <---> JSON

lots of other configs are provided.

Spring Container: IOC container --> Life cycle management of beans and wiring
Spring Container creates instances of classes which has one of these annotations at class level
1) @Component
2) @Repository
3) @Service
4) @Configuration
5) @Controller
6) @RestController

Factory methods are writtin class with @Configuration; methods are marked as @Bean; the object returned this mehtod is managed by spring container [ need: we need 3rd party classes { won't have above mentioned 6 annotations} to be managed by spring container]

public class MyConfig {

}

@Bean
public MyConfig getMyConfig() {
    return new MyConfig(...);
}

Wiring is done using
1) @Autowired
2) @Inject

Wiring is done by using ByteCode instrumentation libraries like ByteBuddy, JavaAssist, CGLib

---

ORM Framework Java <--> database table; ORM frameworks takes care of CRUD operations and also DDL
PersistenceContext is a environment where all entities are managed [ Synchronized with DB ]
@Entity [Must have] --> to be managed by PersistenceContext 
@Table [ if not provided; maps class name to table name]
@Column [ if not provided; maps java variables to table column]
@Id [ must have] for PK
@OneToMany
@ManyToOne
@JoinColumn [ FK mapping]

Where FK comes is decided by @ManyToOne [@JoinColumn introduces FK in owning table] 
or @OneToMany [@JoinColumn introduces FK in the child table]

----

@OneToMany
1) Cascade.ALL
save parent; children are also persited
delete parent object; childrens are also deleted

2) FETCH
* default for OneToMany is LAZY
orderDao.findAll(); // select * from orders;

* if we configure EAGER fetching
orderDao.findAll(); // select * from orders; [ 4, 10, 23]
also: select * from line_items where order_fk = 4;
select * from line_items where order_fk = 10;
select * from line_items where order_fk = 23;

----

interface BookDao extends JpaRepository<Book, String> {

}

JpaRepository has many methods for CRUD operations; Spring Data JPA generates Repositroy class for pre-defined methods;
i.e, we don't need @Repository class

Cascade can be used only for OneToMany and ManyToMany


By Default: ManyToOne is EAGER fetch
=============

Day 5:

JP-QL ==> Java Persitence Query Language 
SQL

select email, fname from customers



select email, firstName from Customer

```
select * from orders o join customers c  on  o.customer_fk = c.email;
+----------+----------------------------+--------+---------------+---------------+---------+-------+
| order_id | order_date                 | total  | customer_fk   | email         | fname   | lname |
+----------+----------------------------+--------+---------------+---------------+---------+-------+
|        1 | 2023-07-20 16:58:37.313000 | 450000 | sam@adobe.com | sam@adobe.com | Samanta | Ruth  |
|        2 | 2023-07-21 10:02:41.873000 | 111500 | raj@adobe.com | raj@adobe.com | Raj     | Kumar |
+----------+----------------------------+--------+---------------+---------------+---------+-------+

public interface OrderDao extends JpaRepository<Order, Integer> {
    @Query(value="select * from orders o join customers c  on  o.customer_fk = c.email", nativeQuery = true)
    List<Object[]> getReport();
}

OR

@ManyToOne
@JoinColumn(name="CUSTOMER_FK")
private Customer customer; 

public interface OrderDao extends JpaRepository<Order, Integer> {
    @Query("from Order o join on o.customer")
    List<Object[]> getReport();
}

```



