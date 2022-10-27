import kotlin.math.PI
class Circle(var x: Int, var y: Int, var r: Int) : Figure(0), Transforming{
    override fun area(): Float {
        return (r * r * PI).toFloat()
    }
    override fun resize(zoom: Int) {
        r *= zoom
        println("Resize: $r")
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