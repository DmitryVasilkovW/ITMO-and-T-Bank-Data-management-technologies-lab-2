package transformer

object Transformers {

  val duplicate: String => String = { duplicateString => duplicateString + duplicateString }

  val divide: String => String = { divideString =>
    val halfLength = divideString.length / 2
    divideString.substring(0, halfLength)
  }

  val revert: String => String = { revertString => revertString.reverse }

  val closure: String => (String => String) => String = { originalString => transformer =>
    transformer(originalString)
  }

}
