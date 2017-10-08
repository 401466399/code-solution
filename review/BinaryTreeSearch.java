package review;

import java.util.Stack;

public class BinaryTreeSearch {
    static class Node{
        int value;
        Node left;
        Node right;
        boolean visited;
        public Node(int value){
            this.value = value;
        }
    }
    static public void inOrderSearch(Node root){
        Stack<Node> s = new Stack<>();
        s.add(root);
        root.visited = true;
        Node now = root;
        while(true){
            while(now.left!=null && now.left.visited==false){
                s.add(now.left);
                now = now.left;
                now.visited = true;
            }
            if(s.empty())return;else {
                now = s.pop();
                System.out.println(now.value);
            }
            if(now.right!=null && now.right.visited ==false){
                s.add(now.right);
                now = now.right;
                now.visited = true;
            }else{
                if(s.empty()){
                    return;
                }else  now = s.peek();
            }
        }
    }
    static public void preOrderSearch(Node root){
        Stack<Node> s = new Stack<>();
        s.add(root);
        root.visited = true;
        System.out.println(root.value);
        Node now = root;
        while(true){
            while(now.left!=null && now.left.visited==false){
                s.add(now.left);
                now = now.left;
                now.visited = true;
                System.out.println(now.value);
            }
            if(s.empty())return;else now = s.pop();
            if(now.right!=null && now.right.visited ==false){
                s.add(now.right);
                now = now.right;
                now.visited = true;
                System.out.println(now.value);
            }else{
                if(s.empty()){
                    return;
                }else  now = s.peek();
            }
        }
    }
    static public void PostOrderSearch(Node root){
        Stack<Node> s = new Stack<>();
        s.add(root);
        Node now = root;
        while(true){
            while(now.left!=null && now.left.visited == false){
                s.add(now.left);
                now = now.left;
            }
            if(now.right!=null && now.right.visited==false){
                s.add(now.right);
                now = now.right;
            }
            else {
                System.out.println(now.value);
                now.visited = true;
                if(!s.empty()){
                    s.pop();
                    if(!s.empty())
                        now = s.peek();
                    else
                        return;
                }
                else
                    return;
            }
        }
    }
    public static void main(String[] args){
        Node node0 = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        node0.left = node1;
        node0.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node6;
        node3.left = node5;
        node6.right = node7;
//        PostOrderSearch(node0);
//        preOrderSearch(node0);
        inOrderSearch(node0);
    }
}

