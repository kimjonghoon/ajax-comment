package net.java_school.controller;

import java.util.List;

import net.java_school.board.Comment;
import net.java_school.board.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentController {

	@Autowired
	private CommentService service;

	@PostMapping
	public void addComment(Comment comment) {
		service.addComment(comment);
	}

	@GetMapping
	public List<Comment> getComments() {
		return service.getComments();
	}

	@DeleteMapping("{no}")
	public void removeComment(@PathVariable(name="no") Integer no) {
		service.removeComment(no);
	}

	@PutMapping("{no}")
	public void modifyComment(@RequestParam(name="content") String content, @PathVariable(name="no") Integer no) {
		Comment comment = this.getComment(no);
		comment.setContent(content);
		service.modifyComment(comment);
	}

	@GetMapping("{no}")
	public Comment getComment(@PathVariable(name="no") Integer no) {
		return service.getComment(no);
	}

}