# 𐃆 Javelin
Pure MVVM Android Architecture in 2023 in Java.

This is an example application containing package core that can be separated into a library. 
There are no libraries (GSON, Retrofit, OkHttp etc.), only standart tools.
Applications solves following task:
- Fetch the config.json to check for chat and call feature availability and work hours
- Call and/or chat buttons are at the top (see wireframe)
- Office hours is displayed below the call and chat buttons
- If both the chat and call features are disabled, do not show the corresponding buttons
- Tapping on either buttons should display an alert with the following message:
  * if within work hours: “Thank you for getting in touch with us. We’ll get back to you as soon as possible”
  * if outside work hours: “Work hours has ended. Please contact us again on the next work day”
- Fetch the pets.json for pet information to display on the screen
- Each pet information is presented in a cell with Image and title
- Tapping on a pet info cell would open a new screen that loads the pet information on a webview
- Views should adjust to orientation and screen size accordingly


DOs:
- Handles the pets list smoothly irrespective of the size.
- Handles HTTP status codes and network failure properly.
- Clean, readable and well-structured code.
- Follow good platform development guidelines wherever applicable.
- Host both json files locally.
- Unit / UI tests.

DONTs:
- Use standard android sdk libraries only, don’t use 3rd-party libraries
- Retrofit NOT allowed.
- Glide/Picasso NOT allowed.
- Gson NOT allowed.
- No other 3rd party library is allowed.
