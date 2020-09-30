package com.bridgelabz.parkinglot

object ParkingStatus extends Enumeration {
  type ParkingStatus = Value

  val parkingFull = Value("Parking lot is full.")
  val parkingAvailable = Value("Vacancy generated. Parking is available")
}
