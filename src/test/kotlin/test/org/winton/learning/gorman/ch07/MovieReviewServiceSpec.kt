package test.org.winton.learning.gorman.ch07

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import io.kotest.matchers.shouldBe
import uk.org.winton.learning.gorman.ch07.MovieReviewService
import uk.org.winton.learning.gorman.ch07.Review

class MovieReviewServiceSpec : FunSpec({
    test("Reviews have default reviewer name if not specified") {
        val review = Review(movie = "Plan 9 from Outer Space", rating = 1, text = "Pretty bad")
        review.movie.shouldBe("Plan 9 from Outer Space")
        review.rating.shouldBe(1)
        review.text.shouldBe("Pretty bad")
        review.reviewer.shouldBe("Anonymous")
    }

    test("Obtaining stats for a non-existent movie should give an empty list") {
        val service = MovieReviewService()
        service.statsFor("The Invisible Man").shouldBeEmpty()
    }

    test("Obtaining stats for a specific added movie") {
        val service = MovieReviewService()
        service.add(Review(movie ="Up!", rating = 5, text = "Great"))
        service.add(Review(movie ="Up!", rating = 5, text = "Superb"))
        service.add(Review(movie ="Up!", rating = 4, text = "Good"))
        service.add(Review(movie ="Toy Story", rating = 5, text = "Amazing"))
        service.statsFor("Up!").shouldContainExactlyInAnyOrder(listOf(Pair(5, 2), Pair(4, 1)))
    }

    test("Obtaining average for a specific added movie") {
        val service = MovieReviewService()
        service.add(Review(movie ="Up!", rating = 5, text = "Great"))
        service.add(Review(movie ="Up!", rating = 4, text = "Superb"))
        service.add(Review(movie ="Up!", rating = 3, text = "Good"))
        service.add(Review(movie ="Toy Story", rating = 5, text = "Amazing"))
        service.averageRatingFor("Up!").shouldBe(4.0)
    }
})