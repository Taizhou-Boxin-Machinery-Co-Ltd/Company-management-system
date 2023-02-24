package api

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.FrameWindowScope
import androidx.compose.ui.window.Window
import java.net.Socket


class WindowHandle(val win_title: MutableState<String>, val boolean:  MutableState<Boolean>) {
    @Composable
    fun build(content: @Composable FrameWindowScope.() -> Unit) {
        if (boolean.value) {
            Window(
                onCloseRequest = { closeWindow() },
                title = win_title.value,
                content = content
            )
        }
    }
    fun setTitle(title: String): WindowHandle {
        win_title.value = title
        return this
    }

    fun closeWindow() : WindowHandle {
        boolean.value = false
        return this
    }
}

//@Composable
//fun Handle(
//    content: @Composable FrameWindowScope.() -> Unit
//) {
//    val boolean = remember { mutableStateOf(true) }
//
//    if (boolean.value) {
//        Window(
//            onCloseRequest = { boolean.value = false },
//            content = content
//        )
//    }
//}