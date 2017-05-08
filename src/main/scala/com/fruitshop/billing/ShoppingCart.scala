package com.fruitshop.billing

import com.fruitshop.billing.actions.{ItemPrint, ItemSelect}
import com.fruitshop.billing.items.Item

/**
  * Created by vijay on 08/05/2017.
  */
object ShoppingCart {

  def main(args: Array[String]): Unit = {

    var totalBill: BigDecimal = BigDecimal("0.00")
    totalBill.setScale(2, BigDecimal.RoundingMode.FLOOR)

    val iSelect = new ItemSelect()
    val iPrint = new ItemPrint()

    if (args.length == 0) {
      System.out.println("Please enter the list of items to be billed.")
      System.exit(0)
    }

    try {
      // Getting the Total amount for all the items.
      for (iName <- args) {
        val iItem: Item = iSelect.getItem(iName)

        if (iItem != null) {
          totalBill = totalBill + (iItem.getPrice)
          iPrint.printItem(iName, iItem.getPrice)

        } else {
          val itemName = iName.substring(0, 1).toUpperCase() + iName.substring(1).toLowerCase()
          System.out.println("The \"" + itemName + "\" item is out of stock")
        }
      }

      println("------------------")
      // Printing the Total onto the console.
      iPrint.printItem("Total", totalBill)

      println(args.mkString("[", ", ", "]") + " => £" + totalBill)

    } catch {
      // Will catch the Exceptions if there are any.
      case ex: Exception => {
        println("Exception is caught = " + ex)
        ex.printStackTrace()
      }
    } finally {
      // Will execute the finallly block.
      System.out.println("\nPricing an Items Basket is complete.")
    }
  }


}
