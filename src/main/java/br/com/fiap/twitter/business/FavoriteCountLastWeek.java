package br.com.fiap.twitter.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.fiap.twitter.model.TwitterModel;
import br.com.fiap.twitter.model.TwitterValueModel;

/*
 * 3. Quantidade por dia de favoritações da última semana.
 */

@Component("favoriteCountLastWeek")
public class FavoriteCountLastWeek implements TwitterBusiness {

	@Override
	public String jsonTwitter(List<TwitterModel> tweets) {
		Gson gson = new Gson();
		TwitterValueModel valeuModel = this.countFavoriteLastWeek(tweets);
		String json = gson.toJson(valeuModel);
		return json;
	}

	private TwitterValueModel countFavoriteLastWeek(List<TwitterModel> tweets) {

		List<TwitterModel> favorities = tweets.stream().filter(tweet -> tweet.getFavoriteCount() > 0)
				.collect(Collectors.toList());
		
		int quantidadeFavoritacoes = favorities.size();
		
		TwitterValueModel valeuModel = new TwitterValueModel();
		valeuModel.setCount(quantidadeFavoritacoes);
		valeuModel.setType("Quantidade por dia de favoritações da última semana.");

		return valeuModel;
	}

}
