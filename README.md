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

database-1.0.0.jar <== build file
Default scope is make the library available in final build ==> JRE
 <scope>provided</scope> ==> use this library only to compile ==> will not be a part of my final production code
 <scope>test</scope> ==> use this library only to run test cases

 Another use case of provided:
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>4.0.1</version>
    <scope>provided</scope>
</dependency>

Here we need servlet-api for compilation and also required in runtime;
we have told that don't include servlet api in my final bundle, use it to compile; target machine [server] already has this

Exception Handling:

public class PersistenceException extends Exception {
    public PersisteinceException(String msg) {
        ...
    }
}

client code:
ProductDao productDao = new ProductDaoJdbcImpl(); // use factory

Product p = new Product(..);
try {
    productDao.addProduct(p);
} catch(PeristenceException ex) {
    ex.getMessage();
    ex.printStackTrace();
}


interface ProductDao {
    void addProduct(Product p) throws PersistenceException;
}

class ProductDaoJdbcImpl implements ProductDao {
    public void addProduct(Product p) throws PersistenceException{
           try {
            // SQL
           } catch(SQLException ex) {
            throw new PersitenceException("unable to add product");
           }
    }
}


class ProductDaoMongodbImpl implements ProductDao {
    public void addProduct(Product p) throws PersistenceException{
           try {
            // SQL
           } catch(MongoException ex) {
            throw new PersitenceException("unable to add product");
           }
    }
}




