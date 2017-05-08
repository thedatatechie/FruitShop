package com.fruitshop.billing.offers

import java.text.NumberFormat
import java.util.Locale

import com.fruitshop.billing.actions.ItemSelect
import com.fruitshop.billing.items.Apple

/**
  * Created by vijay on 08/05/2017.
  */
class AppleDiscount extends Offer {

  override def priceReduction: BigDecimal = {

    val apple = new Apple()
    val numFormat = NumberFormat.getCurrencyInstance(Locale.UK)

    val counter: Int = (ItemSelect.apples / 2).toInt
    val amount: BigDecimal = apple.getPrice;

    val discountSum = amount * BigDecimal(counter)
    discountSum.setScale(2, BigDecimal.RoundingMode.FLOOR)

    val sum = discountSum.doubleValue()
    val str = numFormat.format(-sum)

    if (!discountSum.equals(BigDecimal("0.00"))) {
      System.out.println("Apples buy one, get one free offer discount: " + str)
    }

    discountSum
  }
}
