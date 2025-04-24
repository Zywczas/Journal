import com.zywczas.buildutils.Versions

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.detekt)
    alias(libs.plugins.sqldelight)
}

android {
    namespace = "com.zywczas.storevideo"
    compileSdk = Versions.COMPILE_SDK

    defaultConfig {
        minSdk = Versions.MIN_SDK
    }

    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JVM_TARGET
    }
}

dependencies {

    implementation(project.dependencies.platform(libs.koin.bom))
    implementation(libs.koin.core)

    implementation(libs.sqldelight.android.driver)
}

sqldelight {
    databases {
        create("VideoDatabase") {
            packageName = "com.zywczas.storevideo.cache"
        }
    }
}
