package com.bridgelabz.parkinglot

class ParkingLotException(message: ParkingLotExceptionEnums.Value) extends Exception(message.toString){}
  object ParkingLotExceptionEnums extends Enumeration{
    type ParkingLotException = Value

    val carNumberMissMatch = Value("Car for a given car number is not found")
    val parkingFull = Value("Parking is full.")
  }
