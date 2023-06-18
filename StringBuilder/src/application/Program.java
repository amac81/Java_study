package application;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import entities.Comment;
import entities.Post;

//example of StringBuilder class use
//with hard code data
public class Program {
	public static void main(String[] args) {
		
		//DateTimeFormatter 
		DateTimeFormatter dateFormat1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		Comment c1 = new Comment("Have a nice trip guys!");
		Comment c2 = new Comment("Wow! That's so awesome!");
		Comment c3 = new Comment("Good night!");
		Comment c4 = new Comment("I'll visit that place as well.");
		
		

		Post post1 = new Post(LocalDateTime.parse("21/06/2023 22:04:33", dateFormat1), 
				"Travelling to London", 
				"We're going to visit this wonderful city", 
				12);
		
		post1.addComment(c1);
		post1.addComment(c2);
		
		Post post2 = new Post(LocalDateTime.parse("27/07/2023 10:34:53", dateFormat1), 
				"Visiting the natural history museum of london", 
				"What an interesting museum!", 
				20);
		
		post2.addComment(c3);
		post2.addComment(c4);
		
		System.out.print(post1);
		System.out.print(post2);

		
		
	}

}
