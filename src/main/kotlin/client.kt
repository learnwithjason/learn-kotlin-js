import kotlinx.html.div
import kotlinx.html.dom.append
import org.w3c.dom.Node
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.html.li
import kotlinx.html.p
import kotlinx.html.ul

// small data model
data class PodcastEpisode(
    val title: String,
    val id: Int,
    override val funk: Boolean = false
): Funky

val ep198 = PodcastEpisode(
    "Prototyping With Framer",
    198
)

val ep199 = PodcastEpisode(
    "Distributed Persistent Rendering",
    199
)

val ep200 = PodcastEpisode(
    "GitHub Automation with Octokit",
    200
)

val episodes = listOf(ep198, ep199, ep200)

fun main() {
    window.onload = { document.body?.sayHello() }
}

interface Funky {
    val funk: Boolean
}

inline fun Iterable<PodcastEpisode>.addFunk() = this.map {
    it.copy(funk = it.id != 199)
}

fun Node.sayHello() {
    append {
        div {
            p {
                +"Hello from JS"
            }
        }
        ul {
            episodes.addFunk().forEach {
                li {
                    +"${it.id}: ${it.title} ${it.funk}"
                }
            }
        }
    }
}