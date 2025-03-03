package CRM;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            // Initialize DAOs
            PersonDAO personDAO = new PersonDAO(connection);
            CustomerDAO customerDAO = new CustomerDAO(connection);
            EmployeeDAO employeeDAO = new EmployeeDAO(connection);
            AccountsDAO accountsDAO = new AccountsDAO(connection);
            TicketsDAO ticketsDAO = new TicketsDAO(connection);
            OpportunitiesDAO opportunitiesDAO = new OpportunitiesDAO(connection);
            CampaignsDAO campaignsDAO = new CampaignsDAO(connection);
            LeadsDAO leadsDAO = new LeadsDAO(connection);
            ActivitiesDAO activitiesDAO = new ActivitiesDAO(connection);

            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\n--- CRM System Menu ---");
                System.out.println("1. Person Operations");
                System.out.println("2. Customer Operations");
                System.out.println("3. Employee Operations");
                System.out.println("4. Account Operations");
                System.out.println("5. Ticket Operations");
                System.out.println("6. Opportunity Operations");
                System.out.println("7. Campaign Operations");
                System.out.println("8. Lead Operations");
                System.out.println("9. Activity Operations");
                System.out.println("10. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        personOperations(personDAO, scanner);
                        break;
                    case 2:
                        customerOperations(customerDAO, scanner);
                        break;
                    case 3:
                        employeeOperations(employeeDAO, scanner);
                        break;
                    case 4:
                        accountOperations(accountsDAO, scanner);
                        break;
                    case 5:
                        ticketOperations(ticketsDAO, scanner);
                        break;
                    case 6:
                        opportunityOperations(opportunitiesDAO, scanner);
                        break;
                    case 7:
                        campaignOperations(campaignsDAO, scanner);
                        break;
                    case 8:
                        leadOperations(leadsDAO, scanner);
                        break;
                    case 9:
                        activityOperations(activitiesDAO, scanner);
                        break;
                    case 10:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Person Operations
    private static void personOperations(PersonDAO personDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Person Operations ---");
        System.out.println("1. Insert a new person");
        System.out.println("2. Retrieve all persons");
        System.out.println("3. Retrieve a person by ID");
        System.out.println("4. Retrieve persons by last name");
        System.out.println("5. Update a person");
        System.out.println("6. Delete a person");
        System.out.println("7. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertPerson(personDAO, scanner);
                break;
            case 2:
                retrieveAllPersons(personDAO);
                break;
            case 3:
                retrievePersonById(personDAO, scanner);
                break;
            case 4:
                retrievePersonsByLastName(personDAO, scanner);
                break;
            case 5:
                updatePerson(personDAO, scanner);
                break;
            case 6:
                deletePerson(personDAO, scanner);
                break;
            case 7:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Customer Operations
    private static void customerOperations(CustomerDAO customerDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Customer Operations ---");
        System.out.println("1. Insert a new customer");
        System.out.println("2. Retrieve all customers");
        System.out.println("3. Retrieve a customer by ID");
        System.out.println("4. Update a customer");
        System.out.println("5. Delete a customer");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertCustomer(customerDAO, scanner);
                break;
            case 2:
                retrieveAllCustomers(customerDAO);
                break;
            case 3:
                retrieveCustomerById(customerDAO, scanner);
                break;
            case 4:
                updateCustomer(customerDAO, scanner);
                break;
            case 5:
                deleteCustomer(customerDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Employee Operations
    private static void employeeOperations(EmployeeDAO employeeDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Employee Operations ---");
        System.out.println("1. Insert a new employee");
        System.out.println("2. Retrieve all employees");
        System.out.println("3. Retrieve an employee by ID");
        System.out.println("4. Update an employee");
        System.out.println("5. Delete an employee");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertEmployee(employeeDAO, scanner);
                break;
            case 2:
                retrieveAllEmployees(employeeDAO);
                break;
            case 3:
                retrieveEmployeeById(employeeDAO, scanner);
                break;
            case 4:
                updateEmployee(employeeDAO, scanner);
                break;
            case 5:
                deleteEmployee(employeeDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Account Operations
    private static void accountOperations(AccountsDAO accountsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Account Operations ---");
        System.out.println("1. Insert a new account");
        System.out.println("2. Retrieve all accounts");
        System.out.println("3. Retrieve an account by ID");
        System.out.println("4. Update an account");
        System.out.println("5. Delete an account");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertAccount(accountsDAO, scanner);
                break;
            case 2:
                retrieveAllAccounts(accountsDAO);
                break;
            case 3:
                retrieveAccountById(accountsDAO, scanner);
                break;
            case 4:
                updateAccount(accountsDAO, scanner);
                break;
            case 5:
                deleteAccount(accountsDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Ticket Operations
    private static void ticketOperations(TicketsDAO ticketsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Ticket Operations ---");
        System.out.println("1. Insert a new ticket");
        System.out.println("2. Retrieve all tickets");
        System.out.println("3. Retrieve a ticket by ID");
        System.out.println("4. Update a ticket");
        System.out.println("5. Delete a ticket");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertTicket(ticketsDAO, scanner);
                break;
            case 2:
                retrieveAllTickets(ticketsDAO);
                break;
            case 3:
                retrieveTicketById(ticketsDAO, scanner);
                break;
            case 4:
                updateTicket(ticketsDAO, scanner);
                break;
            case 5:
                deleteTicket(ticketsDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Opportunity Operations
    private static void opportunityOperations(OpportunitiesDAO opportunitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Opportunity Operations ---");
        System.out.println("1. Insert a new opportunity");
        System.out.println("2. Retrieve all opportunities");
        System.out.println("3. Retrieve an opportunity by ID");
        System.out.println("4. Update an opportunity");
        System.out.println("5. Delete an opportunity");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertOpportunity(opportunitiesDAO, scanner);
                break;
            case 2:
                retrieveAllOpportunities(opportunitiesDAO);
                break;
            case 3:
                retrieveOpportunityById(opportunitiesDAO, scanner);
                break;
            case 4:
                updateOpportunity(opportunitiesDAO, scanner);
                break;
            case 5:
                deleteOpportunity(opportunitiesDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Campaign Operations
    private static void campaignOperations(CampaignsDAO campaignsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Campaign Operations ---");
        System.out.println("1. Insert a new campaign");
        System.out.println("2. Retrieve all campaigns");
        System.out.println("3. Retrieve a campaign by ID");
        System.out.println("4. Update a campaign");
        System.out.println("5. Delete a campaign");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertCampaign(campaignsDAO, scanner);
                break;
            case 2:
                retrieveAllCampaigns(campaignsDAO);
                break;
            case 3:
                retrieveCampaignById(campaignsDAO, scanner);
                break;
            case 4:
                updateCampaign(campaignsDAO, scanner);
                break;
            case 5:
                deleteCampaign(campaignsDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Lead Operations
    private static void leadOperations(LeadsDAO leadsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Lead Operations ---");
        System.out.println("1. Insert a new lead");
        System.out.println("2. Retrieve all leads");
        System.out.println("3. Retrieve a lead by ID");
        System.out.println("4. Update a lead");
        System.out.println("5. Delete a lead");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertLead(leadsDAO, scanner);
                break;
            case 2:
                retrieveAllLeads(leadsDAO);
                break;
            case 3:
                retrieveLeadById(leadsDAO, scanner);
                break;
            case 4:
                updateLead(leadsDAO, scanner);
                break;
            case 5:
                deleteLead(leadsDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Activity Operations
    private static void activityOperations(ActivitiesDAO activitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Activity Operations ---");
        System.out.println("1. Insert a new activity");
        System.out.println("2. Retrieve all activities");
        System.out.println("3. Retrieve an activity by ID");
        System.out.println("4. Update an activity");
        System.out.println("5. Delete an activity");
        System.out.println("6. Back to main menu");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                insertActivity(activitiesDAO, scanner);
                break;
            case 2:
                retrieveAllActivities(activitiesDAO);
                break;
            case 3:
                retrieveActivityById(activitiesDAO, scanner);
                break;
            case 4:
                updateActivity(activitiesDAO, scanner);
                break;
            case 5:
                deleteActivity(activitiesDAO, scanner);
                break;
            case 6:
                return;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    // Person Methods
    private static void insertPerson(PersonDAO personDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Person ---");
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();

        Person newPerson = new Person(0, firstName, lastName, email, phone, address);
        personDAO.insertPerson(newPerson);
        System.out.println("New person inserted successfully!");
    }

    private static void retrieveAllPersons(PersonDAO personDAO) throws SQLException {
        System.out.println("\n--- List of All Persons ---");
        List<Person> persons = personDAO.getAllPersons();
        for (Person person : persons) {
            System.out.println(person);
        }
    }

    private static void retrievePersonById(PersonDAO personDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Person by ID ---");
        System.out.print("Enter person ID: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Person person = personDAO.getPersonById(personId);
        if (person != null) {
            System.out.println("Retrieved person: " + person);
        } else {
            System.out.println("Person not found with ID: " + personId);
        }
    }

    private static void retrievePersonsByLastName(PersonDAO personDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Persons by Last Name ---");
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        List<Person> persons = personDAO.getPersonsByLastName(lastName);
        if (!persons.isEmpty()) {
            System.out.println("Persons with last name '" + lastName + "':");
            for (Person person : persons) {
                System.out.println(person);
            }
        } else {
            System.out.println("No persons found with last name: " + lastName);
        }
    }

    private static void updatePerson(PersonDAO personDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update a Person ---");
        System.out.print("Enter person ID to update: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Person person = personDAO.getPersonById(personId);
        if (person != null) {
            System.out.println("Current details: " + person);
            System.out.print("Enter new first name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter new last name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter new address: ");
            String address = scanner.nextLine();

            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setEmail(email);
            person.setPhone(phone);
            person.setAddress(address);

            personDAO.updatePerson(person);
            System.out.println("Person updated successfully!");
        } else {
            System.out.println("Person not found with ID: " + personId);
        }
    }

    private static void deletePerson(PersonDAO personDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete a Person ---");
        System.out.print("Enter person ID to delete: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Person person = personDAO.getPersonById(personId);
        if (person != null) {
            personDAO.deletePerson(personId);
            System.out.println("Person deleted successfully!");
        } else {
            System.out.println("Person not found with ID: " + personId);
        }
    }

    // Customer Methods
    private static void insertCustomer(CustomerDAO customerDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Customer ---");
        System.out.print("Enter person ID: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();
        System.out.print("Enter registration date (YYYY-MM-DD): ");
        String registrationDateStr = scanner.nextLine();
        Date registrationDate = Date.valueOf(registrationDateStr);
        System.out.print("Enter total spent: ");
        Double totalSpent = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Customer newCustomer = new Customer(0, personId, companyName, registrationDate, totalSpent);
        customerDAO.insertCustomer(newCustomer);
        System.out.println("New customer inserted successfully!");
    }

    private static void retrieveAllCustomers(CustomerDAO customerDAO) throws SQLException {
        System.out.println("\n--- List of All Customers ---");
        List<Customer> customers = customerDAO.getAllCustomers();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void retrieveCustomerById(CustomerDAO customerDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Customer by ID ---");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("Retrieved customer: " + customer);
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }
    }

    private static void updateCustomer(CustomerDAO customerDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update a Customer ---");
        System.out.print("Enter customer ID to update: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            System.out.println("Current details: " + customer);
            System.out.print("Enter new person ID: ");
            int personId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new company name: ");
            String companyName = scanner.nextLine();
            System.out.print("Enter new registration date (YYYY-MM-DD): ");
            String registrationDateStr = scanner.nextLine();
            Date registrationDate = Date.valueOf(registrationDateStr);
            System.out.print("Enter new total spent: ");
            double totalSpent = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            customer.setPersonId(personId);
            customer.setCompanyName(companyName);
            customer.setRegistrationDate(registrationDate);
            customer.setTotalSpent(totalSpent);

            customerDAO.updateCustomer(customer);
            System.out.println("Customer updated successfully!");
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }
    }

    private static void deleteCustomer(CustomerDAO customerDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete a Customer ---");
        System.out.print("Enter customer ID to delete: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Customer customer = customerDAO.getCustomerById(customerId);
        if (customer != null) {
            customerDAO.deleteCustomer(customerId);
            System.out.println("Customer deleted successfully!");
        } else {
            System.out.println("Customer not found with ID: " + customerId);
        }
    }

    // Employee Methods
    private static void insertEmployee(EmployeeDAO employeeDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Employee ---");
        System.out.print("Enter person ID: ");
        int personId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter job title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Enter department: ");
        String department = scanner.nextLine();
        System.out.print("Enter salary: ");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter hire date (YYYY-MM-DD): ");
        String hireDateStr = scanner.nextLine();
        Date hireDate = Date.valueOf(hireDateStr);

        Employee newEmployee = new Employee(0, personId, jobTitle, department, salary, hireDate);
        employeeDAO.insertEmployee(newEmployee);
        System.out.println("New employee inserted successfully!");
    }

    private static void retrieveAllEmployees(EmployeeDAO employeeDAO) throws SQLException {
        System.out.println("\n--- List of All Employees ---");
        List<Employee> employees = employeeDAO.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void retrieveEmployeeById(EmployeeDAO employeeDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Employee by ID ---");
        System.out.print("Enter employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee employee = employeeDAO.getEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Retrieved employee: " + employee);
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    private static void updateEmployee(EmployeeDAO employeeDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update an Employee ---");
        System.out.print("Enter employee ID to update: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee employee = employeeDAO.getEmployeeById(employeeId);
        if (employee != null) {
            System.out.println("Current details: " + employee);
            System.out.print("Enter new person ID: ");
            int personId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new job title: ");
            String jobTitle = scanner.nextLine();
            System.out.print("Enter new department: ");
            String department = scanner.nextLine();
            System.out.print("Enter new salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new hire date (YYYY-MM-DD): ");
            String hireDateStr = scanner.nextLine();
            Date hireDate = Date.valueOf(hireDateStr);

            employee.setPersonId(personId);
            employee.setJobTitle(jobTitle);
            employee.setDepartment(department);
            employee.setSalary(salary);
            employee.setHireDate(hireDate);

            employeeDAO.updateEmployee(employee);
            System.out.println("Employee updated successfully!");
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    private static void deleteEmployee(EmployeeDAO employeeDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete an Employee ---");
        System.out.print("Enter employee ID to delete: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Employee employee = employeeDAO.getEmployeeById(employeeId);
        if (employee != null) {
            employeeDAO.deleteEmployee(employeeId);
            System.out.println("Employee deleted successfully!");
        } else {
            System.out.println("Employee not found with ID: " + employeeId);
        }
    }

    // Account Methods
    private static void insertAccount(AccountsDAO accountsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Account ---");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter creation date (YYYY-MM-DD): ");
        String creationDateStr = scanner.nextLine();
        Date creationDate = Date.valueOf(creationDateStr);
        System.out.print("Enter account type (Standard/Premium): ");
        String accountType = scanner.nextLine();
        System.out.print("Enter balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Accounts newAccount = new Accounts(0, customerId, accountNumber, creationDate, accountType, balance);
        accountsDAO.addAccount(newAccount);
        System.out.println("New account inserted successfully!");
    }

    private static void retrieveAllAccounts(AccountsDAO accountsDAO) throws SQLException {
        System.out.println("\n--- List of All Accounts ---");
        List<Accounts> accounts = accountsDAO.getAllAccounts();
        for (Accounts account : accounts) {
            System.out.println(account);
        }
    }

    private static void retrieveAccountById(AccountsDAO accountsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Account by ID ---");
        System.out.print("Enter account ID: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Accounts account = accountsDAO.getAccountById(accountId);
        if (account != null) {
            System.out.println("Retrieved account: " + account);
        } else {
            System.out.println("Account not found with ID: " + accountId);
        }
    }

    private static void updateAccount(AccountsDAO accountsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update an Account ---");
        System.out.print("Enter account ID to update: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Accounts account = accountsDAO.getAccountById(accountId);
        if (account != null) {
            System.out.println("Current details: " + account);
            System.out.print("Enter new customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new account number: ");
            String accountNumber = scanner.nextLine();
            System.out.print("Enter new creation date (YYYY-MM-DD): ");
            String creationDateStr = scanner.nextLine();
            Date creationDate = Date.valueOf(creationDateStr);
            System.out.print("Enter new account type (Standard/Premium): ");
            String accountType = scanner.nextLine();
            System.out.print("Enter new balance: ");
            double balance = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character

            account.setCustomerId(customerId);
            account.setAccountNumber(accountNumber);
            account.setCreationDate(creationDate);
            account.setAccountType(accountType);
            account.setBalance(balance);

            accountsDAO.updateAccount(account);
            System.out.println("Account updated successfully!");
        } else {
            System.out.println("Account not found with ID: " + accountId);
        }
    }

    private static void deleteAccount(AccountsDAO accountsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete an Account ---");
        System.out.print("Enter account ID to delete: ");
        int accountId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Accounts account = accountsDAO.getAccountById(accountId);
        if (account != null) {
            accountsDAO.deleteAccount(accountId);
            System.out.println("Account deleted successfully!");
        } else {
            System.out.println("Account not found with ID: " + accountId);
        }
    }

    // Ticket Methods
    private static void insertTicket(TicketsDAO ticketsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Ticket ---");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter issue description: ");
        String issueDescription = scanner.nextLine();
        System.out.print("Enter status (Open/In Progress/Closed): ");
        String status = scanner.nextLine();
        System.out.print("Enter created date (YYYY-MM-DD): ");
        String createdDateStr = scanner.nextLine();
        Date createdDate = Date.valueOf(createdDateStr);

        Tickets newTicket = new Tickets(0, customerId, issueDescription, status, createdDate);
        ticketsDAO.addTicket(newTicket);
        System.out.println("New ticket inserted successfully!");
    }

    private static void retrieveAllTickets(TicketsDAO ticketsDAO) throws SQLException {
        System.out.println("\n--- List of All Tickets ---");
        List<Tickets> tickets = ticketsDAO.getAllTickets();
        for (Tickets ticket : tickets) {
            System.out.println(ticket);
        }
    }

    private static void retrieveTicketById(TicketsDAO ticketsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Ticket by ID ---");
        System.out.print("Enter ticket ID: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Tickets ticket = ticketsDAO.getTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Retrieved ticket: " + ticket);
        } else {
            System.out.println("Ticket not found with ID: " + ticketId);
        }
    }

    private static void updateTicket(TicketsDAO ticketsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update a Ticket ---");
        System.out.print("Enter ticket ID to update: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Tickets ticket = ticketsDAO.getTicketById(ticketId);
        if (ticket != null) {
            System.out.println("Current details: " + ticket);
            System.out.print("Enter new customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new issue description: ");
            String issueDescription = scanner.nextLine();
            System.out.print("Enter new status (Open/In Progress/Closed): ");
            String status = scanner.nextLine();
            System.out.print("Enter new created date (YYYY-MM-DD): ");
            String createdDateStr = scanner.nextLine();
            Date createdDate = Date.valueOf(createdDateStr);

            ticket.setCustomerId(customerId);
            ticket.setIssueDescription(issueDescription);
            ticket.setStatus(status);
            ticket.setCreatedDate(createdDate);

            ticketsDAO.updateTicket(ticket);
            System.out.println("Ticket updated successfully!");
        } else {
            System.out.println("Ticket not found with ID: " + ticketId);
        }
    }

    private static void deleteTicket(TicketsDAO ticketsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete a Ticket ---");
        System.out.print("Enter ticket ID to delete: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Tickets ticket = ticketsDAO.getTicketById(ticketId);
        if (ticket != null) {
            ticketsDAO.deleteTicket(ticketId);
            System.out.println("Ticket deleted successfully!");
        } else {
            System.out.println("Ticket not found with ID: " + ticketId);
        }
    }

    // Opportunity Methods
    private static void insertOpportunity(OpportunitiesDAO opportunitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Opportunity ---");
        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter estimated value: ");
        double estimatedValue = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter stage (Prospecting/Qualification/Proposal/Negotiation/Closed Won/Closed Lost): ");
        String stage = scanner.nextLine();
        System.out.print("Enter created date (YYYY-MM-DD): ");
        String createdDateStr = scanner.nextLine();
        Date createdDate = Date.valueOf(createdDateStr);

        Opportunities newOpportunity = new Opportunities(0, customerId, description, estimatedValue, stage, createdDate);
        opportunitiesDAO.addOpportunity(newOpportunity);
        System.out.println("New opportunity inserted successfully!");
    }

    private static void retrieveAllOpportunities(OpportunitiesDAO opportunitiesDAO) throws SQLException {
        System.out.println("\n--- List of All Opportunities ---");
        List<Opportunities> opportunities = opportunitiesDAO.getAllOpportunities();
        for (Opportunities opportunity : opportunities) {
            System.out.println(opportunity);
        }
    }

    private static void retrieveOpportunityById(OpportunitiesDAO opportunitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Opportunity by ID ---");
        System.out.print("Enter opportunity ID: ");
        int opportunityId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Opportunities opportunity = opportunitiesDAO.getOpportunityById(opportunityId);
        if (opportunity != null) {
            System.out.println("Retrieved opportunity: " + opportunity);
        } else {
            System.out.println("Opportunity not found with ID: " + opportunityId);
        }
    }

    private static void updateOpportunity(OpportunitiesDAO opportunitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update an Opportunity ---");
        System.out.print("Enter opportunity ID to update: ");
        int opportunityId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Opportunities opportunity = opportunitiesDAO.getOpportunityById(opportunityId);
        if (opportunity != null) {
            System.out.println("Current details: " + opportunity);
            System.out.print("Enter new customer ID: ");
            int customerId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new description: ");
            String description = scanner.nextLine();
            System.out.print("Enter new estimated value: ");
            double estimatedValue = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new stage (Prospecting/Qualification/Proposal/Negotiation/Closed Won/Closed Lost): ");
            String stage = scanner.nextLine();
            System.out.print("Enter new created date (YYYY-MM-DD): ");
            String createdDateStr = scanner.nextLine();
            Date createdDate = Date.valueOf(createdDateStr);

            opportunity.setCustomerId(customerId);
            opportunity.setDescription(description);
            opportunity.setEstimatedValue(estimatedValue);
            opportunity.setStage(stage);
            opportunity.setCreatedDate(createdDate);

            opportunitiesDAO.updateOpportunity(opportunity);
            System.out.println("Opportunity updated successfully!");
        } else {
            System.out.println("Opportunity not found with ID: " + opportunityId);
        }
    }

    private static void deleteOpportunity(OpportunitiesDAO opportunitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete an Opportunity ---");
        System.out.print("Enter opportunity ID to delete: ");
        int opportunityId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Opportunities opportunity = opportunitiesDAO.getOpportunityById(opportunityId);
        if (opportunity != null) {
            opportunitiesDAO.deleteOpportunity(opportunityId);
            System.out.println("Opportunity deleted successfully!");
        } else {
            System.out.println("Opportunity not found with ID: " + opportunityId);
        }
    }

    // Campaign Methods
    private static void insertCampaign(CampaignsDAO campaignsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Campaign ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDateStr = scanner.nextLine();
        Date startDate = Date.valueOf(startDateStr);
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDateStr = scanner.nextLine();
        Date endDate = Date.valueOf(endDateStr);
        System.out.print("Enter budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Campaigns newCampaign = new Campaigns(0, name, startDate, endDate, budget, employeeId);
        campaignsDAO.addCampaign(newCampaign);
        System.out.println("New campaign inserted successfully!");
    }

    private static void retrieveAllCampaigns(CampaignsDAO campaignsDAO) throws SQLException {
        System.out.println("\n--- List of All Campaigns ---");
        List<Campaigns> campaigns = campaignsDAO.getAllCampaigns();
        for (Campaigns campaign : campaigns) {
            System.out.println(campaign);
        }
    }

    private static void retrieveCampaignById(CampaignsDAO campaignsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Campaign by ID ---");
        System.out.print("Enter campaign ID: ");
        int campaignId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Campaigns campaign = campaignsDAO.getCampaignById(campaignId);
        if (campaign != null) {
            System.out.println("Retrieved campaign: " + campaign);
        } else {
            System.out.println("Campaign not found with ID: " + campaignId);
        }
    }

    private static void updateCampaign(CampaignsDAO campaignsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update a Campaign ---");
        System.out.print("Enter campaign ID to update: ");
        int campaignId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Campaigns campaign = campaignsDAO.getCampaignById(campaignId);
        if (campaign != null) {
            System.out.println("Current details: " + campaign);
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new start date (YYYY-MM-DD): ");
            String startDateStr = scanner.nextLine();
            Date startDate = Date.valueOf(startDateStr);
            System.out.print("Enter new end date (YYYY-MM-DD): ");
            String endDateStr = scanner.nextLine();
            Date endDate = Date.valueOf(endDateStr);
            System.out.print("Enter new budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            campaign.setName(name);
            campaign.setStartDate(startDate);
            campaign.setEndDate(endDate);
            campaign.setBudget(budget);
            campaign.setEmployeeId(employeeId);

            campaignsDAO.updateCampaign(campaign);
            System.out.println("Campaign updated successfully!");
        } else {
            System.out.println("Campaign not found with ID: " + campaignId);
        }
    }

    private static void deleteCampaign(CampaignsDAO campaignsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete a Campaign ---");
        System.out.print("Enter campaign ID to delete: ");
        int campaignId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Campaigns campaign = campaignsDAO.getCampaignById(campaignId);
        if (campaign != null) {
            campaignsDAO.deleteCampaign(campaignId);
            System.out.println("Campaign deleted successfully!");
        } else {
            System.out.println("Campaign not found with ID: " + campaignId);
        }
    }

    // Lead Methods
    private static void insertLead(LeadsDAO leadsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Lead ---");
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter status (New/Contacted/Qualified/Lost): ");
        String status = scanner.nextLine();
        System.out.print("Enter employee ID: ");
        int employeeId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Leads newLead = new Leads(0, name, email, phone, source, status, employeeId);
        leadsDAO.addLead(newLead);
        System.out.println("New lead inserted successfully!");
    }

    private static void retrieveAllLeads(LeadsDAO leadsDAO) throws SQLException {
        System.out.println("\n--- List of All Leads ---");
        List<Leads> leads = leadsDAO.getAllLeads();
        for (Leads lead : leads) {
            System.out.println(lead);
        }
    }

    private static void retrieveLeadById(LeadsDAO leadsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Lead by ID ---");
        System.out.print("Enter lead ID: ");
        int leadId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Leads lead = leadsDAO.getLeadById(leadId);
        if (lead != null) {
            System.out.println("Retrieved lead: " + lead);
        } else {
            System.out.println("Lead not found with ID: " + leadId);
        }
    }

    private static void updateLead(LeadsDAO leadsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update a Lead ---");
        System.out.print("Enter lead ID to update: ");
        int leadId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Leads lead = leadsDAO.getLeadById(leadId);
        if (lead != null) {
            System.out.println("Current details: " + lead);
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new phone: ");
            String phone = scanner.nextLine();
            System.out.print("Enter new source: ");
            String source = scanner.nextLine();
            System.out.print("Enter new status (New/Contacted/Qualified/Lost): ");
            String status = scanner.nextLine();
            System.out.print("Enter new employee ID: ");
            int employeeId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            lead.setName(name);
            lead.setEmail(email);
            lead.setPhone(phone);
            lead.setSource(source);
            lead.setStatus(status);
            lead.setEmployeeId(employeeId);

            leadsDAO.updateLead(lead);
            System.out.println("Lead updated successfully!");
        } else {
            System.out.println("Lead not found with ID: " + leadId);
        }
    }

    private static void deleteLead(LeadsDAO leadsDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete a Lead ---");
        System.out.print("Enter lead ID to delete: ");
        int leadId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Leads lead = leadsDAO.getLeadById(leadId);
        if (lead != null) {
            leadsDAO.deleteLead(leadId);
            System.out.println("Lead deleted successfully!");
        } else {
            System.out.println("Lead not found with ID: " + leadId);
        }
    }

    // Activity Methods
    private static void insertActivity(ActivitiesDAO activitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Insert a New Activity ---");
        System.out.print("Enter related type (Opportunity/Campaign/Ticket/Lead): ");
        String relatedType = scanner.nextLine();
        System.out.print("Enter related ID: ");
        int relatedId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter activity type (Call/Email/Meeting/Task): ");
        String activityType = scanner.nextLine();
        System.out.print("Enter activity date (YYYY-MM-DD): ");
        String activityDateStr = scanner.nextLine();
        Date activityDate = Date.valueOf(activityDateStr);
        System.out.print("Enter notes: ");
        String notes = scanner.nextLine();

        Activities newActivity = new Activities(0, relatedType, relatedId, activityType, activityDate, notes);
        activitiesDAO.addActivity(newActivity);
        System.out.println("New activity inserted successfully!");
    }

    private static void retrieveAllActivities(ActivitiesDAO activitiesDAO) throws SQLException {
        System.out.println("\n--- List of All Activities ---");
        List<Activities> activities = activitiesDAO.getAllActivities();
        for (Activities activity : activities) {
            System.out.println(activity);
        }
    }

    private static void retrieveActivityById(ActivitiesDAO activitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Retrieve Activity by ID ---");
        System.out.print("Enter activity ID: ");
        int activityId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Activities activity = activitiesDAO.getActivityById(activityId);
        if (activity != null) {
            System.out.println("Retrieved activity: " + activity);
        } else {
            System.out.println("Activity not found with ID: " + activityId);
        }
    }

    private static void updateActivity(ActivitiesDAO activitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Update an Activity ---");
        System.out.print("Enter activity ID to update: ");
        int activityId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Activities activity = activitiesDAO.getActivityById(activityId);
        if (activity != null) {
            System.out.println("Current details: " + activity);
            System.out.print("Enter new related type (Opportunity/Campaign/Ticket/Lead): ");
            String relatedType = scanner.nextLine();
            System.out.print("Enter new related ID: ");
            int relatedId = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            System.out.print("Enter new activity type (Call/Email/Meeting/Task): ");
            String activityType = scanner.nextLine();
            System.out.print("Enter new activity date (YYYY-MM-DD): ");
            String activityDateStr = scanner.nextLine();
            Date activityDate = Date.valueOf(activityDateStr);
            System.out.print("Enter new notes: ");
            String notes = scanner.nextLine();

            activity.setRelatedType(relatedType);
            activity.setRelatedId(relatedId);
            activity.setActivityType(activityType);
            activity.setActivityDate(activityDate);
            activity.setNotes(notes);

            activitiesDAO.updateActivity(activity);
            System.out.println("Activity updated successfully!");
        } else {
            System.out.println("Activity not found with ID: " + activityId);
        }
    }

    private static void deleteActivity(ActivitiesDAO activitiesDAO, Scanner scanner) throws SQLException {
        System.out.println("\n--- Delete an Activity ---");
        System.out.print("Enter activity ID to delete: ");
        int activityId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Activities activity = activitiesDAO.getActivityById(activityId);
        if (activity != null) {
            activitiesDAO.deleteActivity(activityId);
            System.out.println("Activity deleted successfully!");
        } else {
            System.out.println("Activity not found with ID: " + activityId);
        }
    }
}