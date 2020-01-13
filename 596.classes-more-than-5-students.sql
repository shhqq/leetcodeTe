--
-- @lc app=leetcode id=596 lang=mysql
--
-- [596] Classes More Than 5 Students
--

-- @lc code=start
# Write your MySQL query statement below
select class from (select distinct student, class
from courses) t group by class having count(class) >= 5;
-- @lc code=end

