package blog.entity;

/**
 * @author Administrator
 * 评论实体类
 */
public class Comment {
	/**
	 * 评论条id
	 */
	private Integer id;
	/**
	 * 评论正文
	 */
	private String content;
	/**
	 * 评论日期
	 */
	private String commentDate;
	/**
	 * 评论用户id
	 */
	private Integer userid;
	/**
	 * 被评论的文章id
	 */
	private Integer articleid;
	
	public Comment(){
		
	}
	
	public Comment(String content, Integer userid, Integer articleid) {
		super();
		this.content = content;
		this.userid = userid;
		this.articleid = articleid;
	}
	
	public Comment(Integer id, String content, String commentDate, Integer userid, Integer articleid) {
		super();
		this.id = id;
		this.content = content;
		this.commentDate = commentDate;
		this.userid = userid;
		this.articleid = articleid;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Integer getArticleid() {
		return articleid;
	}
	public void setArticleid(Integer articleid) {
		this.articleid = articleid;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", commentDate=" + commentDate + ", userid=" + userid
				+ ", articleid=" + articleid + "]";
	}
	
}
