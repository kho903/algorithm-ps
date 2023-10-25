package programmers.lv3;

import java.util.*;

public class 길찾기게임 {

	static List<Integer> preorder, postorder;
	public int[][] solution(int[][] nodeinfo) {
		int N = nodeinfo.length;

		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
		}

		Arrays.sort(nodes, (o1, o2) -> o2.y - o1.y);

		Node root = nodes[0];
		for (int i = 1; i < N; i++) {
			insert(root, nodes[i]);
		}

		preorder = new ArrayList<>();
		postorder = new ArrayList<>();
		pre(root);
		post(root);

		return new int[][] {
			preorder.stream().mapToInt(Integer::intValue).toArray(),
			postorder.stream().mapToInt(Integer::intValue).toArray(),
		};
	}

	void pre(Node node) {
		if (node == null) return;
		preorder.add(node.value);
		pre(node.left);
		pre(node.right);
	}

	void post(Node node) {
		if (node == null) return;
		post(node.left);
		post(node.right);
		postorder.add(node.value);
	}

	void insert(Node parent, Node node) {
		if (node.x < parent.x) {
			if (parent.left == null) parent.left = node;
			else insert(parent.left, node);
		} else {
			if (parent.right == null) parent.right = node;
			else insert(parent.right, node);
		}
	}

	static class Node {
		int value;
		int x;
		int y;

		Node left;
		Node right;

		Node(int value, int x, int y) {
			this.value = value;
			this.x = x;
			this.y = y;
		}
	}
}