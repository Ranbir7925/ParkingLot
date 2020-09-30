import com.bridgelabz.parkinglot.{ParkingLot, ParkingLotException, ParkingLotExceptionEnums, ParkingStatus}
import org.scalatest.FunSuite

class ParkingLotTest extends FunSuite{

  test("givenCarDetails_WhenAddedToParkingLot_ShouldReturnTrue"){
    val parkingLot = new ParkingLot()
    parkingLot.park("MH01-3241")
    val isPresent  = parkingLot.isCarPresent("MH01-3241")
    assert(isPresent == true)
  }

  test("givenSameCarDetailsTwice_WhenProvidedToParkTheCar_ShouldGiveException"){
    val throws = intercept[Exception]{
      val parkingLot = new ParkingLot()
      parkingLot.park("MH01-3239")
      parkingLot.park("MH01-3239")
    }
    assert(throws.getMessage == ParkingLotExceptionEnums.sameCarNumber.toString)
  }

  test("givenCarDetails_WhenProvidedToUnParkTheCar_ShouldReturnTrue"){
    val parkingLot = new ParkingLot()
    parkingLot.park("MH01-3242")
    parkingLot.unPark("MH01-3242")
    val isPresent = parkingLot.isCarPresent("MH01-3242")
    assert(isPresent== false)
  }

  test("givenIncorrectCarDetails_WhenProvidedToUnParkTheCar_ShouldGiveException"){
    val throws = intercept[Exception]{
      val parkingLot = new ParkingLot()
      parkingLot.park("MH01-2255")
      parkingLot.unPark("MH01-5475")
    }
    assert(throws.getMessage == ParkingLotExceptionEnums.carNumberMissMatch.toString)
  }

  test("givenCarDetails_WhenTheParkingIsFull_ShouldInformToOwner"){
    val parkingLot = new ParkingLot()
    parkingLot.park("MH01-2348")
    parkingLot.park("MH01-3318")
    parkingLot.park("MH01-2347")
    val parkInfo = parkingLot.informOwner
    assert(parkInfo == ParkingStatus.PARKING_FULL.toString)
  }

  test("givenCarDetails_WhenTheParkingIsFull_ShouldInformToAirportSecurity"){
    val parkingLot = new ParkingLot()
    parkingLot.park("MH01-1548")
    parkingLot.park("MH01-0948")
    parkingLot.park("MH01-0248")
    val parkInfo = parkingLot.informAirportSecurity
    assert(parkInfo == ParkingStatus.PARKING_FULL.toString)
  }
}
