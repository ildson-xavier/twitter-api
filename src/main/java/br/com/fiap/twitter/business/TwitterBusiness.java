package br.com.fiap.twitter.business;

import java.util.List;

import br.com.fiap.twitter.model.TwitterModel;

public interface TwitterBusiness {

	public String jsonTwitter(List<TwitterModel> tweets);
	
}
