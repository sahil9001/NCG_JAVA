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
java -jar lombok.1.18.26.jar

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
    private String title;
    private double price;

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


===========

