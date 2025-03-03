use CRM; 

-- Calculate Employee Bonuses Based on Department

SELECT 
    e.employee_id,
    p.first_name,
    p.last_name,
    p.email,
    p.phone,
    e.department,
    e.salary,
    CASE
        WHEN e.department = 'Sales' THEN e.salary * 0.15
        WHEN e.department = 'IT' THEN e.salary * 0.10
        ELSE e.salary * 0.05
    END AS bonus
FROM Employee e
JOIN Person p ON e.person_id = p.person_id;

-- Categorize Customers Based on Total Spending
SELECT 
    customer_id,
    company_name,
    total_spent,
    CASE
        WHEN total_spent < 5000 THEN 'Low Spender'
        WHEN total_spent BETWEEN 5000 AND 20000 THEN 'Medium Spender'
        ELSE 'High Spender'
    END AS spending_category
FROM Customer;

/*Advanced Filtering with Aggregate Functions: Write a query to retrieve the total amount spent by customers who have made more than 2 tickets. Group the results by customer and order them by total spent in descending order. 
Display the customer's ID, name, number of tickets, and total spent. */

SELECT c.customer_id, p.first_name, p.last_name, COUNT(t.ticket_id) AS total_tickets, c.total_spent
FROM Customer c
JOIN Person p ON c.person_id = p.person_id
JOIN Tickets t ON c.customer_id = t.customer_id
GROUP BY c.customer_id
HAVING total_tickets > 2
ORDER BY c.total_spent DESC;


/* dvanced Inner Join with Multiple Conditions: Write a query to retrieve all employees hired after January 1, 2020, who belong to either the "Sales" or "IT" department. 
Display the employee's ID, name, department, and hire date.  */


SELECT e.employee_id, p.first_name, p.last_name, e.department, e.hire_date
FROM Employee e
JOIN Person p ON e.person_id = p.person_id
WHERE e.hire_date > '2020-01-01'
AND e.department IN ('Sales', 'IT');

/*Advanced Inner Join with Multiple Tables and Condition:  Write a query to retrieve all opportunities for a specific customer (e.g., customer ID = 1) and their associated activities. 
Include activities related to both campaigns and tickets.*/


SELECT o.opportunity_id, o.description, a.activity_id, a.activity_type, a.activity_date
FROM Opportunities o
JOIN Activities a ON o.opportunity_id = a.related_id AND a.related_type = 'Opportunity'
JOIN Customer c ON o.customer_id = c.customer_id
WHERE c.customer_id = 1;


/*Advanced Right Join with Filtering and Subquery: Write a query to retrieve all employees who have worked on campaigns with a budget greater than $5000. 
Use a RIGHT JOIN to ensure all campaigns are listed, even if there is no associated employee.  */

SELECT e.employee_id, p.first_name, p.last_name, c.campaign_id, c.name, c.budget
FROM Employee e
RIGHT JOIN Campaigns c ON e.employee_id = c.employee_id
JOIN Person p ON e.person_id = p.person_id
WHERE c.budget > 5000;


/* Advanced Left Join with Filtering: Write a query to retrieve all customers and their most recent ticket, including customers who have not created any tickets.
 Display the customer ID, name, ticket ID, and the creation date of the ticket.  */
 
SELECT c.customer_id, p.first_name, p.last_name, t.ticket_id, t.created_date
FROM Customer c
LEFT JOIN Tickets t ON c.customer_id = t.customer_id
JOIN Person p ON c.person_id = p.person_id
WHERE t.created_date = (SELECT MAX(created_date) FROM Tickets WHERE customer_id = c.customer_id) OR t.ticket_id IS NULL;



-- Classify Opportunities by Stage and Estimated Value
SELECT 
    opportunity_id,
    description,
    estimated_value,
    stage,
    CASE
        WHEN stage = 'Closed Won' AND estimated_value > 10000 THEN 'High-Value Win'
        WHEN stage = 'Closed Won' AND estimated_value <= 10000 THEN 'Low-Value Win'
        WHEN stage = 'Closed Lost' THEN 'Lost Opportunity'
        ELSE 'In Progress'
    END AS opportunity_status
FROM Opportunities;

--  Categorize Campaigns by Budget Range

SELECT 
    campaign_id,
    name,
    budget,
    CASE
        WHEN budget < 5000 THEN 'Low Budget'
        WHEN budget BETWEEN 5000 AND 20000 THEN 'Medium Budget'
        ELSE 'High Budget'
    END AS budget_category
FROM Campaigns;
 
 
-- Classify Leads by Source and Status

SELECT 
    lead_id,
    name,
    source,
    status,
    CASE
        WHEN source = 'Website' AND status = 'Qualified' THEN 'Hot Lead'
        WHEN source = 'Referral' AND status = 'Contacted' THEN 'Warm Lead'
        ELSE 'Cold Lead'
    END AS lead_quality
FROM Leads;


--  Categorize Tickets by Age (Days Since Creation)
SELECT 
    ticket_id,
    issue_description,
    status,
    created_date,
    DATEDIFF(CURDATE(), created_date) AS days_since_creation,
    CASE
        WHEN DATEDIFF(CURDATE(), created_date) < 7 THEN 'New'
        WHEN DATEDIFF(CURDATE(), created_date) BETWEEN 7 AND 30 THEN 'Aging'
        ELSE 'Stale'
    END AS ticket_age_category
FROM Tickets;


-- Calculate Discounts for Customers Based on Total Spending

SELECT 
    customer_id,
    company_name,
    total_spent,
    CASE
        WHEN total_spent > 50000 THEN total_spent * 0.10
        WHEN total_spent BETWEEN 20000 AND 50000 THEN total_spent * 0.05
        ELSE 0
    END AS discount
FROM Customer;


--  Classify Activities by Type and Related Entity
SELECT 
    activity_id,
    activity_type,
    related_type,
    CASE
        WHEN related_type = 'Opportunity' THEN 'Sales Activity'
        WHEN related_type = 'Campaign' THEN 'Marketing Activity'
        WHEN related_type = 'Ticket' THEN 'Support Activity'
        ELSE 'Other Activity'
    END AS activity_category
FROM Activities;


-- Retrieve the Average Budget of Campaigns per Month

SELECT YEAR(start_date) AS year, MONTH(start_date) AS month, AVG(budget) AS avg_budget
FROM Campaigns
GROUP BY YEAR(start_date), MONTH(start_date);



-- Retrieve the Total Number of Campaigns per name and Budget Range

SELECT name, 
       CASE 
           WHEN budget < 10000 THEN 'Under 10k'
           WHEN budget BETWEEN 10000 AND 50000 THEN '10k-50k'
           ELSE 'Over 50k'
       END AS budget_range,
       COUNT(*) AS campaign_count
FROM Campaigns
GROUP BY name, budget_range;


-- Retrieve the Total Number of Tickets Created per Month

SELECT YEAR(created_date) AS year, MONTH(created_date) AS month, COUNT(*) AS ticket_count
FROM Tickets
GROUP BY YEAR(created_date), MONTH(created_date);



-- Retrieve the Total Number of Activities per Opportunity Stage

SELECT o.stage, COUNT(a.activity_id) AS activity_count
FROM Opportunities o
JOIN Activities a ON o.opportunity_id = a.related_id AND a.related_type = 'Opportunity'
GROUP BY o.stage;




