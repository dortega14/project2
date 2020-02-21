package yttest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.testiculars.yttest.YTService;

public class YTTest {
	@Test
	public void testExtractYTFront()
	{
		String s = "https://youtu.be/jJ2qlKLYKxc aklhflk lkasfdj dkdkek di";
		assertEquals(" aklhflk lkasfdj dkdkek di", YTService.extractYT(s));
	}
	
	@Test
	public void testExtractYTMiddle()
	{
		String s = "hello hello https://youtu.be/jJ2qlKLYKxc hello hello";
		assertEquals("hello hello  hello hello", YTService.extractYT(s));
	}
	
	@Test
	public void testExtractYTEnd()
	{
		String s = "hello hello https://youtu.be/jJ2qlKLYKxc";
		assertEquals("hello hello ", YTService.extractYT(s));
	}
	
	@Test
	public void testGetFrontLT7()
	{
		String s = "hello youtube.com";
		assertEquals(6, YTService.getFront(s, 6));
	}
	
	@Test
	public void testGetFrontLT8()
	{
		String s = "hellos youtube.com";
		assertEquals(7, YTService.getFront(s, 7));
	}
	
	@Test
	public void testGetFrontStart()
	{
		String s = "http://youtube.com";
		assertEquals(0, YTService.getFront(s, 7));
	}
	
	@Test
	public void testGetFrontHttpLT8()
	{
		String s = " http://youtube.com";
		assertEquals(1, YTService.getFront(s, 8));
	}
	
	@Test
	public void testGetFrontHttpsStart()
	{
		String s = "https://youtube.com";
		assertEquals(0, YTService.getFront(s, 8));
	}
	
	@Test
	public void testGetFrontHttpGT7()
	{
		String s = "hello hello http://youtube.com";
		assertEquals(12, YTService.getFront(s, 19));
	}
	
	@Test
	public void testGetFrontHttpsGT8()
	{
		String s = "hello hello https://youtube.com";
		assertEquals(12, YTService.getFront(s, 20));
	}
	
	@Test
	public void testEndOfTime1atEnd()
	{
		String s = "2";
		assertEquals(1, YTService.endOfTime(s, 0));
	}
	
	@Test
	public void testEndOfTime1()
	{
		String s = "3 ";
		assertEquals(1, YTService.endOfTime(s, 0));
	}
	
	@Test
	public void testEndOfTimeGT1atEnd()
	{
		String s = "1232";
		assertEquals(4, YTService.endOfTime(s, 0));
	}
	
	@Test
	public void testEndOfTimeGT1()
	{
		String s = "1234 ";
		assertEquals(4, YTService.endOfTime(s, 0));
	}
	
	@Test
	public void testGetEndVEnd()
	{
		String s = "?v=abcdefghijk";
		assertEquals(14, YTService.getEnd(s, 0));
	}
	
	@Test
	public void testGetEndV()
	{
		String s = "?v=abcdefghijknospace";
		assertEquals(14, YTService.getEnd(s, 0));
	}
	
	@Test
	public void testGetEndVTEnd()
	{
		String s = "?v=abcdefghijk&t=6543";
		assertEquals(21, YTService.getEnd(s, 0));
	}
	
	@Test
	public void testGetEndVT()
	{
		String s = "?v=abcdefghijk&t=6543nospace";
		assertEquals(21, YTService.getEnd(s, 0));
	}
	
	@Test
	public void testGetEndTEnd()
	{
		String s = "?t=345";
		assertEquals(6, YTService.getEnd(s, 0));
	}
	
	@Test
	public void testGetEndT()
	{
		String s = "?t=345notnumber";
		assertEquals(6, YTService.getEnd(s, 0));
	}
	
	@Test
	public void testGetEnd()
	{
		String s = "youtu.be/abcdefghijk";
		assertEquals(20, YTService.getEnd(s, 0));
	}
}
