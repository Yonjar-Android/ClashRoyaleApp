plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.yonjar.clashroyalestats"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.yonjar.clashroyalestats"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "com.yonjar.clashroyalestats.CustomTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")


    //Unit Testing

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly ("org.junit.jupiter:junit-jupiter-engine:5.8.1")
    testImplementation("io.mockk:mockk:1.12.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.0")

    // UI Testing

    val testEspresso = "3.5.1"
    val testHilt = "2.50"

    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:$testEspresso")
    androidTestImplementation ("com.google.dagger:hilt-android-testing:$testHilt")
    kaptAndroidTest ("com.google.dagger:hilt-android-compiler:$testHilt")
    androidTestImplementation ("androidx.fragment:fragment-testing:1.6.2")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:$testEspresso")
    androidTestImplementation ("androidx.test.espresso:espresso-contrib:$testEspresso")



    // Retrofit

    val retrofitVersion = "2.9.0"

    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")

    // Interceptor

    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")


    // Corrutinas
    val activityVersion = "1.8.2"
    val lifecycleVersion = "2.7.0"

    implementation("androidx.activity:activity-ktx:$activityVersion")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion")

    val navVersion = "2.7.7"


    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")

    // Testing Navigation

    androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")

    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:$navVersion")

    // Glide

    implementation("com.github.bumptech.glide:glide:4.16.0")


    // Splash Screen

    implementation("androidx.core:core-splashscreen:1.0.1")

    // Dagger Hilt

    val daggerVersion = "2.50"

    implementation("com.google.dagger:hilt-android:$daggerVersion")
    kapt("com.google.dagger:hilt-android-compiler:$daggerVersion")
}