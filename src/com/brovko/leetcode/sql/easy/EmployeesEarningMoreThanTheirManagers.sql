/* 181. Employees Earning More Than Their Managers
Write an SQL query to find the employees who earn more than their managers.
Return the result table in any order.*/

SELECT e.name as Employee
FROM Employee e
INNER JOIN Employee e2 ON e.managerId = e2.id
WHERE e.salary > e2.salary