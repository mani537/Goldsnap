import java.util.List;

public class StringMani3{
	
	public static void main(String args[])
	{	
		
		int n=10;
		String lib="\0";
		String lib1="\0";
		String Trial="manikanta";
		String Trail1;
		//length=Trial.length();
		char [] mani=Trial.toCharArray();
		for(int i=1;i<=n-1;i++)
		{
			lib=lib+i;
		/*	if(i>1)
			{ */
				lib1=i+lib1;
		//	}
			Trail1=lib+lib1;
			System.out.println("\n"+Trail1);
		}
	
	}
}
