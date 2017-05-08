package com.fruitshop.billing.items


/**
  * Created by vijay on 08/05/2017.
  */
class Apple extends Item {

  protected def itemPrice: BigDecimal = {
    val price: BigDecimal = BigDecimal("0.60")
    price.setScale(2, BigDecimal.RoundingMode.FLOOR)
    price
  }

  def getPrice: BigDecimal = {
    itemPrice
  }

}
