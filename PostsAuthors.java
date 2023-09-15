package com.gdpdemo.GDPSprint1Project;


import javax.persistence.*;


@Entity
@Table(name = "posts_authors")
public class PostsAuthors {

	@EmbeddedId
    private PostsAuthorsId id;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Posts id_post;

    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Home id_author;
    
    public PostsAuthors() {
		super();
	}

    public PostsAuthors(Posts id_post, Home id_author) {
        this.id_post = id_post;
        this.id_author = id_author;
    }

	public PostsAuthors(PostsAuthorsId id, Posts id_post, Home id_author) {
		super();
		this.id = id;
		this.id_post = id_post;
		this.id_author = id_author;
	}

	public PostsAuthorsId getId() {
		return id;
	}

	public Posts getId_post() {
		return id_post;
	}

	public Home getId_author() {
		return id_author;
	}

	public void setId(PostsAuthorsId id) {
		this.id = id;
	}

	public void setId_post(Posts id_post) {
		this.id_post = id_post;
	}

	public void setId_author(Home id_author) {
		this.id_author = id_author;
	}

}
