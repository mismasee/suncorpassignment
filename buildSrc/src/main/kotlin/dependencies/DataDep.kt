package dependencies

object DataDep {
    const val kotlin = Dependencies.KotlinDep.kotlin
    const val javax = Dependencies.JavaDep.javax
    const val coroutineCore = Dependencies.CoroutinesDep.coroutineCore

    object Test {
        const val junit = Dependencies.TestDep.junit
        const val coroutines = Dependencies.TestDep.coroutinesTest
        const val mockitoKotlin = Dependencies.TestDep.mockitoKotlin
        const val mockitoInline = Dependencies.TestDep.mockitoInline
        const val assertJ = Dependencies.TestDep.assertJ
        const val mockitoWebServer = Dependencies.TestDep.mockitoWebServer
        const val mockitoCore = Dependencies.TestDep.mockitoCore
        const val mockitoAndroid = Dependencies.TestDep.mockitoAndroid
    }

    // Hilt
    val DaggerHilt = listOf(
        Dependencies.DaggerHiltDep.hiltAndroid
    )

    val DaggerHiltKapt = listOf(
        Dependencies.DaggerHiltDep.hiltAndroidKapt,
        Dependencies.DaggerHiltDep.hiltKapt
    )

    val retrofit = listOf(
        Dependencies.RetrofitDep.retrofit,
        Dependencies.RetrofitDep.moshiConverter,
        Dependencies.RetrofitDep.loggingInterceptor,
        Dependencies.RetrofitDep.okhttp
    )

    //room
    val room = listOf(
        Dependencies.RoomDep.roomRuntime,
        Dependencies.RoomDep.roomKtx,
        Dependencies.RoomDep.roomCompilerKapt
    )
}