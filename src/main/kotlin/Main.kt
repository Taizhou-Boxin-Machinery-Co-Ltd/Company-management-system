// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.window.application
import api.WindowHandle

@Composable
@Preview
fun App(windowHandle: WindowHandle) {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme {
        Button(onClick = {
            text = "Hello, Desktop!"
        }) {
            Text(text)
        }
    }
}

fun main() {

    application {
        val win_title: MutableState<String> = remember { mutableStateOf("default") }
        val boolean: MutableState<Boolean> = remember { mutableStateOf(true) }

        val windowHandle = WindowHandle(
            win_title = win_title,
            boolean = boolean
        )
        windowHandle
            .setTitle("台州市博新机械有限公司管理系统")
            .build {
                App(windowHandle)
            }

    }
}
