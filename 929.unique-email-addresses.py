#
# @lc app=leetcode id=929 lang=python3
#
# [929] Unique Email Addresses
#

# @lc code=start
class Solution:
    def numUniqueEmails(self, emails: List[str]) -> int:
        '''
        split the local name with '+' and replace the '.' with ''.
        '''
        valid = set()
        for e in emails:
            valid_email = e.split('@')
            if len(valid_email) != 2: # or valid_email[0] == '' or valid_email[1] == '':
                continue
            local = valid_email[0]
            domain = valid_email[1]
            valid_local = local.split('+')[0].replace('.', '')
            valid.add('@'.join([valid_local, domain]))
        return len(valid)
# @lc code=end

