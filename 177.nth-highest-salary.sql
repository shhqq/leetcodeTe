--
-- @lc app=leetcode id=177 lang=mysql
--
-- [177] Nth Highest Salary
--

-- @lc code=start
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M=N-1;
  RETURN (
      # Write your MySQL query statement below.
      select distinct salary from employee order by salary desc limit M, 1
  );
END
-- @lc code=end

