plugins {
    id("org.jetbrains.kotlin.jvm")
    id("custom-plugin")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    jvmToolchain(17)
}

dependencies {
    testImplementation("junit:junit:4.13.2")
}

extensions.configure<CustomExt> {
    excludeClasses.add("com.example.lib.MyClass")
}
