object doom {
  def main(args: Array[String]): Unit = {
    println("Starting to calculate the likely hood of doom.")
    val gold_indicator: Float = args(0).toFloat
    val crude_indicator: Float = args(1).toFloat
    val news_indicator: Int = args(2).toInt
    val interest_rate_indicator: Float = args(3).toFloat
    val doom: Int = calculate_doom(gold_indicator, crude_indicator, news_indicator, interest_rate_indicator)
    println(s"Calculated the likely hood of doom as $doom.")
  }

  def calculate_doom(g: Float, c: Float, n: Int, ir: Float): Int = {
    val dooms = List(calculate_variance(g, "gold"),
      calculate_variance(c, "crude"),
      calculate_variance(n, "news"),
      calculate_variance(ir, "interest")
    )
    val doom = dooms.sum
    doom.toInt
  }

  def calculate_variance(input: Float, input_type: String): Float = {
    var baseline = 0
    if (input_type == "gold"){
      baseline = 1000
    }
    else if (input_type == "crude"){
      baseline = 100
    }
    else if (input_type == "news") {
      baseline = 5
    }
    else if (input_type == "interest"){
      baseline = 3
    }
    val diff: Float = Math.abs(baseline - input)
    diff
  }
  }
