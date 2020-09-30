package com.bridgelabz.parkinglot

import java.util
class ParkingLot {
  val parkingList = new util.ArrayList[String]

  def park(carNumber: String): Boolean = {
    parkingList.add(carNumber)
    true
  }
}
