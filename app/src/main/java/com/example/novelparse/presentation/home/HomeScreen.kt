package com.example.novelparse.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.novelparse.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") }
    var novels by remember { mutableStateOf(sampleNovels)} // Danh sách truyện
    var page by remember { mutableStateOf(1) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        // 🔹 Search Bar
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            placeholder = { Text("Tìm kiếm truyện...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            singleLine = true
        )

        // 🔹 Tiêu đề "Nguồn truyện"
        Text(
            text = "Nguồn truyện",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // 🔹 Grid List View (2 cột, scroll được)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(8.dp)
        ) {
            items(novels) { novel ->
                NovelItem(novel)
            }

            // Pagination: Hiển thị nút "Tải thêm"
            item {
                Button(
                    onClick = {
                        page++
                        novels = novels + getMoreNovels(page) // Load thêm dữ liệu
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Tải thêm")
                }
            }
        }
    }
}

// 🔹 Custom Item (ảnh + tên truyện)
@Composable
fun NovelItem(novel: Novel) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column {
            Image(
                painter = painterResource(id = novel.imageRes),
                contentDescription = novel.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )
            Text(
                text = novel.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

// 🔹 Model dữ liệu
data class Novel(val title: String, val imageRes: Int)

// 🔹 Dữ liệu mẫu
val sampleNovels = listOf(
    Novel("Truyện 1", R.drawable.failure),
    Novel("Truyện 2", R.drawable.failure),
    Novel("Truyện 3", R.drawable.failure),
    Novel("Truyện 4", R.drawable.failure)
)

// 🔹 Fake Pagination (tạo truyện mới)
fun getMoreNovels(page: Int): List<Novel> {
    return listOf(
        Novel("Truyện ${page * 2 + 1}", R.drawable.failure),
        Novel("Truyện ${page * 2 + 2}", R.drawable.failure)
    )
}