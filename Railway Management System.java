package assignment;

import java.util.Scanner;

public class Railway_Management {
	protected int train_no;
	protected String train_name;
	protected int train_index;
	protected String origin;
	protected String destination;
	protected int tot_seats;
	protected int ticket_price;
	protected String time;
	
	Railway_Management(int tno,String tname,int tind,String or,String des,int tot,int pr,String t)
	{
		this.train_no=tno;
		this.train_name=tname;
		this.train_index=tind;
		this.origin=or;
		this.destination=des;
		this.tot_seats=tot;
		this.ticket_price=pr;
		this.time=t;
	}

	/*int gettrainno()
	{
		int l;
		for(l=0;l<6;l++)
		{
			return train_no;
		}
	}*/
}
	interface printingtickets
	{
		void print();
	}
	class reservation extends Railway_Management implements printingtickets
	{
		protected int tno_ui;
		protected int no_tickets;
		protected String or_ui;
		protected String des_ui;
		protected String trn_ui;
		protected String date_ui;
		protected String travelDate;
		protected int comp;
		protected int price;
		protected String passenger;
		protected int age;
		protected int tind_ui;
		
       Scanner n =new Scanner(System.in);
		reservation(int tno,String tname,int tind,String or,String des,int tot,int pr,String t)
		{
			super(tno,tname,tind,or,des,tot,pr,t);
			/*1.here include a method which gets user input for train no(to check whether the train is available if not give a error message),
			  no of seats need to booked
			  2.this method should be a returning method =check using if train no available or not if yes proceed by subtracting the no of seats by total 
			  and price calculation finally return price
			  3.void print=where all the details will be printed
			*/
		}
		void display()
		{// this one is for displaying where we need separate for loop
			System.out.println("Train Number:"+train_no);
			System.out.println("Train Name:"+train_name);
			System.out.println("Train index:"+train_index);
			System.out.println("Starting location:"+origin);
			System.out.println("Destination:"+destination);
			System.out.println("Train timing:"+time);
		}
			
			int trnum()
			{//first we are generating the train number which is only one ...so ot will be returned according to the ui_train_name
				System.out.println("Enter name of train: ");
				trn_ui=n.next();
				int m;
				boolean tr;
				for(m=0;m<6;m++)
				{
					tr=trn_ui.equals(train_name);
					if(tr==true)
					{
						System.out.println("Train number:"+train_no);
						return train_no;
					}
					
				}
				return 0;
				
			}
			void input1()
			{
				System.out.println("Enter the starting location: ");
				or_ui=n.next();
				System.out.println("Enter the destination: ");
				des_ui=n.next();
				System.out.println("Enter the date of travel: ");
				travelDate=n.next();
		   }
			void check()
			{//checks whether the user can proceed with booking or not
				System.out.println("enter the index:");
				tind_ui=n.nextInt();//numbers either 1 to 5
				if(train_index==1 || train_index==2 || train_index==3 || train_index==4 || train_index==5 || train_index==6)
				{
					System.out.println("Proceeding with the ticket booking...");
				}
				else
				{
					System.out.println("ERROR! train name not found");
					int z=0;
					while(z>=0)
					{
						if(train_index>6)
						break;
					}
				}
			}
			
			
			
		   int booking()
		   {//booking part were the user needs to enter the number of seats...after that name&age
			   
			   System.out.println("Enter the number of seats need to be booked");
			   no_tickets=n.nextInt();
			   if(no_tickets<tot_seats)
			   {
				   System.out.println("Seats are available");
				   
				   tot_seats=tot_seats-no_tickets;
				   price=no_tickets*ticket_price;
				   return price;
			   }
			   else
			   {
				   System.out.println("Sorry,try booking for another day");
			   }
			return 0;
		   }
		  void getname()
			{//getting the name of the passengers w.r.t no of seats
				int j;
				for(j=0;j<no_tickets;j++)
				{
					System.out.println("enter the passenger name:");
					passenger=n.next();
					System.out.println(passenger);
				}
			}
		   void getage()
		   {//getting the age of the passengers w.r.t no of seats
			   int k;
			   for(k=0;k<no_tickets;k++)
			   {
				   System.out.println("enter the passenger age:");
				   age=n.nextInt();
				   System.out.println(age);
			   }
			
		   }
		   
		//methods
		public void print()
		{
			System.out.println("Train Number: "+trnum());
			System.out.println("Train Name: "+trn_ui);
			getname();
			getage();
			System.out.println("Origin:"+or_ui+'\t'+"Destination:"+des_ui);
			System.out.println("Price:"+price);
			System.out.println("Southern Railway wishes you a safe and happy journey!");
		}
		
	}
	interface updating_schedule{
	    
		int getrainno();
		String getrainname();
	}
	class route extends Railway_Management implements updating_schedule
	{
		Scanner n =new Scanner(System.in);
		protected String origin1;
		protected String dest1;
		protected int trainnum1;
		protected String trainname1;
		protected int ti_ui1;
		route(int tno,String tname,int tind,String or,String des,int tot,int pr,String t)
		{
			super(tno,tname,tind,or,des,tot,pr,t);
		}
		//display2
		void getschedule_credentials()
		{
			System.out.println("enter the origin need to be added:");
			origin1=n.next();
			System.out.println("enter the destination need to be added:");
			dest1=n.next();
			System.out.println("enter the train no need to be added:");
			trainnum1=n.nextInt();
			System.out.println("enter the train name need to be added:");
			trainname1=n.next();
		}
		String getorigin()
		{
			
			return origin1;
			
		}
		String getdestination()
		{
			
			return dest1;
		}
		public int  getrainno()
		{
			
			return trainnum1;
		}
		public String getrainname()
		{
			
			return trainname1;
		}
		
		void display1()
		{
			System.out.println("enter the index to be added:");
			ti_ui1=n.nextInt();//1 to 5
			if(ti_ui1==1 || ti_ui1==2 || ti_ui1==3 ||ti_ui1==4 || ti_ui1==5 || ti_ui1==6 )
			{
			System.out.println("train no:"+train_no);
			System.out.println("train name:"+train_name);
			System.out.println("train index:"+train_index);
			System.out.println("train starting location:"+origin);
			System.out.println("train destination:"+destination);
			}
			else{
		    
		    	getschedule_credentials();
		    	System.out.println("train no:"+getrainno());
				System.out.println("train name:"+getrainname()); 
				System.out.println("train index:"+ti_ui1); 
				System.out.println("train starting location:"+getorigin());
				System.out.println("train destination:"+getdestination());
		    }
		   
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner n =new Scanner(System.in);
        reservation r1[]=new reservation[6];
        int i,j,p;
        int users;
        r1[0]=new reservation(12674,"cheran_express",1,"Coimbatore","chennai",50,150,"10:50pm");
        r1[1]=new reservation(12680,"Intercity_Express",2,"Coimbatore","Chennai",50,100,"11:55am");
        r1[2]=new reservation(20607,"Mysuru_vande_bharath_Express",3,"chennai","benguluru",50,200,"1:05pm");
        r1[3]=new reservation(16316,"KSR_benguluru_express",4,"ernakulam","bengaluru",50,75,"10:10pm");
        r1[4]=new reservation(16323,"Menguluru_central_express",5,"ettimadai","kannur",50,95,"8:20am");
        r1[5]=new reservation(18112,"Tatanagar_express",6,"bengaluru","Vishakapatnam",50,250,"5:25pm");
        
        route r2[]=new route[6];
        r2[0]=new route(12674,"cheran_express",1,"Coimbatore","chennai",50,150,"10:50pm");
        r2[1]=new route(12680,"Intercity_Express",2,"Coimbatore","Chennai",50,100,"11:55am");
        r2[2]=new route(20607,"Mysuru_vande_bharath_Express",3,"chennai","benguluru",50,200,"1:05pm");
        r2[3]=new route(16316,"KSR_benguluru_express",4,"ernakulam","bengaluru",50,75,"10:10pm");
        r2[4]=new route(16323,"Menguluru_central_express",5,"ettimadai","kannur",50,95,"8:20am");
        r2[5]=new route(18112,"Tatanagar_express",6,"bengaluru","Vishakapatnam",50,250,"5:25pm");
        
        for(i=0;i<6;i++)
        {
        	r1[i].display();
        }
        System.out.println("enter the no of users:");
        users=n.nextInt();
        
        for(j=0;j<users;j++)
        {
        	r1[j].trnum();
        	r1[j].input1();
        	r1[j].check();
        	r1[j].booking();
        	r1[j].print();
        }
        
        for(p=0;p<6;p++)
        {
        	r2[p].display1();
        }
       
        //here the data's of 5 or 6 trains will be given for adding route module  r1[6] all the methods will be 
        //called and using for loop it is printed in the main if the program itself.
        //int tno,String tname,String or,String des,int tot,int pr
	}

}
