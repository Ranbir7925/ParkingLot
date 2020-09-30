package com.bridgelabz.parkinglot

import java.util

class ParkingLot {
  val parkingList = new util.ArrayList[String]

  def park(carNumber: String): Boolean = {
    val capacity :Int = 3
    if (parkingList.size() >= capacity)
      throw new ParkingLotException(ParkingLotExceptionEnums.parkingFull)
    parkingList.add(carNumber)
    parkingList.contains(carNumber)
  }

  def unPark(carNumber: String): Boolean = {
    if (!parkingList.contains(carNumber)){
      throw new ParkingLotException(ParkingLotExceptionEnums.carNumberMissMatch)
    }
    parkingList.remove(carNumber)
    !parkingList.contains(carNumber)
  }

}
