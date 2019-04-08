package io.develicit.mimicbrowser.utils

import io.develicit.mimicbrowser.BuildConfig

object AppConstants {
    private const val BUILD_TYPE_DEBUG = "debug"
    private const val BUILD_TYPE_RELEASE = "release"

    val isDevBuild = BuildConfig.BUILD_TYPE == BUILD_TYPE_DEBUG
}