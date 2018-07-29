package blog.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import blog.entity.Comment;

/**
 * @author Administrator
 * è¯„è®ºDaoç±»
 */
@Repository("commentDao")
public interface CommentDao {
	/**
	 * å¢åŠ è¯„è®º
	 * @param comment
	 * @return
	 */
	public Integer addComment(Comment comment);
	/**
	 * åˆ é™¤è¯„è®º
	 * @param id
	 * @return
	 */
	public Integer deleteComment(Integer id);
	/**
	 * é€šè¿‡idè·å–è¯„è®º
	 * @param id
	 * @return
	 */
	public Comment findById(Integer id);
	/**
	 * æ›´æ–°è¯„è®º
	 * @param comment
	 * @return
	 */
	public Integer updateComment(Comment comment);
	
	/**
	 * è·å–æŸç¯‡æ–‡ç« çš„æ‰€æœ‰è¯„è®º
	 * @param articleid
	 * @return
	 */
	public List<Comment> listByArticleId(Integer articleid);
	
	/**
<<<<<<< HEAD
	 * æŸä¸ªäººçš„æ‰€æœ‰è¯„è®º
=======
	 * Ä³¸öÈËµÄËùÓĞÆÀÂÛ
>>>>>>> upstream/master
	 * @param userid
	 * @return
	 */
	public List<Comment> listByUserId(Integer userid);
	
	/**
<<<<<<< HEAD
	 * è·å–æŸç¯‡æ–‡ç« çš„è¯„è®ºæ€»æ•°
=======
	 * »ñÈ¡Ä³ÆªÎÄÕÂµÄÆÀÂÛ×ÜÊı
>>>>>>> upstream/master
	 * @param articleid
	 * @return
	 */
	public Long getTotalByArticleId(Integer articleid);
	
	/**
<<<<<<< HEAD
	 * è·å–æŸç”¨æˆ·è¯„è®ºçš„æ€»æ•°
=======
	 * »ñÈ¡Ä³ÓÃ»§ÆÀÂÛµÄ×ÜÊı
>>>>>>> upstream/master
	 * @param userid
	 * @return
	 */
	public Long getTotalByUserId(Integer userid);
}
