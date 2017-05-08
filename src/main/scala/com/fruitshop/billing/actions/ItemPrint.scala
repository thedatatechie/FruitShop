package com.fruitshop.billing.actions

import java.text.NumberFormat
import java.util.Locale

/**
  * Created by vijay on 08/05/2017.
  */
class ItemPrint {

  def printItem(item: String, cost: BigDecimal): String = {
    val itemPrice = cost.doubleValue()
    val itemName = item.substring(0, 1).toUpperCase() + item.substring(1).toLowerCase()
    val numFormat = NumberFormat.getCurrencyInstance(Locale.UK)
    val str = numFormat.format(itemPrice)
    System.out.println(itemName + ":\t" + "\t" + str)
    itemName + ": " + str
  }

}
