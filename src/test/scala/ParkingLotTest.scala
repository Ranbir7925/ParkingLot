import com.bridgelabz.parkinglot.{ParkingLot, ParkingLotException, ParkingLotExceptionEnums}
import org.scalatest.FunSuite

class ParkingLotTest extends FunSuite{

  test("givenCarDetails_WhenAddedToParkingLot_ShouldReturnTrue"){
    val parkingLot = new ParkingLot()
    val parked = parkingLot.park("MH01-3241")
    assert(parked == true)
  }

  test("givenCarDetails_WhenProvidedToUnParkTheCar_ShouldReturnTrue"){
    val parkingLot = new ParkingLot()
    val unParked = parkingLot.park("MH01-3241")
    assert(unParked == true)
  }

  test("givenIncorrectCarDetails_WhenProvidedToUnParkTheCar_ShouldGiveException"){
    val throws = intercept[ParkingLotException]{
      val parkingLot = new ParkingLot()
      parkingLot.unPark("MH01-5475")
    }
    assert(throws.getMessage == ParkingLotExceptionEnums.CAR_NUMBER_MISMATCH.toString)
  }
}
