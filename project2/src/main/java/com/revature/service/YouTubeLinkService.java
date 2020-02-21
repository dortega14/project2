package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.YouTubeLinkDao;
import com.revature.model.Post;
import com.revature.model.YouTubeLink;

/**
 * @author TeamLeo
 * This class is the only class that can communicate with the
 * YouTubeLinkDao class inside of the Dao layer.
 * Service layer for the YouTubeLink model.
 */
@Service
public class YouTubeLinkService {

	private YouTubeLinkDao ytld;

	@Autowired
	public void setYtld(YouTubeLinkDao ytld) {
		this.ytld = ytld;
	}

	public List<YouTubeLink> readAll() {
		return ytld.findAll();
	}

	public YouTubeLink findById(int id) {
		return ytld.findById(id);
	}

	public YouTubeLink update(YouTubeLink ytl) {
		return ytld.update(ytl);
	}

	public YouTubeLink insert(YouTubeLink ytl) {
		return ytld.insert(ytl);
	}

	public void delete(YouTubeLink ytl) {
		ytld.delete(ytl);
	}

	/**
	 * Gets and returns the front of a youtube link
	 * @param recipe
	 * @param start
	 * @return start
	 */
	private static int getFront(String recipe, int start) {
		if (start < 7)
			return start;

		if (recipe.substring(start - 7, start).contains("http"))
			return recipe.indexOf("http");

		if (start < 8)
			return start;

		if (recipe.substring(start - 8, start).contains("https"))
			return recipe.indexOf("http");

		else
			return start;
	}

	/**
	 * Gets and returns the end of the time segment of a youtube link, given the
	 * start of the time number within the link
	 * @param recipe
	 * @param n
	 * @return n
	 */
	private static int endOfTime(String recipe, int n) {
		while (n < recipe.length()) {
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

	/**
	 * We have a ?t= to get the time and a ?v= to get the video. 
	 * Either may be present or not.
	 * @param recipe
	 * @param start
	 */
	private static int getEnd(String recipe, int start) {
		if (recipe.contains("?v=")) // Check if we have the video question
		{
			if (recipe.contains("&t=")) // Check if it also has the time
			{
				int n = recipe.indexOf("&t=") + 3;

				return endOfTime(recipe, n); // If it has the time, then we nab the end of that
			}
			return recipe.indexOf("?v=") + 14; // If it doesn't have end of time, return the end of the link, 11 chars
												// for the video key and 3 for the question thingy
		}

		if (recipe.contains("?t=")) // If there is no video question, we still need to check for if we have a time
		{
			return endOfTime(recipe, recipe.indexOf("?t=") + 3); // Nab the time if it's there
		}

		int n = recipe.indexOf("be/");
		int endN = recipe.length() < n + 14 ? recipe.length() : n + 14;
		if (recipe.substring(n, endN).contains(" "))
			return start; // If the link doesn't have a video, then return the start so it can look for
							// another youtube video link
		else
			return n + 14; // Return the end of the link
	}

	/**
	 * This is to grab the youtube link if it is a youtube.com link
	 * @param recipe
	 * @return temp
	 */
	private static String grabYouTube(String recipe) {
		if (recipe.contains("youtube.com/watch?v=")) {
			int start = 0;
			int front = 0, end = 0;
			while (start < recipe.length() - 11) {
				start = recipe.indexOf("youtube.com");
				end = getEnd(recipe, start);
				if (end == start) {
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

	/**
	 * This is to grab the youtube link if it is a youtu.be link
	 * @param recipe
	 * @return temp
	 */
	private static String grabYouTu(String recipe) {
		if (recipe.contains("youtu.be/")) {
			int start = 0;
			int front = 0, end = 0;
			while (start < recipe.length() - 11) {
				start = recipe.indexOf("youtu.be");
				end = getEnd(recipe, start);
				if (end == start) {
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

	private int extractParams(String ytLink, Post ytPost) {
		String videoId;
		int time = 0;
		if (ytLink.contains("?v=")) {
			int start = ytLink.indexOf("?v=") + 3;
			videoId = ytLink.substring(start, start + 11);
			if (ytLink.contains("&t=")) {
				start = ytLink.indexOf("&t=") + 3;
				int end = endOfTime(ytLink, start);

				time = Integer.parseInt(ytLink.substring(start, end));
			}
		} else {
			int start = ytLink.indexOf("be/") + 3;
			videoId = ytLink.substring(start, start + 11);
			if (ytLink.contains("?t=")) {
				start = ytLink.indexOf("?t=") + 3;
				int end = endOfTime(ytLink, start);

				time = Integer.parseInt(ytLink.substring(start, end));
			}
		}
		PostService ps = new PostService();
		ps.insert(ytPost);
		
		YouTubeLink ytl = new YouTubeLink(videoId, time, ytPost);
		ytld.insert(ytl);
		
		return time;
	}

	public String extractYT(Post p) {
//		PostService ps = new PostService();
//		Post p = ps.findById(id);
		
		String temp = "";
		
		String recipe = p.getRecipe();

		temp = grabYouTube(recipe);
		if (temp == null) {
			temp = grabYouTu(recipe);
		}

		if (temp != null) {
			recipe = recipe.replace(temp, "");
			p.setRecipe(recipe);
			extractParams(temp, p);
		}

		
		System.out.println(temp);

		return recipe;
	}

}
