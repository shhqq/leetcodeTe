--
-- @lc app=leetcode id=181 lang=mysql
--
-- [181] Employees Earning More Than Their Managers
--

-- @lc code=start
# Write your MySQL query statement below
select name as Employee from 
(select e.Id, e.Name, e.Salary, e.ManagerId, m.Salary as ManagerSalary 
from Employee e left join Employee m
on m.Id = e.managerID) t 
where t.Salary > t.ManagerSalary;
-- @lc code=end

