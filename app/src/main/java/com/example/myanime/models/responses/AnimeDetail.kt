package com.example.myanime.models.responses

import com.google.gson.annotations.SerializedName

data class AnimeDetailResponse(

    @SerializedName("data") var data: AnimeData? = AnimeData()

)


data class Titles(

    @SerializedName("type") var type: String? = null,
    @SerializedName("title") var title: String? = null

)

data class Prop(

    @SerializedName("from") var from: Date? = Date(),
    @SerializedName("to") var to: Date? = Date(),
    @SerializedName("string") var string: String? = null

)

data class Broadcast(

    @SerializedName("day") var day: String? = null,
    @SerializedName("time") var time: String? = null,
    @SerializedName("timezone") var timezone: String? = null,
    @SerializedName("string") var string: String? = null

)

data class Licensors(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Studios(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)

data class Producers(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Aired(

    @SerializedName("from") var from: String? = null,
    @SerializedName("to") var to: String? = null,
    @SerializedName("prop") var prop: Prop? = Prop()

)

data class Genres(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)

data class ExplicitGenres(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)

data class Themes(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class Date(

    @SerializedName("day") var day: Int? = null,
    @SerializedName("month") var month: Int? = null,
    @SerializedName("year") var year: Int? = null

)

data class Demographics(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null

)


data class AnimeData(

    @SerializedName("mal_id") var malId: Int? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("images") var images: Images? = Images(),
    @SerializedName("trailer") var trailer: Trailer? = Trailer(),
    @SerializedName("approved") var approved: Boolean? = null,
    @SerializedName("titles") var titles: ArrayList<Titles> = arrayListOf(),
    @SerializedName("title") var title: String? = null,
    @SerializedName("title_english") var titleEnglish: String? = null,
    @SerializedName("title_japanese") var titleJapanese: String? = null,
    @SerializedName("title_synonyms") var titleSynonyms: ArrayList<String> = arrayListOf(),
    @SerializedName("type") var type: String? = null,
    @SerializedName("source") var source: String? = null,
    @SerializedName("episodes") var episodes: Int? = null,
    @SerializedName("status") var status: String? = null,
    @SerializedName("airing") var airing: Boolean? = null,
    @SerializedName("aired") var aired: Aired? = Aired(),
    @SerializedName("duration") var duration: String? = null,
    @SerializedName("rating") var rating: String? = null,
    @SerializedName("score") var score: Float? = null,
    @SerializedName("scored_by") var scoredBy: Int? = null,
    @SerializedName("rank") var rank: Int? = null,
    @SerializedName("popularity") var popularity: Int? = null,
    @SerializedName("members") var members: Int? = null,
    @SerializedName("favorites") var favorites: Int? = null,
    @SerializedName("synopsis") var synopsis: String? = null,
    @SerializedName("background") var background: String? = null,
    @SerializedName("season") var season: String? = null,
    @SerializedName("year") var year: Int? = null,
    @SerializedName("broadcast") var broadcast: Broadcast? = Broadcast(),
    @SerializedName("producers") var producers: ArrayList<Producers> = arrayListOf(),
    @SerializedName("licensors") var licensors: ArrayList<Licensors> = arrayListOf(),
    @SerializedName("studios") var studios: ArrayList<Studios> = arrayListOf(),
    @SerializedName("genres") var genres: ArrayList<Genres> = arrayListOf(),
    @SerializedName("explicit_genres") var explicitGenres: ArrayList<ExplicitGenres> = arrayListOf(),
    @SerializedName("themes") var themes: ArrayList<Themes> = arrayListOf(),
    @SerializedName("demographics") var demographics: ArrayList<Demographics> = arrayListOf()

)


data class Trailer(

    @SerializedName("youtube_id") var youtubeId: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("embed_url") var embedUrl: String? = null

)