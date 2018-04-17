package io.pivotal.workshop.snippet.actuator;

public class SnippetMetric {

	private int snippetGet;
	private int snippetPost;
	private int snippetPut;
	private int snippetDelete;
	
	public SnippetMetric(){}

	public SnippetMetric(int snippetGet, int snippetPost, int snippetPut, int snippetDelete) {
		this.snippetGet = snippetGet;
		this.snippetPost = snippetPost;
		this.snippetPut = snippetPut;
		this.snippetDelete = snippetDelete;
	}

	public int getSnippetGet() {
		return snippetGet;
	}

	public void setSnippetGet(int snippetGet) {
		this.snippetGet = snippetGet;
	}

	public int getSnippetPost() {
		return snippetPost;
	}

	public void setSnippetPost(int snippetPost) {
		this.snippetPost = snippetPost;
	}

	public int getSnippetPut() {
		return snippetPut;
	}

	public void setSnippetPut(int snippetPut) {
		this.snippetPut = snippetPut;
	}

	public int getSnippetDelete() {
		return snippetDelete;
	}

	public void setSnippetDelete(int snippetDelete) {
		this.snippetDelete = snippetDelete;
	}

}
