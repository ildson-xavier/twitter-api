package br.com.fiap.twitter.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;
import br.com.fiap.twitter.model.TwitterValueModel;

/*
 * 2. Quantidade por dia de retweets da última semana.
 */

@Component("lastWeekReTweets")
public class LastWeekReTweets implements TwitterBusiness {

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		TwitterValueModel valeuModel = this.countReTwitterLastWeek(tweets);
		String json = gson.toJson(valeuModel);
		return json;
	}

	private TwitterValueModel countReTwitterLastWeek(List<TwitterModel> tweets) {
		List<TwitterModel> listReTweets = tweets.stream().filter(tweet -> tweet.getReTweetsCount() > 0)
				.collect(Collectors.toList());
		
		int quantidadeReTweets = listReTweets.stream().mapToInt(TwitterModel::getReTweetsCount).sum();
		
		TwitterValueModel valeuModel = new TwitterValueModel();
		valeuModel.setCount(quantidadeReTweets);
		valeuModel.setType("Quantidade por dia de retweets da última semana");
		return valeuModel;
	}

}
