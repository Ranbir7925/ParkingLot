package com.bridgelabz.parkinglot

class ParkingOwner extends Observer {
  var status: String = null

  /**
   * this method will set the parking status
   * @param status In String Format
   */
  override def parkingStatus(status: String): Unit = {
    this.status = status
  }
}
