import org.gradle.api.JavaVersion

object Project {
    const val versionName = "1.0.0" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    const val versionCode = 1

    const val COMPILE_SDK = 33
    const val TARGET_SDK = 33
    const val MIN_SDK = 21
    val javaVersion = JavaVersion.VERSION_17
}
