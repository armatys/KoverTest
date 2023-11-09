import kotlinx.kover.gradle.plugin.KoverGradlePlugin
import kotlinx.kover.gradle.plugin.dsl.KoverReportExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.provider.ListProperty
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create

class CustomPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        val ext = target.extensions.create<CustomExt>("customExt")

        target.afterEvaluate {
            // NOTE:
            // If you move the application of the kover plugin
            // outside of `afterEvaluate`, the `:app` project will work,
            // but the `:lib` project will not apply the custom configuration (exclude class) that is applied below.
            target.pluginManager.apply(KoverGradlePlugin::class.java)

            extensions.configure<KoverReportExtension> {
                defaults {
                    if (target.plugins.hasPlugin("com.android.application") ||
                        target.plugins.hasPlugin("com.android.library")
                    ) {
                        mergeWith("debug")
                    }
                }
                filters {
                    excludes {
                        classes(ext.excludeClasses.get())
                    }
                }
            }
        }
    }
}

interface CustomExt {
    val excludeClasses: ListProperty<String>
}
