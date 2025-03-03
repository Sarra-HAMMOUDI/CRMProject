use CRM ; 




 -- Retrieve all persons: 
 SELECT * FROM Person;
 
 
-- Retrieve all customers with their associated person details:

SELECT c.*, p.first_name, p.last_name, p.email, p.phone
FROM Customer c
JOIN Person p ON c.person_id = p.person_id;




-- Retrieve all employees with their associated person details:

SELECT e.*, p.first_name, p.last_name, p.email, p.phone
FROM Employee e
JOIN Person p ON e.person_id = p.person_id;




-- Retrieve all tickets created by a specific customer (e.g., customer_id = 1):

SELECT * FROM Tickets WHERE customer_id = 1;



-- Retrieve all campaigns managed by a specific employee (e.g., employee_id = 1) 4:

-- Retrieve all leads assigned to a specific employee (e.g., employee_id = 1):


-- Retrieve all opportunities for a specific customer (e.g., customer_id = 1):
SELECT * FROM Opportunities WHERE customer_id = 1;


-- Retrieve all activities related to a specific opportunity (e.g., opportunity_id = 7001):

SELECT * FROM Activities WHERE related_type = 'Opportunity' AND related_id = 7001;


-- Retrieve all activities related to a specific campaign (e.g., campaign_id = 8001):

SELECT * FROM Activities WHERE related_type = 'Campaign' AND related_id = 8001;


-- Retrieve all activities related to a specific ticket (e.g., ticket_id = 6001):

SELECT * FROM Activities WHERE related_type = 'Ticket' AND related_id = 6001;


-- Retrieve all activities related to a specific lead (e.g., lead_id = 1001):

SELECT * FROM Activities WHERE related_type = 'Lead' AND related_id = 1001;


SELECT * FROM Activities 
WHERE related_type IN ('Opportunity', 'Campaign', 'Ticket', 'Lead') 
AND related_id IN (7001, 8001, 6001, 1001);


-- Retrieve all tickets that are currently open:
SELECT * FROM Tickets WHERE status = 'Open';


-- Retrieve all leads that are in the 'Qualified' status:

SELECT * FROM Leads WHERE status = 'Qualified';

-- Retrieve all opportunities in the 'Closed Won' stage:

SELECT * FROM Opportunities WHERE stage = 'Closed Won';


-- Retrieve all activities of type 'Call':

SELECT * FROM Activities WHERE activity_type = 'Call';

-- Retrieve all customers who have spent more than $10,000:

SELECT * FROM Customer WHERE total_spent > 10000.00;


-- Retrieve all employees in the 'IT' department:

SELECT * FROM Employee WHERE department = 'IT';

-- Retrieve all tickets created in the last 30 days:

SELECT * FROM Tickets WHERE created_date >= DATE_SUB(CURDATE(), INTERVAL 30 DAY);

-- Retrieve all campaigns with a budget greater than $5,000:

SELECT * FROM Campaigns WHERE budget > 5000.00;




