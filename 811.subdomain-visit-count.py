#
# @lc app=leetcode id=811 lang=python3
#
# [811] Subdomain Visit Count
#

# @lc code=start
class Solution:
    def subdomainVisits(self, cpdomains: List[str]) -> List[str]:
        visit = {}
        for cpdo in cpdomains:
            temp = cpdo.split(' ')
            times = int(temp[0])
            num_dot = temp[1].count('.')
            do = temp[1].split('.')
            print(do)
            domains = []
            for i in range(num_dot+1):
                domains.append('.'.join(do[len(do)-i-1 :len(do)]))
            # print(domains)
            for d in domains:
                if d in visit.keys():
                    visit[d] += times
                else:
                    visit[d] = times
        # print(visit)
        return [str.format('%d %s' %(item[1], item[0])) for item in visit.items()]
# @lc code=end

