package com.neltech.renthouse.view.workflow

import com.google.gson.annotations.SerializedName

data class Workflow(

	@field:SerializedName("screens")
	val screens: Screens? = null,

	@field:SerializedName("app_settings")
	val appSettings: AppSettings? = null,

	@field:SerializedName("mqtt")
	val mqtt: Mqtt? = null
)

data class TextView(

	@field:SerializedName("header")
	val header: Header? = null,

	@field:SerializedName("description")
	val description: Description? = null,

	@field:SerializedName("password")
	val password: Password? = null,

	@field:SerializedName("mobile_number")
	val mobileNumber: MobileNumber? = null,

	@field:SerializedName("user")
	val user: User? = null
)
data class Submit(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
data class Image(

	@field:SerializedName("background_image")
	val backgroundImage: String? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null
)
data class Splash(

	@field:SerializedName("next_page")
	val nextPage: String? = null,

	@field:SerializedName("previous_page")
	val previousPage: String? = null,

	@field:SerializedName("fields")
	val fields: Fields? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)
data class User(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("helper_text")
	val helperText: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
data class BackArrow(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null
)
data class Languages(

	@field:SerializedName("1")
	val jsonMember1: JsonMember1? = null,

	@field:SerializedName("2")
	val jsonMember2: JsonMember2? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("count")
	val count: Int? = null
)
data class AppSettings(

	@field:SerializedName("app_theme")
	val appTheme: AppTheme? = null,

	@field:SerializedName("languages")
	val languages: Languages? = null
)
data class Fields(

	@field:SerializedName("button_view")
	val buttonView: ButtonView? = null,

	@field:SerializedName("view")
	val view: View? = null,

	@field:SerializedName("image_view")
	val imageView: ImageView? = null,

	@field:SerializedName("text_view")
	val textView: TextView? = null
)
data class Signin(

	@field:SerializedName("next_page")
	val nextPage: String? = null,

	@field:SerializedName("previous_page")
	val previousPage: String? = null,

	@field:SerializedName("fields")
	val fields: Fields? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)
data class JsonMember2(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null
)
data class Header(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
data class WifiIcon(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null
)
data class ImageList(

	@field:SerializedName("next_page")
	val nextPage: String? = null,

	@field:SerializedName("previous_page")
	val previousPage: String? = null,

	@field:SerializedName("fields")
	val fields: Fields? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)
data class AppLogo(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null
)
data class ImageSelection(

	@field:SerializedName("next_page")
	val nextPage: String? = null,

	@field:SerializedName("previous_page")
	val previousPage: String? = null,

	@field:SerializedName("fields")
	val fields: Fields? = null,

	@field:SerializedName("properties")
	val properties: Properties? = null
)
data class ImageView(

	@field:SerializedName("back_arrow")
	val backArrow: BackArrow? = null,

	@field:SerializedName("app_logo")
	val appLogo: AppLogo? = null,

	@field:SerializedName("wifi_icon")
	val wifiIcon: WifiIcon? = null
)
data class RightIcon(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null
)
data class View(
	val any: Any? = null
)
data class AppTheme(

	@field:SerializedName("color")
	val color: Color? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("style")
	val style: Style? = null
)
data class LeftIcon(

	@field:SerializedName("color")
	val color: String? = null,

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("url")
	val url: String? = null
)
data class Password(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("helper_text")
	val helperText: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
data class Style(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("secondary_color")
	val secondaryColor: String? = null,

	@field:SerializedName("type")
	val type: Int? = null,

	@field:SerializedName("primary_color")
	val primaryColor: String? = null
)
data class JsonMember1(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("locale")
	val locale: String? = null
)
data class Validation(

	@field:SerializedName("enable")
	val enable: Boolean? = null
)
data class Color(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("secondary_color")
	val secondaryColor: String? = null,

	@field:SerializedName("primary_color")
	val primaryColor: String? = null
)
data class Mqtt(

	@field:SerializedName("enable")
	val enable: Boolean? = null
)
data class Login(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
data class MobileNumber(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("helper_text")
	val helperText: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
data class Screens(

	@field:SerializedName("signin")
	val signin: Signin? = null,

	@field:SerializedName("image_selection")
	val imageSelection: ImageSelection? = null,

	@field:SerializedName("splash")
	val splash: Splash? = null,

	@field:SerializedName("image_list")
	val imageList: ImageList? = null
)
data class ButtonView(

	@field:SerializedName("submit")
	val submit: Submit? = null,

	@field:SerializedName("login")
	val login: Login? = null
)
data class Properties(

	@field:SerializedName("image")
	val image: Image? = null,

	@field:SerializedName("color")
	val color: Color? = null
)
data class Description(

	@field:SerializedName("enable")
	val enable: Boolean? = null,

	@field:SerializedName("right_icon")
	val rightIcon: RightIcon? = null,

	@field:SerializedName("clickable_page")
	val clickablePage: String? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("left_icon")
	val leftIcon: LeftIcon? = null,

	@field:SerializedName("validation")
	val validation: Validation? = null
)
