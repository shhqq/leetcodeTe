--
-- @lc app=leetcode id=196 lang=mysql
--
-- [196] Delete Duplicate Emails
--

-- @lc code=start
# Write your MySQL query statement below
delete p from Person p, Person q 
where p.Id > q.Id and p.Email = q.Email;
-- @lc code=end

