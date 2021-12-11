plugins {
    java
}

group = "com.artglorin"
version = "0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    val jupiterVersion = "5.8.2"
    val assertJVersion = "3.21.0"
    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
}

tasks {
    withType<JavaCompile> {
        sourceCompatibility = JavaVersion.VERSION_17.toString()
        targetCompatibility = JavaVersion.VERSION_17.toString()
        options.compilerArgs = listOf("--enable-preview")
    }
    withType<Test> {
        useJUnitPlatform()
        jvmArgs = listOf("--enable-preview")
    }
}
