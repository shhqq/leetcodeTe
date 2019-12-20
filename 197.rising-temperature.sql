--
-- @lc app=leetcode id=197 lang=mysql
--
-- [197] Rising Temperature
--

-- @lc code=start
# Write your MySQL query statement below
select t1.Id from Weather t1, Weather t2 
where DATEDIFF(t1.RecordDate, t2.RecordDate) = 1
and t1.Temperature > t2.Temperature;
-- @lc code=end

