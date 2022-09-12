package master.sedemo.tasks;

/**
 * Class of a line item as part of an Order. Orders may have multiple order items.
 * 
 * @version <code style=color:green>{@value master.sedemo.application.package_info#Version}</code>
 * @author <code style=color:blue>{@value master.sedemo.application.package_info#Author}</code>
 */
public class OrderItem {

	/**
	 * Ordered article, is never null.
	 */
	private final Article article;

	/**
	 * Number of units ordered, is always a positive number {@code > 0}.
	 */
	private int unitsOrdered;


	/**
	 * Constructor of ordered line item with article and units arguments.
	 * 
	 * @param article ordered from catalog, must not be null.
	 * @param number of units ordered, must be a positive number {@code > 0}.
	 * @throws IllegalArgumentException if article is null or units not a positive {@code units >0} number.
	 */
	OrderItem(Article article, int unitsOrdered) {
		if(article==null)
			throw new IllegalArgumentException("article is null.");
		//
		this.article = article;
		setUnitsOrdered(unitsOrdered);
	}


	/**
	 * Article getter.
	 * 
	 * @return ordered article.
	 */
	public Article getArticle() {
		return article;
	}


	/**
	 * UnitsOrdered getter.
	 * 
	 * @return number of article ordered.
	 */
	public int getUnitsOrdered() {
		return unitsOrdered;
	}


	/**
	 * UnitsOrdered setter.
	 * 
	 * @param units updated number of articles ordered, must be {@code >= 0}.
	 * @throws IllegalArgumentException if units not a positive {@code units >0} number.
	 */
	public void setUnitsOrdered(int units) {
		if(units <= 0)
			throw new IllegalArgumentException("units <= 0.");
		//
		this.unitsOrdered = units;
	}
}