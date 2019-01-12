package br.com.fiap.twitter.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;

/*
 * 5. Exibir a data mais recente e a menos recente.
 */

@Component("displayFirstAndLastDate")
public class DisplayFirstAndLastDate implements TwitterBusiness{

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		this.sortTweetsDate(tweets);
		List<TwitterModel> twitterModels = this.selectFirstAndeLastDate(tweets);
		String json = gson.toJson(twitterModels);
		return json;
	}
	
	private void sortTweetsDate(List<TwitterModel> tweets) {
		Collections.sort(tweets, (t1, t2) -> t1.compareToDate(t1, t2));
	}
	
	private List<TwitterModel> selectFirstAndeLastDate(List<TwitterModel> tweets) {
		TwitterModel first = tweets.get(0);
		int size = tweets.size();
		TwitterModel last = tweets.get(size - 1);
		
		List<TwitterModel> models = new ArrayList<>();
		models.add(first);
		models.add(last);
		
		return models;
	}

}
