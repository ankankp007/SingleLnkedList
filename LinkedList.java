import java.util.Scanner;
class Node{
	int regd_no;
	float marks;
	Node next;
	Node ( int regd_no, float marks){
		this.regd_no=regd_no;
		this.marks= marks;
		this.next=null;
	}
	public float getmark() {
		return marks;
	}
	public int getregd_no(){
		return regd_no;
	}
}
public class LinkedList {
	static boolean key = false;
	static Scanner obj= new Scanner (System.in);
	public static Node create(Node start) {
		System.out.println("EnterRegd No" );
		int rg=obj.nextInt();
		System.out.println("Enter Marks");
		float mark=obj.nextFloat();
		start = new Node(rg,mark);
		System.out.println("LinkedList Created");
		return start;
	}
	public static void Display (Node start) {
		Node temp=start;
		if (temp==null) {
			System.out.println("Empty Linked List");
		}
		else {
			System.out.println("Regd No \tMarks");
			while (temp!=null) {
				System.out.println(temp.regd_no+"\t\t"+temp.marks);
				temp=temp.next;

			}
			System.out.println("Marks are Printed");
		}

	}
	public static Node InsBeg(Node start) {
		if (start==null) {
			start=create(start);
			return start;
		}
		else {
			System.out.println("EnterRegd No" );
			int rg= obj.nextInt();
			System.out.println("Enter Marks");
			float mark= obj.nextFloat();
			Node newNode= new Node(rg,mark);
			newNode.next=start;
			System.out.println("Node Inserted at the beginning");
			return newNode;
		}
	}
	public static Node InsEnd(Node start){
		if (start==null) {
			start=create(start);
			return start;
		}
		else {
			System.out.println("EnterRegd No" );
			int rg= obj.nextInt();
			System.out.println("Enter Marks");
			float mark= obj.nextFloat();
			Node newNode= new Node(rg,mark);
			Node temp=start;
			while(temp.next!=null) 
				temp=temp.next;
			temp.next= newNode;
			System.out.println("Node Inserted at the end");
			return start;
		}
	}


	public static Node InsAny(Node start) {
		System.out.println("Enter the position to insert at:");
		int position=obj.nextInt();
		Node temp =start;
		if(position==1) {
			return InsBeg(start);
		}
		else {
			for(int i=0;i<position;i++) {
				try {
					temp=temp.next;
					if(temp==null)
						throw new NullPointerException();

				}
				catch(NullPointerException e) {
					System.out.println("Inavlid Positio");
					return start;
				}
			}
			System.out.println("EnterRegd No" );
			int rg= obj.nextInt();
			System.out.println("Enter Marks");
			float mark= obj.nextFloat();
			Node newNode= new Node(rg,mark);
			while(temp.next!=null) 
				temp=temp.next;
			temp.next= newNode;
			System.out.println("Node Inserted at the"+ position+"position");
			return start;
		}
	}

	public static Node DelBeg(Node start) {
		if ( start== null) 
			System.out.println("No Node to Delete");

		else {
			start = start.next;
			System.out.println("Node deleted at the beginning");
		}
		return start;
	}
	public static Node DelEnd(Node start) {
		if(start==null) {
			System.out.println("No Node to delete");
		}
		else if (start.next==null) {
			start=null;
			System.out.println("End Node Deleted");
		}
		else {
			Node temp = start;
			while (temp.next.next!=null) {
				temp=temp.next;
			}
			temp.next=null;
			System.out.println("End Node Deleted");
		}
		return start;
	}
	public static Node DelAny(Node start) {
		System.out.println("In which point you wanna delete ");
		int position =obj.nextInt();
		if (position==1) {
			start=start.next;
			System.out.println("Node Deleted at first");
			return start;	
		}
		else {
			Node temp = start;
			for(int i=2;i<position;i++) {
				try {
					temp=temp.next;
					if (temp==null) {
						throw new NullPointerException();
					}
				}
				catch ( NullPointerException e) {
					System.out.println("Wrong Position , nothing to delete");
					return start;
				}
			}
			Node another = temp;
			another=another.next;
			temp.next=another.next;
			System.out.println("Node Deleted");
			return start;
		}
	}
	public static Node DelbyReg(Node start) {
		if ( start== null)
		{
			System.out.println("Empty List, nothing to delete");
			return start;
		}


		System.out.println("Enter the reg to delete");
		int regd_no= obj.nextInt();
		Node current = start;
		Node Previous =null;
		if (start.regd_no==regd_no) {
			System.out.println("Deleted Node "+ regd_no);		
			boolean key =true;
			while ( current != null) {
				if (current.regd_no==regd_no) {
					Previous.next = current.next;
					current.next= null;
					System.out.println("Deleted Node "+regd_no);
					key=false;
					return start;
				}
				Previous = current;
				current = current.next;	}
		}
		try {
			if (key)
				throw new NullPointerException();

		}
		catch(NullPointerException e) {
			System.out.println(regd_no+"Not found in the linked list");
		}
		return start;

	}
	public static void search (Node start) {
		if ( start==null) {
			System.out.println("Empty");

		}
		else {
			System.out.println("Enter the regd no for search");
			int regd_no= obj.nextInt();
			Node temp=start;
			boolean found= true;
			while (temp!=null) {
				if ( temp.regd_no==regd_no) {
					System.out.println("Enter the marks for the student");
					float newMark = obj.nextFloat();
					temp.marks=newMark;
					found =true;
				}
				temp=temp.next;
			}
			try {
				if (!found) {
					throw new Exception("No node have a match with is Regd No");
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}

	}
	public static int count(Node start) {
		int  count =0;
		Node temp= start;
		while (temp!=null) {
			count++;
			temp=temp.next;
		}
		return count;

	}
	public static void sort (Node start) {
		if ( start ==null ) {
			System.out.println("Linked list is empty");
		}
		else if(start.next==null) {
			System.out.println("Linked List is sorted");
		}
		else {
			boolean sort; Node temp;
			Node lastNode=null;
			do {
				sort=false;
				temp=start;	
				while (temp.next!=lastNode) {
					if (temp.marks < temp.next.marks) {
						int tempreg=temp.regd_no;
						float tempmark=temp.marks;
						temp.regd_no=temp.next.regd_no;
						temp.marks=temp.next.marks;
						temp.marks=temp.next.marks;
						temp.next.regd_no=tempreg;
						temp.next.marks=tempmark;
						sort=true;
					}
					temp=temp.next;
				}
				lastNode=temp;
			}
			while (sort);
			System.out.println("Linked list according order of marks");
		}
	}
	public static Node Reverse(Node start) {
		Node reverse= null;
		Node present= start;
		Node future;
		while (present!=null) {
			future=present.next;
			present.next=reverse;
			reverse=present;
			present=future;	
		}
		System.out.println("List reversed succesfully");
		return reverse;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node start= null;
		System.out.println("\n*****Menu*****");
		System.out.println("0:Exit");
		System.out.println("1:Creation");
		System.out.println("2:Display");
		System.out.println("3:Insert at the beginning");
		System.out.println("4:Insert at the end");
		System.out.println("5:Insert at Any Position");
		System.out.println("6:Delete at Beginning");
		System.out.println("7:Delete at End ");
		System.out.println("8:Delete at Any Postion");
		System.out.println("9: Delete by Student Regd No");
		System.out.println("10:Search and Update Mark");
		System.out.println("11:Sort the list");
		System.out.println("12:Count the Number of Nodes ");
		System.out.println("13: Reverse the Node");

		while (true) {
			System.out.println("\nEnetr your Choice");
			int choice= obj.nextInt();
			System.out.println();
			switch(choice) {
			case 0:
				System.out.println("Fuck you bitch , get out of here");
				System.exit(0);
			case 1:
				start=create(start);
				break;
			case 2:
				Display(start);
				break;
			case 3:
				start=InsBeg (start);
				break;
			case 4:
				start=InsEnd(start);
				break;
			case 5:
				start=InsAny (start);
				break;
			case 6:
				start=DelBeg (start);
				break;
			case 7:
				start=DelEnd(start);
				break;
			case 8:
				start=DelAny (start);
				break;
			case 9:
				start=DelbyReg (start);
				break;
			case 10:
				search(start);
				break;
			case 11:
				sort (start);
				break;
			case 12:
				System.out.println("No of Nodes " + count (start));			
				break;
			case 13:
				start=Reverse(start);
				break;
			default:
				System.out.println("Motherfucker ! Can't you have a choice?Are you blind or what?");	
				break;
			}
		}

	}

}
