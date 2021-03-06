package com.techment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.techment.dao.IProductDao;
import com.techment.entity.Product;

@SpringBootApplication
public class SpringBootJpaApplication implements CommandLineRunner
{
	@Autowired
	IProductDao iProductDao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello this is my first spring boot project");
		
		Product product1= new Product("Dell","laptop",45000);
		Product product2= new Product("OnePlus","mobile",35000);
		
		iProductDao.save(product1);
		iProductDao.save(product2);
		
		System.out.println("========Inserted=========");
		
		List<Product>products=iProductDao.findAll();
		products.forEach(System.out::println);
		
//		Optional<Product>product =iProductDao.findById(3);
//		if(product.isPresent())
//			System.out.println("Products: "+product.get());
//		else
//			System.out.println("No value with the given id");
//		
//		Product product3=iProductDao.findById(3).get();
//		System.out.println("Product "+product3);
//		
		//--------------------------------------------------------------------------------------------------------
//		//Count Total product
		long totalProducts=iProductDao.count();
		System.out.println("Total Number of Product: "+totalProducts);
		
		//--------------------------------------------------------------------------------------------------------
		//Delete by Id
		
		
		
//		if(iProductDao.existsById(3))
//		{
//			iProductDao.deleteById(3);
//			System.out.println("=========Deleted=======");
//		}
//		else
//			System.out.println("No id present");
//		
		
		
			List<Product> prod= iProductDao.findByName("Dell");
			System.out.println("Product "+prod);
				
				
				
				

		
	}

}
