package com.wechat.model;

import java.util.List;

/**
 * Created by zxc on 2018/2/22.
 */
public class NewsMessage extends ResBaseMessage {
	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}

	private int ArticleCount;	//图文消息数量最多不超过10个
	private List<Article> Articles;
}
