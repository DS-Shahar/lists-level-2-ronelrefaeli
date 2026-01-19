public class Main {
    public static void main(String[] args)
    {
        int[] values = {1, 2, 3, 4, 5};
        Node<Integer> head = build(values);

        head = ex6(head, 3);
        head = ex7(head, 2);

        int[] a = {1, 4};
        Node<Integer> L1 = build(a);
        Node<Integer> L2 = head; 
        System.out.println(ex8(L1, head));
        System.out.println(ex9(L1, head));

        Node<Integer> common = ex10(L1, L2);
        Node<Integer> p = common;
        while (p != null) {
            System.out.println(p.getValue());
            p = p.getNext();
        }
    }

    public static Node<Integer> build(int[] a)
    {
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> p = dummy;
        for (int i = 0; i < a.length; i++) {
            Node<Integer> x = new Node<>(a[i]);
            p.setNext(x);
            p = x;
        }
        return dummy.getNext();
    }

    public static boolean contains(Node<Integer> head, int target)
    {
        Node<Integer> current = head;
        while (current != null) {
            if (current.getValue() == target)
                return true;
            current = current.getNext();
        }
        return false;
    }

    public static Node<Integer> ex6(Node<Integer> head, int num)
    {
        if (head == null)
            return null;
        if (head.getValue() == num)
            return head.getNext();

        Node<Integer> current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue() == num) {
                current.setNext(current.getNext().getNext());
                return head;
            }
            current = current.getNext();
        }
        return head;
    }

    public static Node<Integer> ex7(Node<Integer> head, int x)
    {
        if (head == null || x <= 0)
            return head;
        if (x == 1)
            return head.getNext();

        Node<Integer> current = head;
        for (int i = 1; i < x - 1 && current != null; i++)
        {
            current = current.getNext();
        }
        if (current != null && current.getNext() != null)
            current.setNext(current.getNext().getNext());

        return head;
    }

    public static boolean ex8(Node<Integer> L1, Node<Integer> L2)
    {
        if (L1 == null)
            return true;
        if (!contains(L2, L1.getValue()))
            return false;
        return ex8(L1.getNext(), L2);
    }

    public static int ex9(Node<Integer> L1, Node<Integer> L2)
    {
        if (L1 == null) {
            return 0;
        }

        if (contains(L2, L1.getValue())) {
            System.out.println(L1.getValue());
        }

        return ex9(L1.getNext(), L2);
    }

    public static Node<Integer> ex10(Node<Integer> L1, Node<Integer> L2)
    {
        if (L1 == null)
            return null;

        if (contains(L2, L1.getValue()))
        {
            Node<Integer> temp = new Node<>(L1.getValue());
            temp.setNext(ex10(L1.getNext(), L2));
            return temp;
        }

        return ex10(L1.getNext(), L2);
    }
    public static Node<Integer> ex11(Node<Integer> L1, Node<Integer> L2) 
    {
    Node<Integer> dummy = new Node<>(-1);
    dummy.setNext(L1);
    Node<Integer> prev = dummy;
    Node<Integer> curr = L1;

    while (curr != null) {
        if (contains(L2, curr.getValue())) {
            prev.setNext(curr.getNext());
        } else {
            prev = curr;
        }
        curr = curr.getNext();
    }
           public static Node<Integer> exlist2ex1(Node<Integer> L1, Node<Integer> L2) { o(n) סיבוכיות 
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> tail = dummy;
        while (L1 != null && L2 != null) {
            if (L1.getValue() <= L2.getValue()) {
                tail.setNext(new Node<>(L1.getValue()));
                L1 = L1.getNext();
            } else {
                tail.setNext(new Node<>(L2.getValue()));
                L2 = L2.getNext();
            }
            tail = tail.getNext();
        }
        while (L1 != null) {
            tail.setNext(new Node<>(L1.getValue()));
            tail = tail.getNext();
            L1 = L1.getNext();
        }
        while (L2 != null) {
            tail.setNext(new Node<>(L2.getValue()));
            tail = tail.getNext();
            L2 = L2.getNext();
        }
        return dummy.getNext();
    }

    public static Node<Integer> exlist2ex2(Node<Integer> head) {   o(n בריבוע) סיבוכיות 
        Node<Integer> newHead = null;
        Node<Integer> newTail = null;
        while (head != null) {
            Node<Integer> minPrev = null;
            Node<Integer> minNode = head;
            Node<Integer> prev = head;
            Node<Integer> curr = head.getNext();
            while (curr != null) {
                if (curr.getValue() < minNode.getValue()) {
                    minPrev = prev;
                    minNode = curr;
                }
                prev = curr;
                curr = curr.getNext();
            }
            if (minPrev != null)
                minPrev.setNext(minNode.getNext());
            else
                head = head.getNext();
            minNode.setNext(null);
            if (newHead == null)
                newHead = minNode;
            else
                newTail.setNext(minNode);
            newTail = minNode;
        }
        return newHead;
    }

    public static int exlist2ex3(Node<Integer> head, int val) { o(n) סיבוכיות 
        int index = 0;
        int sum = 0;
        boolean found = false;
        Node<Integer> p = head;
        while (p != null) {
            if (p.getValue() == val) {
                int distance = index;                     
                Node<Integer> temp = p;
                int endDist = 0;
                while (temp.getNext() != null) {
                    temp = temp.getNext();
                    endDist++;
                }
                sum += distance + endDist;
                found = true;
            }
            index++;
            p = p.getNext();
        }
        return found ? sum : -1;
    }

    public static boolean exlist2ex4(Node<Integer> head) { o(n בריבוע) סיבוכיות 
        Node<Integer> p = head;
        while (p != null) {
            Node<Integer> q = p.getNext();
            while (q != null) {
                if (p.getValue() == q.getValue())
                    return false;
                q = q.getNext();
            }
            p = p.getNext();
        }
        return true;
    }

    public static Node<Integer> exlist2ex5(Node<Integer> head) {       o(n בריבוע) סיבוכיות 
        Node<Integer> dummy = new Node<>(-1);
        Node<Integer> tail = dummy;
        Node<Integer> p = head;
        while (p != null) {
            Node<Integer> q = dummy.getNext();
            boolean exists = false;
            while (q != null) {                                                    
                if (q.getValue() == p.getValue()) {
                    exists = true;                                  
                   
                }
                q = q.getNext();
            }
            if (!exists) {
                tail.setNext(new Node<>(p.getValue()));
                tail = tail.getNext();
            }
            p = p.getNext();
        }
        return dummy.getNext();
    }

    return dummy.getNext();
}
}











public static Node<Integer> ex2(Queue<Integer> q) {
        Node<Integer> r = new Node<Integer>(-1);
        Queue<Integer> q2 = copyQ(q);
        Node<Integer> b = r;
        while (!q2.isEmpty()) 
        {
            r.setNext(new Node<Integer>(max(q2)));
            r = r.getNext();
        }
        return b.getNext();
    }

    public static int max(Queue<Integer> q) {
        Queue<Integer> q2 = copyQ(q);
        int max = 0;
        int y = q2.remove();
        while (!q2.isEmpty()&& y!=0) 
        {
            if (y > max) 
                max = y;
            int y = q2.remove();
        }
        return max;
    }
}























