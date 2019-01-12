package br.com.fiap.twitter.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter4j.DirectMessage;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Component
public class TwitterSendMessages {

	@Autowired
    private TwitterFactory twitterFactory;
	
	public void sendTweets(String idUsuarioTwitter, String mensagem) {
		
		Twitter twitter = twitterFactory.getInstance();
		
		try {
            DirectMessage message = twitter.sendDirectMessage(Long.parseLong(idUsuarioTwitter), mensagem);
            System.out.println("Direct message successfully sent to " + message.getId());
            System.out.println(" details:" + message.toString());
            //System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to send a direct message: " + te.getMessage());
            System.exit(-1);
        }
	}
}
