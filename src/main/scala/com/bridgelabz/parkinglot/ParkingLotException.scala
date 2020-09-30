package com.bridgelabz.parkinglot

class ParkingLotException(message: ParkingLotExceptionEnums.Value) extends Exception(message.toString){}
  object ParkingLotExceptionEnums extends Enumeration{
    type ParkingLotException = Value

    val carNumberMissMatch = Value("Car for a given car number is not found")
    val sameCarNumber = Value("Car cannot be parked as car number is same")
  }
