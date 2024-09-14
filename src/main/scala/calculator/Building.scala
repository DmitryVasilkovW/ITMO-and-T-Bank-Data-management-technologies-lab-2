package calculator

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
    require(length > 0, "Length must be greater than 0")
    require(width > 0, "Width must be greater than 0")
    require(height > 0, "Height must be greater than 0")
    require(floorNumber > 0, "Floor number must be greater than 0")

    buildingType.toLowerCase match {
      case "economy" => Economy(length, width, height, floorNumber)
      case "premium" => Premium(length, width, height, floorNumber)
      case _         => throw new IllegalArgumentException("Unknown building type")
    }
  }

}
