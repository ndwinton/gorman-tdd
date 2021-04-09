package uk.org.winton.learning.gorman.ch07

class MovieReviewService {
    private val reviews = mutableListOf<Review>()

    fun statsFor(name: String): List<Pair<Int,Int>> {
        return reviews.filter { it.movie == name }.groupBy { it.rating }.map { (rating, list) -> Pair(rating, list.size) }
    }

    fun add(review: Review) {
        reviews.add(review)
    }

    fun averageRatingFor(name: String): Double {
        return reviews.filter { it.movie == name }.map { it.rating }.average()
    }
}
