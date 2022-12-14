import dependencies.DataDep

plugins {
    id(Config.Plugins.androidLibrary)
    id(Config.Plugins.kotlinAndroid)
    id(Config.Plugins.kotlinKapt)
    id(Config.Plugins.dagger)
}

android {
    compileSdk = Config.Android.androidCompileSdkVersion
    defaultConfig {
        minSdk = Config.Android.androidMinSdkVersion
        targetSdk = Config.Android.androidTargetSdkVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}


dependencies {
    // Modules
    implementation(project(Modules.domain))
    // Kotlin
    implementation(DataDep.kotlin)
    // Coroutines
    implementation(DataDep.coroutineCore)
    // JavaX
    implementation(DataDep.javax)
    // Retrofit
    DataDep.retrofit.forEach {
        implementation(it)
    }
    // Dagger-Hilt
    DataDep.DaggerHilt.forEach {
        implementation(it)
    }
    DataDep.DaggerHiltKapt.forEach {
        kapt(it)
    }


    // Test Dependencies
    testImplementation(DataDep.Test.junit)
    testImplementation(DataDep.Test.assertJ)
    testImplementation(DataDep.Test.mockitoKotlin)
    testImplementation(DataDep.Test.mockitoInline)
    testImplementation(DataDep.Test.coroutines)
    testImplementation(DataDep.Test.mockitoWebServer)
    testImplementation(DataDep.Test.mockitoCore)
    testImplementation(DataDep.Test.mockitoAndroid)

}
