public class RationalNumber
{	
	private int a;
	private int b;
	
	public RationalNumber(int a, int b)
	{	
		this.a=a;
		if (b!=0)
		{this.b=b;}
		else throw new IllegalArgumentException();
	}

	public int getA()
	{
		return a;

	}
	public int getB()
	{
		return b;
	}
  @Override
  public boolean equals(Object another) {
    if (another == this) return true;
    if (another == null) return false;
    if (!(another instanceof RationalNumber )) return false;

    if (another instanceof RationalNumber){
        final RationalNumber anotherNumber = (RationalNumber) another;
      boolean numerator = this.a == anotherNumber.getA();
      boolean denominator = this.b == anotherNumber.getB();
      return numerator && denominator;
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(a + "/" + b);
  }

}
