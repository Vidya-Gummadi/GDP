package com.gdpdemo.GDPSprint1Project;

import javax.persistence.*;


@Entity
@Table(name = "attachments")
public class Attachments {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private int id_post;

    private String filename;

    @ManyToOne
    private Posts posts;

	public int getId() {
		return id;
	}

	public int getId_post() {
		return id_post;
	}

	public String getFilename() {
		return filename;
	}

	public Posts getPosts() {
		return posts;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public void setPosts(Posts posts) {
		this.posts = posts;
	}
}
