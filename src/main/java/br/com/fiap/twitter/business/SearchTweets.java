package br.com.fiap.twitter.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;

@Component("searchTweets")
public class SearchTweets implements TwitterBusiness{

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		String json = gson.toJson(tweets);
		return json;
	}

}
