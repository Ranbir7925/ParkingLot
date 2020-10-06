package com.bridgelabz.parkinglot

/**
 * Different types of status defined here
 */
object ParkingStatus extends Enumeration {
  type ParkingStatus = Value

  val parkingFull = Value("Parking lot is full.")
  val parkingAvailable = Value("Vacancy generated. Parking is available")
}
