package master.sedemo.tasks.generated;

/**
 * Class of entity type <i>Article</i>.
 * <p>
 * Articles can be referenced as ordered items in orders.
 * </p>
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */
public class Article {

//    /**
//     * Default constructor
//     */
//    public Article() {
//    }

    /**
     * Unique id, null or "" are invalid values, id can be set only once.
     */
    private String id = null;

    /**
     * Article description, never null, may be empty "".
     */
    private String description = "";

    /**
     * Price in cent per article, negative values are invalid.
     */
    private long unitPrice = 0;

    /**
     * Currency in which price is quoted, EUR is the default currency.
     */
    private Currency currency = Currency.EUR;

    /**
     * Tax rate applicable to article, German regular Value-Added Tax (VAT) is the default.
     */
    private TAX tax = TAX.GER_VAT;


    /**
     * Default constructor.
     */
    public Article() {
        // TODO implement here
    }


    /**
     * Constructor with description and price.
     * 
     * @param description descriptive text for article.
     * @param unitPrice price (in cent) for one unit of the article.
     * @throws IllegalArgumentException when description is null or empty "" or price negative {@code < 0}.
     */
    public Article(String description, long unitPrice) {
        // TODO implement here
    }


    /**
     * Id getter.
     * 
     * @return article order id, returns {@code null}, if id is unassigned.
     */
    public String getId() {
        // TODO implement here
        return "";
    }


    /**
     * Id setter. Id can only be set once with valid id, id is immutable after assignment.
     * 
     * @param id only valid id (not null or "") updates id attribute on first invocation.
     * @throws IllegalArgumentException if id argument is invalid ({@code id==null} or {@code id==""}).
     * @return chainable self-reference
     */
    public Article setId(String id) {
        // TODO implement here
        return null;
    }


    /**
     * Description getter.
     * 
     * @return descriptive text for article
     */
    public String getDescription() {
        // TODO implement here
        return "";
    }


    /**
     * Description setter.
     * 
     * @param description descriptive text for article, only valid description (not null or "") updates attribute.
     * @throws IllegalArgumentException when description is null or empty "". 
     * @return chainable self-reference.
     */
    public Article setDescription(String description) {
        // TODO implement here
        return null;
    }


    /**
     * UnitPrice getter.
     * 
     * @return price in cent for one article unit.
     */
    public long getUnitPrice() {
        // TODO implement here
        return 0;
    }


    /**
     * UnitPrice setter.
     * 
     * @param unitPrice price in cent for one article, only valid price ( {@code >= 0} ) updates attribute.
     * @return chainable self-reference.
     */
    public Article setUnitPrice(long unitPrice) {
        // TODO implement here
        return null;
    }


    /**
     * Currency getter.
     * 
     * @return currency in which unitPrice is quoted.
     */
    public Currency getCurrency() {
        // TODO implement here
        return null;
    }


    /**
     * Currency setter.
     * 
     * @param currency in which unitPrice is quoted.
     * @throws IllegalArgumentException if currency is null. 
     * @return chainable self-reference.
     */
    public Article setCurrency(Currency currency) {
        // TODO implement here
        return null;
    }


    /**
     * TAX getter.
     * 
     * @return tax rate applicable for article.
     */
    public TAX getTax() {
        // TODO implement here
        return null;
    }


    /**
     * TAX setter.
     * 
     * @param tax rate that applies to article.
     * @throws IllegalArgumentException if tax is null.
     * @return chainable self-reference.
     */
    public Article setTax(TAX tax) {
        // TODO implement here
        return null;
    }

}