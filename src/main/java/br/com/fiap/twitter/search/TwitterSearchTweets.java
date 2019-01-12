package br.com.fiap.twitter.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fiap.twitter.model.TwitterModel;
import br.com.fiap.twitter.util.TwitterDateUtil;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Component
public class TwitterSearchTweets {

	@Autowired
    private TwitterFactory twitterFactory;
	
	public List<TwitterModel> searchForTweets(String pesquisa) {
		
		Twitter twitter = twitterFactory.getInstance();
		List<TwitterModel> tweetsModel = new ArrayList<>();
		
        try {
            Query query = new Query(pesquisa);
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                	TwitterModel model = new TwitterModel();
                	
                	model.setNameTwitter("@" + tweet.getUser().getScreenName());
                	model.setNameUser(tweet.getUser().getName() );
                	model.setMessage(tweet.getText());
                	model.setFavoriteCount(tweet.getFavoriteCount());
                	model.setIdUser(tweet.getUser().getId());
                	model.setReTweetsCount(tweet.getRetweetCount());
                	model.setDateTweet(TwitterDateUtil.dateToLocalDateTime(tweet.getCreatedAt()));
                	
                	tweetsModel.add(model);
                }
            } while ((query = result.nextQuery()) != null);
            
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
        
        return tweetsModel;
	}
}
