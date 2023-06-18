package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {
	
	private static DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	private LocalDateTime moment;
	private String title;
	private String content;
	private int numberOfLikes;
	private List <Comment> comments = new ArrayList <> ();
	
	public Post() {}

	public Post(LocalDateTime moment, String title, String content, int numberOfLikes) {
		this.moment = moment;
		this.title = title;
		this.content = content;
		this.numberOfLikes = numberOfLikes;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}
	
	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(Comment comment) 
	{
		comments.remove(comment);
	}
	
	public String toString() {
		/* Use of StringBuilder:
		 * 
		 * The + operator uses public String concat(String str) internally. 
		 * This method copies the characters of the two strings, 
		 * so it has memory requirements and runtime complexity 
		 * proportional to the length of the two strings. 
		 * 
		 * StringBuilder works more efficent.
		 * 
		 * Note: StringBuilder is not ThreadSafe, so, to multi threaded environment check StringBuffer.
		 * https://www.digitalocean.com/community/tutorials/string-vs-stringbuffer-vs-stringbuilder
		 * */
		
		StringBuilder strResult = new StringBuilder();
		
		strResult.append(title + "\n");
		strResult.append(numberOfLikes + " Likes - ");
		strResult.append(moment.format(dateFormat1) + "\n");
		strResult.append(content + "\n");
		strResult.append("Comments: \n");
		
		for(Comment c: comments) {
			strResult.append(c.getText() + "\n");
		}
		strResult.append("\n");
		
		return strResult.toString();
	}
		
}
