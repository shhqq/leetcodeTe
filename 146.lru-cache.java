import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
    /**
     * 投票最高的和我的一样，使用一个链表来记录访问顺序。
     * Most voted 使用双链表，这样删除链表比较方便。
     */
    Map<Integer, Integer> cache;
    int capacity;
    ListNode head;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (cache.keySet().contains(key)){
            // 将链表的该值提到最前面
            ListNode node = head;
            while (node.next != null && node.next.val != key) {
                node = node.next;
            }
            ListNode cur = node.next;
            if (cur != null) {
                node.next = cur.next;
                cur.next = head;
                head = cur;
            }
            
            return cache.getOrDefault(key, -1);
        } else {
            return -1;
        }
        
    }
    
    /**
     * 如果key已经存在，则需要调用一次get，将链表更新；
     * 如果key不存在，首先判断cache是否已经达到上限。如果达到上限，则删除
     * 最后一个节点，并移除cache中的值。
     */
    public void put(int key, int value) {
        if (cache.keySet().contains(key)) {
            get(key);
            cache.put(key, value);
            return;
        }
        if (cache.keySet().size() == capacity) {
            if (capacity == 1) {
                cache.clear();
                head = null;
            } else {
                ListNode node = head;
                while(node.next.next != null) {
                    node = node.next;
                }
                // 删除cache中的值，并删除链表最后一个节点
                cache.remove(node.next.val);
                //System.out.println(cache.keySet());
                node.next = null;
            }
            
        }
        ListNode node = new ListNode(key);
        node.next = head;
        head = node;
        cache.put(key, value);
    }

    private class ListNode{
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

