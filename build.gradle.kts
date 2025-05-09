// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.detekt)
    alias(libs.plugins.sqldelight) apply false
}

tasks.register("detektAllModules") {
    subprojects.forEach { subproject ->

        require(subproject.pluginManager.hasPlugin(libs.plugins.detekt.get().pluginId)) {
            "Module '${subproject.name}' doesn't use Detekt plugin. You need to add 'alias(libs.plugins.detekt)' to the module."
        }

        subproject.detekt {
            parallel = true
            config.setFrom(files("$rootDir/code_quality/detekt/detekt.yml"))
        }
        finalizedBy(":${subproject.name}:detekt")
    }
}
