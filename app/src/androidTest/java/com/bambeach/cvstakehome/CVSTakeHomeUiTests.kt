package com.bambeach.cvstakehome

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import com.bambeach.cvstakehome.data.sampleImageList
import com.bambeach.cvstakehome.model.Image
import com.bambeach.cvstakehome.ui.details.DetailsScreen
import com.bambeach.cvstakehome.ui.details.DetailsUiState
import com.bambeach.cvstakehome.ui.home.HomeScreen
import com.bambeach.cvstakehome.ui.home.HomeUiState
import org.junit.Rule
import org.junit.Test

class CVSTakeHomeUiTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testHomeScreen_loadingState() {
        composeTestRule.setContent {
            HomeScreen(uiState = HomeUiState.Loading, onBackClick = { }, onImageClick = { }, onQueryChange = { })
        }

        composeTestRule.onNodeWithTag("Progress Indicator").assertIsDisplayed()
    }

    @Test
    fun testHomeScreen_errorState() {
        composeTestRule.setContent {
            HomeScreen(uiState = HomeUiState.Error, onBackClick = { }, onImageClick = { }, onQueryChange = { })
        }

        composeTestRule.onNodeWithText("Error Loading Images").assertIsDisplayed()
    }

    @Test
    fun testHomeScreen_successState() {
        val images = sampleImageList
        composeTestRule.setContent {
            HomeScreen(
                uiState = HomeUiState.Success(images),
                onBackClick = { },
                onImageClick = { },
                onQueryChange = { }
            )
        }

        composeTestRule.onNodeWithContentDescription(label = images[0].title).assertIsDisplayed()
        composeTestRule.onNodeWithContentDescription(label = images[1].title).assertIsDisplayed()
    }

    @Test
    fun testHomeScreen_search() {
        composeTestRule.setContent {
            HomeScreen(uiState = HomeUiState.Loading, onBackClick = { }, onImageClick = { }, onQueryChange = { })
        }

        composeTestRule.onNodeWithContentDescription("Search").performClick()
        composeTestRule.onNodeWithContentDescription("Search").performTextInput("Test")
        composeTestRule.onNodeWithContentDescription("Search").assertTextEquals("Test")
        composeTestRule.onNodeWithContentDescription("Clear").performClick()
        composeTestRule.onNodeWithContentDescription("Search", useUnmergedTree = true).assertTextEquals("")
    }

    @Test
    fun testDetailsScreen_withContent() {
        val image = Image(
            url = "https://example.com/image.jpg",
            title = "Example Image",
            description = "This is an <b>example</b> image.",
            author = "John Doe",
            date = "7 October 2024 17:35" // Assuming you've formatted the date
        )
        composeTestRule.setContent {
            DetailsScreen(image = image, uiState = DetailsUiState.Success(image), onBackClick = {})
        }

        composeTestRule.onNodeWithText("Example Image").assertIsDisplayed()
        composeTestRule.onNodeWithText("This is an example image.").assertIsDisplayed() // HTML tags should be rendered
        composeTestRule.onNodeWithText("7 October 2024 17:35").assertIsDisplayed()
    }

    @Test
    fun testDetailsScreen_withoutTitle() {
        val image = Image(
            url = "https://example.com/image.jpg",
            title = "",
            description = "This is an example image.",
            author = "John Doe",
            date = "7 October 2024 17:35"
        )
        composeTestRule.setContent {
            DetailsScreen(image = image, uiState = DetailsUiState.Success(image), onBackClick = {})
        }

        composeTestRule.onNodeWithText("This is an example image.").assertIsDisplayed()
        composeTestRule.onNodeWithText("7 October 2024 17:35").assertIsDisplayed()
    }
}