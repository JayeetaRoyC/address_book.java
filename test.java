import java.util.Scanner; 
class Book
{ 
	 //Nested class for each entry 
	class Entry
	{ 
		private String first;
		private String last; 
		private String address; 
		private String phone; 
		Entry(String first, String last, String address, String phone)
		{ 
			this.first = first; 
			this.last = last; 
			this.address = address; 
			this.phone = phone; 
		} 
		Entry()
		{ 
			first = ""; 
			last = ""; 
			address = ""; 
			phone = ""; 
		} 
	} 
	//Keeps track of how many entries are in the book 
	private int entries = 0; 
	Entry[] contents; 
	public void initEntries(int e)
	{ 
		contents = new Entry[e]; 
		for (int i = 0;i<contents.length;i++)
		{ 
			contents[i] = new Entry(); 
		} 
	} 
	//Adds an entry to the book 
	public void add(String first, String last, String address, String phone, int j)
	{  
		contents[entries] = new Entry(first, last, address, phone); 
		entries++; 
		if(contents.length==j)
			System.out.println("Book full!");
		else
			System.out.println((contents.length-j)+" Entries left!");
	} 
	//Removes an entry from the book 
	public void remove(int entry)
	{ 
		if (entries>0)
		{ 
			contents[entry] = new Entry(); 
			for (int i = 0;i<entries-entry;i++)
			{ 
				if (entry+1==entries) 
					contents[entry] = new Entry(); 
				else
				{ 
					Entry temp = contents[entry+i]; 
					contents[entry+i] = contents[entry+i+1]; //Removes an entry end moves each entry after it one backwards. 
					contents[entry+i+1] = temp; 
				} 
			} entries--; 
		} 
		else 
			System.out.println("Error: book is empty."); 
	} 
	//Changes the values of an entry 
	public void modify(String first, String last, String address, String phone, int selection)
	{ 
		contents[selection].first = first; 
		contents[selection].last = last; 
		contents[selection].address = address; 
		contents[selection].phone = phone; 
	} 
	public void display(int j)
	{
		for (int i = 0;i<j;i++)
		{
			System.out.println("Displaying "+(i+1)+" contact:");
			System.out.println("-----------------------------------");
			System.out.println("First Name: "+contents[i].first);
			System.out.println("Last Name: "+contents[i].last);
			System.out.println("Address: "+contents[i].address);
			System.out.println("Phone Number: "+contents[i].phone);
			System.out.println("-----------------------------------");
		}
	}
	public void search(String fname, String lname)
	{
		for (int i = 0;i<contents.length;i++)
		{
			if(fname.equals(contents[i].first) && lname.equals(contents[i].last))
			{
				System.out.println("Displaying searched contact:");
				System.out.println("-----------------------------------");
				System.out.println("First Name: "+contents[i].first);
				System.out.println("Last Name: "+contents[i].last);
				System.out.println("Address: "+contents[i].address);
				System.out.println("Phone Number: "+contents[i].phone);
				System.out.println("-----------------------------------");
				break;
			}
		}
	}
	public static void main(String[] args)
	{
		Book object = new Book();
		Scanner s = new Scanner(System.in);
		while(true)
		{
			System.out.print("How many entries in book? "); 
			int howManyEntries = s.nextInt(); 
			if (howManyEntries>0) 
			{ 
				object.initEntries(howManyEntries); 
				//This code decides how many entries are in each book in the library 
				break; 
		 	} 
			else 
				System.out.println("You must create at least 1 Entry."); 
		}
		int j=0;
		boolean done=false;
		while(done!=true)
		{
				System.out.println("Select an option!"); 
				System.out.println("1. Add an entry"); 
				System.out.println("2. Remove an entry"); 
				System.out.println("3. Edit an entry"); 
				System.out.println("4. Search entries in this book");
				System.out.println("5. Display"); 
				System.out.println("6. Exit"); 
				System.out.print("> "); 
				int selection = s.nextInt(); 
				String first, last, address, phone; 
				switch(selection)
				{ 
					case 1: System.out.println("Adding "+(j+1)+" contact:");
							j++;
							System.out.print("First name? "); 
							first = s.next(); 
							System.out.print("Last name? "); 
							last = s.next(); 
							System.out.print("Address? "); 
							address = s.next(); 
							System.out.print("Phone? "); 
							phone = s.next(); 
							object.add(first, last, address, phone, j); 
							break; 
					case 2: System.out.print("Remove which entry? "); 
							int entry = s.nextInt(); 
							object.remove(entry-1);
							j--;
							break; 
					case 3: System.out.print("Edit which entry?"); 
							int whichEntry = s.nextInt(); 
							System.out.print("First name? "); 
							first = s.next(); 
							System.out.print("Last name? "); 
							last = s.next(); 
							System.out.print("Address? "); 
							address = s.next(); 
							System.out.print("Phone? "); 
							phone = s.next(); 
							object.modify(first, last, address, phone, whichEntry-1); 
							break; 
					case 4: System.out.print("Enter First name to search: "); 
							String fname = s.next(); 
							System.out.print("Enter Last name to search: "); 
							String lname = s.next(); 
							object.search(fname, lname);
							break;
					case 5: object.display(j); 
							break; 
					case 6: done = true; 
							break; 
					default: System.out.print("Please choose a valid menu number"); 
				} 
		}
	} 
} 
