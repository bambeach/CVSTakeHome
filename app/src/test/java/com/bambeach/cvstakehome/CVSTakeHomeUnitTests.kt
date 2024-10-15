package com.bambeach.cvstakehome

import com.bambeach.cvstakehome.model.Image
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.time.OffsetDateTime

class CVSTakeHomeUnitTests {

    @Test
    fun `test image creation`() {
        val image = Image(
            url = "https://example.com/image.jpg",
            title = "Example Image",
            description = "This is an example image.",
            author = "John Doe",
            date = "2024-10-15"
        )

        assertEquals("https://example.com/image.jpg", image.url)
        assertEquals("Example Image", image.title)
        assertEquals("This is an example image.", image.description)
        assertEquals("John Doe", image.author)
        assertEquals("2024-10-15", image.date)
    }

    @Test
    fun `test image with empty fields`() {
        val image = Image(
            url = "",
            title = "",
            description = "",
            author = "",
            date = ""
        )

        assertEquals("", image.url)
        assertEquals("", image.title)
        assertEquals("", image.description)
        assertEquals("", image.author)
        assertEquals("", image.date)
    }

    @Test
    fun `test image with special characters`() {
        val image = Image(
            url = "https://example.com/image with spaces.jpg",
            title = "Example Image with !@#$%^&*()",
            description = "This is an example image with special characters.",
            author = "John Doe Jr.",
            date = "2024-10-15T10:00:00Z"
        )

        assertEquals("https://example.com/image with spaces.jpg", image.url)
        assertEquals("Example Image with !@#$%^&*()", image.title)
        assertEquals("This is an example image with special characters.", image.description)
        assertEquals("John Doe Jr.", image.author)
        assertEquals("2024-10-15T10:00:00Z", image.date)
    }

    @Test
    fun `test date formatting`() {
        val inputDate = "2024-10-07T17:35:39Z"
        val expectedFormattedDate = "7 OCTOBER 2024 17:35"

        val date = OffsetDateTime.parse(inputDate)
        val formattedDate = "${date.dayOfMonth} ${date.month} ${date.year} ${date.hour}:${date.minute}"

        assertEquals(expectedFormattedDate, formattedDate)
    }
}