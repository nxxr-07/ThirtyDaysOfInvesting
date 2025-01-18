package com.nxxr.thirtydaysofinvesting.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Tip(
    val dayCount: Int,
    @StringRes val title: Int,
    @StringRes val description: Int,
    @DrawableRes val image: Int
)
