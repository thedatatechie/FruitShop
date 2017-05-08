package com.fruitshop.billing.items


/**
  * Created by vijay on 08/05/2017.
  */
class Orange extends Item {

  override protected def itemPrice: BigDecimal = {
    val price = BigDecimal("0.25")
    price.setScale(2, BigDecimal.RoundingMode.FLOOR)
    price
  }

  override def getPrice: BigDecimal = {
    itemPrice
  }

}
