package blog.service.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import blog.entity.Article;
import blog.service.*;
import blog.dao.*;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleDao ado;
	@Override
	public List<Article> listArticle(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ado.listArticle(map);
	}

	@Override
	public Long getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ado.getTotal(map);
	}

	@Override
	public Integer getBlogByTypeId(Integer blogtypeid) {
		// TODO Auto-generated method stub
		return ado.getBlogByTypeId(blogtypeid);
	}

	@Override
	public Integer addArticle(Article article) {
		// TODO Auto-generated method stub
		return ado.addArticle(article);
	}

	@Override
	public Integer updateArticle(Article article) {
		// TODO Auto-generated method stub
		return ado.updateArticle(article);
	}

	@Override
	public Integer deleteArticle(Integer id) {
		// TODO Auto-generated method stub
		return ado.deleteArticle(id);
	}

	@Override
	public Article findById(Integer id) {
		// TODO Auto-generated method stub
		return ado.findById(id);
	}

}
