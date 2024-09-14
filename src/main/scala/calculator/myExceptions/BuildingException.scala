package calculator.myExceptions

sealed abstract class BuildingException(message: String) extends Exception(message)

case class InvalidDimensionException(dimension: String, value: Int)
    extends BuildingException(s"Invalid value for $dimension: $value. Must be greater than 0.")

case class UnknownBuildingTypeException(buildingType: String)
    extends BuildingException(s"Unknown building type: $buildingType")
