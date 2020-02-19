package com.service;

public class YTService {
	
	//* Gets and returns the front of a youtube link
	private static int getFront(String recipe, int start)
	{
		if (start < 7)
			return start;
		
		if (recipe.substring(start - 7, start).contains("http"))
			return recipe.indexOf("http");
		
		if (start < 8)
			return start;
		
		if (recipe.substring(start - 8, start).contains("https"))
			return recipe.indexOf("http");
		
		else return start;
	}
	
	//*  Gets and returns the end of the time segment of a youtube link, given the start of the time number within the link
	private static int endOfTime(String recipe, int n)
	{
		while (n < recipe.length())
		{
			try {
				String temp = recipe.substring(n, n + 1);
				Integer.parseInt(temp);
			} catch (NumberFormatException e) {
				break;
			}
			n++;
		}
		return n;
	}
	
	//*  We have a ?t= to get the time and a ?v= to get the video.  Either may be present or not
	private static int getEnd(String recipe, int start)
	{
		if (recipe.contains("?v="))					//Check if we have the video question
		{
			if (recipe.contains("&t="))				//Check if it also has the time
			{
				int n = recipe.indexOf("&t=") + 3;
				
				return endOfTime(recipe, n);		//If it has the time, then we nab the end of that
			}
			return recipe.indexOf("?v=") + 14;		//If it doesn't have end of time, return the end of the link, 11 chars for the video key and 3 for the question thingy
		}
		
		if (recipe.contains("?t="))					//If there is no video question, we still need to check for if we have a time
		{
			return endOfTime(recipe, recipe.indexOf("?t=") + 3);	//Nab the time if it's there
		}
		
		int n = recipe.indexOf("be/");
		int endN = recipe.length() < n + 14 ? recipe.length() : n + 14;
		if (recipe.substring(n, endN).contains(" "))
			return start;							//If the link doesn't have a video, then return the start so it can look for another youtube video link
		else
			return n + 14;							//Return the end of the link
	}
	
	//*  This is to grab the youtube link if it is a youtube.com link
	private static String grabYouTube(String recipe)
	{
		if (recipe.contains("youtube.com/watch?v="))
		{
			int start = 0;
			int front = 0, end = 0;
			while (start < recipe.length() - 11)
			{
				start = recipe.indexOf("youtube.com");
				end = getEnd(recipe, start);
				if (end == start)
				{
					start += 11;
					continue;
				}
				front = getFront(recipe, start);
				break;
			}
			
			String temp = recipe.substring(front, end);
			
			return temp;
		}
		return null;
	}
	
	//*  This is to grab the youtube link if it is a youtu.be link
	private static String grabYouTu(String recipe)
	{
		if (recipe.contains("youtu.be/"))
		{
			int start = 0;
			int front = 0, end = 0;
			while (start < recipe.length() - 11)
			{
				start = recipe.indexOf("youtu.be");
				end = getEnd(recipe, start);
				if (end == start)
				{
					start += 11;
					continue;
				}
				front = getFront(recipe, start);
				break;
			}
			
			String temp = recipe.substring(front, end);
			
			return temp;
		}
		return null;
	}
	
	private static int extractParams(String ytLink)
	{
		String videoId;
		int time = 0;
		if (ytLink.contains("?v="))
		{
			int start = ytLink.indexOf("?v=") + 3;
			videoId = ytLink.substring(start, start + 11);
			if (ytLink.contains("&t="))
			{
				start = ytLink.indexOf("&t=") + 3;
				int end = endOfTime(ytLink, start);
				
				time = Integer.parseInt(ytLink.substring(start, end));
			}
		} else {
			int start = ytLink.indexOf("be/") + 3;
			videoId = ytLink.substring(start, start + 11);
			if (ytLink.contains("?t="))
			{
				start = ytLink.indexOf("?t=") + 3;
				int end = endOfTime(ytLink, start);
				
				time = Integer.parseInt(ytLink.substring(start, end));
			}
		}
		//Save time and videoID here
		
		return time;
	}
	
	public static String extractYT(String recipe)
	{
		String temp = "";
		
		temp = grabYouTube(recipe);
		if (temp == null)
		{
			temp = grabYouTu(recipe);
		}
		
		if (temp != null)
		{
			recipe = recipe.replace(temp, "");
			extractParams(temp);
		}
		
		
//		addYTLink(temp);
		System.out.println(temp);
		
		return recipe;
	}
}
