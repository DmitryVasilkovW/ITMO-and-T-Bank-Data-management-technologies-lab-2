package calculator

import calculator.myExceptions.{InvalidDimensionException, UnknownBuildingTypeException}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ParquetSpec extends AnyFlatSpec with Matchers {

  private val economy1 = Building.Economy(10, 25, 4, 2)
  private val economy2 = Building.Economy(23, 50, 3, 1)
  private val premium1 = Building.Premium(10, 25, 4, 2)
  private val premium2 = Building.Premium(23, 50, 4, 7)

  "calculate" should "calculate parquet cost correctly for economy building" in {
    Parquet.calculate(economy1) shouldEqual 21_000
    Parquet.calculate(economy2) shouldEqual 13_450
  }

  it should "calculate parquet cost corerectly for premium building" in {
    Parquet.calculate(premium1) shouldEqual 351
    Parquet.calculate(premium2) shouldEqual 9856
  }

  it should "throw UnknownBuildingTypeException when an unknown building type is provided" in {
    val exception = intercept[UnknownBuildingTypeException] {
      Building("luxury", 10, 20, 30, 2)
    }
    exception.getMessage shouldEqual "Unknown building type: luxury"
  }

  "Building smart constructor" should "create Economy building when valid parameters are provided" in {
    val building = Building("economy", 10, 77, 30, 2)
    building shouldBe a[Building.Economy]
  }

  it should "create Premium building when valid parameters are provided" in {
    val building = Building("premium", 15, 53, 35, 3)
    building shouldBe a[Building.Premium]
  }

  it should "throw InvalidDimensionException when length is <= 0" in {
    val exception = intercept[InvalidDimensionException] {
      Building("economy", -239, 20, 30, 2)
    }
    exception.getMessage shouldEqual "Invalid value for length: -239. Must be greater than 0."
  }

  it should "throw InvalidDimensionException when height is <= 0" in {
    val exception = intercept[InvalidDimensionException] {
      Building("premium", 10, 20, -239, 2)
    }
    exception.getMessage shouldEqual "Invalid value for height: -239. Must be greater than 0."
  }

  it should "throw InvalidDimensionException when width is <= 0" in {
    val exception = intercept[InvalidDimensionException] {
      Building("economy", 10, 0, 256, 2)
    }
    exception.getMessage shouldEqual "Invalid value for width: 0. Must be greater than 0."
  }

  it should "throw InvalidDimensionException when floorNumber is <= 0" in {
    val exception = intercept[InvalidDimensionException] {
      Building("premium", 10, 20, 60, 0)
    }
    exception.getMessage shouldEqual "Invalid value for floorNumber: 0. Must be greater than 0."
  }

}
