plugins {
    kotlin("jvm")
}

group = "com.suifeng"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.10")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.4.10")
}
