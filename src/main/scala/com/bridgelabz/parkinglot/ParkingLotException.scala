package com.bridgelabz.parkinglot

class ParkingLotException(message: ParkingLotExceptionEnums.Value) extends Exception(message.toString){}
  object ParkingLotExceptionEnums extends Enumeration{
    type ParkingLotException = Value

    val CAR_NUMBER_MISMATCH = Value("Car for a given car number is not found")
  }
