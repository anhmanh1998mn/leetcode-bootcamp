import java.util.ArrayList;

public class MergeKSortedListsTest {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public Solution() {

        }

        public static ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }
            while (lists.length > 1) {
                ArrayList<ListNode> arr = new ArrayList<>();

                for (int i = 0; i < lists.length; i += 2) {
                    ListNode listNode1 = lists[i];
                    ListNode listNode2 = i + 1 < lists.length ? lists[i + 1] : null;
                    arr.add(mergeTwoList(listNode1, listNode2));
                }
                ListNode[] temp = new ListNode[arr.size()];
                temp = arr.toArray(temp);
                lists = temp;
            }
            return lists[0];
        }
    }

    public static ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        ListNode nodeResult;
        if (listNode1.val < listNode2.val) {
            nodeResult = listNode1;
            nodeResult.next = mergeTwoList(listNode1.next, listNode2);
        } else {
            nodeResult = listNode2;
            nodeResult.next = mergeTwoList(listNode1, listNode2.next);
        }
        return nodeResult;
    }

    public static ListNode[] getListInput() {
        ListNode listNodeA = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNodeB = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNodeC = new ListNode(2, new ListNode(6));
        ListNode[] listNodes = {listNodeA, listNodeB, listNodeC};
        return listNodes;
    }

    public static void main(String[] args) {
        ListNode listNodeResult = Solution.mergeKLists(getListInput());
        System.out.printf("" + listNodeResult);
    }
}
