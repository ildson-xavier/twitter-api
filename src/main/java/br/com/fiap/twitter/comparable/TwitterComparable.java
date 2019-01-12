package br.com.fiap.twitter.comparable;

import br.com.fiap.twitter.model.TwitterModel;

public interface TwitterComparable extends Comparable<TwitterModel>{

	public int compareToDate(TwitterModel twitterThis, TwitterModel twitterOuthers);
}
