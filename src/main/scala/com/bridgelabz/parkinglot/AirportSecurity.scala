package com.bridgelabz.parkinglot

class AirportSecurity extends Observer {
  var status:String =null
  override def parkingStatus(status: String): Unit = {
    this.status = status
  }
}