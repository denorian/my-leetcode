/** 1581. Customer Who Visited but Did Not Make Any Transactions

  Write an SQL query to find the IDs of the users who visited without making any transactions
  and the number of times they made these types of visits.
  Return the result table sorted in any order.
  The query result format is in the following example.
 */
select customer_id, count(v.customer_id) as 'count_no_trans' from Visits v
left outer join Transactions t on v.visit_id = t.visit_id
where  t.transaction_id is null
group by v.customer_id