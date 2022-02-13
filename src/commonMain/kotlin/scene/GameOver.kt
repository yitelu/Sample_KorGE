package scene

import com.soywiz.korge.input.onClick
import com.soywiz.korge.scene.Scene
import com.soywiz.korge.ui.uiTextButton
import com.soywiz.korge.view.Container
import com.soywiz.korge.view.position
import com.soywiz.korge.view.text
import com.soywiz.korio.async.launchImmediately
import com.soywiz.korma.geom.Point

class GameOver() : Scene() {

    val textPos = Point(128, 128)
    val buttonWidth = 256.0
    val buttonHeight = 32.0
    val buttonPose = Point(128, 128 + 32)

    override suspend fun Container.sceneInit() {
        text("I'm in ${GameOver::class.simpleName}"){
            position(textPos)
        }

        uiTextButton (buttonWidth, buttonHeight) {
            text = "Go to Rank"
            position(buttonPose)
            onClick {
                launchImmediately { sceneContainer.changeTo<Rank>() }
            }
        }
    }
}
