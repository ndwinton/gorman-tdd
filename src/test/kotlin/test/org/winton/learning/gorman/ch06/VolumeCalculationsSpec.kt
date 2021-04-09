package test.org.winton.learning.gorman.ch06

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch06.Cube
import uk.org.winton.learning.gorman.ch06.Cylinder
import uk.org.winton.learning.gorman.ch06.Pyramid
import kotlin.math.PI

class VolumeCalculationsSpec : FunSpec({
    test("calculating the volume of a cube") {
        table(
            headers("size", "volume"),
            row(1, 1),
            row(2, 8),
            row(3, 27)
        ).forAll { size, volume ->
            val cube = Cube(size = size)
            cube.volume.shouldBe(volume)
        }
    }

    test("calculating the volume of a cylinder") {
        table(
            headers("radius", "height", "volume"),
            row(1.0, 1.0, PI),
            row(2.0, 3.0, PI * 12.0)
        ).forAll { radius, height, volume ->
            val cylinder = Cylinder(radius, height)
            cylinder.volume.shouldBe(volume)
        }
    }

    test("calculating the volume of a pyramid") {
        table(
            headers("length", "width", "height", "volume"),
            row(1.0, 1.0, 1.0, 1.0 / 3.0),
            row(2.0, 3.0, 4.0, 8.0)
        ).forAll { length, width, height, volume ->
            val pyramid = Pyramid(length, width, height)
            pyramid.volume.shouldBe(volume)
        }
    }
})