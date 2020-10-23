//import com.google.protobuf.gradle.*
//
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
//    id("com.google.protobuf") version "0.8.13"
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
//    implementation("io.grpc:grpc-okhttp:1.25.0") // CURRENT_GRPC_VERSION
//    implementation("io.grpc:grpc-protobuf-lite:1.25.0") // CURRENT_GRPC_VERSION
//    implementation("io.grpc:grpc-stub:1.25.0") // CURRENT_GRPC_VERSION
}

tasks {
    test {
        useJUnitPlatform()
    }
}


