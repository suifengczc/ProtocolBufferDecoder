package com.suifeng.decode.gui

import javafx.application.Application
import javafx.event.EventHandler
import javafx.fxml.FXMLLoader
import javafx.geometry.Rectangle2D
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.input.MouseEvent
import javafx.stage.Screen
import javafx.stage.Stage


/**
 *@author suifengczc
 *@date 2020/10/24
 */
class MainApp : Application() {
    override fun start(primaryStage: Stage?) {
        val root = FXMLLoader.load<Parent>(javaClass.getResource("../../../../../../resources/main/MainApp.fxml"))
        val screenRectangle: Rectangle2D = Screen.getPrimary().bounds
        val width: Double = screenRectangle.width / 2
        val height: Double = screenRectangle.height / 2
        val scene = Scene(root, width, height)
        primaryStage?.run {
            this.scene = scene
            this.title = "ProtocolBufferDecoder"
        }
        val hUnit = width / 100
        val vUnit = height / 100

        val labelData = root.lookup("#labelData") as Label
        labelData.layoutX = hUnit * 2
        labelData.layoutY = vUnit * 2
        primaryStage?.show()

        val edData = root.lookup("#edData") as TextField
        edData.layoutX = labelData.layoutX + labelData.width + hUnit
        edData.layoutY = vUnit * 2
        edData.isFocusTraversable = false
        primaryStage?.show()

        //解析按钮点击事件
        var btnParser = root.lookup("#btnParser") as Button
        btnParser.layoutX = edData.layoutX + edData.width + hUnit
        btnParser.layoutY = vUnit * 2
        btnParser.onMouseClicked = EventHandler<MouseEvent> {
            startParser()
        }

        primaryStage?.show()
    }

    private fun startParser() {
        println("start parser")
    }
}

fun main(args: Array<String>) = Application.launch(MainApp::class.java, *args)