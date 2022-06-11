package com.example.jetbizcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetbizcard.ui.theme.JetBizCardTheme
import java.net.ContentHandler

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetBizCardTheme {
                // A surface container using the 'background' color from the theme

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
//                    Column(
//                        verticalArrangement = Arrangement.SpaceBetween,
////                        horizontalAlignment = Alignment.CenterHorizontally
//                    ) {
//                        CreateBizCard()
//                        Nav()
//                    }


                }
            }
        }
    }
}

//@Composable
//fun Nav(){
//    var selectedItem by remember { mutableStateOf(0) }
//    val items = listOf("Songs", "Artists", "Playlists")
//
//    NavigationBar {
//        items.forEachIndexed { index, item ->
//            NavigationBarItem(
//                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
//                label = { Text(item) },
//                selected = selectedItem == index,
//                onClick = { selectedItem = index }
//            )
//        }
//    }
//}
@Preview(showBackground = true)
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
//            border = BorderStroke(width = 2.dp, color = MaterialTheme.colorScheme.primary),
//            shape = RoundedCornerShape(corner = CornerSize(6.dp))
        ) {
            Portfolio(data = listOf("Project 1", "Project 2", "Project 3"))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Portfolio(data: List<String>) {
    LazyColumn {
        items(data) { item ->
            Card(
                modifier = Modifier
                    .padding(vertical = 10.dp)
                    .fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .padding(7.dp)
                ) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(
                        modifier = Modifier
                            .padding(8.dp)
                            .align(alignment = Alignment.CenterVertically),
                    ) {
                        Text(
                            text = item,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(text = "Jetpack Compose", fontWeight = FontWeight.Bold)

                    }
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateBizCard() {
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(
        modifier = Modifier
            .fillMaxWidth()
//            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .padding(12.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
            colors = CardDefaults.elevatedCardColors(containerColor = MaterialTheme.colorScheme.surface),
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
//                    .height(300.dp)
                    .padding(10.dp)
            ) {

                CreateImageProfile()
                Divider(
                    thickness = 0.6.dp,
                )

                CreateInfo()
                Button(
//                    contentPadding = PaddingValues(horizontal = 50.dp, vertical = 10.dp),
                    onClick = {
                        buttonClickedState.value = !buttonClickedState.value
                    },
                    modifier = Modifier.padding(10.dp)

                ) {
                    Text(
                        text = "Portfolio",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                }
                if (buttonClickedState.value == true) {
                    Content()
                } else {
                    Box() {

                    }
                }

            }

        }
    }
}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(
            text = "Aldi Kitta",
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.primary,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "Android Developer",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(3.dp)
        )
        Text(
            text = "@jetpackCompose",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(3.dp)
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = null,
        shadowElevation = 4.dp,
        tonalElevation = 4.dp
    ) {
        Image(
            painter = painterResource(id = R.drawable.pic),
            contentDescription = "Profile Image",
            modifier = modifier.size(135.dp),
        )
    }
}

//@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetBizCardTheme {
        CreateBizCard()
    }
}