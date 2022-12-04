/**
177. Nth Highest Salary

Write an SQL query to report the nth highest salary from the Employee table.
  If there is no nth highest salary, the query should report null.
*/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    set n = N-1 ;
    RETURN (
select ifnull((select distinct Salary from Employee order by Salary desc limit n,1) ,null) getNthHighestSalary
    );
END