package com.shub39.portfolio.pages.rush_demo

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

data class LyricsPageState(
    val song: SongUi = SongUi(),
    val selectedLines: Map<Int, String> = emptyMap(),
    val hypnoticCanvas: Boolean = true,
    val meshSpeed: Float = 1f,
    val mCardBackground: Int = Color.Blue.toArgb(),
    val mCardContent: Int = Color.White.toArgb()
)

data class SongUi(
    val id: Long = 0,
    val title: String = "Long Road No Turns",
    val artists: String = "Daughters",
    val lyrics: List<Map.Entry<Int, String>> = convertStringToEntryList(
        """
            Everybody climbs up high, then falls real far
            A little is all it takes, a little is all it takes
            Everybody climbs up high, then falls real far
            And I don't know what to say, I don't know what to say
            I don't know what to say when people come apart
            The road is long, the road is dark
            And these are just the words to somebody else's song

            Everybody gets in line and makes mistakes
            A little is all it takes, a little is all it takes
            Everybody gets in line and makes mistakes
            And I don't know what to say, I don't know what to say
            I don't know what to say when people come undone
            The road is dark, the road is long
            Remember these are just the words to somebody else's song
            So don't play along, or play a part
            Don't look to me under the weight of your shouldered cross

            These are just the words to somebody else's song

            Please your heart to-
            Please your heart to-
            And please your heart to see some shackled wrists and throat
            Naked as the day they were born

            So, everybody climb up high, then fall real far
            A little is all it will take, a little is all it will take
            Everybody get in line and make mistakes
            But I won't know what to say
            When you come undone, when you come apart
            Remember that the road is long
            Remember that the road is dark
            Don't waste your time learning the words to somebody else's song

            Please your heart to-
            Please your heart to-
            If it will please your heart to see some shackled wrists and throat
            Naked as the day they were born
            It will please your heart to-
            Please your heart to-
            It will please your heart to see some shackled wrists and throat
            Naked as the day they were born

            But no one's going to do that for you
            No one will do that for you
            No one will do that for you!

            Well, ain't it funny how it works?
            Someone's always got it worse
            (They hit the ground harder than you)
            Well, ain't it funny how it works?
            Someone's always got it worse
            (They hit the ground harder than you)

            Well, ain't it funny how it works?
            Someone's always got it worse
            (They hit the ground harder than you)
            Well, ain't it funny how it works?
            Someone's always got it worse
            (They hit the ground harder than you)
        """
    )
)

fun convertStringToEntryList(input: String): List<Map.Entry<Int, String>> {
    val entryList = mutableListOf<Map.Entry<Int, String>>()
    val lines = input.trim().split("\n")

    for ((index, line) in lines.withIndex()) {
        val lineNumber = index + 1
        val trimmedLine = line.trim()
        entryList.add(object : Map.Entry<Int, String> {
            override val key: Int = lineNumber
            override val value: String = trimmedLine
        })
    }
    return entryList
}