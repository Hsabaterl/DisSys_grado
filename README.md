#  Distributed Systems
This repository contains the code for the labs and assignements of Distributed Systems subject. 

## Table of Conents

1. Setup the enviornment and install the dependencies

2. Install the IDE of yout preferences

## 1. Setup the environment

You need to install both the Java JDK and the Java JRE. 

### 1.1 Linux based distibutions

#### Ubuntu / Debian

``` bash 
sudo apt update
sudo apt install default-jre
sudo apt install default-jdk
```

If you want to check whether it is installed, you can do it by typing:

``` bash 
java -version
javac -version
```

If everything was ok, you will see the versions of both the JDK and Java JRE installed. 


## chosing the IDE. 

You can use, (and we encourage you to) use the IDE of your choice. During the course, we will use Maven as the java management tool.  Here, a couple tips for setting and building a Maven project when working on Eclipse IDE / VS Code. 


### 2.1.  Setup the maven project in Visual Studio Code


You must have installed the java extension. 

Afterwards, you must go in the top search bar and type:
` > maven  '

And selecct mave prohect.  Initially, choose the simples option "archetype"


### 2.2. Setup the project in Eclipse. 


You must create a project  in Eclipse main menu  "Create Maven Project". 

Complete the name and namespace for the project.



If everything worked properly you should see the following structure:

```plaintext


├── src/
│   ├── main/
│   │   ├── App.java 
│   ├── test/
│   │   ├── appTestjava.java
│   │   └── 
│   ├── App.js
│   └── index.js
├── target/
│   ├── classes/
│   └── test-classes/
├── .gitignore
├── pom.xml
└── README.md


```



## You can clone this repository to start.

``` bash 
git clone  https://github.com/ghe16/DisSys_grado

