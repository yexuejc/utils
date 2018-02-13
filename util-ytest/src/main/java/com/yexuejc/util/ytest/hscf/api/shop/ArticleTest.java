package com.yexuejc.util.ytest.hscf.api.shop;

import com.yexuejc.util.ytest.hscf.api.core.BaseHscfTest;
import com.yexuejc.util.ytest.hscf.api.model.Pager;
import com.yexuejc.util.ytest.hscf.api.utils.Reqst;
import org.junit.Test;

/**
 *  慧商车服-移动端-shopApi
 * @author yexue
 * @expl
 * @time 2017年8月24日 上午11:45:59
 */
public class ArticleTest extends BaseHscfTest {
	enum URI {
		GET_ARTICLE_PAGE("/getArticlePage"),//咨询分页查询
		GET_ARTICLE_BYID("/getArticleById"),//根据Id查询咨询
		HOT_ARTICLE("/hotArticle"),//热门咨询查询
		RECOMMEND_ARTICLE("/recommendArticle")//推介咨询查询
		
		;

		public String NAME;

		URI(String name) {
			this.NAME = articlePAth+name;
		}
	}
	/**
	 * 咨询分页查询
	 */
	@Test
	public void getArticlePage() {
		Reqst reqst = new Reqst();
		Pager pager = new Pager();
		pager.setPage(1);
		reqst.setData(pager);
		toReqst(URI.GET_ARTICLE_PAGE.NAME,reqst);
	}
	/**
	 * 根据Id查询咨询
	 */
	@Test
	public void getArticleById() {
		Reqst reqst = new Reqst();
		reqst.setData("46e2faf9829741d3b9c00140e98a35d2");
		toReqst(URI.GET_ARTICLE_BYID.NAME,reqst);
	}
	/**
	 * 热门咨询查询
	 */
	@Test
	public void hotArticle() {
		Reqst reqst = new Reqst();
		reqst.setData(10);
		toReqst(URI.HOT_ARTICLE.NAME,reqst);
	}
	/**
	 * 推介咨询查询
	 */
	@Test
	public void recommendArticle() {
		Reqst reqst = new Reqst();
		reqst.setData(10);
		toReqst(URI.RECOMMEND_ARTICLE.NAME,reqst);
	}

}
