package me.juanescobar.storeapp.ui.theme

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import me.juanescobar.storeapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(myNavController: NavController) {
    Scaffold(
        topBar = {
            val scrollBehavior =
                TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Inicio",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Text(
                text = "Promociones destacadas",
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
            )

            val url_imagenes = listOf(
                "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEjfBJQr3r8Yr00wn8j0aXaf9ZMzZdBOpcvgM30aiOg826xbR0BWvaGEDGvO63H4TijpSMJ6IBAmSANaYJPLD5nhqLJ6xxCspb-VnmHpPmQtIbXzJyX8AGWoKG3oUrKWjOS5SRKanlcquH8/s1600/El+Marketing+Mix+Promoci%25C3%25B3n.jpgE",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTIHTAGxgr7nkmDvEZCX9TnQVoxzeTKnchWjQ&s",
                "https://i.pinimg.com/474x/28/c1/ed/28c1ed065d40062bf210b49da4beb515.jpg",
                "https://www.tipos.co/wp-content/uploads/2014/11/promociones.jpg",
                "https://www.skynetcorp.pe/blog/wp-content/uploads/Comunicacion-de-marketing.jpg"
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(start = 16.dp, end = 16.dp)
            ) {
                item { promoCard(url_imagenes[0]) }
                item { promoCard(url_imagenes[1]) }
                item { promoCard(url_imagenes[2]) }
                item { promoCard(url_imagenes[3]) }
                item { promoCard(url_imagenes[4]) }
            }

        }
    }
}


@Composable
fun promoCard(urlImage: String) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(180.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 24.dp)
    ) {
        AsyncImage(
            model = urlImage,
            contentDescription = "Imagen de promoción",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}