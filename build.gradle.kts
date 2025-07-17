plugins {
    id("org.jlleitschuh.gradle.ktlint") version "12.1.0"
    id("io.gitlab.arturbosch.detekt") version "1.23.6"
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.kotlin.kapt) apply false
}

detekt {
    config = files("detekt-config.yml")
    buildUponDefaultConfig = true
}

ktlint {
    version.set("1.2.1")
}
