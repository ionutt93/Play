class Play
{
	public Play()
	{

	}

	private void test()
	{
		for(int i = 1; i < 100; i++)
			System.out.println("tested");
	}

	public static void main(String[] args)
	{
		Play p = new Play();
		p.test();
	}
}