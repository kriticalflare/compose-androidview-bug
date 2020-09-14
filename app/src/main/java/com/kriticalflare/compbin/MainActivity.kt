package com.kriticalflare.compbin

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.AndroidView
import androidx.ui.tooling.preview.Preview
import com.kriticalflare.compbin.ui.ComposemitbinclientTheme
import de.markusressel.kodeeditor.library.extensions.dpToPx
import de.markusressel.kodeeditor.library.view.CodeEditorLayout
import de.markusressel.kodehighlighter.language.python.PythonRuleBook

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposemitbinclientTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(topBar ={ TopAppBar(title = {Text("MitBin Client")})  }) {
                    KodeEditor(codeEditorLayout = rememberKodeEditor())
                }
            }
        }
    }
}

@Composable
fun KodeEditor(codeEditorLayout: CodeEditorLayout){
    AndroidView(viewBlock = {codeEditorLayout}, modifier = Modifier.fillMaxSize()){

    }
}

@Composable
fun rememberKodeEditor(): CodeEditorLayout{
    val context = ContextAmbient.current
    return remember { CodeEditorLayout(context).apply {
        languageRuleBook = PythonRuleBook()
        editable = true
        showDivider = true
        showMinimap = true
        minimapBorderWidth = 1.dpToPx(context)
        minimapMaxDimension = 150.dpToPx(context)
        minimapGravity = Gravity.BOTTOM or Gravity.END
    }}
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposemitbinclientTheme {
        Greeting("Android")
    }
}