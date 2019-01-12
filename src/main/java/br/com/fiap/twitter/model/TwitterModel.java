package br.com.fiap.twitter.model;

import java.time.LocalDateTime;

import br.com.fiap.twitter.comparable.TwitterComparable;
import br.com.fiap.twitter.util.TwitterDateUtil;

public class TwitterModel implements TwitterComparable {

	private String nameTwitter;
	private String nameUser;
	private Long idUser;
	private LocalDateTime dateTweet;
	private Integer reTweetsCount;
	private Integer favoriteCount;
	private String message;
	
	public TwitterModel() {	}
	
	public TwitterModel(String nameTwitter, String nameUser, Long idUser, LocalDateTime dateTweet,
			Integer reTweetsCount, Integer favoriteCount, String message) {
		super();
		this.nameTwitter = nameTwitter;
		this.nameUser = nameUser;
		this.idUser = idUser;
		this.dateTweet = dateTweet;
		this.reTweetsCount = reTweetsCount;
		this.favoriteCount = favoriteCount;
		this.message = message;
	}
	public String getNameTwitter() {
		return nameTwitter;
	}
	public void setNameTwitter(String nameTwitter) {
		this.nameTwitter = nameTwitter;
	}
	public String getNameUser() {
		return nameUser;
	}
	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public LocalDateTime getDateTweet() {
		return dateTweet;
	}
	public void setDateTweet(LocalDateTime dateTweet) {
		this.dateTweet = dateTweet;
	}
	public Integer getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(Integer favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getReTweetsCount() {
		return reTweetsCount;
	}
	public void setReTweetsCount(Integer reTweetsCount) {
		this.reTweetsCount = reTweetsCount;
	}

	@Override
	public int compareTo(TwitterModel othersObject) {
		if (!this.nameUser.equalsIgnoreCase(othersObject.getNameUser())) {
			return -1;
		}
		return 0;
	}

	@Override
	public int compareToDate(TwitterModel twitterThis, TwitterModel twitterOuthers) {
		if (!TwitterDateUtil.dateSmaller(twitterThis.getDateTweet(), twitterOuthers.getDateTweet())) {
			return -1;
		}
		return 0;
	}
	
		
	
}
