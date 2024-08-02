# Bitcot Technologies Assignment

## Overview

This is an Android application that fetches TV show data from a remote API and displays it in a RecyclerView. Users can search for TV shows by genre using the SearchView. The app follows the MVVM architecture and uses Retrofit for network operations.

## Architecture

The app follows the MVVM (Model-View-ViewModel) architecture:
- *Model*: Contains data classes for the TV shows.
- *View*: Activities and XML layouts that display the data.
- *ViewModel*: Manages UI-related data and handles business logic.

## Design Decisions

- *MVVM Architecture*: To separate concerns and make the code more maintainable.
- *Retrofit*: For network operations because of its ease of use and efficiency.
- *DataBinding*: To bind UI components in layouts to data sources.
- *RecyclerView*: To display a list of TV shows.

## Instructions for Running the Application

1.Clone the repository:
   ```sh
   git clone https://github.com/chanchaltharwani/BitCotTechnologiesAssignment.git

2.Open the project in Android Studio.
3.Build the project to download all dependencies.
4.Run the application on an emulator or a physical device.

Usage
Search: Enter a genre in the search bar to filter the list of shows.
Back Button: If the search view is open, it will close on back press.

Key Classes:


MainActivity: Sets up the UI and handles user interactions.
ShowAdapter: Binds TV show data to the RecyclerView.
ShowViewModel: Manages the TV show data and handles business logic.
ShowRepository: Fetches data from the API using Retrofit.
ApiInterface: Defines the API endpoints.


Dependencies


Retrofit: For network operations.
Glide: For image loading.
ViewBinding: For binding UI components to data sources in RecyclerView adapters.
DataBinding: For binding UI components to data sources.
RecyclerView: For displaying lists.