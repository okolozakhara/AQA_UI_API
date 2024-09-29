plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.rest-assured:rest-assured:5.4.0")
    testImplementation ("org.junit.jupiter:junit-jupiter-api:5.8.1")
    implementation("com.google.code.gson:gson:2.8.8")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.0")
    testImplementation ("com.codeborne:selenide:7.5.0")

}

tasks.test {
    useJUnitPlatform()
}