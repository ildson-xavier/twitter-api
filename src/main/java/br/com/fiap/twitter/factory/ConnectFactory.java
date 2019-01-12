package br.com.fiap.twitter.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

@Component
@org.springframework.context.annotation.Configuration
@PropertySource({"classpath:access-token.properties"})
public class ConnectFactory {

	@Autowired
	private Environment env;
	
	@Bean
	public TwitterFactory twitterFactory() {
		Configuration configuration = this.configuration();
		TwitterFactory factory = new TwitterFactory(configuration);
		return factory;
	}
	
	private Configuration configuration() {
		ConfigurationBuilder builder = new ConfigurationBuilder();
		builder.setDebugEnabled(true)
		.setOAuthConsumerKey(env.getProperty("OAUTH-CONSUMER-KEY"))
		.setOAuthConsumerSecret(env.getProperty("OAUTH-CONSUMER-SECRET"))
		.setOAuthAccessToken(env.getProperty("OAUTH-ACCESS-TOKEN"))
		.setOAuthAccessTokenSecret(env.getProperty("OAUTH-ACCESS-TOKEN-SECRET"));
		Configuration configuration = builder.build();
		return configuration ;
	}
}
