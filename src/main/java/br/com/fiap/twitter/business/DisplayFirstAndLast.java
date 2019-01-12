package br.com.fiap.twitter.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;

/*
 * 4. Exibir o primeiro nome e o último nome
 */

@Component("displayFirstAndLast")
public class DisplayFirstAndLast implements TwitterBusiness {

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		this.sortTweetsNameAuthor(tweets);
		List<TwitterModel> twitterModels = this.selectFirstAndeLastAuthor(tweets);
		String json = gson.toJson(twitterModels);
		return json;
	}
	
	private void sortTweetsNameAuthor(List<TwitterModel> tweets) {
		Collections.sort(tweets, (t1, t2) -> t1.getNameUser().compareTo(t2.getNameUser()));
	}
	
	private List<TwitterModel> selectFirstAndeLastAuthor(List<TwitterModel> tweets) {
		TwitterModel first = tweets.get(0);
		int size = tweets.size();
		TwitterModel last = tweets.get(size - 1);
		
		List<TwitterModel> models = new ArrayList<>();
		models.add(first);
		models.add(last);
		
		return models;
	}

}
