
package com.bridgelabz.parkinglot

import java.util

 class ParkingLot {
   val capacity :Int = 3
  var parkingStatus:String = null
  val parkingList = new util.ArrayList[String]

  def park(carNumber: String) = {
    if (parkingList.contains(carNumber)) {
      throw new ParkingLotException(ParkingLotExceptionEnums.sameCarNumber)
    }
    if (parkingList.size() < capacity) {
      parkingList.add(carNumber)
    }
    if (parkingList.size() >= capacity){
      this.parkingStatus = ParkingStatus.PARKING_FULL.toString
      this.informOwner
      this.informAirportSecurity
    }
  }
   def isCarPresent(carNumber:String): Boolean ={
     parkingList.contains(carNumber)
   }

  def unPark(carNumber: String): Boolean = {
    if (!parkingList.contains(carNumber)){
      throw new ParkingLotException(ParkingLotExceptionEnums.carNumberMissMatch)
    }
    parkingList.remove(carNumber)
    !parkingList.contains(carNumber)
  }

   def informOwner: String ={
     val owner = new ParkingOwner
     owner.parkingStatus(parkingStatus)
     owner.status
   }

   def informAirportSecurity:String={
     val airportSecurity = new AirportSecurity
     airportSecurity.parkingStatus(parkingStatus)
     airportSecurity.status
   }

}