class CalculateNeighborsTest extends munit.FunSuite:
  def assertArrayEquals[A](
      actual: Array[Array[A]],
      expected: Array[Array[A]]
  ): Unit =
    assertEquals(actual.map(_.toSeq).toSeq, expected.map(_.toSeq).toSeq)

  test("test1") {
    assertArrayEquals(
      calculateNeighbors(
        Array(
          Array['.' | '@']('.', '.', '.'),
          Array['.' | '@']('.', '@', '.'),
          Array['.' | '@']('.', '.', '.')
        )
      ),
      Array(
        Array(1, 1, 1),
        Array(1, 0, 1),
        Array(1, 1, 1)
      )
    )
  }

  test("test2") {
    assertArrayEquals(
      calculateNeighbors(
        Array(
          Array['.' | '@']('@', '.', '@'),
          Array['.' | '@']('.', '@', '.'),
          Array['.' | '@']('@', '.', '@')
        )
      ),
      Array(
        Array(1, 3, 1),
        Array(3, 4, 3),
        Array(1, 3, 1)
      )
    )
  }

  test("test3") {
    assertArrayEquals(
      calculateNeighbors(
        Array(
          Array['.' | '@']('.', '.', '.', '.', '.'),
          Array['.' | '@']('.', '@', '@', '.', '.'),
          Array['.' | '@']('.', '@', '@', '.', '.'),
          Array['.' | '@']('.', '.', '.', '.', '.')
        )
      ),
      Array(
        Array(1, 2, 2, 1, 0),
        Array(2, 3, 3, 2, 0),
        Array(2, 3, 3, 2, 0),
        Array(1, 2, 2, 1, 0)
      )
    )
  }

class SimulateRollsCollectionTest extends munit.FunSuite:
  test("test1") {
    val cells =
      """
..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.
""".trim.split("\n")
        .map(_.toCharArray.map['.' | '@'] {
          case '.' => '.'
          case '@' => '@'
        })
    val field = buildField(cells)
    assertEquals(simulateRollsCollection(field), 43)
  }
