package com.bridgelabz.parkinglot

import java.util

class ParkingLot {
  val parkingList = new util.ArrayList[String]

  def park(carNumber: String): Boolean = {
    parkingList.add(carNumber)
    true
  }

  def unPark(carNumber: String): Boolean = {
    if (!parkingList.contains(carNumber)){
      throw new ParkingLotException(ParkingLotExceptionEnums.CAR_NUMBER_MISMATCH)
    }
    parkingList.remove(carNumber)
  }

}
