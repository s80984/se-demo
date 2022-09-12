package master.sedemo.system.impl;

import datamodel.Order;
import datamodel.TAX;
import system.Calculator;

import java.util.Map;
import java.util.Optional;


/**
 * Class that implements the Calculator interface.
 * 
 * Class has no dependencies on other components.
 */

class CalculatorImpl implements Calculator {

	/**
	 * Applicable tax rate mapped from TAX enum.
	 */
	private final Map<TAX, Double> taxRateMapper = Map.of(
		TAX.TAXFREE,			 0.0,	// tax free rate
		TAX.GER_VAT,			19.0,	// German VAT tax (MwSt) 19.0%
		TAX.GER_VAT_REDUCED,	 7.0	// German reduced VAT tax (MwSt) 7.0%
	);


	/**
	 * Get percent tax rate from enum value.
	 * 
	 * @param taxRate enum value of applicable tax rate.
	 * @return tax rate in percent.
	 */
	@Override
	public double getTaxRate(final TAX taxRate) {
		return taxRate != null? taxRateMapper.get(taxRate) : 0.0;
	}


	/**
	 * Calculate included VAT tax from gross price/value based on specific
	 * tax rate (VAT is value-added tax, in Germany it is called
	 * <i>"Mehrwertsteuer" (MwSt.)</i>).
	 * 
	 * @param grossValue value that included tax.
	 * @param tax applicable tax rate.
	 * @return tax included in gross value based on tax rate.
	 */
	@Override
	public long calculateIncludedVAT(final long grossValue, final TAX tax) {
		double taxRate = getTaxRate(tax) / 100.0;
		double vat_double = grossValue * taxRate / (1.0 + taxRate);
		double vat_rounded = Math.round(vat_double);
		long vat = Double.valueOf(vat_rounded).longValue();
		return vat;
	}


	/**
	 * Calculate compounded value and VAT tax over all order items.
	 * 
	 * @param order order to calculate compounded value and VAT tax.
	 * @return tuple with compounded value and VAT tax of order items.
	 */
	@Override
	public long[] calculateValueAndTax(final Order order) {
		long[] totals = {0L, 0L};
		Optional.ofNullable(order).ifPresent(o -> o.getItems().forEach(item -> {
			int units = item.getUnitsOrdered();
			long unitPrice = item.getArticle().getUnitPrice();
			long itemPrice = unitPrice * units;
			long vat = calculateIncludedVAT(itemPrice, item.getArticle().getTax());
			totals[0] += itemPrice;	// compound item price
			totals[1] += vat;		// compound item tax	
		}));
		return totals;	// return tuple with compounded {value, vat}
	}
}
