import com.bridgelabz.parkinglot.{ParkingLot, ParkingLotException, ParkingLotExceptionEnums}
import org.scalatest.FunSuite

class ParkingLotTest extends FunSuite{

  test("givenCarDetails_WhenAddedToParkingLot_ShouldReturnTrue"){
    val parkingLot = new ParkingLot()
    val parked = parkingLot.park("MH01-3241")
    assert(parked)
  }

  test("givenCarDetails_WhenProvidedToUnParkTheCar_ShouldReturnTrue"){
    val parkingLot = new ParkingLot()
    val unParked = parkingLot.park("MH01-3241")
    assert(unParked)
  }

  test("givenIncorrectCarDetails_WhenProvidedToUnParkTheCar_ShouldGiveException"){
    val throws = intercept[ParkingLotException]{
      val parkingLot = new ParkingLot()
      parkingLot.park("MH01-2255")
      parkingLot.unPark("MH01-5475")
    }
    assert(throws.getMessage == ParkingLotExceptionEnums.carNumberMissMatch.toString)
  }

  test("givenCarDetails_WhenTheParkingIsFull_ShouldGiveException"){
    val throws = intercept[ParkingLotException]{
      val parkingLot = new ParkingLot()
      parkingLot.park("MH01-2348")
      parkingLot.park("MH01-5348")
      parkingLot.park("MH01-4348")
      parkingLot.park("MH01-9348")
    }
    assert(throws.getMessage == ParkingLotExceptionEnums.parkingFull.toString)
  }
}
