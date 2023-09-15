package com.gdpdemo.GDPSprint1Project;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "posts")
public class Posts {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Length(min = 1, message = "Content of the Post should be start at least one character")
	@Column
	private String post_content;

	@Size(min = 1, message = "category required")
	@Column
	private String category;
	
	
	@Size(min = 1, message = "title is required")
	@Column
	private String title;

	@OneToMany(mappedBy = "id_post", cascade = { CascadeType.MERGE })
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<PostsAuthors> postsAuthors;

	@OneToMany(mappedBy = "posts", cascade = { CascadeType.MERGE, CascadeType.PERSIST })
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private List<Attachments> attachments;
	
	
	public Posts(int id,
			@Length(min = 1, message = "Content of the Post should be start at least one character") String post_content,
			@Size(min = 1, message = "category required") String category,
			@Size(min = 1, message = "title is required") String title, List<PostsAuthors> postsAuthors,
			List<Attachments> attachments) {
		super();
		this.id = id;
		this.post_content = post_content;
		this.category = category;
		this.title = title;
		this.postsAuthors = postsAuthors;
		this.attachments = attachments;
	}

	public Posts() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getPost_content() {
		return post_content;
	}

	public String getCategory() {
		return category;
	}

	public List<PostsAuthors> getPostsAuthors() {
		return postsAuthors;
	}

	public List<Attachments> getAttachments() {
		return attachments;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPost_content(String post_content) {
		this.post_content = post_content;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setPostsAuthors(List<PostsAuthors> postsAuthors) {
		this.postsAuthors = postsAuthors;
	}

	public void setAttachments(List<Attachments> attachments) {
		this.attachments = attachments;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
