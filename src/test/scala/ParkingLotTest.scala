import com.bridgelabz.parkinglot.ParkingLot
import org.scalatest.FunSuite

class ParkingLotTest extends FunSuite{

  test("givenCarDetails_WhenAddedToParkingLot_ShouldReturnTrue"){
    val parkingLot = new ParkingLot
    val parked = parkingLot.park("MH01-3241")
    assert(parked == true)
  }
}
