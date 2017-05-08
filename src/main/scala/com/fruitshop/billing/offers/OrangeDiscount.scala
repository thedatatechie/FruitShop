package com.fruitshop.billing.offers

import java.text.NumberFormat
import java.util.Locale
import com.fruitshop.billing.actions.ItemSelect
import com.fruitshop.billing.items.Orange

/**
  * Created by vijay on 08/05/2017.
  */
class OrangeDiscount extends Offer {

  def priceReduction: BigDecimal = {

    val orange = new Orange()
    val numFormat = NumberFormat.getCurrencyInstance(Locale.UK)

    val counter: Int = (ItemSelect.oranges / 3).toInt
    val amount: BigDecimal = orange.getPrice

    val discountSum = amount * BigDecimal(counter)
    discountSum.setScale(2, BigDecimal.RoundingMode.FLOOR)

    val sum = discountSum.doubleValue()
    val str = numFormat.format(-sum)

    if (!discountSum.equals(BigDecimal("0.00"))) {
      System.out.println("Oranges 3 for the price of 2 offer discount: " + str)
    }

    discountSum
  }
}
