import java.io.*;

public class Main {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			char value = str.charAt(0);
			char leftValue = str.charAt(2);
			char rightValue = str.charAt(4);
		
			createNode(value,leftValue, rightValue);
		}
		
//		System.out.print("\n전위 : ");
		preOrder(root);
		System.out.println();
//		System.out.print("\n중위 : ");
		inOrder(root);
		System.out.println();
//		System.out.print("\n후위 : ");
		postOrder(root);
		
		
		
	}

	static class Node{
		char value;
		Node left;
		Node right;
		
		Node(char value){
			this.value = value;
		}
	}
	
	public static Node root;
	
	public static void createNode(char value, char leftValue, char rightValue) {
		if(root == null) { //root 가 null 이면 새로 만드는 노드를 root로 한다.
			 root = new Node(value);
			 
			 if(leftValue != '.') { //leftValue가 있으면 
				 root.left = new Node(leftValue);
			 }
			 if(rightValue != '.') { //rightValue가 있으면 
				 root.right = new Node(rightValue);
			 }
		}else { //root가 있다면 추가할 위치를 탐색한다.
			searchAddNode(root, value, leftValue, rightValue);
		}
		
	}

	//value와 같은 값을 가지는 부모노드를 찾아 왼쪽노드와 오른쪽 노드를 추가하는 함수
	public static void searchAddNode(Node parentNode, char value, char leftValue, char rightValue) {
		if(parentNode == null) { //탐색하고 있는 node가 null이라면 leaf node 이므로 재귀를 종료한다. 
			return;
		}else if (parentNode.value == value) {
			if(leftValue != '.') { //leftValue가 있으면 
				parentNode.left = new Node(leftValue);
			 }
			 if(rightValue != '.') { //rightValue가 있으면 
				 parentNode.right = new Node(rightValue);
			 }
		}else { // 현 노드가 단말에 도달하지 않은 상태에서 같은 값을 가지는 부모노드를 찾지 못한 경우
			//계속해서 탐색
			searchAddNode(parentNode.left, value, leftValue, rightValue);
			searchAddNode(parentNode.right, value, leftValue, rightValue);
		}
	}
	
	//전위 순회  루트 - 왼쪽 - 오른쪽
	public static void preOrder(Node node) {
		if(node == null) { //단말이라면 순회 멈춤
			return;
		}
		System.out.print(node.value);
		preOrder(node.left);
		preOrder(node.right);
	}
	//중외 순회  왼쪽 - 루트 - 오른쪽
	public static void inOrder(Node node) {
		if(node == null) { //단말이라면 순회 멈춤
			return;
		}
		inOrder(node.left);
		System.out.print(node.value);
		inOrder(node.right);
		
	}
	//후외 순회  왼쪽 - 오른쪽- 루트
	public static void postOrder(Node node) {
		if(node == null) { //단말이라면 순회 멈춤
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.value);
		
	}

	

	
	

}

/*
 input 
 7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
	A
   / \
  B   C
 /   / \
D   E   F
         \
          G
pre ABDCEFG
in DBAECFG
post DBEGFCA

 */