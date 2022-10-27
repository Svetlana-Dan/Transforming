class Rect(var x: Int, var y: Int, var width: Int, var height: Int) : Movable, Figure(0), Transforming{
    var color: Int = -1 // при объявлении каждое поле нужно инициализировать

    lateinit var name: String // значение на момент определения неизвестно (только для объектных типов)
    // дополнительный конструктор вызывает основной
    constructor(rect: Rect) : this(rect.x, rect.y, rect.width, rect.height)

    // нужно явно указывать, что вы переопределяете метод
    override fun move(dx: Int, dy: Int) {
        x += dx; y += dy
        println("Move: $x, $y")
    }

    // для каждого класса area() определяется по-своему
    override fun area(): Float {
        return (width*height).toFloat() // требуется явное приведение к вещественному числу
    }

    override fun resize(zoom: Int) {
        width *= zoom
        height *= zoom
        println("Resize: $width, $height")
    }

    override fun rotate(direction: Transforming.RotateDirection, centerX: Int, centerY: Int) {
        if(centerX==x && centerY==y){
            return
        }
        if(direction==Transforming.RotateDirection.Clockwise){
            x = y - centerY + centerX.also{ y = -x + centerX + centerY}
        }
        if(direction==Transforming.RotateDirection.CounterClockwise){
            x = - y + centerY + centerX.also{ y = x - centerX + centerY}
        }
        println("Rotate: $x, $y")
    }
}