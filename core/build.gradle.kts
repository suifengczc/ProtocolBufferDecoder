import com.google.protobuf.gradle.*

plugins {
    java
    kotlin("jvm")
    id("com.google.protobuf")
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
    implementation("io.grpc:grpc-all:1.25.0") // CURRENT_GRPC_VERSION
}

tasks {
    test {
        useJUnitPlatform()
    }
}

kotlin {
    sourceSets{
        getByName("main"){
            this.kotlin.srcDirs("$buildDir/src/main/java")
        }
    }
}

sourceSets {
    main {

        proto {
            srcDir("src/main/proto")
//            srcDir ("src/main/protocolbuffers")
        }
    }
//    create("generateProto"){
//        proto {
//            srcDir("$buildDir/src/main/java")
//        }
//    }
}

protobuf {
    protoc { artifact = "com.google.protobuf:protoc:3.10.1" }
    generatedFilesBaseDir = "$buildDir/src"
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.25.0" // CURRENT_GRPC_VERSION
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc") {
                    option("lite")
                    outputSubDir = "java"
                }
            }
        }
    }
}
