package com.fruitshop.billing.items

import com.fruitshop.billing.actions.ItemSelect
import org.scalatest._

/**
  * Created by vijay on 08/05/2017.
  */
class ItemSelectTest extends FunSuite with Matchers with BeforeAndAfter {

  var itemSelect: ItemSelect = _
  var item: Item = _
  var price: BigDecimal = _

  before {
    itemSelect = new ItemSelect
  }

  test("Select the product item as apple") {
    val itemName = "apple"
    item = itemSelect.getItem(itemName)
    item.isInstanceOf[Apple] should equal(true)
  }

  test("Select the product item as orange") {
    val itemName = "orange"
    item = itemSelect.getItem(itemName)
    item.isInstanceOf[Orange] should equal(true)
  }

  test(raw"Return the item price as £0.60 for Apple") {
    val itemName = "apple"
    item = itemSelect.getItem(itemName)
    val priceShouldBe = BigDecimal("0.60")
    priceShouldBe.setScale(2, BigDecimal.RoundingMode.FLOOR)

    price = item.getPrice
    price should equal(priceShouldBe)
  }

  test("""Return the item price as £0.25 for Orange""") {
    val itemName = "orange"
    item = itemSelect.getItem(itemName)
    val priceShouldBe = BigDecimal("0.25")
    priceShouldBe.setScale(2, BigDecimal.RoundingMode.FLOOR)

    price = item.getPrice
    price should equal(priceShouldBe)
  }

}
