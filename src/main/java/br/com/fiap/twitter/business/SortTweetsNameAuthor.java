package br.com.fiap.twitter.business;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;

/*
 * 4. Ordenar os tweets pelo nome do autor,
 */

@Component("sortTweetsNameAuthor")
public class SortTweetsNameAuthor implements TwitterBusiness {

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		this.sortTweetsNameAuthor(tweets);
		String json = gson.toJson(tweets);
		return json;
	}
	
	private void sortTweetsNameAuthor(List<TwitterModel> tweets) {
		Collections.sort(tweets, (t1, t2) -> t1.getNameUser().compareTo(t2.getNameUser()));
	}

}
