# CRM System

This repository contains the source code and documentation for a Customer Relationship Management (CRM) system built using Java (Spring Boot) for the backend and MySQL for the database. The project also includes UML diagrams, SQL queries, and detailed descriptions to showcase system design and functionality.
## Folder Structure
The repository is organized as follows:
/CRM-Project
│
├── /docs
│   ├── /uml
│   │   ├── UseCaseDiagram.png
│   │   ├── ClassDiagram.png
│   │   ├── SequenceDiagram.png
│   │   └── DeploymentDiagram.png
│   ├── /descriptions
│   │   ├── CRM_DatabaseDescription.pdf
│   │   └── CRM_JAVA_FILESDescription.pdf
│
├── /src
│   ├── /main
│   │   ├── /java
│   │   │   ├── module-info.java
│   │   │   ├── /CRM
│   │   │   │   ├── Accounts.java
│   │   │   │   ├── Activities.java
│   │   │   │   ├── Campaigns.java
│   │   │   │   ├── Customer.java
│   │   │   │   ├── DatabaseConnection.java
│   │   │   │   ├── Employee.java
│   │   │   │   ├── Leads.java
│   │   │   │   ├── Main.java
│   │   │   │   ├── Opportunities.java
│   │   │   │   ├── Person.java
│   │   │   │   ├── Tickets.java
│   │   │   │   ├── AccountsDAO.java
│   │   │   │   ├── ActivitiesDAO.java
│   │   │   │   ├── CampaignsDAO.java
│   │   │   │   ├── CustomerDAO.java
│   │   │   │   ├── EmployeeDAO.java
│   │   │   │   ├── LeadsDAO.java
│   │   │   │   ├── OpportunitiesDAO.java
│   │   │   │   ├── PersonDAO.java
│   │   │   │   └── TicketsDAO.java
│
├── /sql
│   ├── /queries
│   │   ├── basic-queries.sql
│   │   ├── intermediate-queries.sql
│   │   └── advanced-queries.sql
│   └── CRM.sql
│
├── /frontend (future work)
│
└── README.md
