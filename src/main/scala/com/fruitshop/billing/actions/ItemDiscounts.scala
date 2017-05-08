package com.fruitshop.billing.actions

import com.fruitshop.billing.offers.{AppleDiscount, OrangeDiscount}

/**
  * Created by vijay on 08/05/2017.
  */
class ItemDiscounts {

  def getDiscount(name: String): BigDecimal = {
    val itemName = name.toUpperCase()

    // If logic to create an calculate the total discount on each item type.
    if (itemName.equals("APPLE")) {
      // This block calls the AppleDiscount object and calculates
      // the total discount for all the Apples.
      val iDiscountItem = new AppleDiscount()
      val discountSum = iDiscountItem.priceReduction
      discountSum

    } else if (itemName.equals("ORANGE")) {
      // This block calls the OrangeDiscount object and calculates
      // the total discount for all the Oranges.
      val iDiscountItem = new OrangeDiscount()
      val discountSum = iDiscountItem.priceReduction
      discountSum

    } else {
      val discountSum = BigDecimal("0.00")
      discountSum.setScale(2, BigDecimal.RoundingMode.FLOOR)
      discountSum
    }

  }
}
