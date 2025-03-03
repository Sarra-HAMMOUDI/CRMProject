use CRM ;

-- Verify the Number of Employees in Each Department

SELECT department, COUNT(*) AS employee_count
FROM Employee
GROUP BY department;


-- Verify the Number of Leads Converted to Customers

SELECT
    IF(
        (SELECT COUNT(*) FROM Leads WHERE status = 'Qualified') = 
        (SELECT COUNT(*) FROM Customer),
        'equal',
        'not equal'
    ) AS result;
    

-- Verify the Number of Activities per Lead

SELECT
    IF(
        (SELECT COUNT(*) FROM Activities WHERE related_type = 'Lead') =   -- the result is 100
        (SELECT COUNT(*) FROM Leads) * 3, -- Assuming 3 activities per lead  -- the result is 40 without * 3 
        'equal',
        'not equal'
    ) AS result;
    
    
/* OR

-- Verify the Number of Activities per Lead  */
SELECT 
    IF(
        COUNT(a.activity_id) = (SELECT COUNT(*) FROM Leads) * 3, 
        'equal', 
        'not equal'
    ) AS result
FROM Activities a
WHERE a.related_type = 'Lead';
    
    
-- Verify the Number of Tickets per Customer


SELECT
    IF(
        (SELECT COUNT(*) FROM Tickets) = 
        (SELECT COUNT(DISTINCT customer_id) * 5 FROM Tickets), -- Assuming 5 tickets per customer
        'equal',
        'not equal'
    ) AS result;
    
    
/* Or

  -- Verify the Number of Tickets per Customer */


SELECT 
    IF(
        COUNT(*) = (SELECT COUNT(DISTINCT customer_id) * 5 FROM Tickets),
        'equal',
        'not equal'
    ) AS result
FROM Tickets;

    
-- Verify the Number of Activities Assigned to Employees

SELECT
    IF(
        (SELECT COUNT(*) FROM Activities) = 
        (SELECT COUNT(DISTINCT related_id) * 10 FROM Activities), -- Assuming 10 activities per employee
        'equal',
        'not equal'
    ) AS result;
  
  
/* OR  
-- Verify the Number of Activities Assigned to Employees  */

SELECT 
    IF(
        COUNT(*) = (SELECT COUNT(DISTINCT related_id) * 10 FROM Activities),
        'equal',
        'not equal'
    ) AS result
FROM Activities;


