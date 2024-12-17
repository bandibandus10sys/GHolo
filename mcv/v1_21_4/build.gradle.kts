plugins {
    id("io.papermc.paperweight.userdev")
}

dependencies {
    api(project(":core"))
    paperweight.paperDevBundle("1.21.4-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(21)
}

tasks.assemble {
    dependsOn(tasks.reobfJar)
}