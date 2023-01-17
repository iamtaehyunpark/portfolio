public class Tester{
    public static void buildTree(String expression) {
		if(expression.length() == 0);
		
		if(expression.charAt(0) == '('){
			int count = 1;
			while(expression.charAt(count) != ')') count++;
			String before = expression.subString(1,count);
			expression = expression.subString(count+1);
			Node temp = root;
			buildTree(before);
			temp.right = root;
			root = temp;
		}

		if(EnumUtils.isValidEnum(OP, expression.charAt(0))) {
            if(root = null) root = new Node(expression.charAt(0), null);
            else{
                Node temp = root;
                root = new Node(expression.charAt(0), null);
                root.left = temp;
                buildTree(expression.substring(1));
                Node right = root.parent;
                root.right = right;
            }
		} else{
			char temp = expression.charAt(0);
			buildTree(expression.subString(1));
			Node left = new Node(temp, root);
			root.left = left;
		}
	}

    public static void main(String[] args) {
        buildTree("1*(2-4)/7");
    }

}