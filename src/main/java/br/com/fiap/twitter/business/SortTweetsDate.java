package br.com.fiap.twitter.business;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;

/*
 * 5. Ordenar os tweets por data
 */

@Component("sortTweetsDate")
public class SortTweetsDate implements TwitterBusiness{

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		this.sortTweetsDate(tweets);
		String json = gson.toJson(tweets);
		return json;
	}
	
	private void sortTweetsDate(List<TwitterModel> tweets) {
		Collections.sort(tweets, (t1, t2) -> t1.compareToDate(t1, t2));
	}

}
