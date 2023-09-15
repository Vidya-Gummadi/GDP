package com.gdpdemo.GDPSprint1Project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.gdpdemo.GDPSprint1Project.service.AttachmentsManager;
import com.gdpdemo.GDPSprint1Project.service.PostsAuthorsManager;
import com.gdpdemo.GDPSprint1Project.service.PostsManager;
import com.gdpdemo.GDPSprint1Project.storage.StorageService;

@Controller
public class PostController {

	 	private final PostsManager postsManager;
	    private final PostsAuthorsManager postsAuthorsManager;
	    private final AttachmentsManager attachmentsManager;
	    private final StorageService storageService;

	    @Autowired
	    public PostController(PostsManager postsManager, PostsAuthorsManager postsAuthorsManager, AttachmentsManager attachmentsManager, StorageService storageService) {
	        this.postsManager = postsManager;
	        this.postsAuthorsManager = postsAuthorsManager;
	        this.attachmentsManager = attachmentsManager;
	        this.storageService = storageService;
	    }
	    
	    @GetMapping("/post/{id}")
	    public String post(@PathVariable("id") int id, Model model) {
	        Posts post = postsManager.findById(id);
	        model.addAttribute("post", post);
			/*
			 * model.addAttribute("files", storageService.loadAll() .filter(c ->
			 * c.getFileName().toString().matches(
			 * "(.*[^\\s]+(\\.(?i)(jpg|png|gif|bmp|jpeg))$)")) .map(p ->
			 * p.getFileName().toString()) .collect(Collectors.toList()));
			 */
	        model.addAttribute("comments", new Comments());
	        return "post";
	    }
	    
	  //edit post
	    @GetMapping("/post/edit/{id}")
	    public String editPost(Model model, @PathVariable int id) {
	        List<String> tagsWithDuplication = new ArrayList<>();
	        //postsManager.getAllPosts().forEach(tags -> tagsWithDuplication.addAll(Arrays.asList(tags.getTags().split(" "))));
	        List<String> allTags = new ArrayList<>(new HashSet<>(tagsWithDuplication));
	        Collections.sort(allTags);
	        Posts post = postsManager.findById(id);
	        model.addAttribute("post", post);
	        model.addAttribute("allTags", allTags);
	        model.addAttribute("attachments", post.getAttachments());
	        model.addAttribute("PostId", id);

	        return "edit-post";
	    }
	    
	    
}
