package com.fruitshop.billing.actions

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

/**
  * Created by vijay on 08/05/2017.
  */
@RunWith(classOf[JUnitRunner])
class ItemDiscountTest extends FunSuite with Matchers with BeforeAndAfter {

  var discountItem: ItemDiscounts = _
  var itemName: String = _

  before {
    discountItem = new ItemDiscounts()
    ItemSelect.apples = 3
    ItemSelect.oranges = 5
  }

  test("Offer discount on apples") {
    itemName = "apple"
    val expDiscount: BigDecimal = BigDecimal("0.60")
    expDiscount.setScale(2, BigDecimal.RoundingMode.FLOOR)
    val discount: BigDecimal = discountItem.getDiscount(itemName)
    discount shouldBe expDiscount
  }

  test("Offer discount on oranges") {
    itemName = "orange"
    val expDiscount: BigDecimal = BigDecimal("0.25")
    expDiscount.setScale(2, BigDecimal.RoundingMode.FLOOR)
    val discount: BigDecimal = discountItem.getDiscount(itemName)
    discount shouldBe expDiscount
  }

  after {
    ItemSelect.apples = 0
    ItemSelect.oranges = 0
  }

}
