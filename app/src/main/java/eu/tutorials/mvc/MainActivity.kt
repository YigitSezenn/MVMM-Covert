package eu.tutorials.mvc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import eu.tutorials.mvc.ui.theme.MvcTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
              val viewModel: CounterViewModel = viewModel()
            MvcTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  MvcExample(name = "Android", modifier = Modifier.padding(innerPadding),
                      viewModel
                    )
                }
            }
        }
    }
}

@Composable
fun MvcExample(name: String, modifier: Modifier = Modifier,viewModel: CounterViewModel) {

    Column(modifier=Modifier.fillMaxSize(),
         verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

        ) {
        Text(text ="Count: ${viewModel.count.value}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick ={viewModel.incrementCount()} ) {
                Text(text = "Increment")

            }
            Button(onClick = { viewModel.DecrementCount() }) {
                Text(text = "Decrement")
            }
        }

    }
    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MvcTheme {
        MvcExample("Android",viewModel = CounterViewModel())
    }
}