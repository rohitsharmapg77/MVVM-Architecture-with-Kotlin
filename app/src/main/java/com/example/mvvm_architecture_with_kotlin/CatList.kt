package com.example.mvvm_architecture_with_kotlin

 data class CatList(
     val page: Int,
     val results: List<Result>,
     val total_pages: Int,
     val total_results: Int
)
