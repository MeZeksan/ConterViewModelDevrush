package com.hfad.conterviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hfad.conterviewmodel.ui.theme.ConterViewModelTheme
//VIEW - пользовательский интерфейс приложения
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //создаем viewModel класса CounterViewModel
            val viewModel:CounterViewModel = viewModel()
            ConterViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CounterViewModelFun(viewModel)
                }
            }
        }
    }
}
@Composable
//эта функция получает в качестве параметра экземлпляр класса counterViewModel
fun CounterViewModelFun(viewModel: CounterViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Счетчик", fontSize = 32.sp)
        Text(text = viewModel.count.value.toString(), modifier = Modifier.padding(16.dp), fontSize = 32.sp)

        Row {
            Button(
                onClick = { viewModel.increment() }, modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Увеличить")
            }
            Button(onClick = { viewModel.decrement() }, modifier = Modifier.padding(16.dp)) {
                Text(text = "Уменьшить")

            }
        }
    }
}

