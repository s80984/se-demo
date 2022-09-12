package master.sedemo.system;

import java.util.Properties;

/**
 * Interface of an "Inversion-of-Control" (IoC) container, which creates and holds
 * system component objects.
 * 
 * @version <code style=color:green>{@value application.package_info#Version}</code>
 * @author <code style=color:blue>{@value application.package_info#Author}</code>
 */

public interface IoC {

	/**
	 * Getter of singleton instance that implements the {@link IoC} interface.
	 * 
	 * @return reference to singleton IoC instance.
	 */
	static IoC getInstance() {
		return system.impl.IoC_ContainerImpl.getInstance();
	}


	/**
	 * Getter of system singleton component that implements the {@link Calculator} interface.
	 * 
	 * @return reference to singleton Calculator instance.
	 */
	Calculator getCalculator();

	/**
	 * Getter of system singleton component that implements the {@link Formatter} interface.
	 * 
	 * @return reference to singleton Formatter instance.
	 */
	Formatter getFormatter();

	/**
	 * Getter of system singleton component that implements the {@link Printer} interface.
	 * 
	 * @return reference to singleton Printer instance.
	 */
	Printer getPrinter();

	/**
	 * Getter of system singleton component that builds sample orders using objects from the {@link datamodel} package.
	 * 
	 * @return reference to singleton OrderBuilder instance.
	 */
	OrderBuilder getOrderBuilder();

	/**
	 * Getter of system singleton component that creates instances of classes of the {@link datamodel} package.
	 * 
	 * @return reference to singleton DatamodelFactory instance.
	 */
	DatamodelFactory getDatamodelFactory();

	/**
	 * Getter of system singleton component that contains system properties.
	 * 
	 * @return reference to singleton Properties instance.
	 */
	Properties getProperties();

	/**
	 * Load properties from file from propertyFilePath.
	 * 
	 * @param propertyFilePath path to properties files.
	 * @return number of properties loaded.
	 * @throws IllegalArgumentException when propertyFilePath is null or empty "".
	 */
	int loadProperties(String propertyFilePath);

}
