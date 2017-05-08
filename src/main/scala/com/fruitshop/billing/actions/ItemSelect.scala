package com.fruitshop.billing.actions

import com.fruitshop.billing.items.{Apple, Item, Orange}

/**
  * Created by Vijay on 08/05/2017.
  */
class ItemSelect {

  def getItem(str: String): Item = {
    val itemName: String = str.toUpperCase

    // If logic to create an instance object for each item.
    val itemCreate: Item = if (itemName.equals("APPLE")) {
      new Apple
    } else if (itemName.equals("ORANGE")) {
      new Orange
    } else {
      null
    }

    itemCreate
  }

}

