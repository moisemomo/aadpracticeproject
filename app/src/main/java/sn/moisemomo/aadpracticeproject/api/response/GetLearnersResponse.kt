package sn.moisemomo.aadpracticeproject.api.response

class GetLearnersResponse : ArrayList<GetLearnersResponseItem>()

data class GetLearnersResponseItem(
    val badgeUrl: String,
    val country: String,
    val name: String,
    val score: Int
)