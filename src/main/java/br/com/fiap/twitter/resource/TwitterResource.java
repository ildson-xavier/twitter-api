package br.com.fiap.twitter.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.twitter.business.TwitterBusiness;
import br.com.fiap.twitter.model.TwitterModel;
import br.com.fiap.twitter.search.TwitterSearchTweets;
import br.com.fiap.twitter.send.TwitterSendMessages;

@RestController
@RequestMapping("/api")
public class TwitterResource {

	@Autowired
	private TwitterSearchTweets twitterSearch;
	
	@Autowired
	private TwitterSendMessages twitterSendMessages;
	
	@Autowired
	private TwitterBusiness searchTweets;
	
	@Autowired
	private TwitterBusiness lastWeekTweets;
	
	@Autowired
	private TwitterBusiness lastWeekReTweets;
	
	@Autowired
	private TwitterBusiness favoriteCountLastWeek;
	
	@Autowired
	private TwitterBusiness sortTweetsNameAuthor;
	
	@Autowired
	private TwitterBusiness displayFirstAndLast;
	
	@Autowired
	private TwitterBusiness displayFirstAndLastDate;
	
	@Autowired
	private TwitterBusiness sortTweetsDate;
	
	@GetMapping(value = "/search-tweets/{hashtag}", produces = "application/json")
	public String twitters(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = searchTweets.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/lastWeekTweets/{hashtag}", produces = "application/json")
	public String lastWeekTweets(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = lastWeekTweets.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/lastWeekReTweets/{hashtag}", produces = "application/json")
	public String lastWeekReTweets(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = lastWeekReTweets.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/favoriteCountLastWeek/{hashtag}", produces = "application/json")
	public String favoriteCountLastWeek(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = favoriteCountLastWeek.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/sortTweetsNameAuthor/{hashtag}", produces = "application/json")
	public String sortTweetsNameAuthor(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = sortTweetsNameAuthor.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/displayFirstAndLast/{hashtag}", produces = "application/json")
	public String displayFirstAndLast(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = displayFirstAndLast.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/sortTweetsDate/{hashtag}", produces = "application/json")
	public String sortTweetsDate(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = sortTweetsDate.jsonTwitter(tweets);
		return json;
	}
	
	@GetMapping(value = "/displayFirstAndLastDate/{hashtag}", produces = "application/json")
	public String displayFirstAndLastDate(@PathVariable(name="hashtag") String hashtag) {
		List<TwitterModel> tweets = twitterSearch.searchForTweets(hashtag);
		String json = displayFirstAndLastDate.jsonTwitter(tweets);
		return json;
	}
	
	
	@GetMapping(value = "/send-message/{idUser}/{message}", produces = "application/json")
	public String send(@PathVariable(name="idUser") String idUser, @PathVariable(name="message") String message) {
		twitterSendMessages.sendTweets(idUser, message);
		return "novo teste de envio";
	}
}
