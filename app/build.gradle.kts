plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.pheaktra.zando"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.pheaktra.zando"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation ("androidx.appcompat:appcompat:1.6.1")

    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Accompanist Pager dependency (remove duplicates)
    implementation("com.google.accompanist:accompanist-pager:0.31.3-beta")  // Use the latest version
    implementation("com.google.accompanist:accompanist-pager-indicators:0.31.3-beta")

    // Compose dependencies
    implementation("androidx.compose.ui:ui:1.3.1")
    implementation("androidx.compose.material3:material3:1.0.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.1")
    implementation("androidx.compose.foundation:foundation:1.3.1")

    // Glide for image loading
    implementation("com.github.bumptech.glide:glide:4.12.0")

    // Coil dependencies (only use the latest versions)
    implementation("io.coil-kt.coil3:coil-compose:3.0.3")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.0.3")

    // Navigation Compose for handling navigation
    implementation("androidx.navigation:navigation-compose:2.8.5")

    // ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Material Icons Extended for Compose
    implementation("androidx.compose.material:material-icons-extended:1.7.5")

    // Google Fonts for Compose Text
    implementation("androidx.compose.ui:ui-text-google-fonts:1.3.0")

    // KTX Extensions for Core, Lifecycle, and Activity Compose
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose BOM (Bill of Materials) for managing versions
    implementation(platform(libs.androidx.compose.bom))

    // UI Testing Libraries
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // Debugging & Preview Libraries
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
