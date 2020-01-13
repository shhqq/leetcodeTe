--
-- @lc app=leetcode id=595 lang=mysql
--
-- [595] Big Countries
--

-- @lc code=start
# Write your MySQL query statement below
SELECT NAME, POPULATION, AREA FROM WORLD WHERE AREA > 
3000000 OR POPULATION > 25000000;
-- @lc code=end

