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














