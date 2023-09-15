package com.gdpdemo.GDPSprint1Project;




import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;


@Embeddable
public class PostsAuthorsId implements Serializable {

    
    private static final long serialVersionUID = 1L;


	@Column(name = "id_post")
    private int id_post;

    
    @Column(name = "id_author")
    private int id_author;

	

	public PostsAuthorsId() {
		super();
	}

	public PostsAuthorsId(int id_post, int id_author) {
		super();
		this.id_post = id_post;
		this.id_author = id_author;
	}

	public int getId_post() {
		return id_post;
	}

	public int getId_author() {
		return id_author;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public void setId_author(int id_author) {
		this.id_author = id_author;
	}

}
