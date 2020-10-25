buildscript {
    repositories {
        jcenter()
        mavenCentral()
    }

    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.13")
    }

}

plugins {
    java
    kotlin("jvm") version "1.4.10"
}

group = "com.suifeng"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
    testImplementation("org.jetbrains.kotlin:kotlin-test:1.4.10")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.4.10")
}

tasks {
    test {
        useJUnitPlatform()
    }
}


