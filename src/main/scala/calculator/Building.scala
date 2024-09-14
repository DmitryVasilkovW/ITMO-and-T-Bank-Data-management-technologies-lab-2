package calculator

import calculator.myExceptions.{InvalidDimensionException, UnknownBuildingTypeException}

sealed trait Building(length: Int, width: Int, height: Int, floorNumber: Int)

object Building {

  final case class Economy(length: Int, width: Int, height: Int, floorNumber: Int)
      extends Building(length, width, height, floorNumber)

  final case class Premium(length: Int, width: Int, height: Int, floorNumber: Int)
      extends Building(length, width, height, floorNumber)

  def apply(
    buildingType: String,
    length: Int,
    width: Int,
    height: Int,
    floorNumber: Int
  ): Building = {
    if (length <= 0) throw InvalidDimensionException("length", length)
    if (width <= 0) throw InvalidDimensionException("width", width)
    if (height <= 0) throw InvalidDimensionException("height", height)
    if (floorNumber <= 0) throw InvalidDimensionException("floorNumber", floorNumber)

    buildingType.toLowerCase match {
      case "economy" => Economy(length, width, height, floorNumber)
      case "premium" => Premium(length, width, height, floorNumber)
      case _         => throw UnknownBuildingTypeException(buildingType)
    }
  }

}
