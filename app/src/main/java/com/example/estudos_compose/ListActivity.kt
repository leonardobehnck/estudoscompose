package com.example.estudos_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.estudos_compose.ui.theme.EstudoscomposeTheme


class ListActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      EstudoscomposeTheme {
        Surface { ListScreen() }
      }
    }
  }

  data class Person(
    val name: String
  )

  @Composable
  fun ListScreen() {
    val personList = listOf(Person("Leo"), Person("Ezequiel"), Person("Lucas"))
    LazyColumn (
      modifier = Modifier.padding(55.dp),
      verticalArrangement = Arrangement.spacedBy(15.dp)
    ) {
      items(personList) { item ->
        ItemList(item.name)
      }
    }
//    LazyRow(
//      contentPadding = PaddingValues(horizontal = 25.dp)
//
//    ) {
//      items(personList) { item ->
//        ItemList(item.name)
//      }
//    }
  }

  @Composable
  fun ItemList(name: String) {
    Text(text = name, modifier = Modifier.background(Color.LightGray))
  }
}