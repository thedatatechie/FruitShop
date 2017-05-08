package com.fruitshop.billing.items

/**
  * Created by vijay on 08/05/2017.
  */
abstract class Item {
  protected def itemPrice: BigDecimal

  def getPrice: BigDecimal
}
