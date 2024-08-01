package com.example.bitcottechnologiesassignment.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShowResponseModel(

	@field:SerializedName("ShowResponseModel")
	val showResponseModel: List<ShowResponseModelItem?>? = null
) : Parcelable

@Parcelize
data class Schedule(

	@field:SerializedName("days")
	val days: List<String?>? = null,

	@field:SerializedName("time")
	val time: String? = null
) : Parcelable

@Parcelize
data class Links(

	@field:SerializedName("self")
	val self: Self? = null,

	@field:SerializedName("previousepisode")
	val previousepisode: Previousepisode? = null
) : Parcelable

@Parcelize
data class Country(

	@field:SerializedName("code")
	val code: String? = null,

	@field:SerializedName("timezone")
	val timezone: String? = null,

	@field:SerializedName("name")
	val name: String? = null
) : Parcelable

@Parcelize
data class Show(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("averageRuntime")
	val averageRuntime: Int? = null,

	@field:SerializedName("dvdCountry")
	val dvdCountry: String? = null,

	@field:SerializedName("_links")
	val links: Links? = null,

	@field:SerializedName("premiered")
	val premiered: String? = null,

	@field:SerializedName("rating")
	val rating: Rating? = null,

	@field:SerializedName("runtime")
	val runtime: Int? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("officialSite")
	val officialSite: String? = null,

	@field:SerializedName("network")
	val network: Network? = null,

	@field:SerializedName("schedule")
	val schedule: Schedule? = null,

	@field:SerializedName("webChannel")
	val webChannel: String? = null,

	@field:SerializedName("genres")
	val genres: List<String?>? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("ended")
	val ended: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("externals")
	val externals: Externals? = null,

	@field:SerializedName("updated")
	val updated: Int? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class Image(

	@field:SerializedName("original")
	val original: String? = null,

	@field:SerializedName("medium")
	val medium: String? = null
) : Parcelable

@Parcelize
data class Previousepisode(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Network(

	@field:SerializedName("country")
	val country: Country? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("officialSite")
	val officialSite: String? = null
) : Parcelable

@Parcelize
data class Rating(

	@field:SerializedName("average")
	val average: String? = null
) : Parcelable

@Parcelize
data class Self(

	@field:SerializedName("href")
	val href: String? = null
) : Parcelable

@Parcelize
data class Externals(

	@field:SerializedName("thetvdb")
	val thetvdb: Int? = null,

	@field:SerializedName("imdb")
	val imdb: String? = null,

	@field:SerializedName("tvrage")
	val tvrage: String? = null
) : Parcelable

@Parcelize
data class ShowResponseModelItem(

	@field:SerializedName("score")
	val score: Double? = null,

	@field:SerializedName("show")
	val show: Show? = null
) : Parcelable
