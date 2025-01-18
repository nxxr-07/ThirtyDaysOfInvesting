package com.nxxr.thirtydaysofinvesting.model

import androidx.annotation.StringRes
import com.nxxr.thirtydaysofinvesting.R

object TipsRepository {
    fun getTips(): List<Tip>{
        return listOf(
            Tip(1, R.string.day1_title, R.string.day1_desc, R.drawable.one),
            Tip(2, R.string.day2_title, R.string.day2_desc, R.drawable.two),
            Tip(3, R.string.day3_title, R.string.day3_desc, R.drawable.three),
            Tip(4, R.string.day4_title, R.string.day4_desc, R.drawable.four),
            Tip(5, R.string.day5_title, R.string.day5_desc, R.drawable.five),
            Tip(6, R.string.day6_title, R.string.day6_desc, R.drawable.six),
            Tip(7, R.string.day7_title, R.string.day7_desc, R.drawable.seven),
            Tip(8, R.string.day8_title, R.string.day8_desc, R.drawable.eight),
            Tip(9, R.string.day9_title, R.string.day9_desc, R.drawable.nine),
            Tip(10, R.string.day10_title, R.string.day10_desc, R.drawable.ten),
            Tip(11, R.string.day11_title, R.string.day11_desc, R.drawable.eleven),
            Tip(12, R.string.day12_title, R.string.day12_desc, R.drawable.twelve),
            Tip(13, R.string.day13_title, R.string.day13_desc, R.drawable.thirteen),
            Tip(14, R.string.day14_title, R.string.day14_desc, R.drawable.fourteen),
            Tip(15, R.string.day15_title, R.string.day15_desc, R.drawable.fifteen),
            Tip(16, R.string.day16_title, R.string.day16_desc, R.drawable.sixteen),
            Tip(17, R.string.day17_title, R.string.day17_desc, R.drawable.seventeen),
            Tip(18, R.string.day18_title, R.string.day18_desc, R.drawable.eighteen),
            Tip(19, R.string.day19_title, R.string.day19_desc, R.drawable.nineteen),
            Tip(20, R.string.day20_title, R.string.day20_desc, R.drawable.twenty),
            Tip(21, R.string.day21_title, R.string.day21_desc, R.drawable.twenty_one),
            Tip(22, R.string.day22_title, R.string.day22_desc, R.drawable.twenty_two),
            Tip(23, R.string.day23_title, R.string.day23_desc, R.drawable.twenty_three),
            Tip(24, R.string.day24_title, R.string.day24_desc, R.drawable.twenty_four),
            Tip(25, R.string.day25_title, R.string.day25_desc, R.drawable.twenty_five),
            Tip(26, R.string.day26_title, R.string.day26_desc, R.drawable.twenty_six),
            Tip(27, R.string.day27_title, R.string.day27_desc, R.drawable.twenty_seven),
            Tip(28, R.string.day28_title, R.string.day28_desc, R.drawable.twenty_eight),
            Tip(29, R.string.day29_title, R.string.day29_desc, R.drawable.twenty_nine),
            Tip(30, R.string.day30_title, R.string.day30_desc, R.drawable.thirty)
        )
    }
}