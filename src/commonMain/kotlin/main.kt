import com.soywiz.klock.seconds
import com.soywiz.korge.*
import com.soywiz.korge.scene.Module
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.tween.*
import com.soywiz.korge.view.*
import com.soywiz.korim.color.Colors
import com.soywiz.korim.color.RGBA
import com.soywiz.korim.format.*
import com.soywiz.korinject.AsyncInjector
import com.soywiz.korio.file.std.*
import com.soywiz.korma.geom.SizeInt
import com.soywiz.korma.geom.degrees
import com.soywiz.korma.interpolation.Easing
import scene.*
import kotlin.reflect.KClass

//suspend fun main() = Korge(width = 512, height = 512, bgcolor = Colors["#2b2b2b"]) {
//	val minDegrees = (-16).degrees
//	val maxDegrees = (+16).degrees
//
//	val image = image(resourcesVfs["korge.png"].readBitmap()) {
//		rotation = maxDegrees
//		anchor(.5, .5)
//		scale(.8)
//		position(256, 256)
//	}
//
//	while (true) {
//		image.tween(image::rotation[minDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
//		image.tween(image::rotation[maxDegrees], time = 1.seconds, easing = Easing.EASE_IN_OUT)
//	}
//}
suspend fun main() = Korge(Korge.Config(module = ConfigModule))
object ConfigModule : Module(){
	override val bgcolor: RGBA = Colors["#2b2b2b"]
	override val size: SizeInt = SizeInt(512, 512)
	override val mainScene: KClass<out Scene> = Splash::class
	override suspend fun AsyncInjector.configure() {
		mapPrototype { Splash() }
		mapPrototype { Menu() }
		mapPrototype { GamePlay() }
		mapPrototype { GameOver() }
		mapPrototype { Rank() }
	}
}