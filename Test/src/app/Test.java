package app;

public class Test implements TestInterface
{
	public static int GetInt()
	{
		return 1;
	}

	@Override
	public void SetString(String a) 
	{
		System.out.println(a);
	}
}
