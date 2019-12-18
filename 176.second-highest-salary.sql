--
-- @lc app=leetcode id=176 lang=mysql
--
-- [176] Second Highest Salary
--

-- @lc code=start
# Write your MySQL query statement below
select Salary from (select distinct Salary from Employee order by Salary desc) t where rownum = 1;
-- @lc code=end

