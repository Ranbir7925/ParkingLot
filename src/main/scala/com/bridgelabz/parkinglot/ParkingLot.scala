
package com.bridgelabz.parkinglot

import java.util

 class ParkingLot {
   val capacity :Int = 3
   var parkingStatus:String = null
   val parkingList = new util.ArrayList[String]

   /**
    *
    * @param carNumber Take String value and add to List
    * @return Parking Status
    */
  def park(carNumber: String) = {
    if (parkingList.contains(carNumber)) {
      throw new ParkingLotException(ParkingLotExceptionEnums.sameCarNumber)
    }
    if (parkingList.size() < capacity) {
      parkingList.add(carNumber)
    }
    if (parkingList.size() >= capacity){
      this.parkingStatus = ParkingStatus.parkingFull.toString
      informOwner
      informAirportSecurity
    }
  }

   /**
    * This will check weather Car is present or not
    * @param carNumber Take String Value
    * @return Boolean Value
    */
   def isCarPresent(carNumber:String): Boolean ={
     parkingList.contains(carNumber)
   }

   /**
    * This Method will Un-Park the car
    * @param carNumber Take String Value
    */
  def unPark(carNumber: String): Unit = {
    if (!parkingList.contains(carNumber)){
      throw new ParkingLotException(ParkingLotExceptionEnums.carNumberMissMatch)
    }
    parkingList.remove(carNumber)
    if(parkingList.size() < capacity){
      this.parkingStatus = ParkingStatus.parkingAvailable.toString
      informOwner
    }
  }

   /**
    * This method will inform the status of parking lot to owner
    * @return Status in String
    */
   def informOwner: String ={
     val owner = new ParkingOwner
     owner.parkingStatus(parkingStatus)
     owner.status
   }

   /**
    * This method will inform the status of parking lot to Security
    * @return Status in String
    */
   def informAirportSecurity:String={
     val airportSecurity = new AirportSecurity
     airportSecurity.parkingStatus(parkingStatus)
     airportSecurity.status
   }

}