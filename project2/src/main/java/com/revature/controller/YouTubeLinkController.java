package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.model.YouTubeLink;
import com.revature.service.YouTubeLinkService;

/**
 * @author TeamLeo
 * Controller layer for the YouTubeLink model.
 */
@Controller
public class YouTubeLinkController {

	/**
	 * Initializes YouTubeLinkService
	 */
	private YouTubeLinkService ytls;

	/**
	 * Automatically creates associations
	 * to YouTubeLinkService
	 * @param ytls
	 */
	@Autowired
	public void setYtls(YouTubeLinkService ytls) {
		this.ytls = ytls;
	}
	
	/**
	 * Maps readAllYouTubeLink to /ytlist.app
	 * @return ytls.readAll()
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/ytlist.app", produces = "application/json")
	public ResponseEntity<List<YouTubeLink>> readAllYouTubeLinks(){
		return new ResponseEntity<>(ytls.readAll(), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps findYouTubeLinkById to /yt{id}.app
	 * @param id
	 * @return ytls.findById(id)
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/yt{id}.app", produces = "application/json")
	public ResponseEntity<YouTubeLink> findYouTubeLinkById(@PathVariable("id") int id){
		return new ResponseEntity<>(ytls.findById(id), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps update YoutubeLink to /updateyt.app
	 * @param ytl
	 * @return ytls.update(ytl)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/updateyt.app", produces = "application/json")
	public ResponseEntity<YouTubeLink> updateYouTubeLink(@RequestBody YouTubeLink ytl){
		return new ResponseEntity<>(ytls.update(ytl), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps insertNewYouTubeLink to /newyt.app
	 * @param ytl
	 * @return ytls.insert(ytl)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/newyt.app", produces = "application/json")
	public ResponseEntity<YouTubeLink> insertNewYouTubeLink(@RequestBody YouTubeLink ytl){
		return new ResponseEntity<>(ytls.insert(ytl), HttpStatus.ACCEPTED);
	}
	
	/**
	 * Maps deleteYouTubeLink to /deleteyt.app
	 * @param ytl
	 * @return ytls.delete(ytl)
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/deleteyt.app", produces = "application/json")
	public ResponseEntity<YouTubeLink> deleteYouTubeLink(@RequestBody YouTubeLink ytl){
		ytls.delete(ytl);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
