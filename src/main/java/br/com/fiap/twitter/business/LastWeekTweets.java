package br.com.fiap.twitter.business;

import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;
import br.com.fiap.twitter.model.TwitterValueModel;

/*
 * 1. Quantidade por dia de tweets da última semana.
 */

@Component("lastWeekTweets")
public class LastWeekTweets implements TwitterBusiness {

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		TwitterValueModel valeuModel = this.countTwitterLastWeek(tweets);
		String json = gson.toJson(valeuModel);
		return json;
	}

	private TwitterValueModel countTwitterLastWeek(List<TwitterModel> tweets) {
		
		int quantidadeTweetsNaSemana = tweets.size();
		
		TwitterValueModel valeuModel = new TwitterValueModel();
		valeuModel.setCount(quantidadeTweetsNaSemana);
		valeuModel.setType("Quantidade por dia de tweets da última semana");
		return valeuModel;
	}
}
