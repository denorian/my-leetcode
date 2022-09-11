/* 181. Employees Earning More Than Their Managers
Write an SQL query to find the employees who earn more than their managers.
Return the result table in any order.*/

select e1.name as 'Employee'
from Employee e1
left join Employee e2 on e2.id = e1.managerId
where e1.salary > e2.salary