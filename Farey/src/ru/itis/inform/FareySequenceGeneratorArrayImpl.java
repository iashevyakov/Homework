import org.apache.sanselan.common.RationalNumber;

public class FareySequenceGeneratorArrayImpl implements FareySequenceGeneratorArray
{
	
	RationalNumber [] m = new RationalNumber[100];

	public void init()
	{
		m[0] = new RationalNumber(0,1);
		m[1] = new RationalNumber(1,1);
		private int n;
		private int k;
		private int j;
		private int i;
		private int h;
	for (int c=2; c<100; c++)
	{
		m[c] = new RationalNumber();

	}
	}
	public void generate (int n);
	{	
		init();
		this.n=n;
		this.k=2;
		this.j=0;
		for (this.i=2; this.i<=this.n; this.i++)
		{
			
			while (j <= k-2)
			{
                if ( m[j].getB() + m[j+1].getB() == i )
                {
                  	for (int z=j+2; z<=k; z++)
                  	{
                  		 m[z] = RationalNumber (m[z-1].getA(), m[z-1].getB());
                  	}
                    m[j+1] = new RationalNumber(m[j].getA() + m[j+1].getA(), m[j].getB() + m[j+1].getB() );
                    j++;
                    k++;
                }

                j++;
            }
       

        }
		


		}
		public void out()
		{
		for (int this.h=0; this.h<100; this.h++)
		{
			if(m[h]!=null)
			{
				System.out.println(m[h].getA()+"/"+m[h].getB()+"  ");
			}
		}
		}	
		
	}





	
	





