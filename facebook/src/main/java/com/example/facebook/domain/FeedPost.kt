package com.example.facebook.domain

import androidx.compose.ui.res.stringResource
import com.example.facebook.R

data class FeedPost (
    val communityName: String = "Share",
    val publishDate: String = "12:05",
    val iconId: Int = R.drawable.share,
    val contentText: String = "Павел Дуров сообщил, что с марта владельцы Telegram-каналов смогут начать получать финансовое вознаграждение за показы рекламы. ",
    val contentImageResId: Int = R.drawable.ads,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(type = StatisticType.SHARES, count = 319),
        StatisticItem(type = StatisticType.VIEWS, count = 2834),
        StatisticItem(type = StatisticType.COMMENTS, count = 8549),
        StatisticItem(type = StatisticType.LIKES, count = 42319),
    )
)