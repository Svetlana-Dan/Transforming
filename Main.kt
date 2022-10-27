fun main(args: Array<String>) {
    // интерфейсы удобно использовать в коллекциях
    val figures: Array<Movable>
    val movable: Movable = Rect(0,0,1,1)
    movable.move(1,1)
    // переменной базового класса
    val f: Figure = Rect(0,0,1,1)
    val f2: Figure = Circle(2,3,1)
    val f3: Transforming = Circle(3,3,4)
    val f4: Figure = Square(0,0,2)
    val f5: Transforming = Rect(3,4,1,1)
    val f6: Movable = Rect(1,2,3,5)

    println(f.area())
    println(f2.area())
    println(f4.area())
    println(f5.rotate(Transforming.RotateDirection.Clockwise,3, -3))
    println(f5.rotate(Transforming.RotateDirection.Clockwise,7, -7))
    println(f5.rotate(Transforming.RotateDirection.CounterClockwise,2, -2))
    println(f5.resize(4))
    println(f6.move(0,0))
}