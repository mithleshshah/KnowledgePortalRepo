class Base
{ Base()
  {System.out.println("Base Version..");
	  }
  Base(int x)
  {System.out.println("Base Version.."+x);
	  }
 	}
class Derive extends Base
{ Derive()
  {super(333);
	  System.out.println("Derive Version..");
	  }
  Derive(int x,int y)
  {  super(x);
	  System.out.println("Derive Version.."+x+","+y);
	  }
 	}
 class ExConstructor
{  public static void main(String arg[])
   {Derive D1=new Derive();
	Derive D2=new Derive(10,20);
	//By default derive class constructor any always invoke the base class default constructor implicitly
	}
 }
