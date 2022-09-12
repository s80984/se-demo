package master.sedemo.application;

import master.sedemo.tasks.Customer;

import java.util.Collection;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;


/**
 * Runnable application class that creates and outputs {@link Customer}'s for the
 * <code>
 * <a href="{@docRoot}/index.html">{@value master.sedemo.application.package_info#RootName}</a>.
 * </code>
 * 
 * @version <code style=color:green>{@value master.sedemo.application.package_info#Version}</code>
 * @author <code style=color:blue>{@value master.sedemo.application.package_info#Author}</code>
 */

public class Application_C3 {
	private final String appName;
	//
	private final Customer eric;
	private final Customer anne;
	private final Customer tim;
	private final Customer nadine;
	private final Customer khaled;

	/**
	 * Public main() function.
	 * 
	 * @param args arguments passed from command line.
	 */
	public static void main(String[] args) {
		var appInstance = new Application_C3();
		appInstance.run();
	}


	/**
	 * Private constructor to initialize local attributes.
	 */
	private Application_C3() {
		this.appName = package_info.RootName + ": " + this.getClass().getSimpleName();
		//
		eric = new Customer("Eric Meyer")
			.setId(892474L)		// set id, first time
			.setId(947L)		// ignored, since id can only be set once
			.addContact("eric98@yahoo.com")
			.addContact("eric98@yahoo.com")	// ignore duplicate contact
			.addContact("(030) 3945-642298");
		//
		anne = new Customer("Bayer, Anne")
			.setId(643270L)
			.addContact("anne24@yahoo.de")
			.addContact("(030) 3481-23352")
			.addContact("fax: (030)23451356");
		//
		tim = new Customer("Tim Schulz-Mueller")
			.setId(286516L)
			.addContact("tim2346@gmx.de");
		//
		nadine = new Customer("Nadine-Ulla Blumenfeld")
			.setId(412396L)
			.addContact("+49 152-92454");
		//
		khaled = new Customer()
			.setName("Khaled Saad Mohamed Abdelalim")
			.setId(456454L)
			.addContact("+49 1524-12948210");
	}


	/**
	 * Private method that runs with application instance.
	 */
	private void run() {
		System.out.println(this.appName);
		// 
		Set<Customer> customers = Set.of(eric, anne, tim, nadine, khaled);
		//
		StringBuffer sb = new StringBuffer("Customers:\n");
		printCustomers(sb, customers

/* DELETE FOR HANDOUT */
		, customerStream -> customerStream
			.sorted((c1, c2) -> c1.getLastName().compareTo(c2.getLastName()))	// task 4.)
//			.filter(c -> c.getId() > 400000L && c.getId() < 500000L)	// task 5.)

//			.distinct()
//			.filter(c -> c.getId() % 2 == 1)
//			.sorted((c1, c2) -> c1.getId().compareTo(c2.getId())) // for: Long
//			.sorted((c1, c2) -> Long.compare(c1.getId(), c2.getId()))	// for: long
//			.sorted((c1, c2) -> c1.getLastName().compareTo(c2.getLastName()))
//			.sorted((c1, c2) -> Integer.compare(c1.getLastName().length(), c2.getLastName().length()))
/* END */
		);
		//
//		printCustomers(sb, customers,	// Aufgaben 4.), 5.)
//			customerStream ???
//		);
		//
		System.out.println(sb);
	}


	/**
	 * Print Customer list into StringBuffer as lines with Customer attributes.
	 * <pre>
	 * Example:
	 * | 643270 | Bayer, Anne              | anne24@yahoo.de, (030) 3481-23352   |
	 * | 412396 | Blumenfeld, Nadine-Ulla  | +49 152-92454                       |
	 * | 892474 | Meyer, Eric              | eric98@yahoo.com, (030) 3945-642298 |
	 * </pre>
	 * 
	 * @param sb StringBuffer that will contains the formatted result. A new StringBuffer is created when sb is null.
	 * @param customers collection of Customers (null argument is ignored).
	 * @return StringBuffer that contains formatted result (same sb).
	 */
	public StringBuffer printCustomers(StringBuffer sb, final Collection<Customer> customers) {
		if(customers==null)
			return sb;
		//
		sb = sb==null? new StringBuffer() : sb;
		java.util.Iterator<Customer> cit = customers.iterator();
		while(cit.hasNext()) {		// iterate through Customer collection
			Customer c = cit.next();
			printCustomer(sb, c);		// format each Customer object as line into StringBuffer
		}
		return sb;
	}


	/**
	 * Print Customer list into StringBuffer as lines with Customer attributes.
	 * Method provides control over the Stream of customer objects before formatting.
	 * <pre>
	 * Example:
	 * | 643270 | Bayer, Anne              | anne24@yahoo.de, (030) 3481-23352   |
	 * | 412396 | Blumenfeld, Nadine-Ulla  | +49 152-92454                       |
	 * | 892474 | Meyer, Eric              | eric98@yahoo.com, (030) 3945-642298 |
	 * </pre>
	 * 
	 * @param sb StringBuffer that will contains the formatted result. A new StringBuffer is created when sb is null.
	 * @param customers collection of Customers (null argument is ignored).
	 * @param customerStream functional interface to control (e.g. filter, sort) {@code Stream<Customer>} before formatting.   
	 * @return StringBuffer that contains formatted result (same sb).
	 */
	public StringBuffer printCustomers(StringBuffer sb, final Collection<Customer> customers,
			final Function<Stream<Customer>, Stream<Customer>> customerStream
	) {
		if(customers==null)
			return sb;
		//
		final StringBuffer sb_ = sb==null? new StringBuffer() : sb;
		//
		(customerStream != null? customerStream.apply(customers.stream()) : customers.stream())
			.forEach(c -> printCustomer(sb_, c));
		//
		return sb_;
	}


	/**
	 * Print Customer attributes into StringBuffer as column-separated line.
	 * <pre>
	 * Example:
	 * | 892474 | Meyer, Eric                    | eric98@yahoo.com, (030) 3945-642298          |
	 * </pre>
	 * 
	 * @param sb StringBuffer that will contains the formatted result. A new StringBuffer is created when sb is null.
	 * @param c Customer object.
	 * @return StringBuffer that contains formatted result (same sb).
	 */
	public StringBuffer printCustomer(StringBuffer sb, final Customer c) {
		if(c==null)
			return sb;
		final StringBuffer sb_ = sb==null? new StringBuffer() : sb;
		final int[] fw = {4, 32, 46};	// field widths
		final int nameStyle = 0;
		final String name = fmtName(c.getFirstName(), c.getLastName(), nameStyle);
		final int len = Math.max(fw[1] - name.length() - 1, 1);
		sb_.append( "| ")
			.append(String.valueOf(c.getId())).append(" ".repeat(fw[0]-3))
			.append("| ").append(name).append(" ".repeat(len)).append("| ")
		;
		int clen = sb_.length();
		IntStream.range(0, c.contactsCount())
			.forEach(i ->
				sb_.append(i==0? "" : ", ").append(c.getContacts()[i])
			);
		String fill = " ".repeat(Math.max(fw[2] - sb_.length() + clen - 1, 1));
		return sb_.append(fill).append("|\n");
	}


	/**
	 * Format Customer name according to a style (0 is default):
	 * <pre>
	 * style: 0: "Meyer, Eric"    10: "MEYER, ERIC"    20: "E.M."
	 *        1: "Meyer, E."      11: "MEYER, E."      21: "E."
	 *        2: "Eric Meyer"     12: "ERIC MEYER"     22: "M."
	 *        3: "E. Meyer"       13: "E. MEYER"
	 *        4: "Eric M."        14: "ERIC M."
	 *        5: "Eric"           15: "ERIC"
	 *        6: "Meyer"          16: "MEYER"
	 * </pre>
	 * 
	 * @param firstName first name, may be null or "".
	 * @param lastName last name, may be null or "".
	 * @param style name formatting style.
	 * @return formatted name according to style.
	 */
	public String fmtName(final String firstName, final String lastName, int... style) {
		final int st = style.length > 0? style[0] : 0;	// 0 is default format
		String fn = firstName != null? firstName : "";
		String ln = lastName != null? lastName : "";
		fn = (st==1 || st==3)? fmtName(fn, "", 21) : fn;	// firstName -> "E."
		ln = (st==4)? fmtName("", ln, 22) : ln;		// lastName -> "M."
		//
		return
			(st >= 10)? (
				(st>=10 && st<20)? fmtName(firstName, lastName, st - 10).toUpperCase() :
				(st==20)? fmtName(firstName, "", 21) + fmtName("", lastName, 22) :
				(st==21)? fn.length() > 0? String.format("%s.", fn.substring(0, 1).toUpperCase()) : "" :
				(st==22)? ln.length() > 0? String.format("%s.", ln.substring(0, 1).toUpperCase()) : "" :
					""	// return as default for: st > 22
			) : (
				(fn.length() > 0 && ln.length() > 0)? (
					(st>=0 && st<=1)? String.format("%s, %s", ln, fn) :
					(st>=2 && st<=4)? String.format("%s %s", fn, ln) :
					(st==5)? fn :
					(st==6)? ln : fmtName(fn, ln)	// return default name style
			) : fn + ln);	// fn or ln (or both) are ""
	}
}
