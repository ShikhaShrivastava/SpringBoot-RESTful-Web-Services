package com.techment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techment.dao.IAuthorDao;
import com.techment.dao.IBookDao;
import com.techment.entity.Author;
import com.techment.entity.Book;

@SpringBootApplication
public class SpringAssignment1Application implements CommandLineRunner {

	@Autowired
	IBookDao iBookDao;
	
	@Autowired
	IAuthorDao iAuthorDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAssignment1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Author author1= new Author("Dr. Krishna Saksena	");
		Author author2= new Author("Apoorva Kumar Singh	");
		Author author3= new Author(" Anant Vijay");
		Author author4= new Author("Amitav Ghosh");
		Author author5= new Author("Narayana Murthy");
		
//		iAuthorDao.save(author1);
//		iAuthorDao.save(author2);
//		iAuthorDao.save(author3);
//		iAuthorDao.save(author4);
//		iAuthorDao.save(author5);
		
		
		iBookDao.save(new Book("Java",500, author1));
		iBookDao.save(new Book("Python",350, author2));
		iBookDao.save(new Book("Mysql",700, author3));
		iBookDao.save(new Book("Angular",450, author4));
		iBookDao.save(new Book("React",620, author5));
		System.out.println("===========Inserted================");

		
		System.out.println("======================================================================================");
//		List<Book> book1= iBookDao.findAll();
//		book1.forEach(System.out::println);
		
//		System.out.println("======================================================================================");
//		List<Book> book2= iBookDao.findByAuthorName("Anant Vijay");
//		book2.forEach(System.out::println);
//		
//		System.out.println("======================================================================================");
//		List<Book> book3= iBookDao.findByPriceBetween(500, 1000);
//		book3.forEach(System.out::println);
//		
//		Optional<Author> authors=iAuthorDao.findById(2);
//		System.out.println(authors.get().getName()+" "+authors.get().getId());


		

		

		
	}
	

}
