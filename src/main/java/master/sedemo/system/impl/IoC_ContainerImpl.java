package master.sedemo.system.impl;

import system.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Implementation class of an "Inversion-of-Control" (IoC) container, which creates
 * and holds system component objects.
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */

public final class IoC_ContainerImpl implements IoC {

	/**
	 * Private static singleton IoC_ContainerImpl instance.
	 */
	private static final IoC_ContainerImpl singleton = new IoC_ContainerImpl();

	/**
	 * References to singleton objects that implement system component interfaces.
	 */
	private final Calculator calculator;
	private final Formatter formatter;
	private final Printer printer;
	private final OrderBuilder orderBuilder;
	private final DatamodelFactory datamodelFactory;
	private final Properties props;


	/**
	 * Private constructor to prevent instance creation outside this class.
	 * 
	 */
	private IoC_ContainerImpl() {
		this.calculator = new CalculatorImpl();
		this.formatter = new FormatterImpl();
		this.printer = new PrinterImpl(calculator, formatter);	// inject constructor dependencies
		this.datamodelFactory = new DatamodelFactoryImpl();
		this.props = new Properties();
		//
//		this.orderBuilder = new OrderBuilderImpl(datamodelFactory);	// inject constructor dependency
		//
		// use new OrderBuilder implementation that reads Customer, Article and
		// Order objects from JSON files replacing the prior version that hard-coded
		// their creation.
		//
		this.orderBuilder = new OrderBuilderJSONImpl(datamodelFactory, props);	// inject constructor dependencies
	}


	/**
	 * Getter of singleton instance that implements the {@link IoC} interface.
	 * 
	 * @return reference to singleton IoC instance.
	 */
	public static IoC getInstance() {
		return singleton;
	}


	/**
	 * Getter of system singleton component that implements the {@link Calculator} interface.
	 * 
	 * @return reference to singleton Calculator instance.
	 */
	@Override
	public Calculator getCalculator() {
		return this.calculator;
	}


	/**
	 * Getter of system singleton component that implements the {@link Formatter} interface.
	 * 
	 * @return reference to singleton Formatter instance.
	 */
	@Override
	public Formatter getFormatter() {
		return this.formatter;
	}


	/**
	 * Getter of system singleton component that implements the {@link Printer} interface.
	 * 
	 * @return reference to singleton Printer instance.
	 */
	@Override
	public Printer getPrinter() {
		return this.printer;
	}


	/**
	 * Getter of system singleton component that builds sample orders using objects from the {@link datamodel} package.
	 * 
	 * @return reference to singleton OrderBuilder instance.
	 */
	@Override
	public OrderBuilder getOrderBuilder() {
		return this.orderBuilder;
	}


	/**
	 * Getter of system singleton component that creates instances of classes of the {@link datamodel} package.
	 * 
	 * @return reference to singleton DatamodelFactory instance.
	 */
	@Override
	public DatamodelFactory getDatamodelFactory() {
		return this.datamodelFactory;
	}


	/**
	 * Getter of system singleton component that contains system properties.
	 * 
	 * @return reference to singleton Properties instance.
	 */
	@Override
	public Properties getProperties() {
		return this.props;
	}


	/**
	 * Load properties from file from propertyFilePath.
	 * 
	 * @param propertyFilePath path to properties files.
	 * @return number of properties loaded.
	 * @throws IllegalArgumentException when propertyFilePath is null or empty "".
	 */
	@Override
	public int loadProperties(String propertyFilePath) {
		if(propertyFilePath==null || propertyFilePath.length()==0)
			throw new IllegalArgumentException("propertyFilePath is null or empty \"\"");
		//
		int count = props.size();
		try {
			props.load(new FileInputStream(propertyFilePath));
		//
		} catch(IOException e) {
			// ignore
		}
		return props.size() - count;
	}

}
