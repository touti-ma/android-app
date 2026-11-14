package com.android.touti

import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.android.touti.ui.theme.SampleAppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ThemeAndPreviewTest {

  @get:Rule val composeTestRule = createAndroidComposeRule<ComponentActivity>()

  @Test
  fun previews_render() {
    composeTestRule.setContent {
      GreetingPreview()
      GreetingPreview2()
    }
    composeTestRule.onNodeWithText("Hello Android!").assertExists()
    composeTestRule.onNodeWithText("Hello Robolectric!").assertExists()
  }

  @Test
  fun theme_dark_without_dynamic_color() {
    composeTestRule.setContent {
      SampleAppTheme(darkTheme = true, dynamicColor = false) { Text("dark") }
    }
    composeTestRule.onNodeWithText("dark").assertExists()
  }

  @Test
  fun theme_light_without_dynamic_color() {
    composeTestRule.setContent {
      SampleAppTheme(darkTheme = false, dynamicColor = false) { Text("light") }
    }
    composeTestRule.onNodeWithText("light").assertExists()
  }

  @Test
  fun theme_dynamic_dark_and_light() {
    composeTestRule.setContent {
      SampleAppTheme(darkTheme = true, dynamicColor = true) { Text("dyn-dark") }
    }
    composeTestRule.onNodeWithText("dyn-dark").assertExists()
  }
}
