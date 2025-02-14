package com.nxxr.thirtydaysofinvesting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nxxr.thirtydaysofinvesting.model.Tip
import com.nxxr.thirtydaysofinvesting.model.TipsRepository
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.nxxr.thirtydaysofinvesting.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TipApp(
                        modifier = Modifier
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Composable
fun TipCard(tip: Tip,modifier: Modifier = Modifier) {

    val extended = remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .width(390.dp)
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Image
            Box (
                modifier = Modifier.weight(3f)
            ){
                Image(
                    painter = painterResource(id = tip.image),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(8.dp))
                        .background(MaterialTheme.colorScheme.surface),
                    contentScale = ContentScale.Crop
                )
            }

            // Day label
            Text(
                text = "Day ${tip.dayCount}",
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.Start)
            )

            // Description
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .animateContentSize(
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioNoBouncy,
                            stiffness = Spring.StiffnessMediumLow
                        )
                    )
            ){
                if (extended.value) {
                    Text(
                        text = stringResource(tip.description),
                        color = MaterialTheme.colorScheme.onSecondaryContainer,
                        style = MaterialTheme.typography.bodyLarge,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(top = 8.dp)  // Add padding to avoid text touching the top
                    )
                }
            }

            // Title and Expand Icon
            Row (
                modifier = modifier
                    .height(200.dp)
                    .width(370.dp)
            ){
                Text(
                    text = stringResource(tip.title),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    style = MaterialTheme.typography.displayLarge,
                    textAlign = TextAlign.Start,
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentWidth(Alignment.Start),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis

                )

               IconButton(
                    onClick = { extended.value = !extended.value },
                    modifier = Modifier.align(Alignment.CenterVertically)
               ) {
                   Icon(
                       imageVector = if (extended.value) Icons.Filled.Remove else Icons.Filled.Add,
                       contentDescription = null,
                       tint = MaterialTheme.colorScheme.onPrimaryContainer,
                       modifier = Modifier.size(32.dp)
                   )
               }
            }
        }
    }
}


@Composable
fun TipApp(modifier: Modifier = Modifier) {
    val tips = TipsRepository.getTips()
    val lazyListState = rememberLazyListState()


    Scaffold (
        Modifier.fillMaxSize()
    ){  it ->
        Column (
            modifier = Modifier.padding(it)
        ){
            TipsTopAppBar()

            LazyRow (
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .fillMaxSize(),
                state = lazyListState,
                contentPadding =  it,
                flingBehavior = rememberSnapFlingBehavior(lazyListState)
            ) {
                items(tips) {
                    TipCard(
                        tip = it,
                        modifier = Modifier
                            .animateContentSize(
                                animationSpec = spring(
                                    dampingRatio = Spring.DampingRatioMediumBouncy,
                                    stiffness = Spring.StiffnessMediumLow
                                )
                            )
                    )
                }
            }
        }

    }
}

@Preview
@Composable
fun TipsTopAppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.app_name),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            style = MaterialTheme.typography.displaySmall.copy(fontSize = 30.sp),
            maxLines = 2,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Preview
@Composable
fun TipCardPreview(){
    TipCard(tip = TipsRepository.getTips()[0])
}

@Preview(showBackground = true)
@Composable
fun TipAppPreview() {
    TipApp()
}