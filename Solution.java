/*
 * 
 */
public class Solution {

	/*
	 * 
	 */
	public static class MyStack<T> {
		
		// **** array size ****
		private final int ARRAY_SIZE 	= (7 + 11 + 13);
		
		// **** per class members ****
		private static Object[] arr		= null;
		private static int 		used 	= -1;
		
		// **** per instance members ****
		private int min	= -1;
		private int max	= -1;
		private int top = -1;
		
		/*
		 * Constructor
		 */
		public MyStack(int stackSize) throws Exception {
			
			// **** check argument ****
			if (stackSize + used >= ARRAY_SIZE)
				throw new Exception("invalid argument stackSize: " + stackSize);

			// **** set instance members ****
			this.min = used + 1;
			this.max = this.min + stackSize - 1;
			this.top = this.min - 1;

			// **** update class members ****
			if (arr == null) {
				arr = new Object[ARRAY_SIZE];
				init();
			}

			used += stackSize;
		}
		
		/*
		 * Push element into the stack
		 */
		public void push(int item) throws Exception {
			
			// **** check if stack is full ****
			if (isFull())
				throw new Exception("stack is full");
					
			// **** push element into stack ****
			arr[++top] = item;
		}
		
		/*
		 * Pop element from the stack
		 */
		@SuppressWarnings("unchecked")
		public T pop() throws Exception {
		
			T item = null;
			
			// **** check if stack is  empty ****
			if (isEmpty())
				throw new Exception("stack is empty");
			
			// **** pop item ****
			item = (T)arr[top];
			
			// **** clear the entry in the array ****
			arr[top] = -1;
			
			// **** adjust top ****
			top--;
			
			// **** return item ****
			return item;
		}
		
		/*
		 * Check if the stack is empty
		 */
		public boolean isEmpty() {
			if (this.top < this.min)
				return true;
			else
				return false;
		}
		
		/*
		 * Check if the stack is full
		 */
		public boolean isFull() {
			if (this.top >= this.max)
				return true;
			else
				return false;
		}
		
		/*
		 * Peek top element in stack
		 */
		@SuppressWarnings("unchecked")
		public T peek() throws Exception {
						
			// **** check if stack is empty ****
			if (isEmpty())
				throw new Exception("stack is empty");
			
			// **** ****
			return (T)arr[this.top];
		}
		
		/*
		 * Return string with contents of the stack.
		 */
		public String toString() {
			
			// **** for efficiency ****
			StringBuilder sb = new StringBuilder("[ ");
			
			// **** append stack elements ****
			for (int i = this.min; i <= this.top; i++) {
				if (i < this.top)
					sb.append(arr[i].toString() + " -> ");
				else 
					sb.append(arr[i].toString() + " ");
			}
			
			// **** ****
			sb.append("]");
			
			// **** add stack variables ****
			sb.append(" min: " + this.min);
			sb.append(" max: " + this.max);
			sb.append(" top: " + this.top);
			
			// **** return the string ****
			return sb.toString();
		}
		
		/*
		 * Return the capacity of the stack.
		 */
		public int capacity() {
			return this.max - this.min + 1;
		}
		
		/*
		 * Initialize the array (for testing purpose only).
		 */
		private void init() {
//			for (int i = 0; i < arr.length; i++) {
//				arr[i] = -1;
//			}
		}
		
		/*
		 * Build a string with the contents of the array.
		 * (For testing purpose only).
		 */
		public String array() {
			
			// **** ****
			StringBuilder sb = new StringBuilder("[ ");
			
			// **** display the contents of the array (not the stack) ****
			for (int i = 0; i < arr.length; i++) {
				if (i < arr.length - 1) {
					if (arr[i] == null)
						sb.append("N, ");
					else
						sb.append(arr[i].toString() + ", ");
				}
				else {
					if (arr[i] == null)
						sb.append("N, ");
					else
						sb.append(arr[i].toString() + " ");
					
				}

			}
			
			// **** ****
			sb.append("]");
			
			// **** ****
			return sb.toString();
		}
	}
	
	/*
	 * Test scaffolding.
	 */
	public static void main(String[] args) throws Exception {
				
		// **** instantiate the first stack ****
		int size = 7;
		MyStack<Integer> firstStack = new MyStack<Integer>(size);
		
		// **** display the capacity of the first stack ****
		System.out.println("main <<< firstStack.capacity: " + firstStack.capacity());
				
		// **** display the contents of the array ****
		System.out.println("main <<< firstStack: " + firstStack.array() + "\n");
		
		// **** display the contents of the first stack ****
		System.out.println("main <<< firstStack: " + firstStack.toString());

		// **** push elements into the first stack ****
		int i = 0;
		while (!firstStack.isFull()) {
			firstStack.push(i++);
		}
		
		// **** display the contents of the first stack ****
		System.out.println("main <<< firstStack.array: " + firstStack.toString() + "\n");

		// **** display the contents of the array ****
		System.out.println("main <<< firstStack: " + firstStack.array() + "\n");

		
		// **** instantiate the second stack ****
		size = 11;
		MyStack<Integer> secondStack = new MyStack<Integer>(size);
		
		// **** display the capacity of the second stack ****
		System.out.println("main <<< secondStack.capacity: " + secondStack.capacity());
		
		// **** display the contents of this stack ****
		System.out.println("main <<< secondStack: " + secondStack.toString() + "\n");

		
		// *** instantiate third stack ****
		size = 13;
		MyStack<Integer> thirdStack = new MyStack<Integer>(size);
		
		// **** displat the capacity of the third stack ****
		System.out.println("main <<< thirdStack.capacity: " + thirdStack.capacity());
		
		// **** display the contents of this stack ****
		System.out.println("main <<< thirdStack: " + thirdStack.toString());

		// **** push elements into the third stack ****
		i = 0;
		while (!thirdStack.isFull())
			thirdStack.push(i++);
		
		// **** display the contents of this stack ****
		System.out.println("main <<< thirdStack: " + thirdStack.toString() + "\n");
		
		// **** display the contents of the array ****
		System.out.println("main <<< thirdStack: " + thirdStack.array() + "\n");
		
		
		// **** push elements into the second stack ****
		i = 0;
		while (!secondStack.isFull())
			secondStack.push(i++);
		
		// **** display the contents of this stack ****
		System.out.println("main <<< secondStack: " + secondStack.toString() + "\n");

		// **** display the contents of the array ****
		System.out.println("main <<< firstStack: " + secondStack.array() + "\n");
		
		
		// **** pop elements from the first stack ****
		while (!firstStack.isEmpty()) {
			System.out.println("main <<< fisrtStack.peek: " + firstStack.peek());
			System.out.println("main <<<  firstStack.pop: " + firstStack.pop());
		}
		System.out.println();
		
		// **** pop elements from the second stack ****
		while (!secondStack.isEmpty()) {
			System.out.println("main <<< secondStack.peek: " + secondStack.peek());
			System.out.println("main <<<  secondStack.pop: " + secondStack.pop());
		}
		System.out.println();
		
		// **** pop elements from the third stack ****
		while (!thirdStack.isEmpty()) {
			System.out.println("main <<< thirdStack.peek: " + thirdStack.peek());
			System.out.println("main <<<  thirdStack.pop: " + thirdStack.pop());
		}
		System.out.println();
		
		// **** display the contents of the array ****
		System.out.println("main <<< thirdStack: " + thirdStack.array());
	}

}
