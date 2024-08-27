package com.example.estudos_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.estudos_compose.ui.theme.EstudoscomposeTheme
import com.example.estudos_compose.ui.theme.Typography

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      EstudoscomposeTheme {
        Surface { MainScreen() }
      }
    }
  }
}

@Composable
fun MainScreen() {
  Row(
    modifier = Modifier
      .fillMaxSize()
      .background(Color.Black),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.Center,
  ) {
    Column {
      StarWarsCard(starWars = StarWars("StarWars", "Luke Skywalker"), modifier = Modifier.background(Color.White))
      StarWarsCard(starWars = StarWars("StarWars", "Leia Organa"), modifier = Modifier.background(Color.Gray))

    }
 }
}

data class StarWars(
  val name: String,
  val character: String,
)

@Composable
fun StarWarsCard(starWars: StarWars, modifier: Modifier = Modifier) {
  Row (verticalAlignment = Alignment.CenterVertically,
    modifier = modifier
  )
  {
    Image(
      painter = painterResource(R.drawable.star_wars_lg),
      contentDescription = "StarWars Logo",
      modifier = Modifier
        .size(200.dp)
        .clip(CircleShape)
        .background(Color.White)

    )
    Column {
      Text(text = starWars.name, color = Color.Gray)
      Text(text = starWars.character, color = Color.Gray)

    }
  }
}

@Composable
private fun TestingColumns() {
  Column(
    modifier = Modifier
      .background(Color.LightGray)
      .fillMaxWidth()
      .fillMaxHeight()
      .padding(15.dp, 15.dp, 15.dp, 15.dp)


  ) {
    Row {

      Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier
          .background(Color.Gray)
          .padding(15.dp)

      )
      Text(
        text = stringResource(id = R.string.app_name),
        style = MaterialTheme.typography.titleSmall,
        modifier = Modifier
          .background(Color.Gray)
          .padding(15.dp)
      )
    }


    //Text(text = "Meu primeiro texto com compose")
    //Text(text = "Meu segundo texto com compose")
    Button(
      onClick = { /*TODO*/ },
      modifier = Modifier
        .fillMaxWidth()
        .absoluteOffset(x = 0.dp, y = 100.dp),

      colors = ButtonDefaults.buttonColors(
        containerColor = Color.Gray,
        contentColor = Color.Black,
      )
    ) {
      Text(text = "Meu botão")
      Icon(
        painter = painterResource(id = R.drawable.ic_star),
        tint = Color.White,
        //modifier = Modifier.background(Color.Black),
        contentDescription = "Star icon",
      )
    }
  }
}


@Preview
@Composable
fun MainScreenPreview() {
  EstudoscomposeTheme {
    MainScreen()
  }
}


