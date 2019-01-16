package app;

public class Main extends Test
{
	public static int GetInt()
	{
		return 2;
	}
	
	public static int GetInt(int a)
	{
		return a;
	}
	
	public static void main(String[] args) 
	{
		Bean b = new Bean();
		b.setName("정인혜");
		b.setAge(24);
		b.setCheck(true);
		
		System.out.println(b.getName());
		System.out.println(b.getAge());
		System.out.println(b.isCheck());
		
		System.out.println(b.toString());
		
		System.out.println(GetInt());
		
		Test t = new Test();
		t.SetString("인터페이스 추상메소드 메소드구현");
	}
}
