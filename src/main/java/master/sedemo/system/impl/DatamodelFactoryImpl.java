package master.sedemo.system.impl;

import datamodel.Article;
import datamodel.Customer;
import datamodel.Order;
import system.DatamodelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Factory that creates instances of classes of the {@link datamodel} package.
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */

class DatamodelFactoryImpl implements DatamodelFactory {

	/**
	 * Internal lists of Customer, Article and Order objects.
	 */
	private final List<Customer> customers = new ArrayList<Customer>();
	private final List<Article> articles = new ArrayList<Article>();
	private final List<Order> orders = new ArrayList<Order>();


	/**
	 * None-public constructor.
	 */
	DatamodelFactoryImpl() { }


	/**
	 * Customer factory method using default constructor.
	 * 
	 * @return Customer object created with default constructor.
	 */
	@Override
	public Customer createCustomer() { return add(new Customer()); }


	/**
	 * Customer factory method using constructor with name argument.
	 * 
	 * @param name single-String Customer name, e.g. "Eric Meyer".
	 * @return Customer object created with constructor with name argument.
	 */
	@Override
	public Customer createCustomer(String name) { return add(new Customer(name)); }


	/**
	 * Article factory method using default constructor.
	 * 
	 * @return Article object created with default constructor.
	 */
	@Override
	public Article createArticle() { return add(new Article()); }


	/**
	 * Article factory method using constructor with description and unitPrice arguments.
	 * 
	 * @param description descriptive text for article.
	 * @param unitPrice price (in cent) for one unit of the article.
	 * @return Article object created with constructor with description and unitPrice arguments.
	 */
	@Override
	public Article createArticle(String description, long unitPrice) {
		return add(new Article(description, unitPrice));
	}


	/**
	 * Order factory method using constructor with owning customer as argument.
	 * 
	 * @param customer owning customer who created the order.
	 * @return Order object created with constructor with owning customer as argument.
	 * @throws IllegalArgumentException when customer argument is null or has invalid id.
	 */
	@Override
	public Order createOrder(Customer customer) { return add(new Order(customer)); }


	/**
	 * Getter method to return created Customer objects.
	 * 
	 * @return created Customer objects.
	 */
	@Override
	public List<Customer> getCustomers() { return customers; }


	/**
	 * Getter method to return created Article objects.
	 * 
	 * @return created Article objects.
	 */
	@Override
	public List<Article> getArticles() { return articles; }


	/**
	 * Getter method to return created Order objects.
	 * 
	 * @return created Order objects.
	 */
	@Override
	public List<Order> getOrders() { return orders; }


	/**
	 * Return number of created Customer objects.
	 * 
	 * @return number of created Customer objects.
	 */
	@Override
	public int customersCount() { return customers.size(); }


	/**
	 * Return number of created Article objects.
	 * 
	 * @return number of created Article objects.
	 */
	@Override
	public int articlesCount() { return articles.size(); }


	/**
	 * Find a created Customer object by its id.
	 * 
	 * @param id customer id.
	 * @return Optional with found object or empty Optional.
	 */
	@Override
	public Optional<Customer> findCustomerById(long id) {
		return customers.stream()
			.filter(c -> c.getId()==id)
			.findFirst();
	}


	/**
	 * Find a created Article object by its id.
	 * 
	 * @param id article id.
	 * @return Optional with found object or empty Optional.
	 */
	@Override
	public Optional<Article> findArticleById(String id) {
		return articles.stream()
			.filter(a -> a.getId().equals(id))
			.findFirst();
	}


	/**
	 * Find a created Order object by its id.
	 * 
	 * @param id order id.
	 * @return Optional with found object or empty Optional.
	 */
	@Override
	public Optional<Order> findOrderById(String id) {
		return orders.stream()
			.filter(o -> o.getId().equals(id))
			.findFirst();
	}


	/**
	 * Return number of created Order objects.
	 * 
	 * @return number of created Order objects.
	 */
	@Override
	public int ordersCount() { return orders.size(); }


	/*
	 * Private methods to add objects to internal lists.
	 */

	private Customer add(Customer customer) {
		customers.add(customer);
		return customer;
	}

	private Article add(Article article) {
		articles.add(article);
		return article;
	}

	private Order add(Order order) {
		orders.add(order);
		return order;
	}
}
